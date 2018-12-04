package com.example.employeeProjects.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="employees")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    @Column(name="firstname")
    private String firstName;
    @Column(name="lastname")
    private String lastName;
    @Column(name="employee_no")
    private int employeeNo;
    @ManyToOne
    @JoinColumn(name="department_id",nullable=false)
    private Department department;

    @ManyToMany
    @JoinTable(
            name="employees_projects",
            joinColumns = {@JoinColumn(
                    name="employee_id",
                    nullable=false,
                    updatable = false)
            },
            inverseJoinColumns = {@JoinColumn(
                    name="project_id",
                    nullable=false,
                    updatable=false)
            }
    )
    private List<Project> project;

    public Employee(String firstName, String lastName, int employeeNo,Department department) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.employeeNo = employeeNo;
        this.department = department;
    }

    public Employee() {
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public Long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getEmployeeNo() {
        return employeeNo;
    }

    public void setEmployeeNo(int employeeNo) {
        this.employeeNo = employeeNo;
    }
}
