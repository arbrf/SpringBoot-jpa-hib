package com.in28minutes.springboot.learn_spring_boot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.in28minutes.springboot.learn_spring_boot.pojo.CurrencyConfiguration;

@RestController
public class CurrencyConfigurationController {
	@Autowired
	private CurrencyConfiguration currencyConfiguration;

	@RequestMapping("/currencyConfigurarion")
	public CurrencyConfiguration currencyConfigurarion() {
		return currencyConfiguration;
	}
}
