package com.JWT_gestion_compte.authJWT.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.JWT_gestion_compte.authJWT.dao.RoleRepository;
import com.JWT_gestion_compte.authJWT.dao.UserRepository;
import com.JWT_gestion_compte.authJWT.entities.AppRole;
import com.JWT_gestion_compte.authJWT.entities.AppUser;


@Service
@Transactional	
public class AccountServiceImpl implements AccountService{

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private RoleRepository roleRepository;
	
	
	@Override
	public AppUser saveUser(AppUser user) {
		
		String hashPW = bCryptPasswordEncoder.encode(user.getPassword());		
		user.setPassword(hashPW);
		
		
		return userRepository.save(user);
	}

	@Override
	public AppRole saveRole(AppRole role) {
		return roleRepository.save(role);
	}

	@Override
	public void addRoleToUser(String username, String roleName) {
		AppRole role = roleRepository.findByRoleName(roleName);
		AppUser user = userRepository.findByUsername(username);
		
		user.getRoles().add(role);		
	}

	@Override
	public AppUser findUserByUsername(String username) {
		return userRepository.findByUsername(username);
	}

	
}
