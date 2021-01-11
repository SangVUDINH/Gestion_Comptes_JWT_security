package com.JWT_gestion_compte.authJWT.service;

import com.JWT_gestion_compte.authJWT.entities.AppRole;
import com.JWT_gestion_compte.authJWT.entities.AppUser;

public interface AccountService {

	public AppUser saveUser(AppUser user);
	public AppRole saveRole(AppRole role);
	
	public void addRoleToUser(String username, String roleName);
	
	public AppUser findUserByUsername(String username);
}
