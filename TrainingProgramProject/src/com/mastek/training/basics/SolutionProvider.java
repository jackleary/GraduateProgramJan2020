package com.mastek.training.basics;

public class SolutionProvider {

	/*
	 * take 2 numbers from the user and display the max number as output
	 */
	// public static <return-datatype> <name>(<param_type1> <param_name1>,...)
	public static int getMaxNumber(int num1,int num2) {// declare inputs as params
		int max=0; // declare output as local variable
		if (num1>num2) { // validate conditions for logical output
			max=num1;
		} else {
			max=num2;

		}
		return max; // return result to the caller
	}
	
	/*
	 * Write an algorithm and code for accepting two numbers, divide the first number by second and display their quotient and remainder
	 */
	
	public static String getQuotientAndRemainder(int numb1,int numb2) {
		int quotient = (numb1/numb2);
		int remainder = (numb1%numb2);
		return(quotient+" with remainder "+remainder);
		
	}
	
	public static double getKmFromMiles(double num1) {
		double miles = (num1/8)*5;
		return(miles);
	}
	
	public static double getArea(double num1, double num2) {
		double rarea = (num1*num2);
		double sarea = (num1*num2);
		if (num1!=num2) {
				return rarea;
		}
		else {
			return sarea;
		}
	}
	
	/*
	 * accepting the distance and speed values for a particular journey, calculate the time taken for the journey and display the same.
	 */
	public static double getTime(double num1, double num2) {
		double time = (num1/num2);
		return time;
	}
	
	public static double getAreaCircle(double num1) {
		double area = (Math.PI*Math.pow(num1,2));
		return area;
	}
	
	public static String getMultiplicationTable(int num1) {
		String table = "";
		for(int i = 1; i<=12; i++) {
			table+=num1+"x"+i+"="+num1*i+"\n";
		}
		return table;
	}
	
	public static int getMaxNumber1(int num1,int num2, int num3) {
		int max=0; 
		if (num1>num2) { 
			max=num1;
		}else {max=num2;}
		if(max<num3) {
			max=num3;
		}
		return max;}
	
	public static int getMaxValue(int num1, int num2, int num3) {
		int[] a = new int[] {num1,num2,num3};
		int max = a[0];
		for(int i = 1; i < a.length;i++) {
			if(a[i] > max)
			{
				max = a[i];
			}
		}
		return max;
	}
	
	/*
	 * Accept student Details like (StudentID, StudentName, StudentAge, Marks1, Marks2, Marks3) 
	 * Calculate Total and Percentage. If percentage is greater than 50 then display PASS else display FAIL.
	 */
	public static String getPassOrFail(String str1, int num2, int num3, int num4) {
		String deets = str1;
		int total = (num2+num3+num4);
		int percentage = (total/3);
		if(percentage>50) {
			return "pass"+ "," + str1;
		} else {
			return "fail" + "," + str1;
		}
	}
	
	public static int getLucky(int num1) {
		String num = num1+"";
		if(num.length()>1){
			int sum=0;
			for(int i=0;i<num.length();i++){
				sum+= Integer.parseInt(num.charAt(i)+"");
				}
				System.out.println(sum);
				return getLucky(sum);
			}
			else {
				return num1;
			}
	}
}






