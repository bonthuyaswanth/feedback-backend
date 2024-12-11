package com.klef.jfsd.service;

import com.klef.jfsd.model.User;
import com.klef.jfsd.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public void registerUser(User user) {
        if (userRepository.findByEmail(user.getEmail()).isPresent()) {
            throw new RuntimeException("Email is already registered");
        }
        userRepository.save(user);
    }

    public boolean authenticateUser(String email, String password, String userType) {
        return userRepository.findByEmailAndPasswordAndUserType(email, password, userType).isPresent();
    }
}
