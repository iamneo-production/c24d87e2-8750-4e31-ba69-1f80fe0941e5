package com.example.centralservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.centralservice.modeldto.CentralDataDto;
import com.example.centralservice.modeldto.ResponseDto;
import com.example.centralservice.service.CentralSureveillanceService;
import com.example.centralservice.model.CentralData;
import java.util.List;

@RestController
@RequestMapping("/Central")
public class CentralController {
    
    @Autowired
	CentralSureveillanceService centralSureveillanceService;
	
	@PostMapping("/surveillance")
	public String addCentralSurveillance(@RequestBody CentralDataDto careReport) {
		return centralSureveillanceService.addCentralSurveillance(careReport);
	}
	
	@GetMapping("/analysisCount")
	public ResponseDto analysisCount() {
		return centralSureveillanceService.analysisCount();
	}

	@GetMapping("/getAllDisease")
	public List<CentralData> getAllDisease(){
		return centralSureveillanceService.getAllDisease();
	}
}
