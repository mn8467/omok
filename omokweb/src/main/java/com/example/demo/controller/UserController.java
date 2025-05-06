package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller()
public class UserController {
    @GetMapping("/signup")
    public String signupPage(){
        return "signup";
    }
}
