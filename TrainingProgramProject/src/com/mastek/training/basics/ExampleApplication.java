package com.mastek.training.basics;

public class ExampleApplication {

	public static void main(String[] args) {
		int maxResult=0; // int is mandatory to declare variable maxResult as an integer. Always declare variables
		String getQuotientAndRemainder="";
		double getAreaCircle =0;
		String getMultiplicationTable = "";
		int getLucky =0;
		
		maxResult = SolutionProvider.getMaxNumber(10, 2);
		System.out.println("Max Result is "+maxResult);
		
		maxResult = SolutionProvider.getMaxNumber(10, 10);
		System.out.println("Max Result is "+maxResult);
		
		maxResult = SolutionProvider.getMaxNumber(-110, -2);
		System.out.println("Max Result is "+maxResult);
		
		maxResult = SolutionProvider.getMaxNumber(99999, 2);
		System.out.println("Max Result is "+maxResult);
		
		getQuotientAndRemainder = SolutionProvider.getQuotientAndRemainder(13, 5);
		System.out.println(getQuotientAndRemainder);
		
		getAreaCircle = SolutionProvider.getAreaCircle(5);
		System.out.println(getAreaCircle);
		
		
		getMultiplicationTable = SolutionProvider.getMultiplicationTable(5);
		System.out.println(getMultiplicationTable); 
		
		getLucky = SolutionProvider.getLucky(12345);
		System.out.println(getLucky);
		
	}
	
}
