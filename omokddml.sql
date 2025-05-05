CREATE Database omok;

Use omok;

CREATE TABLE User (
    user_id BIGINT UNSIGNED AUTO_INCREMENT,  -- 자동 증가로 설정
    user_name VARCHAR(50) NOT NULL,
    password VARCHAR(100) NOT NULL,
    email VARCHAR(320) NOT NULL UNIQUE,  -- 이메일은 유니크 제약
    created_at DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY (user_id)  -- 기본 키 추가
);

CREATE TABLE Room (
    room_id BIGINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    room_name VARCHAR(100) NOT NULL,
    status ENUM('waiting', 'playing', 'finished') NOT NULL DEFAULT 'waiting',
    created_at DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP
);