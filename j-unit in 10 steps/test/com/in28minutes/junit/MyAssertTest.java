package com.in28minutes.junit;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

class MyAssertTest {
	List<String> myList=Arrays.asList("AWS","Devops","Azure");
	

	@Test
	void test() {
		//fail("Not yet implemented");
		boolean test2=myList.contains("JAVA");
		boolean test3=myList.contains("Devops");
		
		assertFalse(test2);
		assertEquals(true, myList.contains("AWS"));
		assertEquals(3, myList.size());
		assertArrayEquals(new int[] {1,2}, new int[] {2,1});
		
	}

}
