package com.springboottuto.springboot.in0.steps.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboottuto.springboot.in0.steps.course.Course;
@RestController
public class CourseController {
	@RequestMapping("/courses")
    public List<Course> retrieveAllCourses() {
        return Arrays.asList(
            new Course(1, "Learn AWS47", "in28minutes"),
            new Course(2, "Learn  Devops", "in28minutes")
        );
    }
}
