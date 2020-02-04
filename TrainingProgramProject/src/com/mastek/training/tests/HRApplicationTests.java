package com.mastek.training.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.mastek.training.hrapp.Announcement;
import com.mastek.training.hrapp.Designations;
import com.mastek.training.hrapp.EmailAnnouncement;
import com.mastek.training.hrapp.Employee;
import com.mastek.training.hrapp.Grades;
import com.mastek.training.hrapp.SMSAnnouncement;
import com.mastek.training.hrapp.SalesEmployee;
import com.mastek.training.packone.Circle;
import com.mastek.training.packone.Rectangle;
import com.mastek.training.packone.Shape;



class HRApplicationTests {
	
	Employee ex1;
	
	@BeforeEach
	public void setup() {
		System.out.println("\n<==========Before test case==========>\n");
		// Employee.DEFAULT_ZERO; // <Class_Name>.<Static_Member>
		ex1 = new Employee();
		ex1.setEmpno(1002);
		ex1.setName("Jack");
		ex1.setUnitDaySalary(300);
		ex1.setDesignation(Designations.MANAGER);
		ex1.setGrade(Grades.G8);
		
		Employee ex2 = new Employee(1122);
		Employee ex3 = new Employee(2233,"Example",344.0,Designations.DEVELOPER);
		
		ex2=null;  // release the object to mark as garbage
		ex3=null;
		System.gc(); // notify system to collect garbage
		// ex2.getEmpno(); will throw NullPointerException
	}
	
	@AfterEach
	public void tearDown() {
		System.out.println("\n<==========After test case==========>");
	}

	@Test
	void testCreateAndPrintExampleEmployeeObject() {
		System.out.println("test case create");

		System.out.println(
				"Number: "+ex1.getEmpno()+
				"\nName: "+ex1.getName()+
				"\nDay Salary: "+ex1.getUnitDaySalary()+
				"\nDesignation: "+ex1.getDesignation()+
				"\nGrade: "+ex1.getGrade());
	}
	
	@Test
	void testCreateAndComputeSalaryEmployeeObject() {
		System.out.println("test case compute");
		try {
			assertEquals(0,ex1.getNetSalary(-30),"Invalid net salary computation");
			assertEquals(9000.0,ex1.getNetSalary(30),"Invalid net salary computation");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	@Test
	void testSalesEmployeeObjectUsage() {
		SalesEmployee saleEX1 = new SalesEmployee();
		
		saleEX1.setEmpno(224);
		saleEX1.setName("hi");
		saleEX1.setUnitDaySalary(100);
		saleEX1.setDesignation(Designations.OFFICE);
		saleEX1.setGrade(Grades.G8);
		saleEX1.setComission(0.8);
		saleEX1.setTarget(1000000000);
		
		try {
			assertEquals(1620,saleEX1.getNetSalary(9),"Invalid Salary Calculated");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	void testObjectFeaturesOnEmployee() {
		System.out.println("<==== Object Features Start ====>");
		System.out.println(ex1.toString());
		System.out.println("HashCode: "+ex1.hashCode());
		System.out.println("<==== Object Features End ====>");
	}
	
	@Test
	void testSendAnnouncementToEmployees() {
		// we cannot create an object of abstract class using new keyword
		// Announcement exAnnouncement = new Announcement();
		
		// to use an abstract class object you must extend it with derived class
		// and override all abstract methods defined in base/parent class
		Announcement exSMS = new SMSAnnouncement();
		exSMS.setFrom("UK-HR");
		exSMS.setForGroup("Masketeer_at_glasgow");
		exSMS.setSubject("Inclement weather conditions at Glasgow");
		exSMS.setContentText("All employees are advised to opt for work from home, tomorrow");
		
		
		Announcement exEmail = new EmailAnnouncement();
		exEmail.setFrom("Leadership Team");
		exEmail.setForGroup("Masketeers");
		exEmail.setSubject("QMEET JAN 2020");
		exEmail.setContentText("You are all invited to attend Quarterly Meet Online via WEBEX");
		
		if(exSMS instanceof SMSAnnouncement) {
			System.out.println("Connect to Telecom SMS service");
			exSMS.sendAnnouncement(); // connect to SMS and use Send from SMSAnnouncement
		}
		if(exEmail instanceof EmailAnnouncement) {
			System.out.println("Connect to Email service");
			exEmail.sendAnnouncement(); // connect to Email and use Send from SMSAnnouncement
		}
		assertTrue(exSMS instanceof SMSAnnouncement, "Invalid Announcement Implementation");
		assertTrue(exEmail instanceof EmailAnnouncement, "Invalid Announcement Implementation");
	}
	
	@Test
	void testShapeExample() {
		Rectangle rect = new Rectangle();
		rect.setLength(10);
		rect.setBreadth(20);
		
		Circle circle = new Circle();
		circle.setRadius(20);
		
		Shape shRect = rect;
		Shape shCircle = circle;
		
		System.out.println("Rectangle Area: "+shRect.getArea());
		System.out.println("Rectangle Perimeter: "+shRect.getPerimeter());
		
		
		System.out.println("Circle Area: "+shCircle.getArea());
		System.out.println("Circle Perimeter: "+shCircle.getPerimeter());
		
		assertTrue(rect instanceof Shape, "Invalid Type of Shape");
		assertTrue(circle instanceof Shape, "Invalid Type of Shape");
	}

}
