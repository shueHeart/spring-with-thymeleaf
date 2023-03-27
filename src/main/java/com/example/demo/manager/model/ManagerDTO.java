package com.example.demo.manager.model;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public class ManagerDTO {
	
	private String username;
		
	private List<UUID> enterprises = new ArrayList<UUID>();
	
	private ManagerDTO(Manager manager) {
		
		
		this.username = manager.getUsername();
		this.enterprises = manager.getEnterprises().stream().map(enterprise -> enterprise.getUuid()).collect(Collectors.toList());
		
		
	}
	
	public static ManagerDTO fromManager(Manager manager) {
		return new ManagerDTO(manager);
	}
	

	public List<UUID> getEnterprises() {
		return enterprises;
	}

	public void setEnterprises(List<UUID> enterprises) {
		this.enterprises = enterprises;
	}


	
	public String getUsername() {
		return this.username;
	}
	
	public void setUsername(String username) { 
		this.username = username;
	}
	
	
	
}
