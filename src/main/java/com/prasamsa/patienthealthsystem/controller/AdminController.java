package com.prasamsa.patienthealthsystem.controller;


import com.prasamsa.patienthealthsystem.model.User;
import com.prasamsa.patienthealthsystem.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private UserRepository userRepo;


    @GetMapping("/")
    public String home(Model m) {
        List<User> list = userRepo.findAll();
        m.addAttribute("all_users", list);

        return "admin/home";
    }

    @GetMapping ("/edit_form/{email}")
    public String editForm(@PathVariable(value="email") String email,Model m) {
        Optional<User> user = Optional.ofNullable(userRepo.findByEmail(email));
        User user2 = user.get();

        System.out.println("Users" + user2);
        m.addAttribute("user",user2);
        return "admin/edit";
    }

    @PostMapping("/edit/{email}")
    public String editUser(@PathVariable String email, @ModelAttribute("user") User user) {
        userRepo.save(user);
        return "redirect:/users";
    }









}
