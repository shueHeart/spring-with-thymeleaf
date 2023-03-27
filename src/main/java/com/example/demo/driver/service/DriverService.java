package com.example.demo.driver.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.driver.model.Driver;
import com.example.demo.driver.model.DriverDTO;
import com.example.demo.driver.repository.DriverRepository;
import com.example.demo.enterprise.model.Enterprise;
import com.example.demo.enterprise.repository.EnterpriseRepository;
import com.example.demo.vehicle.model.Brand;
import com.example.demo.vehicle.model.Vehicle;

@Service
public class DriverService {
	
	@Autowired
	private DriverRepository driverRepository;
	
	@Autowired
	private EnterpriseRepository enterpriseRepository;

	public List<DriverDTO> getAllDrivers() {
		
		return driverRepository.findAll().stream()
				.map(driver -> DriverDTO.fromDriver(driver)).collect(Collectors.toList());
		
	}
	
	public ModelAndView createDriver() {
		
		ModelAndView createDriver = new ModelAndView("createDriver");
		
		List<Enterprise> enterpriseList = enterpriseRepository.findAll();
			
		createDriver.addObject("enterpriseList", enterpriseList);
		
		return createDriver;
		
		
	}
	
	public Driver saveOrUpdate(Driver driver) {
		return driverRepository.save(driver);
	}
	
}
