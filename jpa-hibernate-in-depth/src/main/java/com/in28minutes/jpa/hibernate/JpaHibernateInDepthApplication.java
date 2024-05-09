package com.in28minutes.jpa.hibernate;

import org.aspectj.weaver.patterns.ThisOrTargetAnnotationPointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.in28minutes.jpa.hibernate.entity.Course;
import com.in28minutes.jpa.hibernate.repository.CourseRepository;

@SpringBootApplication
public class JpaHibernateInDepthApplication implements CommandLineRunner{
	@Autowired
	CourseRepository courseRepository;
	private Logger logger=LoggerFactory.getLogger(this.getClass());
	public static void main(String[] args) {
		SpringApplication.run(JpaHibernateInDepthApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
//		logger.info("The Course is {}",courseRepository.findById(10001));
//		courseRepository.save(new Course("LEarn MicroServices in 100 Steps"));
		courseRepository.playWithEntityManager();
		}

}
