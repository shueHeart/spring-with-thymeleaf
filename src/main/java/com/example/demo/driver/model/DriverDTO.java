package com.example.demo.driver.model;

import java.util.UUID;

public class DriverDTO {

	private UUID uuid;
	
	private String firstName;
	
	private String lastName;
	
	private int salary;
	
	private int age;

	private UUID enterpriseUuid;
	
	private UUID vehicleUuid;

	private DriverDTO(Driver driver) {
		this.uuid = driver.getUuid();
		this.firstName = driver.getFirstName();
		this.lastName = driver.getLastName();
		this.salary = driver.getSalary();
		this.age = driver.getAge();
		
		if (driver.getEnterprise() != null) {
			this.enterpriseUuid = driver.getEnterprise().getUuid();
		}
		
		if (driver.getVehicle() != null) {
			this.vehicleUuid = driver.getVehicle().getUuid();
		}
	}
	
	public static DriverDTO fromDriver(Driver driver) {
		return new DriverDTO(driver);
	}
	
	public UUID getUuid() {
		return uuid;
	}

	public void setUuid(UUID uuid) {
		this.uuid = uuid;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public UUID getEnterpriseUuid() {
		return enterpriseUuid;
	}

	public void setEnterpriseUuid(UUID enterpriseUuid) {
		this.enterpriseUuid = enterpriseUuid;
	}

	public UUID getVehicleUuid() {
		return vehicleUuid;
	}

	public void setVehicleUuid(UUID vehicleUuid) {
		this.vehicleUuid = vehicleUuid;
	}

}
