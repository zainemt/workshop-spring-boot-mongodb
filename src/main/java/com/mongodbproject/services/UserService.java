package com.mongodbproject.services;

import java.util.List;
import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mongodbproject.domain.User;
import com.mongodbproject.exceptions.InvalidObject;
import com.mongodbproject.exceptions.ObjectNotFoundException;
import com.mongodbproject.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository repository;
	
	public List<User> findAll() {
		return repository.findAll();
	}
	
	public User findById(ObjectId id) {
		Optional<User> user = repository.findById(id);
		return user.orElseThrow(() -> new ObjectNotFoundException("Id consultado: " + id));
	}
	
	//public User fromDTO(UserDTO dto) {
		//return new User(null, dto.getName(), dto.getEmail());
	//}
	
	public User insert(User user) {
		if (user.getName() == null || user.getEmail() == null) {
			throw new InvalidObject("Informações pendentes: " + user.toString());
		}
		return repository.insert(user);
	}

	public void delete(ObjectId id) {
		findById(id);
		repository.deleteById(id);
	}
}
