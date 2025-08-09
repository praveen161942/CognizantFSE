package com.cognizant.spring_advanced_rest_handson.model;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import jakarta.validation.constraints.Positive;
import java.util.Date;

public class Employee {

    @NotNull(message = "ID cannot be null")
    private Integer id;

    @NotNull(message = "Name cannot be null")
    @Size(min = 2, max = 30, message = "Name should have 2 to 30 characters")
    private String name;

    @NotNull(message = "Salary cannot be null")
    @Positive(message = "Salary must be positive")
    private double salary;

    @NotNull(message = "Permanent status is required")
    private Boolean permanent;

    private Date dateOfBirth;

    @Valid
    private Department department;

    public Employee() {
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

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public Boolean getPermanent() {
        return permanent;
    }

    public void setPermanent(Boolean permanent) {
        this.permanent = permanent;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }
}
