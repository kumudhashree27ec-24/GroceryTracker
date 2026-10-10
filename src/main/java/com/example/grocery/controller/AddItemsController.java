package com.example.grocery.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.grocery.domain.Items;
import com.example.grocery.repository.ItemsRepository;



@Controller 
public class AddItemsController {
    @Autowired 
    ItemsRepository repo;
    @GetMapping("/additems")
    public String DisplayItems() {
        return "additems.html";
    }
    @PostMapping("/additems")
    public String AddItems(@ModelAttribute Items item) {
        repo.save(item);
        return "redirect:/dashboard.html";
    }
}
