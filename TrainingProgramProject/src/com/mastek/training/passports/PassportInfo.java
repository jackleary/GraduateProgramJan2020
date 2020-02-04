// Build an application to accept for new passport to store them in Database

// Case Study Objectives:
// a. Create the database Table structure
// b. Create the Classes and Enums as required
// c. Create the Unit Test Cases to ensure all the operations are tested
// d. Create the DAO objects to help them access from the Database table

package com.mastek.training.passports;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.Date;

public class PassportInfo {
	
	private String passportNumber;
	private LocalDate issueDate;
	private LocalDate expiaryDate;
	private Sex sex;
	private String name;
	private String address;
	private String city;
	private String county;
	private String postcode;
	private LocalDate dateOfBirth;
	
	private static final LocalDate EXAMPLEDATE = LocalDate.of(2015, Month.JULY, 29);
	private static final LocalDate EXAMPLEDATE2 = LocalDate.of(2025, Month.JULY, 29);
	private static final LocalDate DOB = LocalDate.of(1990, Month.FEBRUARY, 25);
	
	static{
		
	}
	
	{
		setPassportNumber("999999999");
		setIssueDate(EXAMPLEDATE);
		setExpiaryDate(EXAMPLEDATE2);
		setSex(Sex.OTHER);
		setName("Example");
		setAddress("Example");
		setCity("Example");
		setCounty("Example");
		setPostcode("Example");
		setDateOfBirth(DOB);
	}
	
	public PassportInfo() {
		System.out.println("Default Constructor");
	}
	
	
	public void finalize() {
		setPassportNumber(null);
		setIssueDate(null);
		setExpiaryDate(null);
		setSex(null);
		setName(null);
		setAddress(null);
		setCity(null);
		setCounty(null);
		setPostcode(null);
		setDateOfBirth(null);
	}
	
	
	public String getPassportNumber() {
		return passportNumber;
	}
	
	public boolean isNum(String passportNumber) {
		try {
			Integer.parseInt(passportNumber);
			return true;
			
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		
	}
	
	public void setPassportNumber(String passportNumber) {
		if(isNum(passportNumber)) {
			if(passportNumber.length()==9) {
				this.passportNumber = passportNumber;
			}
		}
		
	}
	public LocalDate getIssueDate() {
		return issueDate;
	}
	public void setIssueDate(LocalDate exampledate3) {
		this.issueDate = exampledate3;
	}
	public LocalDate getExpiaryDate() {
		return expiaryDate;
	}
	public void setExpiaryDate(LocalDate exampledate22) {
		this.expiaryDate = exampledate22;
	}
	public Sex getSex() {
		return sex;
	}
	public void setSex(Sex sex) {
		this.sex = sex;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getCounty() {
		return county;
	}
	public void setCounty(String county) {
		this.county = county;
	}
	public String getPostcode() {
		return postcode;
	}
	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}
	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(LocalDate dob2) {
		this.dateOfBirth = dob2;
	}
	
	

}
