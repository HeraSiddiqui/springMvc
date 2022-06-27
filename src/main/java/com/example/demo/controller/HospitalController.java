package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.entity.Hospital;
import com.example.demo.service.HospitalService;

@Controller
public class HospitalController {
	
	private HospitalService hospitalService;

	public HospitalController(HospitalService hospitalService) {
		super();
		this.hospitalService = hospitalService;
	}
	 
	//handler method to handle list students and return mode and view
	@GetMapping("/hospital")
	public String listHospital(Model model) {
		model.addAttribute("hospital", hospitalService.getAllHospitals());
		return "hospital";
	}
	
	@GetMapping("/hospital/new")
	public String createHspitalForm(Model model) {
		
		// create student object to hold student form data
		Hospital hospital = new Hospital();
		model.addAttribute("hospital", hospital);
		return "create_hospital";
		
	}
	
	@PostMapping("/hospital")
	public String saveHospital(@ModelAttribute("hospital") Hospital hospital) {
		hospitalService.saveHospital(hospital);
		return "redirect:/hospital";
	}
	
	@GetMapping("/hospital/edit/{id}")
	public String editHospitalForm(@PathVariable Long id, Model model) {
		model.addAttribute("hospital", hospitalService.getHospitalById(id));
		return "edit_hospital";
	}

	@PostMapping("/hospital/{id}")
	public String updateHospital(@PathVariable Long id,
			@ModelAttribute("hospital") Hospital hospital,
			Model model) {
		
		// get student from database by id
		Hospital existingHospital = hospitalService.getHospitalById(id);
		existingHospital.setId(id);
		existingHospital.setFirstName(hospital.getFirstName());
		existingHospital.setLastName(hospital.getLastName());
		existingHospital.setEmail(hospital.getEmail());
		existingHospital.setAge(hospital.getAge());
		existingHospital.setHealthstatus(hospital.getHealthstatus());
		
		// save updated student object
		hospitalService.updateHospital(existingHospital);
		return "redirect:/hospital";		
	}
	
	// handler method to handle delete student request
	
	@GetMapping("/hospital/{id")
	public String deleteHospital(@PathVariable Long id) {
		hospitalService.deleteHospitalById(id);
		return "redirect:/hospital";
	}
}
