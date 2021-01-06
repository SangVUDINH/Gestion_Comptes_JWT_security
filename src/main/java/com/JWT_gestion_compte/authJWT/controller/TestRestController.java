package com.JWT_gestion_compte.authJWT.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.JWT_gestion_compte.authJWT.dao.TaskRepository;
import com.JWT_gestion_compte.authJWT.entities.Task;

@RestController
public class TestRestController {
	@Autowired
	private TaskRepository taskRepository;
	
	@GetMapping("/tasks")
	public List<Task> listTasks(){
		return taskRepository.findAll();
	}
	
	@PostMapping("/task")
	public Task save(@RequestBody Task t) {
		return taskRepository.save(t);
	}
	
	
}
