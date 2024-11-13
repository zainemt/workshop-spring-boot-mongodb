package com.mongodbproject.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.mongodbproject.domain.User;
import com.mongodbproject.repository.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public void run(String... args) throws Exception {
		
		userRepository.deleteAll();
		
		User maria = new User(null, "Maria Brown", "maria@gmail.com", "maria1", "12345"); 
		User alex = new User(null, "Alex Green", "alex@gmail.com", "alex", "12345"); 
		User bob = new User(null, "Bob Grey", "bob@gmail.com", "bob", "12345"); 
		
		userRepository.saveAll(Arrays.asList(maria, alex, bob));
		
	}

}
