package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.entity.Hospital;
import com.example.demo.repository.HospitalRepository;

@SpringBootApplication
public class HospitalManagementSystemApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(HospitalManagementSystemApplication.class, args);
	}
	
	@Autowired
	private  HospitalRepository hospitalRepository;
	
	@Override
	public void run(String...args) throws Exception {
		
		Hospital hospital1=new Hospital("Hera", "Siddiqui", "hera12@gmail.com", 21 ,"BpLow");
		hospitalRepository.save(hospital1);
		
		Hospital hospital2=new Hospital("Zaid", "Siddiqui", "zaid26@gmail.com", 19 ,"BackPain");
		hospitalRepository.save(hospital2);
		
		Hospital hospital3=new Hospital("Aabish", "Siddiqui", "aabish04@gmail.com", 17 ,"HeightIssues");
		hospitalRepository.save(hospital3);
		
		Hospital hospital4=new Hospital("Zikra", "Siddiqui", "zikra30@gmail.com", 16 ,"Migrane");
		hospitalRepository.save(hospital4);
	}
		
		
	

}
