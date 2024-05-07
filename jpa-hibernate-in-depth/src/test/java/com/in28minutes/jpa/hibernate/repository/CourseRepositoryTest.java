package com.in28minutes.jpa.hibernate.repository;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.in28minutes.jpa.hibernate.JpaHibernateInDepthApplication;
import com.in28minutes.jpa.hibernate.entity.Course;
@RunWith(SpringRunner.class)
@SpringBootTest(classes = JpaHibernateInDepthApplication.class)
class CourseRepositoryTest {
	@Autowired
	CourseRepository courseRepository;
	private Logger logger=LoggerFactory.getLogger(this.getClass());
	
	@Test
	void contextLoads() {
	Course course=courseRepository.findById(10001);
	
	logger.info("The TestEnviron Course is {}",course);
	assertEquals("Learn AWSin 10 Steps", course.getName());
	}

}
