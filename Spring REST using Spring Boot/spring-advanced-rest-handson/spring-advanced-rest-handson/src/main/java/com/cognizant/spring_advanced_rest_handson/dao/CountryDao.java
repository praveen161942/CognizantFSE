package com.cognizant.spring_advanced_rest_handson.dao;

import com.cognizant.spring_advanced_rest_handson.model.Country;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class CountryDao {
    private static List<Country> countries = new ArrayList<>();

    static {
        countries.add(new Country() {{ setCode("IN"); setName("India"); }});
        countries.add(new Country() {{ setCode("US"); setName("United States"); }});
        countries.add(new Country() {{ setCode("UK"); setName("United Kingdom"); }});
    }

    public List<Country> getAllCountries() {
        return countries;
    }

    public Country getCountry(String code) {
        Optional<Country> country = countries.stream()
                .filter(c -> c.getCode().equalsIgnoreCase(code))
                .findFirst();
        return country.orElse(null);
    }

    public void addCountry(Country country) {
        countries.add(country);
    }

    public void updateCountry(Country country) {
        for (int i = 0; i < countries.size(); i++) {
            if (countries.get(i).getCode().equalsIgnoreCase(country.getCode())) {
                countries.set(i, country);
                return;
            }
        }
    }

    public void deleteCountry(String code) {
        countries.removeIf(c -> c.getCode().equalsIgnoreCase(code));
    }
}