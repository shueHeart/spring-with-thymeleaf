package com.example.demo.vehicle.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.vehicle.model.Brand;
import com.example.demo.vehicle.model.Vehicle;
import com.example.demo.vehicle.model.VehicleType;
import com.example.demo.vehicle.repository.BrandRepository;
import com.example.demo.vehicle.repository.VehicleRepository;

@Service
public class VehicleService {

	@Autowired
	private VehicleRepository vehicleRepository;
	
	@Autowired
	private BrandRepository brandRepository;
	
	public List<Vehicle> findAll() {
		return vehicleRepository.findAll();
	}
	
	public ModelAndView saveVehicle(Vehicle vehicle) {
		
		vehicleRepository.save(vehicle);
		
		ModelAndView vehicles = new ModelAndView("vehicles");
		
		vehicles.addObject("vehicleList", vehicleRepository.findAll());
		
		return vehicles; 
	}
	
	public ModelAndView saveVehicleForm () {
		
		ModelAndView createVehicle = new ModelAndView("createVehicle");
		
		createVehicle.addObject("brandList", findAllBrands());
		
		return createVehicle;
	}
	
	public ModelAndView deleteVehicle(UUID vehicleUuid) {
		
		vehicleRepository.deleteById(vehicleUuid);
		
		ModelAndView vehiclesForm = new ModelAndView("vehicles");
		
		vehiclesForm.addObject("vehicleList", vehicleRepository.findAll());
		
		return vehiclesForm;
		
	}
	
	public List<Brand> findAllBrands() {
		return brandRepository.findAll();
	}
	
	public ModelAndView getAllBrands() {
		
	 	ModelAndView brands = new ModelAndView("brands");
	    
		List<Brand> brandList = findAllBrands();
		
		brands.addObject("brandList", brandList);
		
		return brands;
		
	}
	
	public ModelAndView saveBrand(Brand brand) {
		
		brandRepository.save(brand);
		
		ModelAndView brands = new ModelAndView("brands");
		
		brands.addObject("brandList", brandRepository.findAll());
		
		return brands; 
	}
	
	public ModelAndView saveBrandForm() {
		
		ModelAndView createBrandForm = new ModelAndView("createBrand");
		
		createBrandForm.addObject("typeList", VehicleType.values());
		
		return createBrandForm;
	}
	
	public ModelAndView deleteBrand(UUID brandUuid) {
		
		brandRepository.deleteById(brandUuid);
		
		ModelAndView brandForm = new ModelAndView("brands");
		
		brandForm.addObject("brandList", brandRepository.findAll());
		
		return brandForm;
		
	}
	
	
}
