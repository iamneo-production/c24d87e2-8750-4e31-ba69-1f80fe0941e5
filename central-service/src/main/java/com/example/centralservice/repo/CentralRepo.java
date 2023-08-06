package com.example.centralservice.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.centralservice.model.CentralData;
import com.example.centralservice.model.Disease;
import org.springframework.stereotype.Repository;

@Repository
public interface CentralRepo extends JpaRepository<CentralData,Integer> {
	long countByPatientDiseaseName(Disease diseases);
}
