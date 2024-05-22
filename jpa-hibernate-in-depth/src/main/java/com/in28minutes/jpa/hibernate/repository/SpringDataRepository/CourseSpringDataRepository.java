package com.in28minutes.jpa.hibernate.repository.SpringDataRepository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.in28minutes.jpa.hibernate.entity.Course;
@RepositoryRestResource(path = "courses")
public interface CourseSpringDataRepository extends JpaRepository<Course, Long>{
	
	List<Course> findByName(String name);
	
	 long countByName(String name);
	    
	List<Course> findByNameAndId(String name, Long id);
	
	void deleteByName(String name);
	
	@Query("select c From Course c where name like '100' ")
	List<Course> courseWith100StepsinName();
	
	@Query(value="select * From Course c where c.name like '100' ",nativeQuery=true)
	List<Course> courseWith100StepsinNameNativeQuery();
	
	@Query(name="query_get_100_step_courses")
	List<Course> courseWith100StepsinNameNamedQuery();
	
	
	
	

}
