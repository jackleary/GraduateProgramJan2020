package com.mastek.training.packtwo;

import com.mastek.training.packone.SimpleClass;

public class AnotherClass {
	
	public static void main(String[] args) {
		SimpleClass sc1 = new SimpleClass();
		// in the Another class of a different package  we can access none of the types of members except for public members
		System.out.println(
				/*"Private: "+sc1.privateNumber+
				", Default: "+sc1.defaultNumber+
				", Protected: "+sc1.protectedNumber+*/
				", Public: "+sc1.publicNumber);
	}

}
