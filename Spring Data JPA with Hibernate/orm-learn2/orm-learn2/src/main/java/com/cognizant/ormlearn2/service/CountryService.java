package com.cognizant.ormlearn2.service;

import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cognizant.ormlearn2.model.Country;
import com.cognizant.ormlearn2.repository.CountryRepository;

@Service
public class CountryService {

    @Autowired
    private CountryRepository countryRepository;

    @Transactional
    public List<Country> searchByName(String keyword) {
        return countryRepository.findByNameContainingOrderByNameAsc(keyword);
    }

    @Transactional
    public List<Country> getByPrefix(String prefix) {
        return countryRepository.findByNameStartingWith(prefix);
    }
}