package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.services.HealthCareService;
import com.example.demo.modeldto.HealthCareReport;

@RestController
@RequestMapping("/healthcare")
public class HealthcareController {
    

    @Autowired
	HealthCareService healthCareService;
	
	@PostMapping("/report")
	public String healthCareReport(@RequestBody HealthCareReport careReport) {
		return healthCareService.healthCareReport(careReport);
	} 
}
