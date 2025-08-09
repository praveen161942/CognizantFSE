package com.cognizant.spring_advanced_rest_handson.controller;

import com.cognizant.spring_advanced_rest_handson.model.Country;
import com.cognizant.spring_advanced_rest_handson.service.CountryService;
import com.cognizant.spring_advanced_rest_handson.service.exception.CountryNotFoundException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/countries")
public class CountryController {

    @Autowired
    private CountryService countryService;

    // Get all countries
    @GetMapping
    public List<Country> getAllCountries() {
        return countryService.getAllCountries();
    }

    // Get country by code
    @GetMapping("/{code}")
    public Country getCountry(@PathVariable String code) throws CountryNotFoundException {
        return countryService.getCountry(code);
    }

    // Add new country
    @PostMapping
    public void addCountry(@Valid @RequestBody Country country) {
        countryService.addCountry(country);
    }

    // Update existing country
    @PutMapping("/{code}")
    public void updateCountry(@PathVariable String code, @Valid @RequestBody Country country) throws CountryNotFoundException {
        country.setCode(code);
        countryService.updateCountry(country);
    }

    // Delete country
    @DeleteMapping("/{code}")
    public void deleteCountry(@PathVariable String code) throws CountryNotFoundException {
        countryService.deleteCountry(code);
    }
}