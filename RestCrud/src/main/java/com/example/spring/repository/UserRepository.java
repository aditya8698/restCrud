package com.example.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.spring.entity.User;

public interface UserRepository extends JpaRepository<User, Long>{

}
