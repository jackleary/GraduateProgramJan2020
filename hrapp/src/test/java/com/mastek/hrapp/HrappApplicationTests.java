package com.mastek.hrapp;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.mastek.hrapp.dao.DepartmentJPADAO;
import com.mastek.hrapp.dao.EmployeeJPADAO;
import com.mastek.hrapp.dao.ProjectJPADAO;
import com.mastek.hrapp.entities.Department;
import com.mastek.hrapp.entities.Designation;
import com.mastek.hrapp.entities.Employee;
import com.mastek.hrapp.entities.Project;
import com.mastek.hrapp.services.DepartmentServices;
import com.mastek.hrapp.services.EmployeeService;
import com.mastek.hrapp.services.ProjectServices;

@SpringBootTest
class HrappApplicationTests {

	@Autowired // spring will provide object using IoC, Dependent Injection technique
	EmployeeService empSvc;
	
	@Autowired
	EmployeeService empSvc1;
	
	@Autowired
	EmployeeJPADAO empDAO;
	
	/*@Autowired
	DepartmentServices depSvc;*/
	
	@Autowired
	DepartmentJPADAO depDAO;
	
	/*@Autowired
	ProjectServices projSvc;*/
	
	@Autowired
	ProjectJPADAO projDAO;
	
	@Test
	void testEmployeeServiceExamleMethod() {
		empSvc.exampleMethod();
		empSvc1.exampleMethod();
	}

	@Test
	void testEmployeeDAOAdd() {
		Employee emp = new Employee();
		emp.setName("Example");
		emp.setSalary(2334);
		emp.setDesignation(Designation.MANAGER);
		
		// emp = empDAO.save(emp);
		
		System.out.println(emp);
		assertNotNull(emp,"Employee not added");
	}
	
	@Test
	void testListEmployees() {
		Iterable<Employee> emps = empDAO.findAll();
		assertNotNull(emps, "Employees not found");
		for (Employee employee : emps) {
			System.out.println(employee);
		}
	}
	
	/*@Test
	void testDepartmentServiceExamleMethod() {
		depSvc.exampleMethod();
	}*/
	
	@Test
	void testDepartmentDAOAdd() {
		Department dep = new Department();
		dep.setName("Example");
		dep.setLocation("Example");;
		
		// dep = depDAO.save(dep);
		
		System.out.println(dep);
		assertNotNull(dep,"Department not added");
	}
	
	@Test
	void testListDepartment() {
		Iterable<Department> deps = depDAO.findAll();
		assertNotNull(deps, "Department not found");
		for (Department department : deps) {
			System.out.println(department);
		}
	}
	
	/*@Test
	void testProjectServiceExamleMethod() {
		projSvc.exampleMethod();
	}*/
	
	@Test
	void testProjectDAOAdd() {
		Project proj = new Project();
		proj.setName("Example");
		proj.setCustomerName("Capita");
		
		// proj = projDAO.save(proj);
		
		System.out.println(proj);
		assertNotNull(proj,"Project not added");
	}
	
	@Test
	void testListProject() {
		Iterable<Project> projs = projDAO.findAll();
		assertNotNull(projs, "Project not found");
		for (Project project : projs) {
			System.out.println(project);
		}
	}
	
	@Test
	void testUpdateEmployees() {
		Employee emp = empDAO.findById(1).get();
		System.out.println("Employee fetched: "+emp);
		
		emp.setSalary(emp.getSalary()+1001);
		emp.setDesignation(Designation.TESTER);
		
		emp = empDAO.save(emp);
		
		System.out.println("Updated employee: "+emp);				
	}
	
	/*@Test
	void testDeleteEmployeeById() {
		// empDAO.delete(emp); // deletes by object
		empDAO.deleteById(25); // deletes by ID	
	}*/
	
	@Test
	void testAssignEmployeeToDepartment() {
						// emp.Svc.assignEmployeeToDepartment(empno,depno)
		Employee emp=empSvc.assignEmployeeToDepartment(4,26);
		assertNotNull(emp.getCurrentDepartment(),"Department not assigned");
	}
	
	@Test
	void testAssignEmployeeToProject() {            // empno,projectId
		Employee emp = empSvc.assignEmployeeToProject(4,18);
		assertTrue(emp.getProjectsAssigned().size()>0,"Projects assigned");
	}
	
}

















