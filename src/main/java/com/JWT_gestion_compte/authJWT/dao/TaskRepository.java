package com.JWT_gestion_compte.authJWT.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.JWT_gestion_compte.authJWT.entities.Task;

public interface TaskRepository extends JpaRepository<Task, Long>{

}
