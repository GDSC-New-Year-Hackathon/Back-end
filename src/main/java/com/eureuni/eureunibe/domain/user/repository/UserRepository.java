package com.eureuni.eureunibe.domain.user.repository;

import com.eureuni.eureunibe.domain.user.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUserId(Long userId);

    Optional<User> findByEmail(String email);

    Boolean existsByEmail(String email);
}
