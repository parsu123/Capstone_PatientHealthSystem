package com.prasamsa.patienthealthsystem.repository;

import com.prasamsa.patienthealthsystem.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@Transactional
public interface UserRepository extends JpaRepository<User, Long> {

    public boolean existsByEmail(String email);

    public User findByEmail(String email);

    @Modifying
    @Transactional
    @Query("update User u set u.firstName = ?1, u.lastName = ?2, u.dob =?3 where u.email = ?4")
    void update(String firstname, String lastname, Date dob, String email);

    @Modifying
    @Transactional
    @Query("delete User u where u.email = ?1")
    void delete(String email);

}

