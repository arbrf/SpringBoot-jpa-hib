package com.in28minutes.jpa.hibernate.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.in28minutes.jpa.hibernate.entity.Course;

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
	
	

}
