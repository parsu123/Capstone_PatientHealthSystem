package com.prasamsa.patienthealthsystem.repository;

import com.prasamsa.patienthealthsystem.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    public boolean existsByEmail(String email);

    public User findByEmail(String email);



}

