package com.cognizant.ormlearn2.model;

import java.util.*;
import javax.persistence.*;

@Entity
@Table(name = "skill")
public class Skill {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;

    @ManyToMany(mappedBy = "skillList")
    private Set<Employee> employeeList;
}
