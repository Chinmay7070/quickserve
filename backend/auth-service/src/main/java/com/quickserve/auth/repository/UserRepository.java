package com.quickserve.auth.repository;

import com.quickserve.auth.eintity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
   Optional<User> findByEmail(String email);
    Boolean existsByEmail(String email);
}
