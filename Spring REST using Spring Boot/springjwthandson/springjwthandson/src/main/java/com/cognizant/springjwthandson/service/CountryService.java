package com.cognizant.springjwthandson.service;

import com.cognizant.springjwthandson.dao.CountryDao;
import com.cognizant.springjwthandson.model.Country;
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
}