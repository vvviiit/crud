package org.arpit.java2blog.service;

import org.arpit.java2blog.dao.CountryDAO;
import org.arpit.java2blog.model.Country;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("countryService")
public class CountryService {

    @Autowired
    CountryDAO countryDAO;

    @Transactional
    public List getAllCountries(){
        return countryDAO.getAllCountries();
    }
    @Transactional
    public Country getCountry(int id){
        return  countryDAO.getCountry(id);
    }
    @Transactional
    public void addCountry(Country country){
        countryDAO.addCountry(country);
    }
    @Transactional
    public void updateCountry(Country country){
        countryDAO.updateCountry(country);
    }
    @Transactional
    public void deleteCountry(int id){
        countryDAO.deleteCountry(id);
    }
}
