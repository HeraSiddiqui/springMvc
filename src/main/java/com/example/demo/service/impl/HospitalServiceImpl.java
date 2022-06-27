package com.example.demo.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.entity.Hospital;
import com.example.demo.repository.HospitalRepository;
import com.example.demo.service.HospitalService;

@Service
public class HospitalServiceImpl implements HospitalService {

	private HospitalRepository hospitalRepository;
	
	
	public HospitalServiceImpl(HospitalRepository hospitalRepository) {
		super();
		this.hospitalRepository = hospitalRepository;
	}


	@Override
	public List<Hospital> getAllHospitals() {
		return hospitalRepository.findAll();
	}


	@Override
	public Hospital saveHospital(Hospital hospital) {
		return hospitalRepository.save(hospital);
	}


	@Override
	public Hospital getHospitalById(Long id) {
		return hospitalRepository.findById(id).get();
	}


	@Override
	public Hospital updateHospital(Hospital hospital) {
		return hospitalRepository.save(hospital);
	}

	@Override
	public void deleteHospitalById(Long id) {
		hospitalRepository.deleteById(id);
	
	}
	

	
}
