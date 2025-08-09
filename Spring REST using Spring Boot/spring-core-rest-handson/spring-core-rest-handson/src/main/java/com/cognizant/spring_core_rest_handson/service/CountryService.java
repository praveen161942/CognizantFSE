package com.cognizant.spring_core_rest_handson.service;

import com.cognizant.spring_core_rest_handson.model.Country;
import com.cognizant.spring_core_rest_handson.service.exception.CountryNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;

@Service
public class CountryService {
    private static final Logger LOGGER = LoggerFactory.getLogger(CountryService.class);

    public Country getCountry(String code) {
        LOGGER.debug("START - getCountry({})", code);
        ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");
        @SuppressWarnings("unchecked")
        ArrayList<Country> countries = (ArrayList<Country>) context.getBean("countryList");

        for (Country c : countries) {
            if (c.getCode().equalsIgnoreCase(code)) {
                LOGGER.debug("END - getCountry() found {}", c);
                return c;
            }
        }

        LOGGER.debug("END - getCountry() not found, throwing exception");
        throw new CountryNotFoundException();
    }
}