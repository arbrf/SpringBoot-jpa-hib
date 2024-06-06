package com.springRecap.SpringRecap.helloworld;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;

record Person(String name,int age,Address address) {}
record Address(String firstLane,String city) {}

public class HelloWorldConfiguration {
	@Bean
	public String name() {
		return "Hello Davoodh";
	}
	
	@Bean
	public int age() {
		return 19;
	}
	@Bean
	public Person person() {
		
		return new Person("Sherlock Holmes", 32,null);
	}
	
	@Bean
	public Address address() {
		return new Address("ParkAvenue", "England");
		
	}
	@Bean(name = "address1")
	@Primary
	public Address address1() {
		return new Address("Bakers Street", "London");
		
	}
	@Bean
	public Person personMethodCall() {
		
		return new Person(name(),age(),address());
	}
	@Bean(name = "address2")
	@Qualifier("Qualifieraddress")
	public Address address2() {
		return new Address("Tolly Chowki", "Hyderabad");
		
	}
	@Bean
	public Person personParameters(String name,int age,Address address2) {
		
		return new Person(name,age,address2);
	}
	@Bean
	public Person personParameters2(String name,int age,@Qualifier("Qualifieraddress") Address address) {
		
		return new Person(name,age,address);
	}
	
}
