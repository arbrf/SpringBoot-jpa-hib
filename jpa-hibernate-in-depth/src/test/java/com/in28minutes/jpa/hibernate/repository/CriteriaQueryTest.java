package com.in28minutes.jpa.hibernate.repository;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.in28minutes.jpa.hibernate.JpaHibernateInDepthApplication;
import com.in28minutes.jpa.hibernate.entity.Course;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import jakarta.transaction.Transactional;
@RunWith(SpringRunner.class)
@SpringBootTest(classes = JpaHibernateInDepthApplication.class)
@Transactional
class CriteriaQueryTest {
	@Autowired
	EntityManager em;
	private Logger logger=LoggerFactory.getLogger(this.getClass());


	@Test
	void criteria_select_all_courses() {
		CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
	CriteriaQuery<Course> criteriaQuery = criteriaBuilder.createQuery(Course.class);
	Root<Course> courseroot = criteriaQuery.from(Course.class);
	TypedQuery<Course> query = em.createQuery(criteriaQuery.select(courseroot));
	List<Course> resultList=query.getResultList();
	logger.info("The List Course is {}",resultList);

	}
	
	@Test
	void criteria_select_course_like_100_steps() {
		CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
	CriteriaQuery<Course> criteriaQuery = criteriaBuilder.createQuery(Course.class);
	Root<Course> courseroot = criteriaQuery.from(Course.class);
	Predicate like = criteriaBuilder.like(courseroot.get("name"),"100 steps");
	criteriaQuery.where(like);
	TypedQuery<Course> query = em.createQuery(criteriaQuery.select(courseroot));
	List<Course> resultList=query.getResultList();
	logger.info("The List Course like 100 steps {}",resultList);

	}
}
