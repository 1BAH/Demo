package com.example.demo.controllers;

import com.example.demo.models.User;
import com.example.demo.repos.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.restart.RestartEndpoint;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserController {
    @Autowired
    UserRepo userRepo;

    @Autowired
    private RestartEndpoint restartEndpoint;

    @GetMapping("/registration")
    public String Registration(Model model) {
        return "registration";
    }

    @GetMapping("/registration/form")
    public String addUser(@RequestParam String name, @RequestParam String surname, @RequestParam String passport, @RequestParam String address) {
        User user = new User();
        user.setName(name);
        user.setSurname(surname);
        user.setPassport(passport);
        user.setAddress(address);

        userRepo.save(user);

        restartEndpoint.restart();

        return "redirect:/";
    }

    @GetMapping("/home")
    public String home(Model model) {
        return "home";
    }

    @GetMapping("/")
    public String main(Model model) {
        return "redirect:/home";
    }

}
