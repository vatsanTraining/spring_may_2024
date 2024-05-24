package com.example.demo.service;

import org.springframework.stereotype.Service;
import java.util.*;
@Service
public class EmployeeService {

	
	private HashMap<String, List<String>> list;

	public EmployeeService() {
		super();
		
		this.list= new HashMap<>();

		this.list.put("hr", List.of("Ramesh","Suresh","Magesh"));
		this.list.put("finance", List.of("ganga","yamuna","krishna"));
		
	}
	
	
	public List<String> getEmployeeByDept(String dept){
		
		return this.list.get(dept);
	}
	
	
}
