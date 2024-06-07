package com.springRecap.SpringRecap.f1;

import java.util.Arrays;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
@Component
class ClassA{

	public void getReady() {
		// TODO Auto-generated method stub
		System.out.println("Dependecies are ready to be wired");
	}}

@Component
class ClassB{
	private ClassA classA;

	public ClassB(ClassA classA) {
		super();
		System.out.println("This is eagerly initialized");
		this.classA = classA;
		
		
	}
	@PostConstruct
	void Initialize() {
		classA.getReady();
	}
	
	@PreDestroy
	void wiringCompleted() {
		System.out.println("Wiring completed");
	}
	
}

@Configuration
@ComponentScan
public class PostConstructPreDestroyContextLauncher {
 public static void main(String args[]) {

		
		try (
		AnnotationConfigApplicationContext context = new 
		AnnotationConfigApplicationContext(PostConstructPreDestroyContextLauncher.class)) {
			String[] beanNames = context.getBeanDefinitionNames();
	        
	        // Print all bean names using streams
	        Arrays.stream(beanNames).forEach(System.out::println);
		}
		
	
	
 }
 
}
