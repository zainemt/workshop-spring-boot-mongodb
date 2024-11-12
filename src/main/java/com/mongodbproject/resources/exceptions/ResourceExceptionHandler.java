package com.mongodbproject.resources.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.mongodbproject.exceptions.ObjectNotFoundException;

import jakarta.servlet.http.HttpServletRequest;

@ControllerAdvice //dita para o Spring que a classe será responsável por tratar possíveis erros 
public class ResourceExceptionHandler {

	@ExceptionHandler(ObjectNotFoundException.class) //quando ocorrer a exceção declarada, será executado o tratamento definido
	public ResponseEntity<StandardError> objectNotFoundException(ObjectNotFoundException exception, HttpServletRequest request) {
		HttpStatus status = HttpStatus.NOT_FOUND;
		StandardError error = new StandardError(System.currentTimeMillis(), status.value(), "Não encontrado.", exception.getMessage(), request.getRequestURI());
		return ResponseEntity.status(status).body(error);
	}
	
}
