package com.example.demo.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Employee;
import com.example.demo.services.EmployeeService;

@RestController
@RequestMapping(path = "/employees")

@CrossOrigin(origins = "*")
public class EmployeeController {

	
	private EmployeeService service;
	
	
	
	public EmployeeController(EmployeeService service) {
		super();
		this.service = service;
	}


	@GetMapping
	List<Employee> findAll(){

		return this.service.findAll();
		
	}
	
	
	@PostMapping
	ResponseEntity<Employee> save(@RequestBody Employee entity) {
		
		return ResponseEntity.status(201).body( this.service.addEmployee(entity));
		
	}
	
	@PutMapping
	ResponseEntity<Employee> update(@RequestBody Employee entity) {
		
		return ResponseEntity.status(200).body( this.service.addEmployee(entity));
		
	}
	
	@DeleteMapping
	ResponseEntity<Employee> remove(@PathVariable("id") int id) {
		
		return ResponseEntity.status(200).body( this.service.remove(id));
		
	}
	
	
	
}
