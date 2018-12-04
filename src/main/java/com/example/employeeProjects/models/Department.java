package com.example.employeeProjects.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="departments")

public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    @Column(name="name")
    private String name;
    @JsonIgnore
    @OneToMany(mappedBy="department",fetch = FetchType.LAZY)
        private List<Employee> employees;


    public Department(String name) {
        this.name = name;
        this.employees = new ArrayList<Employee>();
    }

    public Department() {
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }
}
