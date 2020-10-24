package com.leeseojune53.citylife.Repository;

import com.leeseojune53.citylife.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> { }
