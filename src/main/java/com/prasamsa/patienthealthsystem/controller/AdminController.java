package com.prasamsa.patienthealthsystem.controller;


import com.prasamsa.patienthealthsystem.model.UpdateUser;
import com.prasamsa.patienthealthsystem.model.User;
import com.prasamsa.patienthealthsystem.repository.UserRepository;
import com.prasamsa.patienthealthsystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private UserRepository userRepo;

    @Autowired
    private UserService userService;


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

    @PostMapping("/edit_form/updateUser")
    public String updateUser(@ModelAttribute UpdateUser updateuser, HttpSession session)  {

           userService.updateUser(updateuser);

        return "redirect:/admin/code";
    }

    @GetMapping("/deleteUser/{email}")
    public String deleteUser(@PathVariable String email, HttpSession session)  {

        userService.deleteUser(email);

        return "redirect:/admin/messagefordelete";
    }

    @GetMapping("/code")
    public String code(Model m , HttpSession session) {
        List<User> list = userRepo.findAll();
        m.addAttribute("all_users", list);
        session.setAttribute("msg", "Updated successfully.");
        return "admin/home";
    }

    @GetMapping("/messagefordelete")
    public String deletemessage(Model m , HttpSession session) {
        List<User> list = userRepo.findAll();
        m.addAttribute("all_users", list);
        session.setAttribute("msg", "Deleted successfully.");
        return "admin/home";
    }


}
