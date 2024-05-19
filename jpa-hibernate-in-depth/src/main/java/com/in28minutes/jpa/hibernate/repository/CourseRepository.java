package com.in28minutes.jpa.hibernate.repository;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.in28minutes.jpa.hibernate.entity.Course;
import com.in28minutes.jpa.hibernate.entity.Review;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class CourseRepository {
	@Autowired
	EntityManager entityManager;
	private Logger logger=LoggerFactory.getLogger(this.getClass());
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
	public void playWithEntityManager() {
		Course course1 = new Course("Learn Web Services in 100 Steps");
		entityManager.persist(course1);
		Course course2 = new Course("Learn Angular JS in 100 Steps");
		entityManager.persist(course2);
		course2.setName("LEarn Angular JS in 59 Steps updated!!!!");
		entityManager.flush();
		
	}
	
	public void addHardCodedReviewsForCourse() {
		Course course=findById(10003);
		Review review1=new Review("5","This good Handson Stuff");
		review1.setCourse(course);
		Review review2=new Review("5","This good HatsoFF");
		review2.setCourse(course);
		course.addReviews(review2);
		course.addReviews(review1);
		entityManager.persist(review1);
		entityManager.persist(review2);
	}
	public void addReviewsForCourse(int id, List<Review> reviews) {
		// TODO Auto-generated method stub
		Course course=findById(id);
		for(Review review:reviews) {
			course.addReviews(review);
			review.setCourse(course);
			entityManager.persist(review);
		}
		
	}
	
	public void jpql_Course_Without_Students() {
	    TypedQuery<Course> query =
	    		entityManager.createQuery("SELECT c FROM Course c WHERE c.students IS EMPTY", Course.class);
	    List<Course> resultList = query.getResultList();
	    logger.info("retrieve Courses without Students {}", resultList);
	}
}
