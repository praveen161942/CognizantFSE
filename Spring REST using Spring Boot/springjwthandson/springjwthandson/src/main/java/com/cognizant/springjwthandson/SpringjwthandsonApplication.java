package com.cognizant.springjwthandson;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@ImportResource("classpath:country.xml")
public class SpringjwthandsonApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringjwthandsonApplication.class, args);
    }
}