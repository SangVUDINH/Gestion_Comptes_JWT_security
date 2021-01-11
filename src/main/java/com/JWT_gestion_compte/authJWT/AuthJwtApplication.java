package com.JWT_gestion_compte.authJWT;

import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.JWT_gestion_compte.authJWT.dao.TaskRepository;
import com.JWT_gestion_compte.authJWT.entities.AppRole;
import com.JWT_gestion_compte.authJWT.entities.AppUser;
import com.JWT_gestion_compte.authJWT.entities.Task;
import com.JWT_gestion_compte.authJWT.service.AccountService;

@SpringBootApplication
public class AuthJwtApplication implements CommandLineRunner{

	@Autowired
	private TaskRepository taskRepository;
	
	@Autowired
	private AccountService accountService;
	
	public static void main(String[] args) {
		SpringApplication.run(AuthJwtApplication.class, args);
	}
	
	@Bean
	public BCryptPasswordEncoder getBCPE() {
		return new BCryptPasswordEncoder();
	}
	
	@Override
	public void run(String... arg0) throws Exception {
		accountService.saveUser(new AppUser(null,"admin","1234", null));
		accountService.saveUser(new AppUser(null,"user","1234", null));
		
		accountService.saveRole(new AppRole(null,"ADMIN"));
		accountService.saveRole(new AppRole(null,"USER"));
		
		accountService.addRoleToUser("admin","ADMIN");
		accountService.addRoleToUser("admin","USER");
		accountService.addRoleToUser("user","USER");
		
		Stream.of("T1","T2","T3").forEach(t->{
			Task task = new Task(null,t);
			taskRepository.save(task);
		});
		
		taskRepository.findAll().forEach(t -> {
			System.out.println(t.getTaskName());
		});
	}

}
