package com.prasamsa.patienthealthsystem.configs;

import com.prasamsa.patienthealthsystem.model.User;
import com.prasamsa.patienthealthsystem.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepo;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userRepo.findByEmail(email);
        if(user!=null)
        {
            return new CustomUserDetails(user);
        }
        throw new UsernameNotFoundException("user not available");
    }
}
