package com.in28minutes.jpa.hibernate;

import java.util.List;

import org.apache.tomcat.util.digester.ArrayStack;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.in28minutes.jpa.hibernate.entity.Review;
import com.in28minutes.jpa.hibernate.repository.CourseRepository;
import com.in28minutes.jpa.hibernate.repository.StudentRepository;

@SpringBootApplication
public class JpaHibernateInDepthApplication implements CommandLineRunner{
	@Autowired
	CourseRepository courseRepository;
	@Autowired
	StudentRepository studentRepository;
	private Logger logger=LoggerFactory.getLogger(this.getClass());
	public static void main(String[] args) {
		SpringApplication.run(JpaHibernateInDepthApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
//		logger.info("The Course is {}",courseRepository.findById(10001));
//		courseRepository.save(new Course("LEarn MicroServices in 100 Steps"));
//		courseRepository.playWithEntityManager();
		List<Review> reviews = Review.asListOf(
			    new Review("5", "Good Hands-on Stuff"),
			    new Review("4", "Best Course")
			);

	//	studentRepository.saveStudentwithPassword();
	//	courseRepository.addHardCodedReviewsForCourse();
	//	courseRepository.addReviewsForCourse(10003,reviews);
		
		}

}
