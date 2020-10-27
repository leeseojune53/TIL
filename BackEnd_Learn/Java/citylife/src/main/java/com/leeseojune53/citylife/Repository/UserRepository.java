package com.leeseojune53.citylife.Repository;

import com.leeseojune53.citylife.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUserId(String userId);
    public List<User> findTop3ByOrderByUserIdDesc();
}
