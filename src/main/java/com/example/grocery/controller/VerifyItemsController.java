package com.example.grocery.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.grocery.domain.Items;
import com.example.grocery.repository.ItemsRepository;




@Controller 
public class VerifyItemsController {
    @Autowired 
    ItemsRepository repo;
    @GetMapping("/verifyitems")
    public String DisplayVerifyItems() {
        return "verifyitems.html";
    }
    @PostMapping("/verifyitems")
    public String VerifyItems(@RequestParam String name) {
        Items entity = repo.findByName(name);
        if(entity == null){
            return "redirect:/additems.html";
        }
        return "redirect:/verifyfinal.html";
    }
    @GetMapping("/back")
    public String Back() {
        return "redirect:/dashboard.html";
    }
    
}
