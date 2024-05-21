package com.example.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.ifaces.StudentRepository;
import com.example.demo.impl.InMemoryStudentRepo;

@Service
public class StudentService {

	private StudentRepository repo;

	
	

	@Autowired
	public StudentService(StudentRepository repo) {
		super();
		this.repo = repo;
	}
	
	public String[] getStudents() {
		
		return this.repo.getStudents();
	}
	

}
