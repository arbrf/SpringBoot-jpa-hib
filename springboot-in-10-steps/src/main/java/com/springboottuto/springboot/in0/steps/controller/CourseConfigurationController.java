package com.springboottuto.springboot.in0.steps.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class CourseConfigurationController {
	@Autowired
	private CurrencyConfiguration configuration;
	@RequestMapping("/currency-configuration")
    public CurrencyConfiguration retrieveAllCourses() {
		return configuration;
        
    }
}
