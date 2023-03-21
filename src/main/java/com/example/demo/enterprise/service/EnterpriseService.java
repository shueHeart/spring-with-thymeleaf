package com.example.demo.enterprise.service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.enterprise.model.Enterprise;
import com.example.demo.enterprise.model.EnterpriseDTO;
import com.example.demo.enterprise.repository.EnterpriseRepository;
import com.example.demo.manager.model.Manager;
import com.example.demo.manager.repository.ManagerRepository;

@Service
public class EnterpriseService {
	
	@Autowired
	private EnterpriseRepository enterpriseRepository;
	
	@Autowired
	private ManagerRepository managerRepository;
	
	public List<EnterpriseDTO> findAllEnterprises() {
		return enterpriseRepository.findAll().stream()
				.map(enterprise -> EnterpriseDTO.fromEnterprise(enterprise)).collect(Collectors.toList());
	}
	
	public Enterprise saveOrUpdate(Enterprise enterprise) {
		return enterpriseRepository.save(enterprise);
	}
	
	public List<Enterprise> findAllEnterprisesByManagerId(UUID managerId) {
		
		Manager manager = managerRepository.findById(managerId)
				.orElseThrow(() -> new RuntimeException("Manager not found"));
		
//		List<Manager> managers = new ArrayList<Manager>();
//		
//		managers.add(manager);
		
		return manager.getEnterprises();
	}
	
}
