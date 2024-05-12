package com.in28minutes.jpa.hibernate.repository;

import java.time.LocalDateTime;
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
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
@RunWith(SpringRunner.class)
@SpringBootTest(classes = JpaHibernateInDepthApplication.class)
@Transactional
class JpqlTest {
	@Autowired
	EntityManager em;
	private Logger logger=LoggerFactory.getLogger(this.getClass());
	
	@Test
	void jpql_basics() {
	List list=em.createNamedQuery("query_get_all_course").getResultList();
		
	logger.info("The TestEnviron Course is {}",list);

	}

	@Test
	void jpql_Typed() {
	TypedQuery<Course> query = em.createNamedQuery("query_get_all_course",Course.class);
	List<Course> resultList=query.getResultList();
	logger.info("The List Course is {}",resultList);

	}
	@Test
	void jpql_where() {TypedQuery<Course> query = em.createNamedQuery("query_get_100_step_courses", Course.class);
	List<Course> resultList = query.getResultList();
	logger.info("The List Course Where name like 100 is {}", resultList);
}
	@Test
	void native_Query() {
		Query query = em.createNativeQuery("SELECT *FROM COURSE");
	List<Course> resultList = query.getResultList();
	logger.info("The List of Native Queryv Course  {}", resultList);
}
	@Test
	void native_Query_paramter() {
		Query query = em.createNativeQuery("SELECT *FROM COURSE where id=?");
		query.setParameter(1, 10001);
	List<Course> resultList = query.getResultList();
	logger.info("The List of Native Queryv Paramete Course Where id  is 10001 {}", resultList);
}
	@Test
	void native_Query_Named_paramter() {
		Query query = em.createNativeQuery("SELECT *FROM COURSE where id=:id");
		query.setParameter("id", 10001);
	List<Course> resultList = query.getResultList();
	logger.info("The List of Native Queryv CourseWhere id  is 10001 {}", resultList);
}
	@Test
	void update_native_Query() {
	    LocalDateTime currentDateTime = LocalDateTime.now();
	    Query query = em.createNativeQuery("update COURSE set updated_date = :currentDateTime");
	    query.setParameter("currentDateTime", currentDateTime);
	    int noOfRowUpdated = query.executeUpdate();
	    logger.info("The number of rows updated is {}", noOfRowUpdated);
	}

}
