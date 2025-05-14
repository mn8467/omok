package com.example.demo.controller;


import com.example.demo.domain.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.HashMap;
import java.util.Map;

@RestController()
@RequiredArgsConstructor  // Lombok이 생성자 자동 생성
public class UserController {

    private final UserService userService;

//    @PostMapping("/signup")
//    public String processSignup (@ModelAttribute User user, RedirectAttributes redirectAttributes) {
//        userService.createUser(user);
//
//        redirectAttributes.addFlashAttribute("message", "회원가입이 완료되었습니다. 로그인해주세요!");
//
//        return "redirect:/login";
//    }

    @PostMapping("/signup")
    public ResponseEntity<Map<String, String>> processSignup(@ModelAttribute User user) {
        userService.createUser(user);

        Map<String, String> response = new HashMap<>();
        response.put("redirectUrl", "/login"); // 리다이렉트 URL 추가

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}
