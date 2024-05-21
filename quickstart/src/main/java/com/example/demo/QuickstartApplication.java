package com.example.demo;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;

import com.example.demo.ifaces.StudentRepository;
import com.example.demo.impl.InMemoryStudentRepo;
import com.example.demo.impl.JdbcStudentRepo;
import com.example.demo.services.StudentService;

@SpringBootApplication
public class QuickstartApplication {

	public static void main(String[] args) {
	ConfigurableApplicationContext ioc	=SpringApplication.run(QuickstartApplication.class, args);
	
	 System.out.println(ioc.getClass().getName());
	 
	  StudentService service =ioc.getBean("studentService",StudentService.class);
	  
	 // StudentService service2 = (StudentService)ioc.getBean("studentService");
	  
	   service.getStudents();
	   
	   for(String eachStudent:service.getStudents()) {
		   System.out.println(eachStudent);
	   }
	 
	}

	@Bean
	public StudentRepository repoOne() {
		
		return new InMemoryStudentRepo();
	}
	
	@Bean
	@Primary
	public StudentRepository repoTwo() {
		
		return new JdbcStudentRepo();
	}
	
	
}
