package com.mongodbproject.exceptions;

public class InvalidObject extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public InvalidObject(String msg) {
		super(msg);
	}
}