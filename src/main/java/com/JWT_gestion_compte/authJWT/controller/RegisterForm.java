package com.JWT_gestion_compte.authJWT.controller;

import lombok.Data;

@Data
public class RegisterForm {
	
	private String username;
	private String password;
	private String repassword;
	
}
