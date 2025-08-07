package com.cognizant.ormlearn3;

import java.util.List;
import com.cognizant.ormlearn3.model.Employee;
import com.cognizant.ormlearn3.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SpringBootApplication
public class OrmLearn3Application implements CommandLineRunner {

    @Autowired
    private EmployeeService employeeService;

    private static final Logger LOGGER = LoggerFactory.getLogger(OrmLearn3Application.class);

    public static void main(String[] args) {
        SpringApplication.run(OrmLearn3Application.class, args);
    }

    @Override
    public void run(String... args) {
        testGetAllPermanentEmployees();
        testGetAverageSalary();
        testGetAllEmployeesNative();
    }

    private void testGetAllPermanentEmployees() {
        LOGGER.info("Start - Get All Permanent Employees");

        List<Employee> employees = employeeService.getAllPermanentEmployees();
        employees.forEach(e -> {
            LOGGER.debug("Employee: {}", e);
            LOGGER.debug("Department: {}", e.getDepartment());
            LOGGER.debug("Skills: {}", e.getSkillList());
        });

        LOGGER.info("End - Get All Permanent Employees");
    }

    private void testGetAverageSalary() {
        LOGGER.info("Start - Get Average Salary by Department");
        double avgSalary = employeeService.getAverageSalary(2);
        LOGGER.debug("Average Salary (Department ID 2): {}", avgSalary);
        LOGGER.info("End - Get Average Salary by Department");
    }

    private void testGetAllEmployeesNative() {
        LOGGER.info("Start - Native Query Get All Employees");
        List<Employee> employees = employeeService.getAllEmployeesNative();
        employees.forEach(e -> LOGGER.debug("Employee (Native): {}", e));
        LOGGER.info("End - Native Query Get All Employees");
    }
}