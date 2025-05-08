package com.example.demo.controller;


import com.example.demo.domain.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequiredArgsConstructor  // Lombok이 생성자 자동 생성
public class UserController {

    private final UserService userService;

    @PostMapping("/signup")
    public String processSignup (@ModelAttribute User user,Model model) {
        userService.createUser(user);

       model.addAttribute("message", "회원가입 완료");

        return "/login";
    }



}
