package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.enterprise.model.Enterprise;
import com.example.demo.enterprise.model.EnterpriseDTO;
import com.example.demo.enterprise.service.EnterpriseService;

@RestController
public class EnterpriseController {

	@Autowired
	private EnterpriseService enterpriseService;
	
	@GetMapping("/enterprises")
	public List<EnterpriseDTO> findAllEnterprises() {
		
		return enterpriseService.findAllEnterprises();
		
	}
	
	@PostMapping("/enterprise")
	public Enterprise saveOrUpdate(@RequestBody Enterprise enterprise) {
		return enterpriseService.saveOrUpdate(enterprise);
	}
	
}
