package com.example.demo;

import java.util.List;

import org.example.demo.Task;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.context.AnnotationConfigServletWebServerApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Primary;

import com.example.demo.model.Doctor;
import com.example.demo.model.Hospital;
import com.example.demo.model.Patient;

@SpringBootApplication
@ComponentScan(basePackages = {"com.example.demo","org.example.demo"})
public class HospitalServiceApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext ctx=SpringApplication.run(HospitalServiceApplication.class, args);
		
//		AnnotationConfigServletWebServerApplicationContext abc;  // this is the class has  ApplicationContext in its hierarchy
//		
//		System.out.println(ctx.getClass().getName());
//		
//		//System.out.println(ctx.getBean("reddy", Doctor.class).toString());
//		//System.out.println(ctx.getBean("doctor", Doctor.class).toString());
//		//System.out.println(ctx.getBean(Doctor.class).toString());
//		
//		System.out.println(ctx.getBean(Hospital.class).toString());
//		
//		List<Patient> patientList = ctx.getBean("doc",Doctor.class).getPatientList();
//		
//		 patientList.forEach(System.out::println);
		 
		Task bean =ctx.getBean(Task.class);
		
		
		System.out.println(ctx.isSingleton("task"));
		System.out.println(ctx.isPrototype("task"));
		
		ctx.close();
	}
	
	@Bean
	//@Primary    //@Bean and @primary go together
	public Doctor reddy() {
		
		return new Doctor(101,"Srinivas Reddy");
	}

	@Bean
	public Patient amar() {
		
		return new Patient(201, "Amar");
	}
	
	@Bean
	public Patient akbar() {
		
		return new Patient(202, "Akbar");
	}
	@Bean
	public Patient anthony() {
		
		return new Patient(203, "Anthony");
	}
}
