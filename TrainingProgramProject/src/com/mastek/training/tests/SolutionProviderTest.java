package com.mastek.training.tests;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import com.mastek.training.basics.SolutionProvider;

class SolutionProviderTest {

	@Test
	void testGetMaxNumberValidParams(){
		// assert<condition>(<Expexted-Result>,<call the function for actual Result>,
		//						<Message to display if Expected Result does not match Actual result>);
		
		assertEquals(10,SolutionProvider.getMaxNumber(10, 2),"Invalid Max Number returned");
	}
	
	@Test
	void testGetMaxNumberEqualParams(){
		assertEquals(9, SolutionProvider.getMaxNumber(9, 9),"Invalid Max Number returned");
	}
	
	@Test
	void testGetMaxNumberNegativeValueParams(){
		assertEquals(-2, SolutionProvider.getMaxNumber(-110, -2),"Invalid Max Number returned");
	}
	
	@Test
	void testGetMaxNumberMaxLimitsForIntParams(){
		assertEquals(99999, SolutionProvider.getMaxNumber(99999, 2),"Invalid Max Number returned");
	}
}