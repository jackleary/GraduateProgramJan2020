package com.mastek.training.hrapp;

// Each class specifies their base/parent class name using extends keyword
// If the class does not have extends keyword it is by default inheriting java.lang.Object
public class SalesEmployee extends Employee {
	
	long target;
	double comission;
	
	public SalesEmployee() {
		// System.out.println("Example");
		// use super keyword to call base class constructor from the child/derived class
		// super constructor call must be the first line in the constructor
		super(7777,"SalesExample",99,Designations.OFFICE);
		System.out.println("Sales Employee Created");
	}
	
	
	// Method overriding 
	// We write the same method in base class in child class with different or additional logic for processing the result
	@Override
	public double getNetSalary(int noOfDays) throws Exception {
		// TODO Auto-generated method stub
		return super.getNetSalary(noOfDays)+(super.getNetSalary(noOfDays)*getComission());
	}




	public long getTarget() {
		return target;
	}
	public void setTarget(long target) {
		this.target = target;
	}
	public double getComission() {
		return comission;
	}
	public void setComission(double comission) {
		this.comission = comission;
	}
	
	
}

