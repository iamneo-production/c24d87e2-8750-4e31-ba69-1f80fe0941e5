package com.example.centralservice.modeldto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import com.example.centralservice.model.Disease;

@Setter
@Getter
@ToString
public class CentralDataDto {
	
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
	private String createdBy;
}
