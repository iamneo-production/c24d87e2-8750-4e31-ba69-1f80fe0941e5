package com.analytics.analytics.commonservice;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import com.analytics.analytics.modeldto.ResponseDto;

@FeignClient(name = "centralsurveillanceservice")
public interface AnalysisCount {
	
	@GetMapping("/Central/analysisCount")
	public ResponseDto analysisCounts();
}