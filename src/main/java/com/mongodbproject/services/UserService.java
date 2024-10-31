package com.mongodbproject.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mongodbproject.domain.User;
import com.mongodbproject.repository.UserRepository;

import jakarta.annotation.PostConstruct;

@Service
public class UserService {

	@Autowired
	private UserRepository repository;
	
	public List<User> findAll() {
		return repository.findAll();
	}
	
	public User findByName(String name) {
		return repository.findByName(name);
	}
	
	@PostConstruct
	public void testInsert() {
	    User user = new User(null, "Teste Usuario", "teste@example.com");
	    repository.save(user);
	    System.out.println("Usuário de teste inserido.");
	}
}
