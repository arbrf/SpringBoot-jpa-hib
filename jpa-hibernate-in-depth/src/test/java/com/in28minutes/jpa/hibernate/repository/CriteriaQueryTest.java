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
import jakarta.persistence.criteria.JoinType;
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
	void criteria_select_all_courses() { // Step 1: Get the CriteriaBuilder from the EntityManager
        CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();

        // Step 2: Create a CriteriaQuery object
        CriteriaQuery<Course> criteriaQuery = criteriaBuilder.createQuery(Course.class);

        // Step 3: Define the root for the query
        Root<Course> courseRoot = criteriaQuery.from(Course.class);

        // Step 4: Specify the select clause
        criteriaQuery.select(courseRoot);

        // Step 5: Create a TypedQuery
        TypedQuery<Course> query = em.createQuery(criteriaQuery);

        // Step 6: Execute the query and get results
        List<Course> resultList = query.getResultList();

        // Step 7: Log the results
        logger.info("The List of Courses is {}", resultList);}
	
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
	@Test
	void criteria_select_course_where_students_empty() {
		CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
	CriteriaQuery<Course> criteriaQuery = criteriaBuilder.createQuery(Course.class);
	Root<Course> courseroot = criteriaQuery.from(Course.class);
	Predicate studentEmpty = criteriaBuilder.isEmpty(courseroot.get("students"));
	criteriaQuery.where(studentEmpty);
	TypedQuery<Course> query = em.createQuery(criteriaQuery.select(courseroot));
	List<Course> resultList=query.getResultList();
	logger.info("The List Course where student is empty {}",resultList);

	}
	
	@Test
	void criteria_select_course_students_join() {
		CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
	CriteriaQuery<Course> criteriaQuery = criteriaBuilder.createQuery(Course.class);
	Root<Course> courseroot = criteriaQuery.from(Course.class);
	courseroot.join("students");
	TypedQuery<Course> query = em.createQuery(criteriaQuery.select(courseroot));
	List<Course> resultList=query.getResultList();
	logger.info("The List Course  student inner join {}",resultList);

	}
	@Test
	void criteria_select_course_students_leftjoin() {
		CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
	CriteriaQuery<Course> criteriaQuery = criteriaBuilder.createQuery(Course.class);
	Root<Course> courseroot = criteriaQuery.from(Course.class);
	courseroot.join("students",JoinType.LEFT);
	TypedQuery<Course> query = em.createQuery(criteriaQuery.select(courseroot));
	List<Course> resultList=query.getResultList();
	logger.info("The List Course  student left join {}",resultList);

	}
}
