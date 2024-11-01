package com.mongodbproject.domain.dto;

import java.io.Serializable;

import org.bson.types.ObjectId;

import com.mongodbproject.domain.User;

public class UserDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private ObjectId id;
	private String name;
	private String email;
	
	public UserDTO() {}
	
	public UserDTO(User user) {
		this.id = user.getId();
		this.name = user.getName();
		this.email = user.getEmail();
	}

	public ObjectId getId() {
		return id;
	}
	public void setId(ObjectId id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
}
