package com.example.demo.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Hospital {

	@Autowired
	@Qualifier("reddy")
	private Doctor doctor;
	
	@Autowired
	@Qualifier("anthony")
	private Patient patient;
	
	
	public Hospital() {
		super();
		// TODO Auto-generated constructor stub
	}
	//@Autowired    //@Autowired and @Qualifier goes together
	// autowire done by name and type since the id of the bean 
	// and argument to the constructor match it will injecting
	// doctor bean instead reddy 
//	@Autowired
//	public Hospital(Doctor doctor, @Qualifier("amar") Patient patient) {
//		super();
//		this.doctor = doctor;
//		this.patient = patient;
//	}
	public Doctor getDoctor() {
		return doctor;
	}
	
	//@Autowired
	//@Qualifier("reddy")
	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}
	public Patient getPatient() {
		return patient;
	}
	//@Autowired
	//@Qualifier("akbar")
	public void setPatient(Patient patient) {
		this.patient = patient;
	}
	@Override
	public String toString() {
		return "Hospital [doctor=" + doctor + ", patient=" + patient + "]";
	}
	
	
}
