package com.example.demo.driver.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.driver.model.Driver;
import com.example.demo.driver.model.DriverDTO;
import com.example.demo.driver.repository.DriverRepository;

@Service
public class DriverService {
	
	@Autowired
	private DriverRepository driverRepository;

	public List<DriverDTO> getAllDrivers() {
		
		return driverRepository.findAll().stream()
				.map(driver -> DriverDTO.fromDriver(driver)).collect(Collectors.toList());
		
	}
	
	public Driver saveOrUpdate(Driver driver) {
		return driverRepository.save(driver);
	}
	
}
