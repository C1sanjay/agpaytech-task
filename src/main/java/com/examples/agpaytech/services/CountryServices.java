package com.examples.agpaytech.services;

import java.util.ArrayList;
import java.util.List;

import com.examples.agpaytech.model.Country;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class CountryServices {

    private static List<Country> list=new ArrayList<Country>();

    static{

        list.add(new Country("India"));
        list.add(new Country("Nepal"));
        list.add(new Country("Africa"));
        list.add(new Country("Paris"));

    }
        public List<Country> getAllCountry(){
            return list;
        }

        public Country getCountryByName(String name){
           Country country=null;
           try{
            country= list.stream().filter(e->e.getCountryName().equals(name)).findFirst().get();
           }
           catch(Exception e){
               e.printStackTrace();
           }
           
           return country;

        }
        //adding a country in list.
        public Country addCountries(Country c){
            try{

             
          Country v= list.stream().filter(e->e.getCountryName().equals(c.getCountryName())).findFirst().get();
           if(v!=null)
           {
               return null;
           }
        }catch(Exception e){
            e.printStackTrace();
        }
        list.add(c);
        return c;

        
           

        }
    
    
}
