/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.aabu.springjpa.contoller;

/**
 *
 * @author AnwarQ
 */
import edu.aabu.springjpa.model.Country;
import edu.aabu.springjpa.service.CountryService;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CountryControllerAngular {

    private HttpServletRequest request;
    @Autowired
    CountryService countryService = new CountryService();

    @RequestMapping(value = "/countries", method = {RequestMethod.GET,RequestMethod.POST}, headers = "Accept=application/json")
    public List getCountries() {

        List listOfCountries = countryService.getAllCountries();
        return listOfCountries;
    }

    @RequestMapping(value = "/getCountryByid/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
    public Country getCountryById(@PathVariable int id) {
        return countryService.getCountry(id);
    }

    @RequestMapping(value = "/insertCountry", method = RequestMethod.POST, headers = "Accept=application/json")
    public Country addCountry(@RequestBody Country country) {
        return countryService.addCountry(country);
    }

    @RequestMapping(value = "/updCountry", method = RequestMethod.PUT, headers = "Accept=application/json")
    public Country updateCountry(@RequestBody Country country) {
        return countryService.updateCountry(country);

    }

    @RequestMapping(value = "/delCountry/{id}", method = {RequestMethod.DELETE,RequestMethod.GET}, headers = "Accept=application/json")
    public void deleteCountry(@PathVariable("id") int id) {
        countryService.deleteCountry(id);

    }
}
