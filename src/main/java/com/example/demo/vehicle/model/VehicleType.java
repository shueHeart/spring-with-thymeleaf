package com.example.demo.vehicle.model;

public enum VehicleType {
	
	PASSENGER("Легковой", 0), CARGO("Грузовой", 2), BUS("Автобус", 3);
	
	private final String title;
	
	private final int value;
	

	private VehicleType(String title, int value) {
		
		this.title = title;
		this.value = value;
		
	}
	

	public String getTitle() {
		return title;
	}

	public int getValue() {
		return value;
	}
	
}
