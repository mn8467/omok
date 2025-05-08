package com.example.demo.domain;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    @Column(length = 50, nullable = false)
    private String userName;

    @Column(length = 100, nullable = false)
    private String password;

    @Column(length = 320, nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String userRole;

    @Column(nullable = false)
    private LocalDateTime createdAt;

    @PrePersist
    public void prePersist() { // 회원가입시 비밀번호 암호화, 가입시간 현재시간으로 초기화
        if (this.password != null) {
            this.password = new BCryptPasswordEncoder().encode(this.password);
        }
        this.createdAt = LocalDateTime.now();
    }
    @Builder
    public User(String userName, String password, String email,String userRole) {
        this.userName = userName;
        this.password = password;
        this.email = email;
        this.userRole = userRole;

    }

}

