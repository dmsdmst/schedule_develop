CREATE TABLE user (
    userId INT NOT NULL PRIMARY KEY,
    name VARCHAR(20) NOT NULL,
    password VARCHAR(20) NOT NULL,
    email VARCHAR(40) NOT NULL,
    createdDate  TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updatedDate  TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);

CREATE TABLE schedule (
    scheduleId INT NOT NULL PRIMARY KEY,
    userId INT NOT NULL,
    title VARCHAR(20) NOT NULL,
    contents VARCHAR(200),
    createdDate  TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updatedDate  TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    foreign key (userId) references user (userId)
);


-- 회원가입
INSERT INTO user (name, password, email)
    VALUES ('홍길동', 'qwer1234', 'a@b.com');


-- 일정 생성
INSERT INTO schedule (userId, title, contents)
    VALUES ('홍길동', '내일배움캠프', '과제 제출');


-- 전체 일정 조회
SELECT scheduleId, title, updatedDate FROM schedule
ORDER BY updatedDate DESC;


-- 선택 일정 조회
SELECT  title, contents, updatedDate FROM schedule;


-- 선택 일정 수정
UPDATE schedule SET title = '', contents = ''
    WHERE scheduleId;


-- 유저 삭제
DELETE FROM user WHERE userId;


-- 선택 일정 삭제
DELETE FROM schedule WHERE scheduleId;