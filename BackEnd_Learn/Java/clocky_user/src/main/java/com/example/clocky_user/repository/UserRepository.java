package com.example.clocky_user.repository;

import com.example.clocky_user.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface UserRepository extends JpaRepository<User, Long> { }
