package com.demomap.mapping.repository;

import com.demomap.mapping.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Long> {

    Optional<User> findByUsername(String username);
    Optional<User> findByEmail(String email);
    Optional<User> findByUsernameOrEmail(String Username, String email);
    Boolean existsByUsername(String username);
    Boolean existsByEmail(String email);

}
