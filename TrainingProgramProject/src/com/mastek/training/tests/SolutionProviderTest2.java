package com.mastek.training.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.mastek.training.basics.SolutionProvider;

class SolutionProviderTest2 {

	@Test
	void testGetQuotientAndRemainder() {
		assertEquals("2 with remainder 3",SolutionProvider.getQuotientAndRemainder(13, 5),"Invalid numbers returned");
	}
	
	@Test
	void testGetKmFromMiles() {
		assertEquals(6.25,SolutionProvider.getKmFromMiles(10),"Invalid numbers returned");
	}
	
	@Test
	void testGetArea() {
		assertEquals(25,SolutionProvider.getArea(5, 5),"Invalid numbers returned");
	}
	
	@Test
	void testTime() {
		assertEquals(2,SolutionProvider.getTime(10, 5),"Invalid numbers returned");
	}
	
	@Test
	void testAreaCircle() {
		assertEquals(78.53981633974483,SolutionProvider.getAreaCircle(5),"Invalid numbers returned");
	}
	
	@Test
	void testMultiTable() {
		assertEquals(78.53981633974483,SolutionProvider.getAreaCircle(5),"Invalid numbers returned");
	}
	
	@Test
	void testMaxValue1() {
		assertEquals(10,SolutionProvider.getMaxNumber1(1, 2, 10),"Invalid numbers returned");
	}
	
	@Test
	void testMaxValue2() {
		assertEquals(10,SolutionProvider.getMaxValue(1, 2, 10),"Invalid numbers returned");
	}


}
