package com.example.demo.impl;

import com.example.demo.ifaces.StudentRepository;

public class JdbcStudentRepo implements StudentRepository {

	@Override
	public String[] getStudents() {
		
		String[] names = {"Ganga","Yamnua","Saraswathi"};
		
		return names;
	}

}
