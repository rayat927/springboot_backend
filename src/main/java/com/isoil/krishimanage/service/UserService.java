package com.isoil.krishimanage.service;

import java.util.Optional;

import com.isoil.krishimanage.model.User;
import com.isoil.krishimanage.repository.UserRepository;

public class UserService {
    private UserRepository userRepository;
    
    public User registerUser(User user) 
    {
        return userRepository.save(user);
    }
    
    public Optional<User> findById(Number id) 
    {
        return userRepository.findById(id);
    }

    public Optional<User> findByEmail(String email) 
    {
        return userRepository.findByEmail(email);
    }
}
