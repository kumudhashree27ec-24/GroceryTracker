package com.example.grocery.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.grocery.domain.User;
import com.example.grocery.repository.UserRepository;



@Controller 
public class RegisterController {
    @Autowired
    UserRepository repo;

    @GetMapping("/signup")
    public String SignUp() {
        return "register.html";
    }
    @PostMapping("/signup")
    public String Register(@ModelAttribute User user) {
        repo.save(user);
        return "redirect:/index.html";
    }
}