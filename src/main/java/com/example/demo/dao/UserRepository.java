package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entiry.User;

public interface UserRepository extends JpaRepository<User, Integer> {

}
