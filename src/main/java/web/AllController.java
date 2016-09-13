package web;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import proc.Directory;
import proc.DirectoryService;
import proc.Link;
import proc.LinkService;


@Controller
@RequestMapping("/all")
public class AllController {
	
	List<Directory> directorylist = null;
	List<Link> linkList = null;
	@Inject
	DirectoryService directoryService;
	@Inject
	LinkService linkService;
	
	@RequestMapping(value = "/all", method = RequestMethod.GET)
	public String showListOfDirectories(ModelMap model) {
		directorylist = directoryService.getSortedByName();
		linkList = linkService.getSortedByName();
		model.addAttribute("directoryList", directorylist);
		model.addAttribute("linkList", linkList);
		return "all";
	}
	
}
