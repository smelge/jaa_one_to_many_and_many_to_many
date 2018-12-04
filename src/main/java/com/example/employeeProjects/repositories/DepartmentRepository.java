package com.example.employeeProjects.repositories;

import com.example.employeeProjects.models.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department,Long> {
}
