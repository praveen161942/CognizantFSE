package com.cognizant.spring_advanced_rest_handson.model;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Country {
    private static final Logger LOGGER = LoggerFactory.getLogger(Country.class);

    @NotNull(message = "Code cannot be null")
    @Size(min = 2, max = 2, message = "Code should be exactly 2 characters")
    private String code;

    @NotNull(message = "Name cannot be null")
    @Size(min = 2, max = 30, message = "Name should have 2 to 30 characters")
    private String name;

    public Country() {
        LOGGER.debug("Inside Country Constructor.");
    }

    public String getCode() {
        LOGGER.debug("Getting country code");
        return code;
    }

    public void setCode(String code) {
        LOGGER.debug("Setting country code: {}", code);
        this.code = code;
    }

    public String getName() {
        LOGGER.debug("Getting country name");
        return name;
    }

    public void setName(String name) {
        LOGGER.debug("Setting country name: {}", name);
        this.name = name;
    }

    @Override
    public String toString() {
        return "Country [code=" + code + ", name=" + name + "]";
    }
}