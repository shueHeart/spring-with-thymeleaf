package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.manager.model.Manager;
import com.example.demo.manager.service.ManagerService;

@RestController
public class ManagerController {

	@Autowired
	private ManagerService managerService;
	
	@PostMapping("/{username}/manager")
	public Manager createOrUpdateManager(@PathVariable("username") String username) {
		
		return managerService.createOrUpdateManager(username);
		
	}
	
	@GetMapping("/{username}/managers")
	public Manager getAllManager(@PathVariable("username") String username) {
		return managerService.loadUserByUsername(username);
	}
	
}
