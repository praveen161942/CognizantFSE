package com.cognizant.spring_advanced_rest_handson.dao;

import com.cognizant.spring_advanced_rest_handson.model.Employee;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class EmployeeDao {

    private static List<Employee> employees = new ArrayList<>();

    static {
        // Preload some employees
        employees.add(new Employee() {{
            setId(1);
            setName("John Doe");
            setSalary(50000);
            setPermanent(true);
        }});
        employees.add(new Employee() {{
            setId(2);
            setName("Jane Smith");
            setSalary(60000);
            setPermanent(false);
        }});
    }

    public List<Employee> getAllEmployees() {
        return employees;
    }

    public Employee getEmployeeById(int id) {
        return employees.stream().filter(e -> e.getId() == id).findFirst().orElse(null);
    }

    public void addEmployee(Employee employee) {
        employees.add(employee);
    }

    public void updateEmployee(Employee updatedEmployee) {
        Employee employee = getEmployeeById(updatedEmployee.getId());
        if (employee != null) {
            employee.setName(updatedEmployee.getName());
            employee.setSalary(updatedEmployee.getSalary());
            employee.setPermanent(updatedEmployee.getPermanent());
            employee.setDepartment(updatedEmployee.getDepartment());
            employee.setDateOfBirth(updatedEmployee.getDateOfBirth());
        }
    }

    public void deleteEmployee(int id) {
        employees.removeIf(e -> e.getId() == id);
    }
}