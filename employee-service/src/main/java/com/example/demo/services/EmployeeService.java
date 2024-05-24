package com.example.demo.services;

import java.util.List;

import org.springframework.objenesis.instantiator.basic.DelegatingToExoticInstantiator;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Employee;
import com.example.demo.ifaces.EmployeeRepository;

@Service
public class EmployeeService {

	
	private EmployeeRepository repo;

	public EmployeeService(EmployeeRepository repo) {
		super();
		this.repo = repo;
	}
	
	
	public Employee addEmployee(Employee entity) {
		
		return this.repo.save(entity);
	}
	
	public List<Employee> findAll(){
		
		return this.repo.findAll();
	}
	
	public Employee update(Employee entity) {
		
		return this.repo.save(entity);
	}
	public Employee remove(int  id) {
		
		Employee deletedElement = null;
		
		if(this.repo.existsById(id)) {
		
			deletedElement = this.findById(id);
		 this.repo.deleteById(id);
		}
		
		return deletedElement;
		
		
		
	}


	public  Employee findById(int id) {
		return this.repo.findById(id).orElseThrow(()-> new RuntimeException("Element with given Id Not Present"));
	}
}
