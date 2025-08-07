package com.cognizant.ormlearn2;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import com.cognizant.ormlearn2.model.*;
import com.cognizant.ormlearn2.repository.StockRepository;
import com.cognizant.ormlearn2.service.CountryService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class OrmLearn2Application implements CommandLineRunner {

    @Autowired
    private CountryService countryService;

    @Autowired
    private StockRepository stockRepository;

    public static void main(String[] args) {
        SpringApplication.run(OrmLearn2Application.class, args);
    }

    @Override
    public void run(String... args) {
        countryService.searchByName("ou").forEach(System.out::println);
        countryService.getByPrefix("Z").forEach(System.out::println);

        stockRepository.findByCodeAndDateBetween("FB",
                LocalDate.of(2019, 9, 1), LocalDate.of(2019, 9, 30))
                .forEach(System.out::println);

        stockRepository.findByCodeAndCloseGreaterThan("GOOGL", new BigDecimal("1250"))
                .forEach(System.out::println);

        stockRepository.findTop3ByOrderByVolumeDesc().forEach(System.out::println);
        stockRepository.findTop3ByCodeOrderByCloseAsc("NFLX").forEach(System.out::println);
    }
}