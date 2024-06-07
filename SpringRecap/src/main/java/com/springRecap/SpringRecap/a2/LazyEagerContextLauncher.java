package com.springRecap.SpringRecap.a2;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
@Component
class ClassA{}

@Component
@Lazy
class ClassB{
	private ClassA classA;

	public ClassB(ClassA classA) {
		super();
		System.out.println("This is eagerly initialized");
		this.classA = classA;
	}
	
}

@Configuration
@ComponentScan
public class LazyEagerContextLauncher {
 public static void main(String args[]) {

		
		try (
		AnnotationConfigApplicationContext context = new 
		AnnotationConfigApplicationContext(LazyEagerContextLauncher.class)) {
		System.out.println(context.getBean(ClassB.class));
		System.out.println("Context LAunching completed");
		
		}
		
	
	
 }
 
}
