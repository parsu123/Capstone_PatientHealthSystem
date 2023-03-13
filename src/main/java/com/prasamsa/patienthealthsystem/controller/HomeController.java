package com.prasamsa.patienthealthsystem.controller;

import com.prasamsa.patienthealthsystem.model.User;
import com.prasamsa.patienthealthsystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;


@Controller
public class HomeController {

    @Autowired
    private UserService userService;

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/about")
    public String about() {
        return "about";
    }

    @GetMapping("/register")
    public String register() {
        return "register";
    }

    @GetMapping("/signin")
    public String login() {
        return "login";
    }

    @GetMapping("/patient")
    public String patient() {
        return "patient";
    }

    @GetMapping("/admin")
    public String admin() {
        return "admin";
    }

    @GetMapping("/contactUs")
    public String contactUs() {
        return "contactUs";
    }

    @PostMapping("/createUser")
    public String createuser(@ModelAttribute User user, HttpSession session) {

        boolean val = userService.checkEmail(user.getEmail());

        if(val)
        {
            session.setAttribute("msg", "Email id already exists.");
        }else
        {
            User user1 = userService.createUser(user);
            if(user1!=null) {
                session.setAttribute("msg", "Registered successfully.");
            } else {
             session.setAttribute("msg", "Something wrong on server.");
            }
        }


        return "redirect:/register";
    }


}