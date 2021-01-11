package com.JWT_gestion_compte.authJWT.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.JWT_gestion_compte.authJWT.entities.AppUser;
import com.JWT_gestion_compte.authJWT.service.AccountService;

@RestController
public class AccountRestController {

	@Autowired
	private AccountService accountService;
	
	@PostMapping("/register")
	public AppUser register(@RequestBody RegisterForm userForm) {
		
		if(!userForm.getPassword().equals(userForm.getRepassword())) {
			throw new RuntimeException("not the same PW");
		}
		
		AppUser userCheck = accountService.findUserByUsername(userForm.getUsername());
		if(userCheck != null) {
			throw new RuntimeException("user name used !");
		}
		
		AppUser user = new AppUser();
		user.setUsername(userForm.getUsername());
		user.setPassword(userForm.getPassword());
		accountService.saveUser(user);
		accountService.addRoleToUser(user.getUsername(), "USER");
		return user;
	}
}
