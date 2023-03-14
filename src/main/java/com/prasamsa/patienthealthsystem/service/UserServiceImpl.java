package com.prasamsa.patienthealthsystem.service;

import com.prasamsa.patienthealthsystem.model.UpdateUser;
import com.prasamsa.patienthealthsystem.model.User;
import com.prasamsa.patienthealthsystem.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepo;

    @Autowired
    private BCryptPasswordEncoder passwordEncode;

    @Override
    public User createUser(User user) {

        user.setPassword(passwordEncode.encode(user.getPassword()));
        user.setRole("ROLE_USER");
        return userRepo.save(user);
    }

    @Override
    public boolean checkEmail(String email) {
        return userRepo.existsByEmail(email);
    }

    public UpdateUser updateUser(UpdateUser update)  {

        userRepo.update(update.getFirstName(),update.getLastName(),update.getDob(),update.getEmail());
        return null;
    }

    public String deleteUser(String email) {
        userRepo.delete(email);
        return null;
    }

}


