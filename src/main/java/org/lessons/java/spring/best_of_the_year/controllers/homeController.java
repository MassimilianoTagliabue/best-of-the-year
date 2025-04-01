package org.lessons.java.spring.best_of_the_year.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.GetMapping;



@Controller
@RequestMapping("/")
public class homeController {
    

    @GetMapping("/")
    public String home( Model model) {
        model.addAttribute("nome", "gino");
       return "index";
    }
    
}
