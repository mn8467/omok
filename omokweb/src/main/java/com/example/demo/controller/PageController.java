package com.example.demo.controller;


import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageController {
    @GetMapping("/signup")
    public String signupPage(){
        return "signup";
    }
    @GetMapping("/home")
    public String homePage(){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        System.out.println(auth.getName());  // username
        System.out.println(auth.isAuthenticated()); // true
        return "home";
    }

    @GetMapping("/login")
    public String loginPage(){
        return "login";
    }


}
