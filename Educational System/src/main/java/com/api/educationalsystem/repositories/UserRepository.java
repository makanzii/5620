package com.api.educationalsystem.repositories;

import org.springframework.data.repository.CrudRepository;

import com.api.educationalsystem.models.User;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

public interface UserRepository extends CrudRepository<User, Integer> {

    User findByEmailAndPassword(String email, String password);

    User findByEmail(String username);

}