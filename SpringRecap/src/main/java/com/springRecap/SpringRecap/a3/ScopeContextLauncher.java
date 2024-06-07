package com.springRecap.SpringRecap.a3;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
@Component
@Scope("prototype")
class ClassA{}

@Component
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
public class ScopeContextLauncher {
 public static void main(String args[]) {

		
		try (
		AnnotationConfigApplicationContext context = new 
		AnnotationConfigApplicationContext(ScopeContextLauncher.class)) {
			System.out.println(context.getBean(ClassA.class));
			System.out.println(context.getBean(ClassA.class));
			System.out.println(context.getBean(ClassA.class));
			
		System.out.println(context.getBean(ClassB.class));
		System.out.println(context.getBean(ClassB.class));
		System.out.println(context.getBean(ClassB.class));
		System.out.println(context.getBean(ClassB.class));
		System.out.println(context.getBean(ClassB.class));
		
		System.out.println("Context LAunching completed");
		
		}
		
	
	
 }
 
}
