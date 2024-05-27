package com.in28minutes.jpa.hibernate.demo.repository;

import static org.assertj.core.api.Assertions.contentOf;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.util.List;

import javax.persistence.EntityGraph;
import javax.persistence.EntityManager;
import javax.persistence.Subgraph;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import com.in28minutes.jpa.hibernate.demo.DemoApplication;
import com.in28minutes.jpa.hibernate.demo.entity.Course;
import com.in28minutes.jpa.hibernate.demo.entity.Review;
import com.in28minutes.jpa.hibernate.demo.entity.ReviewRating;
import com.in28minutes.jpa.hibernate.demo.entity.Student;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = DemoApplication.class)
public class PerformTunigTest {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	CourseRepository repository;

	@Autowired
	EntityManager em;

	@Test
	public void findById_basic() {
		Course course = repository.findById(10001L);
		assertEquals("JPA in 50 Steps", course.getName());
	}
	
	@Test
	@Transactional
	public void creatingNPlusOneProblem() {
		
		List<Course> course = em.createNamedQuery("query_get_all_courses",Course.class).getResultList();
		
		for(Course courses:course) {
			logger.info("Course -> {} student-> {}",courses,courses.getStudents());
		}
		
	}
	
	@Test
	@Transactional
	public void solvingNPlusOneProblem_Entity_graph() {
		EntityGraph<Course> entityGraph = em.createEntityGraph(Course.class);
		Subgraph<Object> addSubgraph = entityGraph.addSubgraph("students");
		List<Course> course = em.createNamedQuery("query_get_all_courses",Course.class)
				.setHint("javax.persistence.loadgraph", entityGraph)
				.getResultList();
		
		for(Course courses:course) {
			logger.info("Course -> {} student-> {}",courses,courses.getStudents());
		}
		
	}
	
	@Test
	@Transactional
	public void solvingNPlusOneProblem_Join_Fetch() {
		
		List<Course> course = em.createNamedQuery("query_get_all_courses_using_join_fetch",Course.class).getResultList();
		
		for(Course courses:course) {
			logger.info("Course -> {} student-> {}",courses,courses.getStudents());
		}
		
	}
	


}
