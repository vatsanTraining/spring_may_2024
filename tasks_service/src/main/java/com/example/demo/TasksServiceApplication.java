package com.example.demo;

import java.time.LocalDate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

import com.example.demo.entity.Task;
import com.example.demo.services.TaskService;

@SpringBootApplication
public class TasksServiceApplication {

	public static void main(String[] args) {
		
		ConfigurableApplicationContext ctx=SpringApplication.run(TasksServiceApplication.class, args);
		
		 TaskService service=ctx.getBean(TaskService.class);
		   
		Task bean = ctx.getBean("bean",Task.class);
		  
				   service.save(bean);
		 
		 service.findAll().forEach(System.out::println);
		 
		 ctx.close();
		 
	}

	
	@Bean
	 Task bean() {
		
		return new Task(102,"form controls alignment change","Vicky",LocalDate.of(2024, 7, 26));
		
	}
}
