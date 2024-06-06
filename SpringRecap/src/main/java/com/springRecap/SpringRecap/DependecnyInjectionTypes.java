package com.springRecap.SpringRecap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Component
class BussinessClass{
	//@Autowired
	Dependency1 dependency1;
	//@Autowired
	Dependency2 dependency2;
//	@Autowired
//public void setDependency1(Dependency1 dependency1) {
//		this.dependency1 = dependency1;
//	}
//	@Autowired
//	public void setDependency2(Dependency2 dependency2) {
//		this.dependency2 = dependency2;
//	}

		public BussinessClass(Dependency1 dependency1, Dependency2 dependency2) {
		super();
		System.out.print("Dependecny"+dependency1+"Dependecny2 "+dependency2);
		this.dependency1 = dependency1;
		this.dependency2 = dependency2;
	}
	@Override
	public String toString() {
		return "BussinessClass [dependency1=" + dependency1 + ", dependency2=" + dependency2 + "]";
	}
	
	
}
@Component
class Dependency1{}
@Component
class Dependency2{}

@Configuration
@ComponentScan
public class DependecnyInjectionTypes {
 public static void main(String args[]) {

		
		try (
		AnnotationConfigApplicationContext context = new 
		AnnotationConfigApplicationContext(DependecnyInjectionTypes.class)) {
		
		for(String obj:context.getBeanDefinitionNames()) {
			//System.out.println(obj);
			
		}
		System.out.println(context.getBean(BussinessClass.class));
		
		}
		
	
	
 }
 
}
