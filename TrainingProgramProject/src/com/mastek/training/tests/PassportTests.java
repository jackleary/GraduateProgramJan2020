package com.mastek.training.tests;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.time.Month;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.mastek.training.hrapp.Employee;
import com.mastek.training.hrapp.dao.DataAccessObject;
import com.mastek.training.passports.PassportDAO;
import com.mastek.training.passports.PassportInfo;
import com.mastek.training.passports.PassportJDBC;
import com.mastek.training.passports.Sex;

class PassportTests {
	
	PassportDAO<PassportInfo> passDAO;
		
		@BeforeEach
		void setUp() throws Exception {
			
			passDAO = new PassportJDBC();
			
		}
		
		@AfterEach
		void tearDown() throws Exception {
			
		}
		
//		@Test
//		void testSetPassportNumber() {
//			PassportInfo p = new PassportInfo();
//			p.setPassportNumber("123456789");
//			
//			System.out.println("Number: "+p.getPassportNumber());
//		}
		
		@Test
		void testAddPassport() {
			PassportInfo p = new PassportInfo();
			p.setPassportNumber("123456782");
			p.setAddress("Example");
			p.setCity("Example");
			p.setCounty("Example");
			p.setDateOfBirth(LocalDate.of(1998, Month.MARCH, 25));
			p.setIssueDate(LocalDate.of(2010, Month.DECEMBER, 20));
			p.setExpiaryDate(LocalDate.of(2020, Month.DECEMBER, 20));
			p.setName("Example");
			p.setPostcode("CH82 8GF");
			p.setSex(Sex.MALE);
			
			p = passDAO.add(p);
			assertNotNull(p,"Passport not added");
			
//			PassportInfo fetchp = passDAO.find(1);
//			assertNotNull(fetchp,"Passport not found");
			
			
		}
		
//		@Test
//		void testRemovePassport() {
//			fail("Test not implemented");
//		}
//		
//		@Test
//		void testPrintPassports() {
//			fail("Test not implemented");
//		}
		
	}
