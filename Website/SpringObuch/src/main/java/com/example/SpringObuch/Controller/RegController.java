package com.example.SpringObuch.Controller;

import com.example.SpringObuch.Server.RegServer;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class RegController {

    @GetMapping("/reg")
    public String blockMain(Model model){
        model.addAttribute("title", "reg");
        return "reg";
    }

    @PostMapping("/reg")
    public String regMain(@RequestParam String floatingFIO, @RequestParam String floatingTelephone, @RequestParam String floatingDateBirsd, @RequestParam String countries,  Model model){
        if(!floatingFIO.isEmpty() && !floatingTelephone.isEmpty() && !floatingDateBirsd.isEmpty() && !countries.isEmpty()){
            RegServer.Reg(floatingFIO, floatingTelephone, floatingDateBirsd, countries);
            return "home";
        }
        else {
            return "reg";
        }

    }
}
