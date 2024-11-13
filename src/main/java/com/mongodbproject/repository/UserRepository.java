package com.mongodbproject.repository;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

import com.mongodbproject.domain.User;

@Repository
public interface UserRepository extends MongoRepository<User, ObjectId>{

	UserDetails findByLogin(String login);
}
