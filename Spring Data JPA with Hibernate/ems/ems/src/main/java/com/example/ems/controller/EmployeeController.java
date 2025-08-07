package com.example.ems.controller;

import com.example.ems.model.Employee;
import com.example.ems.projection.EmployeeNameView;
import com.example.ems.repository.EmployeeRepository;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    private final EmployeeRepository repo;

    public EmployeeController(EmployeeRepository repo) {
        this.repo = repo;
    }

    @GetMapping
    public List<Employee> getAll() {
        return repo.findAll();
    }

    @PostMapping
    public Employee create(@RequestBody Employee e) {
        return repo.save(e);
    }

    @PutMapping("/{id}")
    public Employee update(@PathVariable Long id, @RequestBody Employee e) {
        e.setId(id);
        return repo.save(e);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        repo.deleteById(id);
    }

    @GetMapping("/search")
    public List<Employee> search(@RequestParam String keyword) {
        return repo.findByNameContaining(keyword);
    }

    @GetMapping("/email")
    public List<Employee> searchByEmail(@RequestParam String email) {
        return repo.searchByEmail(email);
    }

    @GetMapping("/paged")
    public Page<Employee> getPaged(@RequestParam int page, @RequestParam int size) {
        return repo.findAll(PageRequest.of(page, size));
    }

    @GetMapping("/names")
    public List<EmployeeNameView> getNames() {
        return repo.findAllBy();
    }
}