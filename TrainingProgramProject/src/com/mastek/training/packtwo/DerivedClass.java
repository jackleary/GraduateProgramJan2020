package com.mastek.training.packtwo;

import com.mastek.training.packone.SimpleClass;

public class DerivedClass extends SimpleClass {
	
	public static void main(String[] args) {
		DerivedClass sc1 = new DerivedClass();
		// In derived class of the other package we can access public and protected members of the class
		// we cannot access private and default members of the class
		System.out.println(
//				 "Private: "+sc1.privateNumber+
//				", Default: "+sc1.defaultNumber+
				", Protected: "+sc1.protectedNumber+
				", Public: "+sc1.publicNumber);
	}

}
