package com.in28minutes.jpa.hibernate.repository;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.in28minutes.jpa.hibernate.entity.Course;

import jakarta.persistence.Embeddable;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class CourseRepository {
	@Autowired
	EntityManager entityManager;
	
	public Course findById(int id) {
		return entityManager.find(Course.class, id);
	}
	public void deleteByID(int id) {
		Course course=findById(id);
		entityManager.remove(course);
	}
	
	public Course save(Course course) {
		Optional<Long> courseIdOptional = Optional.ofNullable(course.getId());

		if (!courseIdOptional.isPresent()) {
		    // courseId is null
		    // Handle the case where courseId is null
			entityManager.persist(course);
		} 		    
		else {
			entityManager.merge(course);
		}
		return course;

	}
	
	

}
