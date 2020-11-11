package com.example.jwt.Entity.RefreshToken;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RefreshTokenRepository extends JpaRepository<RefreshToken, Integer> {
    Optional<RefreshToken> findById(Integer id);
    Optional<RefreshToken> findByRefreshToken(String RefreshToken);
}
