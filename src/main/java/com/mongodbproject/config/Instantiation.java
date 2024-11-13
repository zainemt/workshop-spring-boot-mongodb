package com.mongodbproject.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.mongodbproject.domain.dto.RegisterDTO;
import com.mongodbproject.repository.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public void run(String... args) throws Exception {
		
		RegisterDTO user1 = new RegisterDTO(null, null, null);
		
	}

}
