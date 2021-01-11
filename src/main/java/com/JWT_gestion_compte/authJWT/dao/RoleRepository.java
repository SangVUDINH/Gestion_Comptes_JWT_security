package com.JWT_gestion_compte.authJWT.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.JWT_gestion_compte.authJWT.entities.AppRole;

public interface RoleRepository extends JpaRepository<AppRole,Long>{

	public AppRole findByRoleName(String roleName);
}
