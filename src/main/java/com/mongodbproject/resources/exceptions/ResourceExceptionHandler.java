package com.mongodbproject.resources.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.mongodbproject.exceptions.InvalidObject;
import com.mongodbproject.exceptions.ObjectNotFoundException;

import jakarta.servlet.http.HttpServletRequest;

@ControllerAdvice //dita para o Spring que a classe será responsável por tratar possíveis erros 
public class ResourceExceptionHandler {

	@ExceptionHandler(ObjectNotFoundException.class) //quando ocorrer a exceção declarada, será executado o tratamento definido
	public ResponseEntity<StandardError> objectNotFoundException(ObjectNotFoundException exception, HttpServletRequest request) {
		HttpStatus status = HttpStatus.NOT_FOUND;
		StandardError error = new StandardError(System.currentTimeMillis(), status.value(), "Objeto não encontrado.", exception.getMessage(), request.getRequestURI());
		return ResponseEntity.status(status).body(error);
	}
	
	@ExceptionHandler(InvalidObject.class) //inserção de um objeto inválido
	public ResponseEntity<StandardError> invalidObject(InvalidObject exception, HttpServletRequest request) {
		HttpStatus status = HttpStatus.BAD_REQUEST;
		StandardError error = new StandardError(System.currentTimeMillis(), status.value(), "Objeto inválido.", exception.getMessage(), request.getRequestURI());
		return ResponseEntity.status(status).body(error);
	}
	
}
