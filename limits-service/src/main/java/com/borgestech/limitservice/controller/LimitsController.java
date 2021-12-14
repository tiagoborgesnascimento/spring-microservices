package com.borgestech.limitservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.borgestech.limitservice.bean.Limits;
import com.borgestech.limitservice.configuration.LimitsConfiguration;

@RestController
@RequestMapping("/limits")
public class LimitsController {
	
	@Autowired
	private LimitsConfiguration limitsConfiguration;
	
	@GetMapping
	public Limits getLimits() {
		return new Limits(limitsConfiguration.getMinimum(), limitsConfiguration.getMaximum());
	}
	
}
