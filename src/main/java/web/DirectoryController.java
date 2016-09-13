package web;

import java.util.List;

import javax.inject.Inject;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import proc.Directory;
import proc.DirectoryService;
import proc.Link;
import proc.LinkService;


@Controller
@RequestMapping("/directories")
public class DirectoryController {
	
	List<Directory> list = null;
	List<Link> links = null;
	@Inject
	DirectoryService service;
	@Inject
	LinkService linkService;
	
	@RequestMapping(value = "/listOfDirectories", method = RequestMethod.GET)
	public String showListOfDirectories(ModelMap model) {
		list = service.findAll();
		model.addAttribute("directoryList", list);
		links = linkService.findAll();
		model.addAttribute("linkList", links);
		return "listOfDirectories";
	}
	@RequestMapping(value = "/sortByName", method = RequestMethod.GET)
	public String showListOfDirectoriesSortedByName(ModelMap model) {
		list = service.getSortedByName();
		model.addAttribute("directoryList", list);
		links = linkService.findAll();
		model.addAttribute("linkList", links);
		return "listOfDirectories";
	}
	@RequestMapping(value = "/newDirectory", method = RequestMethod.GET)
	public String addDirectory(ModelMap model) {
		model.addAttribute("directory", new Directory());
		return "newDirectory";
	}

	@RequestMapping(value = "/addDirectory", method = RequestMethod.POST)
    public String addMerchant(@Valid @ModelAttribute("directory")Directory directory, 
    		BindingResult bindingResult,	ModelMap model) {
		
	   if(bindingResult.hasErrors()&&directory.getId()==0) { return "newDirectory"; }
       service.save(directory);
       list = service.getSortedByName();
       model.addAttribute("directoryList", list);
       return "listOfDirectories";    
   }
	@RequestMapping(value = "/editDirectory_{directoryId}", method = RequestMethod.GET)
	public String editMerchant(@PathVariable String directoryId, ModelMap model) {
	     int id = Integer.valueOf(directoryId);
	     Directory directory = service.findById(id);
	     model.addAttribute("directory", directory);
	     return "newDirectory";
	}
	@RequestMapping(value = "/deleteDirectory_{directoryId}", method = RequestMethod.GET)
	public String deleteLink(@PathVariable String directoryId, ModelMap model) {
	     int id = Integer.valueOf(directoryId);
	     Directory directory = null;
	     directory = service.findById(id);
	     links = linkService.findByDirectory(directory.getDirectoryName());
	     if(links.size()>0) for (Link l:links) linkService.delete(l);
	     service.delete(directory);
	     list = service.getSortedByName();
	     model.addAttribute("directoryList", list);
	     links = linkService.findAll();
		 model.addAttribute("linkList", links);
	     return "listOfDirectories";
	}
}
