package com.example.demo.impl;

import com.example.demo.ifaces.StudentRepository;

public class InMemoryStudentRepo implements StudentRepository {

	@Override
	public String[] getStudents() {
		
		String[] names = {"Ramesh","Suresh","Magesh"};
		
		return names;
	}

}
