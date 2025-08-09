package com.cognizant.spring_advanced_rest_handson;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@ImportResource("classpath:country.xml")
class SpringadvancedresthandsonApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringadvancedresthandsonApplication.class, args);
    }
}