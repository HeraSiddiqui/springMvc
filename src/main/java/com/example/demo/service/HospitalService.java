package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Hospital;

public interface HospitalService {
    List<Hospital> getAllHospitals();
    
    Hospital saveHospital(Hospital hospital);
    
    Hospital getHospitalById(Long id);
    Hospital updateHospital(Hospital hospital);

	void deleteHospitalById(Long id);
}
