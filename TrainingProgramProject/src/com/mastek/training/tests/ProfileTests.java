package com.mastek.training.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.mastek.training.corporateprofile.Profile;

class ProfileTests {
	
	Profile ex1;
	
	@BeforeEach
	public void setupProfileTestCases() {
		System.out.println("Before test case");
		ex1 = new Profile();
		ex1.setName("hi");
		ex1.setCertifications("Example");
		ex1.setQualifications("Example");
		ex1.setJobDetails("Example...");	
	}
	
	@Test
	void testCreateAndPrintProfileObject() {
		System.out.println(
				"Name: "+ex1.getName()+
				"\nCertifications: "+ex1.getCertifications()+
				"\nQualifications: "+ex1.getQualifications()+
				"\nJob Details: "+ex1.getJobDetails());
	}

}
