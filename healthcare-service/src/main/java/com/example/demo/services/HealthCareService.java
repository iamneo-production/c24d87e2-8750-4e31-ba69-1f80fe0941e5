package com.example.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.modeldto.HealthCareReport;
import com.example.demo.commonservice.CentralService;

@Service
public class HealthCareService {

    @Autowired
	CentralService centralService;
    
    public String healthCareReport(HealthCareReport careReport) {
		return centralService.healthCareReport(careReport);
	}
}
