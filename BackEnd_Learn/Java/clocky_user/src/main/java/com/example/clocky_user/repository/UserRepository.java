package com.example.clocky_user.repository;

import com.example.clocky_user.model.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<User, Long> { }
