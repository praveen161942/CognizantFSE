package com.example.ems.repository;

import com.example.ems.model.Employee;
import com.example.ems.projection.EmployeeNameView;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    List<Employee> findByNameContaining(String keyword);

    @Query("SELECT e FROM Employee e WHERE e.email LIKE %:email%")
    List<Employee> searchByEmail(@Param("email") String email);

    Page<Employee> findAll(Pageable pageable);

    List<EmployeeNameView> findAllBy();
}