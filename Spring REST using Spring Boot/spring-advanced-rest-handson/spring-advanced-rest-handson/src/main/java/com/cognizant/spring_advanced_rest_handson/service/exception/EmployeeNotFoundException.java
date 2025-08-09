package com.cognizant.spring_advanced_rest_handson.service.exception;


public class EmployeeNotFoundException extends Exception {
    public EmployeeNotFoundException(String message) {
        super(message);
    }
}