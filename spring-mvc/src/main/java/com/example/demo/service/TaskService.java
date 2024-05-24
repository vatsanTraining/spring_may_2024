package com.example.demo.service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.demo.entity.Task;
import com.example.demo.ifaces.TaskRepository;

@Service
public class TaskService {
	
	
	private TaskRepository repo;

	// Repository will be injected -constructor DI
	
	public TaskService(TaskRepository repo) {
		super();
		this.repo = repo;
	}
	
	
	public Task save(Task entity) {
		
		return this.repo.save(entity);
	}
	
	public List<Task>      findAll() {
		
		return this.repo.findAll();
		
	}
	
	
	
	public Task findById(int id) 
	{
		  return this.repo.findById(id).orElseThrow(() -> new RuntimeException("Element with given id"+id+"Not found"));   //using optional and exception handling
	}
	
	
	public Task removeById(int id){
		
		Task elementDeleted = null;
		if(this.repo.existsById(id)) {
			 elementDeleted = this.findById(id);

		 this.repo.deleteById(id);  //passing argument
		} 
		
		return elementDeleted;
		
	}
	
	
	public  Task update(Task entity){
		
		return this.repo.save(entity); 
	}
	
	public Map<String, String> getTaskAndAssigne(){
		
		return findAll().stream().collect(Collectors.toMap(Task::getTask, Task::getAssingedTo));
	}
}
