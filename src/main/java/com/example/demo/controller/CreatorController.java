package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.creator.model.Creator;
import com.example.demo.creator.service.CreatorService;

@RestController
public class CreatorController extends BaseController{

	@Autowired
	private CreatorService creatorService;
	
	
	@PostMapping("/creator/create")
	public void creator(@RequestBody Creator creator) {
		creatorService.create(creator, getCurrentUser());
	}
	
}
