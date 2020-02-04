package com.mastek.training.packone;

// a class can inherit from interface using implements keyword
// one class can implement more than one interface
// interfaces use the class object for implementing its behaviours
// hence it is used frequently as it saves additional number of objects created
public class Rectangle implements Shape {
	
	private int length;
	private int breadth;
	
	
	public int getLength() {
		return length;
	}
	public void setLength(int length) {
		this.length = length;
	}
	public int getBreadth() {
		return breadth;
	}
	public void setBreadth(int breadth) {
		this.breadth = breadth;
	}
	@Override
	public double getArea() {
		// TODO Auto-generated method stub
		return getLength()*getBreadth();
	}
	@Override
	public double getPerimeter() {
		// TODO Auto-generated method stub
		return 2*(getLength()+getBreadth());
	}

	
}
