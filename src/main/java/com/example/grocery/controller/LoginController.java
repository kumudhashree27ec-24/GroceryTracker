package com.example.grocery.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.grocery.domain.User;
import com.example.grocery.repository.UserRepository;

@Controller 

public class LoginController {
    @Autowired 
    UserRepository repo;
    @GetMapping("/signin")
    public String SignIn() {
        return "login.html";
    }
    @PostMapping("/signin")
    public String Login(@RequestParam String name, @RequestParam String password) {
        User entity = repo.findByNameAndPassword(name, password);
        if(entity == null){
            return "redirect:/register.html";
        }
        return "redirect:/dashboard.html";
    }
    @GetMapping("/logout")
    public String LogOut() {
        return "redirect:/index.html";
    }
}
