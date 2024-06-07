package com.springRecap.SpringRecap.a1;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;


@Configuration
@ComponentScan
public class SimpleContextLauncher {
 public static void main(String args[]) {

		
		try (
		AnnotationConfigApplicationContext context = new 
		AnnotationConfigApplicationContext(SimpleContextLauncher.class)) {
		
		for(String obj:context.getBeanDefinitionNames()) {
			//System.out.println(obj);
			
		}
		
		}
		
	
	
 }
 
}
