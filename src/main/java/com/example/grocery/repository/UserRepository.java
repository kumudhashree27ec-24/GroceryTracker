package com.example.grocery.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.grocery.domain.User;

@Repository 
public interface UserRepository extends JpaRepository<User, Integer> {
    User findByNameAndPassword(String name, String password);

}
