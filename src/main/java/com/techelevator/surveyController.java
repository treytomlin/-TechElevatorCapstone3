package com.techelevator;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.techelevator.npgeek.FavoritePark;
import com.techelevator.npgeek.FavoriteParkDAO;
import com.techelevator.npgeek.Survey;
import com.techelevator.npgeek.SurveyDAO;

@Controller
public class surveyController {
	
	@Autowired
	private SurveyDAO surveydao; 
	@Autowired 
	private FavoriteParkDAO favoriteparkdao; 
	
	
	@RequestMapping("/survey")
	public String displaySurveyPage(Model model) {
		
		if(! model.containsAttribute("survey")) {
			model.addAttribute("survey", new Survey()); 
		}
		return "survey"; 
	}

	@RequestMapping(path="/survey", method=RequestMethod.POST)
	public String addNewSurvey(
			@Valid @ModelAttribute Survey newSurvey, 
			BindingResult result, 
			RedirectAttributes attr 
	) {
		
		if(result.hasErrors()) {
			return "survey"; 
		}
		
		surveydao.saveSurvey(newSurvey);
		attr.addFlashAttribute("survey", newSurvey); 
		return "redirect:/thankYou";
		
	}
		
	@RequestMapping(path="/thankYou", method=RequestMethod.GET)
	public String displayThankYou(Model modelHolder, ModelMap map) {
		
		if(!modelHolder.containsAttribute("survey")) {
			map.addAttribute("surveyResult", new Survey()); 
		} else {
			map.addAttribute("surveyResult", modelHolder.asMap().get("survey")); 
		}
		
		List<FavoritePark> favoriteParks = favoriteparkdao.getFavoriteParks(); 
		map.addAttribute("favoriteParks", favoriteParks); 
		return "thankYou"; 
	}
}		
		
	
	

