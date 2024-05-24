package com.example.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "sbd_employees")
public class Employee {


	@Id
	@Column(name="id")
    private int id;
	
	@Column(name="employee_name")
    private String employeeName;
	
	@Column(name="designation")
    private String designation;
	
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Employee(int id, String employeeName, String designation) {
		super();
		this.id = id;
		this.employeeName = employeeName;
		this.designation = designation;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getEmployeeName() {
		return employeeName;
	}
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	@Override
	public String toString() {
		return "Employee [id=" + id + ", employeeName=" + employeeName + ", designation=" + designation + "]";
	}
    
    
    
    
}
