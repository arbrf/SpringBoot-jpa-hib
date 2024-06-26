package com.in28minutes.springboot.learn_spring_boot.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.in28minutes.springboot.learn_spring_boot.pojo.Course;

@RestController
public class CourseController {
	@RequestMapping("/courses")
	public List<Course> retrieveAllCourses(){
		return Arrays.asList(
				new Course(1,"Learn AWS","in28minutes"),
				new Course(2,"Learn Devops","in28minutes"),
				new Course(1,"Learn AZure","in28minutes")
				
				);
	}
}
