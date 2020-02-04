package com.mastek.training.packone;

public class DerivedClass extends SimpleClass {
	
	public static void main(String[] args) {
		DerivedClass sc1 = new DerivedClass();
		// In derived class of the same package we can access all the types of members of the class
		// except private numbers
		System.out.println(
				// "Private: "+sc1.privateNumber+
				", Default: "+sc1.defaultNumber+
				", Protected: "+sc1.protectedNumber+
				", Public: "+sc1.publicNumber);
	}

}
