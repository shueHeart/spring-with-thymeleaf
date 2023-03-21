package com.example.demo.manager.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.demo.manager.model.Manager;
import com.example.demo.manager.repository.ManagerRepository;

@Service
public class ManagerService {
	
	@Autowired
	private ManagerRepository managerRepository;
	
	public Manager createOrUpdateManager(String username) {
		
		User user = new User(username, "123", true, true, true, true, new ArrayList());
		
		Manager manager = new Manager();
		
		manager.setUser(user);
		
		return managerRepository.save(manager);
		
	}
	
	public List<Manager> findAll() { 
		return managerRepository.findAll();
	}

	
	public Manager loadUserByUsername(String username) throws UsernameNotFoundException {
		return managerRepository.findByUsername(username);
	}
	
}
