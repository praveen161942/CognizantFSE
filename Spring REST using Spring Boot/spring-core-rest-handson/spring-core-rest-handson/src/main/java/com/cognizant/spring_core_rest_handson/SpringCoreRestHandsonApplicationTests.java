package com.cognizant.spring_core_rest_handson;

import com.cognizant.spring_core_rest_handson.controller.CountryController;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class SpringCoreRestHandsonApplicationTests {

    @Autowired
    private CountryController countryController;

    @Autowired
    private MockMvc mvc;

    @Test
    public void contextLoads() {
        assertNotNull(countryController);
    }

    @Test
    public void testGetCountry() throws Exception {
        mvc.perform(get("/country"))
           .andExpect(status().isOk())
           .andExpect(jsonPath("$.code").value("IN"))
           .andExpect(jsonPath("$.name").value("India"));
    }

    @Test
    public void testGetCountryByCode() throws Exception {
        mvc.perform(get("/countries/IN"))
           .andExpect(status().isOk())
           .andExpect(jsonPath("$.code").value("IN"))
           .andExpect(jsonPath("$.name").value("India"));
    }

    @Test
    public void testCountryNotFound() throws Exception {
        mvc.perform(get("/countries/ZZ"))
           .andExpect(status().isNotFound());
    }
}