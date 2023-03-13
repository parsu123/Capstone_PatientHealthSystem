package com.prasamsa.patienthealthsystem.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/other")
public class OtherController {

    @GetMapping("/")
    public String home() {
        return "other/home";
    }
}
