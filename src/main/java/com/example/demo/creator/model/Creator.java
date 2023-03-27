package com.example.demo.creator.model;

import com.example.demo.enterprise.model.Enterprise;

public class Creator {

	private Enterprise enterprise;
	
	private int driverNum;
	
	private int vehicleNum;



	public Enterprise getEnterprise() {
		return enterprise;
	}

	public void setEnterprise(Enterprise enterprise) {
		this.enterprise = enterprise;
	}

	public int getDriverNum() {
		return driverNum;
	}

	public void setDriverNum(int driverNum) {
		this.driverNum = driverNum;
	}

	public int getVehicleNum() {
		return vehicleNum;
	}

	public void setVehicleNum(int vehicleNum) {
		this.vehicleNum = vehicleNum;
	}
	
	
	
}
