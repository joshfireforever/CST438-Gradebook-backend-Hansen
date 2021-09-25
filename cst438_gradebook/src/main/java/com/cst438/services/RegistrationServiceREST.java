package com.cst438.services;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.cst438.domain.CourseDTOG;

public class RegistrationServiceREST extends RegistrationService {

	
	RestTemplate restTemplate = new RestTemplate();
	
	@Value("${registration.url}") 
	String registration_url;
	
	public RegistrationServiceREST() {
		System.out.println("REST registration service ");
	}
	
	@Override
	public void sendFinalGrades(int course_id , CourseDTOG courseDTO) { 
		
		System.out.println("Sending final grades: "+courseDTO);
		
		restTemplate.put(
				"http://localhost:8080/course/" + course_id,   // URL
				courseDTO,                              // data to send
				CourseDTOG.class);                 // return data type
		
		
	}
}
