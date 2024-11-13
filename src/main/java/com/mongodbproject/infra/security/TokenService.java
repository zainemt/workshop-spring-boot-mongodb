package com.mongodbproject.infra.security;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.mongodbproject.domain.User;

@Service
public class TokenService {

	@Value("${api.security.token.secret}")
	private String secret;
	
	public String generateToken(User user) {
		try {
			//gera uma criptografia única para a aplicação
			//uso da chave pessoal (secret) para a descriptografia
			Algorithm algorithm = Algorithm.HMAC256(secret);
			String token = JWT.create().withIssuer("auth-api").withSubject(user.getLogin()).withExpiresAt(generateExpirationDate()).sign(algorithm);
			return token;
		} catch (JWTCreationException e) {
			throw new RuntimeException("Erro na geração do token", e);
		}
	}
	
	//retorna o usuário
	public String validateToken(String token) {
		try {
			Algorithm algorithm = Algorithm.HMAC256(secret);
			return JWT.require(algorithm).withIssuer("auth-api").build().verify(token).getSubject();
		} catch (JWTVerificationException e) {
			return "";
		}
	}
	
	private Instant generateExpirationDate() {
		return LocalDateTime.now().plusHours(2).toInstant(ZoneOffset.of("-03:00"));
	}
	
}
