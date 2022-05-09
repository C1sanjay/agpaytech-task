package com.examples.agpaytech.controller;

import java.util.List;
import java.util.Optional;

import javax.annotation.PostConstruct;

import com.examples.agpaytech.model.Country;
import com.examples.agpaytech.services.CountryServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.info.ProjectInfoProperties.Build;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CountryController {
    
    @Autowired
    private CountryServices countryServices;
    
    @GetMapping("/countrylist")
    public ResponseEntity <List<Country>> getName(){
        List<Country> list=this.countryServices.getAllCountry();
        if(list.size()<=0)
        {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        
        return ResponseEntity.of(Optional.of(list));
    }

    @GetMapping("/countrylist/{name}")
    public ResponseEntity <Country> getCountries(@PathVariable("name") String name){
        
      Country co=countryServices.getCountryByName(name);
      if(co==null)
      {
          return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
      }
      return ResponseEntity.of(Optional.of(co));

    }
    @PostMapping("/addcname")
    public ResponseEntity<Country> addCountry(@RequestBody Country country){

      Country cn=null;
    
      try
      {
        cn=this.countryServices.addCountries(country);

        if(cn==null)
        {
          return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).build();

        }
        
        return ResponseEntity.of(Optional.of(cn));
    }catch(Exception e)
      {
          e.printStackTrace();
          return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
      }
      
      
       
    }
    
}
