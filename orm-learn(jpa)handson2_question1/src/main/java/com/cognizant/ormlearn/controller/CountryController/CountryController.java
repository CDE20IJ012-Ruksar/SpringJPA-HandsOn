package com.cognizant.ormlearn.controller.CountryController;


import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.cognizant.ormlearn.OrmLearnApplication;
import com.cognizant.ormlearn.CountryRepository.CountryRepository;
import com.cognizant.ormlearn.model.Country.Country;
import com.cognizant.ormlearn.service.CountryService.CountryService;



@Controller
public class CountryController {
	@Autowired
	private CountryRepository countryRepository;
	@RequestMapping(value="/showPage",method=RequestMethod.GET)
	public String enterCountry()
	{
		return "show";
	}
	
	@RequestMapping(value="/displaycountry",method=RequestMethod.GET)
	public String checkCountry(ModelMap map,  @ModelAttribute("country") Country country,@Param("name") String name)
	{
		
		List<Country> country1=countryRepository.findByNameContainingOrderByNameAsc(name);
		map.addAttribute("country1",country1);
		return "displaycountry";
	      
	}
	@RequestMapping(value="/displaysearch",method=RequestMethod.GET)
	public String checkCountryStartingWith(ModelMap map,  @ModelAttribute("country") Country country,@Param("n") String name)
	{
		List<Country> country2=countryRepository.findByNameStartingWith(name);
		map.addAttribute("country2",country2);
		return "displaysearch";
	      
	}
}
