package com.in28minutes.jpa.hibernate.repository.SpringDataRepository;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Optional;

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
class CourseSpringDataRepositoryTest {
	@Autowired
	CourseSpringDataRepository repository;
	private Logger logger=LoggerFactory.getLogger(this.getClass());
	@Test
	void course_is_Present() {
		Optional<Course> findById = repository.findById(10001L);
		assertTrue(findById.isPresent());
	}
	
	@Test
	void course_is_notPresent() {
		Optional<Course> findById = repository.findById(20001L);
		assertFalse(findById.isPresent());
	}
	@Test
	void insert_new_course() {
		Course course=new Course("Learn MERN Stack in 400 steps");
		repository.save(course);
		course.setName("Learn MERN Stack in 400 steps Updated!!!! ");
		repository.save(course);
		logger.info("All Courses{}",repository.findAll());
		logger.info("All Courses{} count",repository.count());
		
		
	}
}
