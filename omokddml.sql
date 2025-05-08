CREATE Database omok;

Use omok;

CREATE TABLE user (
    user_id BIGINT UNSIGNED AUTO_INCREMENT,  -- 자동 증가로 설정
    user_name VARCHAR(50) NOT NULL,
    password VARCHAR(100) NOT NULL,
    email VARCHAR(320) NOT NULL UNIQUE,  -- 이메일은 유니크 제약
    created_at DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    user_role VAR
    PRIMARY KEY (user_id)  -- 기본 키 추가
);

ALTER TABLE user ADD COLUMN user_role VARCHAR(20) NOT NULL;


CREATE TABLE Room (
    room_id BIGINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    room_name VARCHAR(100) NOT NULL,
    status ENUM('waiting', 'playing', 'finished') NOT NULL DEFAULT 'waiting',
    created_at DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP
);

Use omok;

Use mysql;

select host,user, authentication_string from user;
create user 'mino'@'%'identified by '6588';

GRANT ALL PRIVILEGES ON mysql.* TO 'mino'@'%';

SHOW GRANTS FOR 'admin'@'%';

GRANT ALL PRIVILEGES ON mysql.* TO 'admin'@'%';

FLUSH PRIVILEGES;

USE omok

SELECT *
FROM user

drop table user;
drop table User;
