package com.JWT_gestion_compte.authJWT.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.JWT_gestion_compte.authJWT.entities.AppUser;

public interface UserRepository extends JpaRepository<AppUser, Long> {
	
	public AppUser findByUsername (String username);

}
