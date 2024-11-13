package com.mongodbproject.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mongodbproject.domain.User;
import com.mongodbproject.domain.dto.AuthenticationDTO;
import com.mongodbproject.domain.dto.LoginResponseDTO;
import com.mongodbproject.domain.dto.RegisterDTO;
import com.mongodbproject.infra.security.TokenService;
import com.mongodbproject.repository.UserRepository;

@RestController
@RequestMapping(value = "/auth")
public class AuthenticationResource {
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private UserRepository userRepository;

	@Autowired
	private TokenService tokenService;
	
	@PostMapping(value = "/login")
	public ResponseEntity login(@RequestBody AuthenticationDTO data) {
		var usernamePassword = new UsernamePasswordAuthenticationToken(data.login(), data.password()); //realiza uma junção de usuário + senha, criando deles um token
		var auth = this.authenticationManager.authenticate(usernamePassword);
		
		var token = tokenService.generateToken((User)auth.getPrincipal());
		
		return ResponseEntity.ok(new LoginResponseDTO(token));
	}
	
	@PostMapping("/register")
	public ResponseEntity<Void> register(@RequestBody RegisterDTO data) {
		if (userRepository.findByLogin(data.login()) != null) return ResponseEntity.badRequest().build();
		
		String encryptedPassword = new BCryptPasswordEncoder().encode(data.password());
		User user = new User(data.login(), encryptedPassword , data.role());
		userRepository.save(user);
		return ResponseEntity.ok().build();
	}
	
}
