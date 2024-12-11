package com.klef.jfsd.repository;

import com.klef.jfsd.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);

    Optional<User> findByEmailAndPasswordAndUserType(String email, String password, String userType);
}
