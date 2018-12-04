package com.example.employeeProjects.repositories;

import com.example.employeeProjects.models.Project;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepository extends JpaRepository<Project,Long> {
}
