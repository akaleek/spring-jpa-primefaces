/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.aabu.springjpa.contoller;

/**
 *
 * @author heba
 */
import edu.aabu.springjpa.model.Country;
import edu.aabu.springjpa.service.CountryService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
@Controller
public class CountryController {
 
 @Autowired
 CountryService countryService;
 
 @RequestMapping(value = "/getAllCountries", method = RequestMethod.GET, headers = "Accept=application/json")
 public String getCountries(Model model) {
  
  List listOfCountries = countryService.getAllCountries();
  model.addAttribute("country", new Country());
  model.addAttribute("listOfCountries", listOfCountries);
  return "countryDetails";
 }
 
 @RequestMapping(value = "/getCountry/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
 public Country getCountryById(@PathVariable int id) {
  return countryService.getCountry(id);
 }
 
 @RequestMapping(value = "/addCountry", method = RequestMethod.POST, headers = "Accept=application/json")
 public String addCountry(@ModelAttribute("country") Country country) {
     System.out.println("country == null" +(country == null));
  if(Integer.valueOf(0).equals(country.getId()))
  {
      countryService.addCountry(country);
  }
  else
  {
      countryService.updateCountry(country);
  }
  
  return "redirect:/sp/getAllCountries";
 }
 
 @RequestMapping(value = "/updateCountry/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
 public String updateCountry(@PathVariable("id") int id,Model model) {
   model.addAttribute("country", this.countryService.getCountry(id));
         model.addAttribute("listOfCountries", this.countryService.getAllCountries());
         return "countryDetails";
 }
 
 @RequestMapping(value = "/deleteCountry/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
 public String deleteCountry(@PathVariable("id") int id) {
  countryService.deleteCountry(id);
   return "redirect:/sp/getAllCountries";
 
 }
} 
