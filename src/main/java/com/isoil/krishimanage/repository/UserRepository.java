package com.isoil.krishimanage.repository;

import com.isoil.krishimanage.model.User;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findById(Number id);
    Optional<User> findByEmail(String email);
}
