package com.example.demo.modeldto;

import com.example.demo.modeldto.Disease;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class HealthCareReport {
	
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