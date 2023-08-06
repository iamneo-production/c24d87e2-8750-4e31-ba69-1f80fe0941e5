package com.example.centralservice.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;



import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



  
import lombok.ToString;

@Setter
@ToString
@NoArgsConstructor
@Getter
@Entity
@Table(name = "CentralData")
public class CentralData {
	
	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int id;
	
	private String patientName;
	private String patientAge;
	private String patientSex;
	private String patientCity;
	private String patientState;
	private String patientHospitalName;
	private String patientHospitalCity;
	private String patientHospitalState;
	
	@Enumerated(EnumType.STRING)
	private Disease patientDiseaseName;
	
	private String patientDiseaseDescription;
	private LocalDateTime createdOn;
	private String createdBy;
	
	public CentralData(String patientName, String patientAge, String patientSex, String patientCity,
			String patientState, String patientHospitalName, String patientHospitalCity, String patientHospitalState,
			String patientDiseaseDescription, String createdBy) {
		super();
		this.patientName = patientName;
		this.patientAge = patientAge;
		this.patientSex = patientSex;
		this.patientCity = patientCity;
		this.patientState = patientState;
		this.patientHospitalName = patientHospitalName;
		this.patientHospitalCity = patientHospitalCity;
		this.patientHospitalState = patientHospitalState;
		this.patientDiseaseDescription = patientDiseaseDescription;
		this.createdBy = createdBy;
	}
	
}
