package com.cognizant.spring_advanced_rest_handson.service;

import com.cognizant.spring_advanced_rest_handson.dao.EmployeeDao;
import com.cognizant.spring_advanced_rest_handson.model.Employee;
import com.cognizant.spring_advanced_rest_handson.service.exception.EmployeeNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeDao employeeDao;

    public List<Employee> getAllEmployees() {
        return employeeDao.getAllEmployees();
    }

    public Employee getEmployee(int id) throws EmployeeNotFoundException {
        Employee employee = employeeDao.getEmployeeById(id);
        if (employee == null) {
            throw new EmployeeNotFoundException("Employee with ID " + id + " not found");
        }
        return employee;
    }

    public void addEmployee(Employee employee) {
        employeeDao.addEmployee(employee);
    }

    public void updateEmployee(Employee employee) throws EmployeeNotFoundException {
        if (employeeDao.getEmployeeById(employee.getId()) == null) {
            throw new EmployeeNotFoundException("Employee with ID " + employee.getId() + " not found");
        }
        employeeDao.updateEmployee(employee);
    }

    public void deleteEmployee(int id) throws EmployeeNotFoundException {
        if (employeeDao.getEmployeeById(id) == null) {
            throw new EmployeeNotFoundException("Employee with ID " + id + " not found");
        }
        employeeDao.deleteEmployee(id);
    }
}