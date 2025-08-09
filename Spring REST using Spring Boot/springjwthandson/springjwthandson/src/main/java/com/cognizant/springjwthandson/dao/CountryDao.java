package com.cognizant.springjwthandson.dao;

import com.cognizant.springjwthandson.model.Country;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CountryDao {

    @Autowired
    private ApplicationContext context;

    @SuppressWarnings("unchecked")
    public List<Country> getAllCountries() {
        return (List<Country>) context.getBean("countryList");
    }
}