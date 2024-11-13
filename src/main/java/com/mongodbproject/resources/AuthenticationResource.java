package com.mongodbproject.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mongodbproject.domain.dto.AuthenticationDTO;

@RestController
@RequestMapping(value = "/auth")
public class AuthenticationResource {
	
	@Autowired
	private AuthenticationManager authenticationManager;

	@PostMapping(value = "/login")
	public ResponseEntity<Void> login(@RequestBody AuthenticationDTO data) {
		var usernamePassword = new UsernamePasswordAuthenticationToken(data.login(), data.password()); //realiza uma junção de usuário + senha, criando deles um token
		var auth = this.authenticationManager.authenticate(usernamePassword);
		
		return ResponseEntity.ok().build();
	}
	
	@PostMapping("Register")
	public ResponseEntity<Void> register(@RequestBody RegisterDTO data) {
		
	}
	
}
