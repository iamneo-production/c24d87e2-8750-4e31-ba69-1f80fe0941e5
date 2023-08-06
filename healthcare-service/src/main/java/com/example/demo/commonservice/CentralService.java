package com.example.demo.commonservice;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.modeldto.HealthCareReport;

@FeignClient(name = "centralsurveillanceservice")
public interface CentralService {
	
	@PostMapping("/Central/surveillance")
	public String healthCareReport(HealthCareReport careReport);
}
