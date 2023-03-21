package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.enterprise.model.Enterprise;
import com.example.demo.enterprise.service.EnterpriseService;
import com.example.demo.vehicle.model.Brand;
import com.example.demo.vehicle.model.Vehicle;
import com.example.demo.vehicle.model.VehicleDTO;
import com.example.demo.vehicle.service.VehicleService;

@RestController(value="")
public class VehicleController {

	@Autowired
	private VehicleService vehicleService;
	
	@Autowired
	private EnterpriseService enterpriseService;
	
	@GetMapping("/vehicles")
	public ModelAndView getAllVehicles() {
		return vehicleService.getAllVehicles();
	}
	
	@GetMapping("/json/vehicles") 
	public List<VehicleDTO> getAllJsonVehicles() {
		return vehicleService.findAll();
	}
	
	@GetMapping("/vehicle/create")
	public ModelAndView saveVehicleForm() {
		
		return vehicleService.saveVehicleForm();
		
	}
	

	@PostMapping("/json/vehicle")
	public Vehicle saveJsonVehicle(@RequestBody Vehicle vehicle) {
		
		return vehicleService.saveJsonVehicle(vehicle);
		
	}
	
	@PostMapping("/vehicle")
	public ModelAndView saveVehicle(@ModelAttribute Vehicle vehicle) {
		
		return vehicleService.saveVehicle(vehicle);
		
	}
	
	@GetMapping("/update/{vehicleUuid}/vehicle")
	public ModelAndView updateVehicle(@PathVariable("vehicleUuid") UUID vehicleUuid) {
		return vehicleService.updateVehicle(vehicleUuid);
	}
	
	@GetMapping("/vehicle/{vehicleUuid}")
	public ModelAndView deleteVehicle(@PathVariable("vehicleUuid") UUID vehicleUuid) {
		
		return vehicleService.deleteVehicle(vehicleUuid);
		
	}
	
	
	@GetMapping("/brands")
	public ModelAndView getAllBrands() {		
		return vehicleService.getAllBrands();
	}
	
	@GetMapping("/json/brands")
	public List<Brand> getAllJsonBrands() {		
		return vehicleService.findAllBrands();
	}
	
	@GetMapping("/brand/create")
	public ModelAndView saveBrandForm() {
		
		return vehicleService.saveBrandForm();
		
	}
	
	@GetMapping("/update/{brandUuid}/brand")
	public ModelAndView updateBrand(@PathVariable("brandUuid") UUID brandUuid) {
		return vehicleService.updateBrand(brandUuid);
	}
	
	@PostMapping("/brand")
	public ModelAndView saveBrand(@ModelAttribute Brand vehicle) {
		
		return vehicleService.saveBrand(vehicle);
		
	}
	
	@GetMapping("/brand/{brandUuid}")
	public ModelAndView deleteBrand(@PathVariable("brandUuid") UUID brandUuid) {
		
		return vehicleService.deleteBrand(brandUuid);
		
	}
	
	@GetMapping("/manager/{mangerId}/vehicles")
	public List<Vehicle> findAllVehiclesForManager(@PathVariable("mangerId") UUID mangerId) {
		
		List<Enterprise> enterprises = enterpriseService.findAllEnterprisesByManagerId(mangerId);
		
		List<Vehicle> vehicles = new ArrayList<Vehicle>();
		
		enterprises.forEach(enterprise -> vehicles.addAll(enterprise.getVehicles()));
		
		return vehicles;
		
	}
	
}
