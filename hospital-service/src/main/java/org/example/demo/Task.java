package org.example.demo;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
//@Lazy
//@Scope(scopeName = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class Task {

	private int id;
	private String task;
	private String description;
	public Task() {
		super();

		System.out.println("Inside the constructor");
	}
	
	
	
}


