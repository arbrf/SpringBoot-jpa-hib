package com.in28minutes.jpa.hibernate.repository.SpringDataRepository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.in28minutes.jpa.hibernate.entity.Course;

public interface CourseSpringDataRepository extends JpaRepository<Course, Long>{

}
