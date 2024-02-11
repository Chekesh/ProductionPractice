package com.example.SpringObuch.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BlogController {
    @GetMapping("/blog")
    public String blockMain(Model model){
        model.addAttribute("title", "blog");
        return "blog";
    }
}
