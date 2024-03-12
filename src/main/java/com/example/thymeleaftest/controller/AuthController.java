package com.example.thymeleaftest.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/auth")
public class AuthController {
    @GetMapping("/register")
    public String showRegisterPage(Model model){
//        model.addAttribute("registerRequest", new User)
        return "register_page";
    }

    @GetMapping("/login")
    public String showLoginPage(){
        return "login_page";
    }

    @PostMapping("/register")
    public String register()
}
