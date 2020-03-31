package com.mastek.hrapp;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.mastek.hrapp.dao.DepartmentJPADAO;
import com.mastek.hrapp.dao.EmployeeJPADAO;
import com.mastek.hrapp.dao.JobPositionsDAO;
import com.mastek.hrapp.dao.PaymentJPADAO;
import com.mastek.hrapp.dao.ProjectJPADAO;
import com.mastek.hrapp.entities.CardPayment;
import com.mastek.hrapp.entities.ChequePayment;
import com.mastek.hrapp.entities.Department;
import com.mastek.hrapp.entities.Designation;
import com.mastek.hrapp.entities.Employee;
import com.mastek.hrapp.entities.JobPositions;
import com.mastek.hrapp.entities.Payment;
import com.mastek.hrapp.entities.Project;
import com.mastek.hrapp.services.EmployeeService;

@SpringBootTest
class HrappApplicationTests {

	@Autowired // spring will provide object using IoC, Dependent Injection technique
	EmployeeService empSvc;
	
	@Autowired
	EmployeeService empSvc1;
	
	@Autowired
	EmployeeJPADAO empDAO;
	
	@Autowired
	DepartmentJPADAO depDAO;
	
	@Autowired
	ProjectJPADAO projDAO;
   
    @Autowired
    PaymentJPADAO paymentDAO;
    
    @Autowired
    JobPositionsDAO jobDAO;
    
    @Test
    void testAddJobPositionDocument() {
    	JobPositions jp = new JobPositions();
    	jp.setJobId(125);
    	jp.setLocation("LEEDS");
    	jp.setClientName("MOD");
    	jp.setSkillsRequired("JAVA");
    	jp.setNoOfPositions(2);
    	
    	jp = jobDAO.save(jp);
    	
    	assertNotNull(jp,"Job Position Not Saved");
    }
    
    @Test
    void testListAllJobPositions() {
    	System.out.println("Print all job positions");
    	for(JobPositions jp : jobDAO.findAll())
    		System.out.println(jp);
    }
    
    @Test
    void testFindEmployeesBySalary(){
    	double minSalary=100.0;
    	double maxSalary=5000.0;
    							// empDAO.findBySalary(minSalary,maxSalary)
    	Iterable<Employee> emps = empDAO.findBySalary(minSalary,maxSalary);
    	
    	System.out.println("All employees having salary between min: "+minSalary+" and max: "+maxSalary);
    	
    	for (Employee employee : emps) {
			System.out.println(employee);
		}
    }
    
    @Test
    void testFindByEmployeesByDesignation() {
    	Iterable<Employee> emps = empDAO.findByDesignation(Designation.MANAGER);
    	
    	System.out.println("All employees with designation as "+Designation.MANAGER);
    	
    	for (Employee employee : emps) {
			System.out.println(employee);
		}
    }
	
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
	
//	// @Test
//	void testDepartmentDAOAdd() {
//		Department dep = new Department();
//		dep.setName("Example");
//		dep.setLocation("Example");;
//		
//		// dep = depDAO.save(dep);
//		
//		System.out.println(dep);
//		assertNotNull(dep,"Department not added");
//	}
	
//	// @Test
//	void testListDepartment() {
//		Iterable<Department> deps = depDAO.findAll();
//		assertNotNull(deps, "Department not found");
//		for (Department department : deps) {
//			System.out.println(department);
//		}
	
	/*@Test
	void testProjectServiceExamleMethod() {
		projSvc.exampleMethod();
	}*/
	
//	// @Test
//	void testProjectDAOAdd() {
//		Project proj = new Project();
//		proj.setName("Example");
//		proj.setCustomerName("Capita");
//		
//		// proj = projDAO.save(proj);
//		
//		System.out.println(proj);
//		assertNotNull(proj,"Project not added");
//	}
	
//	// @Test
//	void testListProject() {
//		Iterable<Project> projs = projDAO.findAll();
//		assertNotNull(projs, "Project not found");
//		for (Project project : projs) {
//			System.out.println(project);
//		}

	
//	// @Test
//	void testUpdateEmployees() {
//		Employee emp = empDAO.findById(1).get();
//		System.out.println("Employee fetched: "+emp);
//		
//		emp.setSalary(emp.getSalary()+1001);
//		emp.setDesignation(Designation.TESTER);
//		
//		emp = empDAO.save(emp);
//		
//		System.out.println("Updated employee: "+emp);				
//	}
	
	/*@Test
	void testDeleteEmployeeById() {
		// empDAO.delete(emp); // deletes by object
		empDAO.deleteById(25); // deletes by ID	
	}*/
	
//	// @Test
//	void testAssignEmployeeToDepartment() {
//						// emp.Svc.assignEmployeeToDepartment(empno,depno)
//		Employee emp=empSvc.assignEmployeeToDepartment(4,26);
//		assertNotNull(emp.getCurrentDepartment(),"Department not assigned");
//	}
	
//	// @Test
//	void testAssignEmployeeToProject() {            // empno,projectId
//		Employee emp = empSvc.assignEmployeeToProject(4,18);
//		assertTrue(emp.getProjectsAssigned().size()>0,"Projects assigned");
//	}
	
	 @Test
	    void testCashPaymentAdd() {
	        Payment cashP = new Payment();
	        cashP.setAmount(200);
	       
	        cashP= paymentDAO.save(cashP);
	       
	        System.out.println(cashP);
	        assertNotNull(cashP, "Cash Paymeny Not Saved");
	       
	       
	       
	    }
	   
	    @Test
	    void testChequePaymentAdd() {
	        ChequePayment cheqP = new ChequePayment();
	        cheqP.setAmount(777);
	        cheqP.setChequeNumber(65656565);
	        cheqP.setBankName("RBS");
	       
	        cheqP= paymentDAO.save(cheqP);
	       
	        System.out.println(cheqP);
	        assertNotNull(cheqP, "Cheque Paymeny Not Saved");
	       
	       
	       
	    }
	   
	    @Test
	    void testCardPaymentAdd() {
	        CardPayment cardP = new CardPayment();
	        cardP.setAmount(666);
	        cardP.setCardNumber(89898989);
	        cardP.setCardService("VISA");
	       
	        cardP= paymentDAO.save(cardP);
	       
	        System.out.println(cardP);
	        assertNotNull(cardP, "Card Payment Not Saved");
	       
	    }
	
//	    // @Test
//	    void testApplyForJobPosition() {
//	    	int jobId=1222;
//	    	int empno=16;
//	    	JobPositions jp = empSvc.applyForJobPosition(jobId, empno);
//	    	
//	    	assertNotNull(jp,"Job Not Applied");
//	    	
//	    	for (Employee applicant : jp.getApplicants()) {
//				System.out.println(applicant);
//			}
	    }
	    

















