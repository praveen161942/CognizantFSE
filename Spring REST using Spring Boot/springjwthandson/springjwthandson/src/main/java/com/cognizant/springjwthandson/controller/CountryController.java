package com.cognizant.springjwthandson.controller;

import com.cognizant.springjwthandson.model.Country;
import com.cognizant.springjwthandson.service.CountryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CountryController {
    private static final Logger LOGGER = LoggerFactory.getLogger(CountryController.class);

    private final CountryService countryService;
    public CountryController(CountryService countryService) {
        this.countryService = countryService;
    }

    @GetMapping("/countries")
    public List<Country> getAllCountries() {
        LOGGER.info("START - getAllCountries");
        List<Country> list = countryService.getAllCountries();
        LOGGER.info("END - getAllCountries");
        return list;
    }
}