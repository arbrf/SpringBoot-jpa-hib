package com.in28minutes.junit;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MyBeforeAfter {

	@Test
	void test() {
		System.out.println("Test");
	}
	@Test
	void test1() {
		System.out.println("Test1");
	}
	@Test
	void test2() {
		System.out.println("Test2");
	}
	@BeforeEach
	void beforeEach() {
		System.out.println("Before Each");
	}
	@AfterEach
	void afterEach() {
		System.out.println("After Each");
	}
	@BeforeAll
	static void beforeAll() {
		System.out.println("Before All");
	}
	@AfterAll
	static void afterAll() {
		System.out.println("After All");
	}
	
	
	
	
	

}
