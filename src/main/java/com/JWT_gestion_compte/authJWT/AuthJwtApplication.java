package com.JWT_gestion_compte.authJWT;

import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.JWT_gestion_compte.authJWT.dao.TaskRepository;
import com.JWT_gestion_compte.authJWT.entities.Task;

@SpringBootApplication
public class AuthJwtApplication implements CommandLineRunner{

	@Autowired
	private TaskRepository taskRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(AuthJwtApplication.class, args);
	}
	
	@Override
	public void run(String... arg0) throws Exception {
		Stream.of("T1","T2","T3").forEach(t->{
			Task task = new Task(null,t);
			taskRepository.save(task);
		});
		
		taskRepository.findAll().forEach(t -> {
			System.out.println(t.getTaskName());
		});
	}

}
