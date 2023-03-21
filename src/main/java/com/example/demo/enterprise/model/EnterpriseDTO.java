package com.example.demo.enterprise.model;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import com.example.demo.driver.model.DriverDTO;
import com.example.demo.vehicle.model.VehicleDTO;

public class EnterpriseDTO {

	private UUID uuid;
	
	private String name;
	
	private String country;
	
	private String city;
	
	private OrganizationalForm organizationalForm;
	
	private List<UUID> vehicleUuids;
	
	private List<UUID> driverUuids;
	
	private EnterpriseDTO(Enterprise enterprise) {  
		
		this.uuid = enterprise.getUuid();
		this.name = enterprise.getName();
		this.country = enterprise.getCountry();
		this.city = enterprise.getCity();
		this.organizationalForm = enterprise.getOrganizationalForm();
		
		if(enterprise.getVehicles() != null) {
			this.vehicleUuids = enterprise.getVehicles().stream()
			.map(vehicle -> vehicle.getUuid()).collect(Collectors.toList());
		}
		
		if(enterprise.getDrivers() != null) {
			this.driverUuids = enterprise.getDrivers().stream()
			.map(driver -> driver.getUuid()).collect(Collectors.toList());
		}
		
	}
	
	public static EnterpriseDTO fromEnterprise(Enterprise enterprise) {
		return new EnterpriseDTO(enterprise);
	}
	

	public UUID getUuid() {
		return uuid;
	}

	public void setUuid(UUID uuid) {
		this.uuid = uuid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public OrganizationalForm getOrganizationalForm() {
		return organizationalForm;
	}

	public void setOrganizationalForm(OrganizationalForm organizationalForm) {
		this.organizationalForm = organizationalForm;
	}


	public List<UUID> getVehicleUuids() {
		return vehicleUuids;
	}


	public void setVehicleUuids(List<UUID> vehicleUuids) {
		this.vehicleUuids = vehicleUuids;
	}


	public List<UUID> getDriverUuids() {
		return driverUuids;
	}


	public void setDriverUuids(List<UUID> driverUuids) {
		this.driverUuids = driverUuids;
	}

	
	
	
}
