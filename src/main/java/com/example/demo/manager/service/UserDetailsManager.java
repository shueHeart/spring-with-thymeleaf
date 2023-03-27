package com.example.demo.manager.service;

import java.util.ArrayList;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.demo.controller.LoginController;
import com.example.demo.manager.model.Manager;
import com.example.demo.manager.repository.ManagerRepository;

import lombok.extern.slf4j.Slf4j;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
@Slf4j
public class UserDetailsManager implements UserDetailsService {
	
	
    private static final Logger log = LoggerFactory.getLogger(LoginController.class);

    @Autowired
    private ManagerRepository managerRepository;

    @Override
    public Manager loadUserByUsername(String username) throws UsernameNotFoundException {
        Manager manager = managerRepository.findByUsername(username);
        
        log.info(username);
        
        if (manager == null) {
            throw new UsernameNotFoundException("User not found with username: " + username);
        }
        return manager;
    }
}
