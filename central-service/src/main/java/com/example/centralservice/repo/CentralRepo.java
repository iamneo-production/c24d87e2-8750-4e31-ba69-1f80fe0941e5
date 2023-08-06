package com.example.centralservice.CentralRepo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.centralservice.model.CentralData;
import com.example.centralservice.model.Disease;

public interface CentralRepo extends JpaRepository<CentralData,Integer> {
	long countByPatientDiseaseName(Disease diseases);
}
