package com.example.demo.enterprise.model;

public enum OrganizationalForm {

	OJC("ОАО", 0), CSC("ЗАО", 1), LLC("ООО", 2);
	
	private final String title;
	
	private final int value;
	

	private OrganizationalForm(String title, int value) {
		
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
