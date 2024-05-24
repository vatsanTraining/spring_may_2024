package com.example.demo.ifaces;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
