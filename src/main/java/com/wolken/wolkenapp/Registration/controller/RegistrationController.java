package com.wolken.wolkenapp.Registration.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wolken.wolkenapp.Registration.Entity.RegistrationEntity;
import com.wolken.wolkenapp.Registration.Service.RegistartionService;

@RestController
@Transactional
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/")
public class RegistrationController {
	@Autowired
	RegistartionService service;
	
	Logger logger = LoggerFactory.getLogger(RegistrationController.class);
	@GetMapping("/index")
	public String index() {
		return "Hello";
	}
	
	@PostMapping("/save")
	public String addUserDetails(@RequestBody RegistrationEntity entity) {
		logger.info("Entered the controller");
		return service.validateAndAdd(entity);
	}
	
	@GetMapping("/getbyemail")
	public RegistrationEntity getByEmail(String email) {
		logger.info("Entered the controller");
		return service.validateAndGetByEmail(email);
	}
	
	@PutMapping("/updatebyemail")
	public String updateByEmail(@RequestBody RegistrationEntity entity) {
		logger.info("Entered the controller");
		return service.validateAndUpdateByEmail(entity);
	}
	
	@DeleteMapping("/deletebyemail")
	public String deleteByEmail(String email) {
		logger.info("Entered the controller");
		return service.validateAndDeleteByEmail(email);
	}

}
