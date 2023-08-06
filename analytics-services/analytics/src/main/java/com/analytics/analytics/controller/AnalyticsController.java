package com.analytics.analytics.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.analytics.analytics.service.AnalysisService;

@RestController
@RequestMapping("/AnalysisController")
public class AnalyticsController {
    

    @Autowired
	AnalysisService analysisService;
	
	@GetMapping("/analysis")
	public String getAnalysis() {
		return analysisService.getAnalysis();
	}
}
