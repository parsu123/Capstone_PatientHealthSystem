package com.prasamsa.patienthealthsystem.service;

import com.prasamsa.patienthealthsystem.model.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {

    public User createUser(User user);

    public boolean checkEmail(String email);








}
