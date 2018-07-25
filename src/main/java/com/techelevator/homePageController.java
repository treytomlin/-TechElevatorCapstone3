package com.techelevator;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.techelevator.npgeek.Forecast;
import com.techelevator.npgeek.ForecastDAO;
import com.techelevator.npgeek.Park;
import com.techelevator.npgeek.ParkDAO;

@Controller
@SessionAttributes({"tempClass", "parkDetails"})
public class homePageController {


	@Autowired
	private ParkDAO parkdao; 
	@Autowired
	private ForecastDAO forecastdao; 
	
	@RequestMapping("/homePage")
	public String displayHomePage(ModelMap model) {
		
		List<Park> allParks = parkdao.getAllParks(); 
		model.addAttribute("parks", allParks); 
		
		if (model.get("tempClass") != null) {
			System.out.println("HOMEPAGE..." + model.get("tempClass").toString()); // look into
		}
		
		return "homePage"; 
	}
	

	@RequestMapping(path="/parkDetailPage", method=RequestMethod.GET)
	public String displayDetailsPage(@RequestParam String parkcode, @RequestParam(required=false) String convert, ModelMap model) {
		
		
		if (!model.containsAttribute("tempClass")) {
			model.put("tempClass", "2");
		}
		
		if (convert != null) {
			model.put("tempClass", convert);
		}
		
				
		Park park = parkdao.findParkByParkCode(parkcode); 
		
		List<Forecast> forecast = forecastdao.getForecastByParkCode(parkcode); 
		
		
		model.addAttribute("parkDetails", park);
		model.addAttribute("forecast", forecast);
		

		
		return"parkDetailPage"; 
	
	}
	
	
//	@RequestMapping(path="/parkConversionPage", method=RequestMethod.POST)
//	public String displayDetailsPageinCelsius(@RequestParam(name="convert") int tempScale, ModelMap model) {
//		model.addAttribute("tempClass", tempScale); 
////		
//////		String tempConvert = (String) session.getAttribute("convert");
//////		
//////		//String parkCode = request.getParameter("parkcode"); 
//////	 
//////
//////		if (convert == null) {
//////			convert ="F";
//////			session.setAttribute("convert", convert);
//////		}
//////		Park park = parkdao.findParkByParkCode(parkCode); 
//////		List<Forecast> forecasts = forecastdao.getForecastByParkCode(parkCode); 
//////		
//////		if (convert.equals("C")) {
//////			for (Forecast temp : forecasts) {
//////				int tempConverted;
//////				tempConverted = (int) Forecast.convertHighToC(temp.getHighTemp());
//////				((Forecast) forecasts).setHighTemp(tempConverted);
//////				tempConverted = (int) Forecast.convertLowToC(temp.getLowTemp());
//////				((Forecast) forecasts).setLowTemp(tempConverted);
//////			}
//////
//////		session.setAttribute("parkDetails", park);
//////		session.setAttribute("forecast", forecasts); // might be fucked up
////		}
//		
//		return"redirect:/homePage"; 
//	
//	}
//	@RequestMapping(path="/parkDetailPage/{parkCode}",method=RequestMethod.POST)
//	public String displayConversionPage(@PathVariable String parkCode, @RequestParam String convert, HttpSession session, ModelMap modelHolder){
//			session.setAttribute("convert", convert);
//			
//		return"parkDetailPage/ + parkCode"; 
//	}
//	
//	
	
}