package com.springRecap.SpringRecap.helloworld;

import org.springframework.boot.autoconfigure.amqp.RabbitConnectionDetails.Address;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App02HelloworldApplication {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AnnotationConfigApplicationContext context = 
				new AnnotationConfigApplicationContext(HelloWorldConfiguration.class);
		System.out.println(context.getBean("name"));
		System.out.println(context.getBean("age"));
		System.out.println(context.getBean("person"));
		System.out.println(context.getBean("address1"));
		System.out.println(context.getBean("address"));
		System.out.println("IF there is more then one type of bean @Primary");
		System.out.println(context.getBean(Address.class));
		System.out.println(context.getBean("personMethodCall"));
		System.out.println(context.getBean("personParameters"));  
		System.out.println("personParameters2 with Address address");
		System.out.println(context.getBean("personParameters2"));
		System.out.println("GetBean Definition names");
		for(String beans:context.getBeanDefinitionNames()) {
			System.out.println(beans);
		}
		
	}

}
