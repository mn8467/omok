package com.example.demo.service;

import com.example.demo.domain.User;
import com.example.demo.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, BCryptPasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public User registerUser(Long userId, String userName, String rawPassword, String email,String userRole) {
        String encodedPassword = passwordEncoder.encode(rawPassword);

        User user = User.builder()
                .userId(userId)
                .userName(userName)
                .password(encodedPassword)
                .email(email)
                .userRole(userRole)
                .build();

        return userRepository.save(user);
    }
}
