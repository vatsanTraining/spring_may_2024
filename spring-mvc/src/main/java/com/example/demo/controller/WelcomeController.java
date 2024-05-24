package com.example.demo.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.entity.Task;
import com.example.demo.service.EmployeeService;
import com.example.demo.service.TaskService;


@Controller
public class WelcomeController {

	

	private EmployeeService service;
	private TaskService taskService;
	
	public WelcomeController(EmployeeService service,TaskService taskService) {
		
		this.service = service;
		this.taskService=taskService;
	}
	
	//@RequestMapping(path = "/",method = RequestMethod.GET)
	@GetMapping("/")
	public String init(Model model) {
		
		model.addAttribute("heading", "Jeevan Blood Bank");
		return "index";
	}
	
	@GetMapping("/srch")
	public String initSearch(Model model) {
		
		model.addAttribute("heading", "Jeevan Blood Bank");
		return "searchemployee";
	}
	
	
	@GetMapping(path = "/employees")
	public String getEmployees(Model model){
		
		
		List<String> list = service.getEmployeeByDept("hr");
		
		model.addAttribute("list",list);
		
		return "showemployee";
	}
	
	@GetMapping(path = "/tasks")
	public String getTasks(Model model){
		
		
		List<Task> list = taskService.findAll();
		
		model.addAttribute("list",list);
		
		return "showtask";
	}
	
	@PostMapping(path = "/tasks")
	public String addTask(Model model ,Task entity){
		
		
		Task response = taskService.save(entity);
		
		
		return "showtask";
	}
	
	
	
	@GetMapping(path = "/srchByDept")
	public String findByDepatment(@RequestParam("dept") String dept,Model model) {
		
		List<String> list = service.getEmployeeByDept(dept);
		
		model.addAttribute("list",list);

		
		return "showemployee";
	}
	
	
}
