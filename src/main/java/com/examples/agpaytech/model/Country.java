package com.examples.agpaytech.model;

public class Country {


    private String countryName;
    public Country(String countryName) {
        this.countryName = countryName;
    }
    public Country() {
    }
    public String getCountryName() {
        return countryName;
    }
    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }
    @Override
    public String toString() {
        return "Country [countryName=" + countryName + "]";
    }
    



   
    
}
