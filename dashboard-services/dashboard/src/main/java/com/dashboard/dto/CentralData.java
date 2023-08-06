package com.dashboard.dto;

import java.time.LocalDateTime;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



  
import lombok.ToString;
@Data
@Document(collection= "CentralData")
public class CentralData {
	

	private int id;
	
	private String patientName;
	private String patientAge;
	private String patientSex;
	private String patientCity;
	private String patientState;
	private String patientHospitalName;
	private String patientHospitalCity;
	private String patientHospitalState;
	
	
	private Disease patientDiseaseName;
	
	private String patientDiseaseDescription;
	private LocalDateTime createdOn;
	private String createdBy;
	
	
	
}
