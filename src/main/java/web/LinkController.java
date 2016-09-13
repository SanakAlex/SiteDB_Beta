package web;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.inject.Inject;
import javax.validation.Valid;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import proc.Directory;
import proc.DirectoryService;
import proc.Link;
import proc.LinkService;

@Controller
@RequestMapping("/links")
public class LinkController {
	
	List<Link> list = null;
	@Inject
	LinkService service;
	@Inject
	DirectoryService directoryService;
	
	@RequestMapping(value = "/listOfLinks", method = RequestMethod.GET)
	public String showListOfLinks(ModelMap model) {
		list = service.findAll();
		model.addAttribute("linkList", list);
		return "listOfLinks";
	}
	@RequestMapping(value = "/listOfLinksOfDirectory_{directoryName}", method = RequestMethod.GET)
	public String showListOfLinksOfDirectory(@PathVariable String directoryName, ModelMap model) {
		list = service.findByDirectory(directoryName);
		model.addAttribute("linkList", list);
		return "listOfLinks";
	}
	@RequestMapping(value = "/sortBy{sortingParametr}", method = RequestMethod.GET)
	public String showListOfLinksSortedByName(@PathVariable String sortingParametr,ModelMap model) {
		if (sortingParametr.equals("Name")) list = service.getSortedByName();
		if (sortingParametr.equals("Utility")) list = service.getSortedByUtility();
		if (sortingParametr.equals("AdditionDate")) list = service.getSortedByAdditionDate();
		if (sortingParametr.equals("Directory")) list = service.getSortedByDirectory();
		if (sortingParametr.equals("Status")) list = service.getSortedByStatus();
		model.addAttribute("linkList", list);
		return "listOfLinks";
	}
	@RequestMapping(value = "/newLink", method = RequestMethod.GET)
	public String addLink(ModelMap model) {
		List<Directory> directoryList = directoryService.findAll();
		model.addAttribute("directoryList", directoryList);
		Link link = new Link();
		//link.setDirectory(new Directory());
		model.addAttribute("link", link);
		return "newLink";
	}

	@RequestMapping(value = "/addLink", method = RequestMethod.POST)
    public String addLink(@Valid @ModelAttribute("link")Link link, 
    		BindingResult bindingResult,	ModelMap model) {
	   List<Directory> directoryList = directoryService.findAll();
	   model.addAttribute("directoryList", directoryList);
	   link.setAdditionDate(new Timestamp(new Date().getTime()));
	   if(bindingResult.hasErrors()&&link.getLinkId()==0) { return "newLink"; }
       service.save(link);
       list = service.getSortedByName();
       model.addAttribute("linkList", list);
       return "listOfLinks";    
   }
	@RequestMapping(value = "/editLink_{linkId}", method = RequestMethod.GET)
	public String editLink(@PathVariable String linkId, ModelMap model) {
	     int id = Integer.valueOf(linkId);
	     Link link = service.findById(id);
	     model.addAttribute("link", link);
	     List<Directory> directoryList = directoryService.findAll();
		 model.addAttribute("directoryList", directoryList);
	     return "newLink";
	}
	
	@RequestMapping(value = "/deleteLink_{linkId}", method = RequestMethod.GET)
	public String deleteLink(@PathVariable String linkId, ModelMap model) {
	     int id = Integer.valueOf(linkId);
	     Link link = null;
	     link = service.findById(id);
	     service.delete(link);
	     list = service.getSortedByName();
	     model.addAttribute("linkList", list);
	     return "listOfLinks";
	}
	@InitBinder
	public void initBinder(WebDataBinder dataBinder){
	     SimpleDateFormat dateFormat = new 	SimpleDateFormat("yyyy-MM-dd HH:mm:s");	
	     dataBinder.registerCustomEditor(Timestamp.class, new 	CustomDateEditor(dateFormat, true));
	}
}
