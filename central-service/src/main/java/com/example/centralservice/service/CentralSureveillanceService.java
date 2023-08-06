package com.example.centralservice.CentralSureveillanceService;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.centralservice.modeldto.CentralDataDto;
import com.example.centralservice.modeldto.ResponseDto;
import com.example.centralservice.model.CentralData;
import com.example.centralservice.model.Disease;
import com.example.centralservice.repo.CentralRepo;

@Service
public class CentralSureveillanceService {
	
	@Autowired
	CentralRepo centralRepo;

	public String addCentralSurveillance(CentralDataDto careReport) {
		String response;

		CentralData centralData = new CentralData(careReport.getPatientName(),careReport.getPatientAge(),careReport.getPatientSex(),
				careReport.getPatientCity(),careReport.getPatientState(),careReport.getPatientHospitalName(),
				careReport.getPatientHospitalCity(),careReport.getPatientHospitalState(),
				careReport.getPatientDiseaseDescription(),careReport.getCreatedBy());
		
		
		System.out.println(centralData);
		centralData.setCreatedOn(LocalDateTime.now());
		centralData.setPatientDiseaseName(careReport.getPatientDiseaseName());
		centralRepo.save(centralData); 
		response = "Report saved successfully";
		return response;
		
	}

	public ResponseDto analysisCount() {
		
		boolean result = false;
		ResponseDto responseDto = new ResponseDto();
		
		long hiv = centralRepo.countByPatientDiseaseName(Disease.HIV);
		long malaria = centralRepo.countByPatientDiseaseName(Disease.MALARIA);
		long chickenpox = centralRepo.countByPatientDiseaseName(Disease.CHICKENPOX);
		long anthrax = centralRepo.countByPatientDiseaseName(Disease.ANTHRAX);
		long fever = centralRepo.countByPatientDiseaseName(Disease.FEVER);
		Map<String, Long> notifyData = new HashMap();
		
		if(hiv > 10) {
			notifyData.put("HIV",hiv);	
		}
		if(malaria > 10) {
			notifyData.put("MALARIA",malaria);
		}
		if(chickenpox > 10) {
			notifyData.put("CHICKENPOX",chickenpox);
		}
		if(anthrax > 10) {
			notifyData.put("ANTHRAX",anthrax);
		}
		if(fever > 10) {
			notifyData.put("FEVER",fever);
		}
		responseDto.setDiseaseName(notifyData);
		return responseDto;

	}

}