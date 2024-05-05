package com.in28minutes.junit;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class MyMathTest {
	private MyMath myMath=new MyMath();

	@Test
	void test() {
		//fail("Not yet implemented");
		
		int expectedResult=6;
		
		assertEquals(expectedResult, myMath.calculateSum(new int[] {1,2,3}));
		System.out.println(myMath.calculateSum(new int[] {1,2,3}));
		
	}
	@Test
	void test1() {
		//fail("Not yet implemented");
		
		int expectedResult=0;
		
		assertEquals(expectedResult, myMath.calculateSum(new int[] {}));
		System.out.println("test1:  "+myMath.calculateSum(new int[] {}));
		
	}

}
