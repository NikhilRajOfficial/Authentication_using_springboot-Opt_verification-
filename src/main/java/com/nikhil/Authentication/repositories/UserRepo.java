package com.nikhil.Authentication.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nikhil.Authentication.entity.User;


public interface UserRepo extends JpaRepository<User , Long>{

    Optional<User> findByEmail(String email);

}
