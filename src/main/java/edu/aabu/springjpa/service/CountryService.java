/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.aabu.springjpa.service;

/**
 *
 * @author heba
 */
import edu.aabu.springjpa.model.Country;
import edu.aabu.springjpa.repository.CountryRepository;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
 
@Service("countryService")
public class CountryService {
 
 @Autowired
 CountryRepository countryRepository;
 
 @Transactional
 public List getAllCountries() {
  List countries=new ArrayList();
  Iterable countriesIterable=countryRepository.findAll();
  Iterator countriesIterator=countriesIterable.iterator();
  while(countriesIterator.hasNext())
  {
   countries.add(countriesIterator.next());
  }
  return countries;
 }
 
 @Transactional
 public Country getCountry(int id) {
  return countryRepository.findOne(id);
 }
 
 @Transactional
 public Country addCountry(Country country) {
  return countryRepository.save(country);
 }
 
 @Transactional
 public Country updateCountry(Country country) {
     return countryRepository.save(country);
 
 }
 
 @Transactional
 public void deleteCountry(int id) {
  countryRepository.delete(id);
 }

    public CountryRepository getCountryRepository() {
        return countryRepository;
    }

    public void setCountryRepository(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }
 
}