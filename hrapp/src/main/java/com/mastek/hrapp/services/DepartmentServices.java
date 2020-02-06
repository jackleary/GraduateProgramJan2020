package com.mastek.hrapp.services;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component // marking class as bean to be created
@Scope("singleton") // singleton: One object used across test cases, prototype: one object per request
public class DepartmentServices {
	
	String exampleProperty;
	
	public DepartmentServices() {
		// TODO Auto-generated constructor stub
	}
	
	@PostConstruct // initialisation method of the class
	public void initializeService() {
		System.out.println("Department service initialized");
	}
	
	@PreDestroy // calls before shutting down the application
	public void terminateService() {
		System.out.println("Department service terminated");
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
