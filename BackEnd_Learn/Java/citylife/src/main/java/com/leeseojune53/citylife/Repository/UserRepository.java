package com.leeseojune53.citylife.Repository;

import com.leeseojune53.citylife.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUserId(String userId);
    List<User> findTop3ByOrderByUserIdDesc();
}
