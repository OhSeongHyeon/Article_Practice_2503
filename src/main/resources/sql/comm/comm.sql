#디비 캐릭터셋 utf8mb4=이모지 포함
#show variables like "%char%";

CREATE TABLE Member (
    id          VARCHAR(255) NOT NULL COMMENT '회원 아이디'
,   password    VARCHAR(255) NOT NULL COMMENT '회원 비밀번호'
,   role        VARCHAR(255) NOT NULL DEFAULT 'member' COMMENT '권한 및 등급'
,   name        VARCHAR(255) NOT NULL COMMENT '이름'
,   nick_name   VARCHAR(255) NULL COMMENT '가명'
,   email       VARCHAR(255) NULL COMMENT '이메일'
,   point       INT NULL DEFAULT 0 COMMENT '포인트'
,   reg_date    DATE NOT NULL COMMENT '등록일'
,   conn_date   DATE NULL COMMENT '접속일'
,   is_deleted  TINYINT(1) NOT NULL DEFAULT 0 COMMENT '회원탈퇴 여부'
,   CONSTRAINT Member_PK PRIMARY KEY (id)
) COMMENT='회원';

#더미 데이터 (회원) 어드민, 개발계정
INSERT INTO Member (
    id
,   password
,   role
,   name
,   nick_name
,   email
,   point
,   reg_date
,   conn_date
,   is_deleted
) VALUES (
    "osh"
,   "1234"
,   "admin"
,   "osh"
,   "osh"
,   "yee@mail.com"
,   100
,   SYSDATE()
,   null
,   0
);
INSERT INTO Member (
    id
,   password
,   role
,   name
,   nick_name
,   email
,   point
,   reg_date
,   conn_date
,   is_deleted
) VALUES (
 "test"
,   "1234"
,   "member"
,   "test"
,   "test"
,   "teste@mail.com"
,   0
,   SYSDATE()
,   null
,   0
);

SELECT * FROM MEMBER;

CREATE TABLE BoardThread (
    seq            INT NOT NULL AUTO_INCREMENT COMMENT '글번호'
,   writer_id      VARCHAR(100) NOT NULL COMMENT '작성자'
,   title          VARCHAR(255) NOT NULL COMMENT '글제목'
,   content        TEXT NOT NULL COMMENT '글내용'
,   view_cnt       INT NOT NULL DEFAULT 0 COMMENT '조회수'
,   is_notice      TINYINT(1) NOT NULL DEFAULT 0 COMMENT '공지글 여부'
,   is_deleted     TINYINT(1) NOT NULL DEFAULT 0 COMMENT '글 삭제 여부'
,   is_admin_allow TINYINT(1) NOT NULL DEFAULT 0 COMMENT '글 노출 권한제한 여부'
,   reg_date       DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '등록일'
,   modified_date  DATETIME NULL DEFAULT NULL COMMENT '수정일'
,   CONSTRAINT BoardThread_PK PRIMARY KEY (seq)
,   CONSTRAINT BoardThread_FK_writer_id FOREIGN KEY (writer_id) REFERENCES Member(id) ON DELETE CASCADE
) COMMENT='게시글';

#더미데이터
INSERT INTO BoardThread (writer_id, title, content, view_cnt, is_notice, is_deleted, is_admin_allow, reg_date, modified_date)
VALUES
    ('osh', '공지사항 안내', '공지사항 내용을 확인해주세요.', 50, 1, 0, 0, NOW(), NULL)
,   ('osh', '첫 번째 게시글', '이것은 첫 번째 게시글의 내용입니다.', 10, 0, 0, 0, NOW(), NULL)
,   ('test', '자유게시판 글', '자유롭게 글을 작성하세요!', 5, 0, 0, 0, NOW(), NULL);

INSERT INTO BoardThread (
    seq
,   writer_id
,   title
,   content
,   view_cnt
,   is_notice
,   is_deleted
,   is_admin_allow
,   reg_date
,   modified_date
) VALUES (
 null
,   'osh'
,   '공지사항 안내'
,   '공지사항 내용을 확인해주세요.'
,   50
,   1
,   0
,   0
,   NOW()
,   NULL
);

SELECT * FROM BoardThread ORDER BY seq DESC;

SELECT * FROM BoardThread
WHERE seq = 1;






