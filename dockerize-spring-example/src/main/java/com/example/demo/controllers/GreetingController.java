package com.example.demo.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/greet")
public class GreetingController {

	
	
	@GetMapping
	public String getMessage() {
		
		return "Dockerizing Done correctly By Ramesh";
	}
}
