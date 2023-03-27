package com.example.demo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import com.example.demo.manager.model.Manager;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public abstract class BaseController {

    private static final Logger log = LoggerFactory.getLogger(LoginController.class);
    
	protected Manager getCurrentUser()  {
		log.info("HERERERE");

		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//		log.info(authentication.getPrincipal().toString());
		if (authentication != null && authentication.getPrincipal() instanceof Manager) {
			return (Manager) authentication.getPrincipal();
		} else {
			throw new RuntimeException("You aren't authorized to perform this operation!");
		}
	}

}
