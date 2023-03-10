package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class MainPatternController {

    
    @GetMapping("/greeting")
    public ModelAndView greeting(@RequestParam(name="name", required=false, defaultValue="World") String name) {
    	
        ModelAndView modelAndView = new ModelAndView("greeting");
        modelAndView.addObject("hello", "Приветствую");
    	modelAndView.addObject("name", name);
    	
        return modelAndView;
    }
    
	
}
