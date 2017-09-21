/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.aabu.springjpa.repository;

import edu.aabu.springjpa.model.Country;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author heba
 */
public interface CountryRepository extends CrudRepository<Country,Integer>{
    
}
