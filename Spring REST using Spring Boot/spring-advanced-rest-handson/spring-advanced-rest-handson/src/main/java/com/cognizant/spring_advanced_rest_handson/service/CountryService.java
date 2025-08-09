package com.cognizant.spring_advanced_rest_handson.service;

import com.cognizant.spring_advanced_rest_handson.dao.CountryDao;
import com.cognizant.spring_advanced_rest_handson.model.Country;
import com.cognizant.spring_advanced_rest_handson.service.exception.CountryNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountryService {

    @Autowired
    private CountryDao countryDao;

    public List<Country> getAllCountries() {
        return countryDao.getAllCountries();
    }

    public Country getCountry(String code) throws CountryNotFoundException {
        Country country = countryDao.getCountry(code);
        if (country == null) {
            throw new CountryNotFoundException("Country with code " + code + " not found");
        }
        return country;
    }

    public void addCountry(Country country) {
        countryDao.addCountry(country);
    }

    public void updateCountry(Country country) throws CountryNotFoundException {
        if (countryDao.getCountry(country.getCode()) == null) {
            throw new CountryNotFoundException("Country with code " + country.getCode() + " not found");
        }
        countryDao.updateCountry(country);
    }

    public void deleteCountry(String code) throws CountryNotFoundException {
        if (countryDao.getCountry(code) == null) {
            throw new CountryNotFoundException("Country with code " + code + " not found");
        }
        countryDao.deleteCountry(code);
    }
}