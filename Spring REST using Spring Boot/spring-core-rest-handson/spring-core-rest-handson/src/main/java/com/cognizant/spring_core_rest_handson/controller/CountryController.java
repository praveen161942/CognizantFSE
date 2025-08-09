package com.cognizant.spring_core_rest_handson.controller;


import com.cognizant.spring_core_rest_handson.model.Country;
import com.cognizant.spring_core_rest_handson.service.CountryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@RestController
public class CountryController {
    private static final Logger LOGGER = LoggerFactory.getLogger(CountryController.class);

    private final CountryService countryService;

    public CountryController(CountryService countryService) {
        LOGGER.debug("Inside CountryController constructor.");
        this.countryService = countryService;
    }

    @RequestMapping("/country")
    public Country getCountryIndia() {
        LOGGER.info("START - getCountryIndia()");
        ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");
        Country country = (Country) context.getBean("country");
        LOGGER.debug("Country : {}", country);
        LOGGER.info("END - getCountryIndia()");
        return country;
    }

    @GetMapping("/countries")
    public ArrayList<Country> getAllCountries() {
        LOGGER.info("START - getAllCountries()");
        ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");
        @SuppressWarnings("unchecked")
        ArrayList<Country> countries = (ArrayList<Country>) context.getBean("countryList");
        LOGGER.debug("Countries : {}", countries);
        LOGGER.info("END - getAllCountries()");
        return countries;
    }

    @GetMapping("/countries/{code}")
    public Country getCountry(@PathVariable String code) {
        LOGGER.info("START - getCountry({})", code);
        Country country = countryService.getCountry(code);
        LOGGER.debug("Country : {}", country);
        LOGGER.info("END - getCountry()");
        return country;
    }
}