package com.mastek.training.packone;

public class AnotherClass {
	
	public static void main(String[] args) {
		SimpleClass sc1 = new SimpleClass();
		// In another class of the same package we can access all the types of members of the class
		// except private numbers
		System.out.println(
				// "Private: "+sc1.privateNumber+
				", Default: "+sc1.defaultNumber+
				", Protected: "+sc1.protectedNumber+
				", Public: "+sc1.publicNumber);
	}

}
