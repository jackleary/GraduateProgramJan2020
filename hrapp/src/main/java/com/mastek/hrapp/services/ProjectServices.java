package com.mastek.hrapp.services;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Value;

public class ProjectServices {
	
	String exampleProperty;
	
	public ProjectServices() {
		// TODO Auto-generated constructor stub
	}
	
	@PostConstruct // initialisation method of the class
	public void initializeService() {
		System.out.println("Project service initialized");
	}
	
	@PreDestroy // calls before shutting down the application
	public void terminateService() {
		System.out.println("Project service terminated");
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

}
