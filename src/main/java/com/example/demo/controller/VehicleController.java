package com.example.demo.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.vehicle.model.Brand;
import com.example.demo.vehicle.model.Vehicle;
import com.example.demo.vehicle.service.VehicleService;

@RestController(value="")
public class VehicleController {

	@Autowired
	private VehicleService vehicleService;
	
	@GetMapping("/vehicles")
	public ModelAndView getAllVehicles() {
				
		ModelAndView vehicles = new ModelAndView("vehicles");
	    
		List<Vehicle> vehicleList = vehicleService.findAll();
		
		vehicles.addObject("vehicleList", vehicleList);
		
		return vehicles;
	}
	
	@GetMapping("/vehicle/create")
	public ModelAndView saveVehicleForm() {
		
		return vehicleService.saveVehicleForm();
		
	}
	
	@PostMapping("/vehicle")
	public ModelAndView saveVehicle(@ModelAttribute Vehicle vehicle) {
		
		return vehicleService.saveVehicle(vehicle);
		
	}
	
	@GetMapping("/vehicle/{vehicleUuid}")
	public ModelAndView deleteVehicle(@PathVariable("vehicleUuid") UUID vehicleUuid) {
		
		return vehicleService.deleteVehicle(vehicleUuid);
		
	}
	
	
	@GetMapping("/brands")
	public ModelAndView getAllBrands() {		
		return vehicleService.getAllBrands();
	}
	
	@GetMapping("/brand/create")
	public ModelAndView saveBrandForm() {
		
		return vehicleService.saveBrandForm();
		
	}
	
	@PostMapping("/brand")
	public ModelAndView saveBrand(@ModelAttribute Brand vehicle) {
		
		return vehicleService.saveBrand(vehicle);
		
	}
	
	@GetMapping("/brand/{brandUuid}")
	public ModelAndView deleteBrand(@PathVariable("brandUuid") UUID brandUuid) {
		
		return vehicleService.deleteBrand(brandUuid);
		
	}
	
}
