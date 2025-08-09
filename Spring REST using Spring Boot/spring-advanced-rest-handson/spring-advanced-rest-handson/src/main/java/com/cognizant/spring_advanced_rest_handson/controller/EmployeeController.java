package com.cognizant.spring_advanced_rest_handson.controller;


import com.cognizant.spring_advanced_rest_handson.model.Employee;
import com.cognizant.spring_advanced_rest_handson.service.EmployeeService;
import com.cognizant.spring_advanced_rest_handson.service.exception.EmployeeNotFoundException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    // Get all employees
    @GetMapping
    public List<Employee> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

    // Get employee by ID
    @GetMapping("/{id}")
    public Employee getEmployee(@PathVariable int id) throws EmployeeNotFoundException {
        return employeeService.getEmployee(id);
    }

    // Add new employee
    @PostMapping
    public void addEmployee(@Valid @RequestBody Employee employee) {
        employeeService.addEmployee(employee);
    }

    // Update existing employee
    @PutMapping("/{id}")
    public void updateEmployee(@PathVariable int id, @Valid @RequestBody Employee employee) throws EmployeeNotFoundException {
        employee.setId(id);
        employeeService.updateEmployee(employee);
    }

    // Delete employee
    @DeleteMapping("/{id}")
    public void deleteEmployee(@PathVariable int id) throws EmployeeNotFoundException {
        employeeService.deleteEmployee(id);
    }
}