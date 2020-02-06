package com.mastek.hrapp.services;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.mastek.hrapp.dao.DepartmentJPADAO;
import com.mastek.hrapp.dao.EmployeeJPADAO;
import com.mastek.hrapp.dao.ProjectJPADAO;
import com.mastek.hrapp.entities.Department;
import com.mastek.hrapp.entities.Employee;
import com.mastek.hrapp.entities.Project;

@Component // marking class as bean to be created
@Scope("singleton") // singleton: One object used across test cases, prototype: one object per request
public class EmployeeService {
	
	String exampleProperty;
	
	// declare all the entity DAOs to perform operation across multiple entities
	@Autowired
	EmployeeJPADAO empDAO;
	
	@Autowired
	DepartmentJPADAO depDAO;
	
	@Autowired
	ProjectJPADAO projDAO;
	
	public EmployeeService() {
		System.out.println("Employee service created");
	}
	
	@PostConstruct // initialisation method of the class
	public void initializeService() {
		System.out.println("Employee service initialized");
	}
	
	@PreDestroy // calls before shutting down the application
	public void terminateService() {
		System.out.println("Employee service terminated");
	}
	
	public void exampleMethod() {
		System.out.println("Connect to "+getExampleProperty()+" for business data");
	}

	public String getExampleProperty() {
		return exampleProperty;
	}

	@Value("Spring example data source") // initialise property with the value 
	public void setExampleProperty(String exampleProperty) {
		System.out.println("Example property set: "+exampleProperty);
		this.exampleProperty = exampleProperty;
	}

	@Transactional // this will keep the session open until the method returns the value
	public Employee assignEmployeeToDepartment(int empno, int depno) {
		Employee emp = empDAO.findById(empno).get();
		Department dep = depDAO.findById(depno).get(); // fetch numbers if they exist
		
		// assign association between employee and department
		emp.setCurrentDepartment(dep); // assign department to employee
		dep.getTeam().add(emp); // add employee in the department team
		
		// save changes in database
		empDAO.save(emp);
		depDAO.save(dep);
		
		return emp; // return result
	}

	@Transactional
	public Employee assignEmployeeToProject(int empno, int projId) {
		Employee emp = empDAO.findById(empno).get(); // get employee object
		Project newProject = projDAO.findById(projId).get(); // get project object
		
		emp.getProjectsAssigned().add(newProject); // assign employee to project
		empDAO.save(emp); // save employee object
		
		return emp; // return employee object
	}
	
}
