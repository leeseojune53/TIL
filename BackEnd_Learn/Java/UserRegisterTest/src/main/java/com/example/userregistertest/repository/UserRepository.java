package com.example.userregistertest.repository;

import com.example.userregistertest.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface UserRepository extends CrudRepository<User, Long> {

}
