package com.example.employeeProjects;

import com.example.employeeProjects.models.Department;
import com.example.employeeProjects.models.Employee;
import com.example.employeeProjects.models.Project;
import com.example.employeeProjects.repositories.DepartmentRepository;
import com.example.employeeProjects.repositories.EmployeeRepository;
import com.example.employeeProjects.repositories.ProjectRepository;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EmployeeProjectsApplicationTests {
	@Autowired
	EmployeeRepository employeeRepository;
	@Autowired
	DepartmentRepository departmentRepository;
	@Autowired
	ProjectRepository projectRepository;

	@Test
	public void contextLoads() {
	}

	@Test
	public void canGetEmployee(){
		Department department = new Department("Sheep & Grazing");
		Employee employee = new Employee("John","McExplosion",90210,department);
		departmentRepository.save(department);
		employeeRepository.save(employee);
	}

	@Test
	public void canGetDepartment(){
		Department department = new Department("Seasonings");
		departmentRepository.save(department);
	}

	@Test
	public void canGetProject(){
		Project project = new Project("Fake Santa",24);
		projectRepository.save(project);
	}

	@Test
	public void createEmployeeAndDepartment(){
		Department department = new Department("Fancy Meats");
		departmentRepository.save(department);
		Employee employee1 = new Employee("Leslie","Flaps",1234,department);
		employeeRepository.save(employee1);
	}

	@Test
	public void createEmployeeAndProject(){
		Project project = new Project("Greasy Chains",50);
		Department department2 = new Department("Spinning Wildly");
		Employee employee2 = new Employee("Peter","Munt",6743,department2);

		departmentRepository.save(department2);
		employeeRepository.save(employee2);
		projectRepository.save(project);
		project.setEmployees(employee2);
		projectRepository.save(project);
	}


}
