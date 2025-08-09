package com.cognizant.spring_advanced_rest_handson.model;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class Department {

    @NotNull(message = "Department ID cannot be null")
    private Integer id;

    @NotNull(message = "Department name cannot be null")
    @Size(min = 2, max = 30, message = "Department name should have 2 to 30 characters")
    private String name;

    public Department() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}