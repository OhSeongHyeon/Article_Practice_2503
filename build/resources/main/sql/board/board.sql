CREATE TABLE MEMBER (
                        ID         VARCHAR2(100) NOT NULL,  -- 회원 아이디
                        PASSWORD   VARCHAR2(255) NOT NULL,  -- 회원 비밀번호
                        ROLE       VARCHAR2(50) DEFAULT 'MEMBER' NULL,  -- 권한 및 등급
                        NAME       VARCHAR2(100) NOT NULL,  -- 이름
                        NICK_NAME  VARCHAR2(100) NULL,  -- 가명
                        EMAIL      VARCHAR2(255) NULL,  -- 이메일
                        POINT      NUMBER DEFAULT 0 NULL,  -- 포인트
                        REG_DATE   DATE NULL,  -- 등록일
                        CONN_DATE  DATE NULL,  -- 접속일
                        IS_DELETED NUMBER(1) DEFAULT 0 NULL,  -- 회원탈퇴 여부 (0 = 유지, 1 = 탈퇴)
                        CONSTRAINT pk_MEMBER PRIMARY KEY (ID)
);

--COMMENT ON TABLE MEMBER IS '회원';
--COMMENT ON COLUMN MEMBER.ID IS '회원 아이디';
--COMMENT ON COLUMN MEMBER.PASSWORD IS '회원 비밀번호';
--COMMENT ON COLUMN MEMBER.ROLE IS '권한 및 등급';
--COMMENT ON COLUMN MEMBER.NAME IS '이름';
--COMMENT ON COLUMN MEMBER.NICK_NAME IS '가명';
--COMMENT ON COLUMN MEMBER.EMAIL IS '이메일';
--COMMENT ON COLUMN MEMBER.POINT IS '포인트';
--COMMENT ON COLUMN MEMBER.REG_DATE IS '등록일';
--COMMENT ON COLUMN MEMBER.CONN_DATE IS '접속일';
--COMMENT ON COLUMN MEMBER.IS_DELETED IS '회원탈퇴 여부';

SELECT * FROM MEMBER;

INSERT INTO MEMBER (ID, PASSWORD, ROLE, NAME, NICK_NAME, EMAIL, POINT, REG_DATE, CONN_DATE, IS_DELETED)
VALUES ('user1', 'password123', 'MEMBER', '홍길동', '홍길동닉네임', 'user1@example.com', 100, SYSDATE, SYSDATE, 0);

CREATE TABLE BOARD_THREAD (
                              SEQ           NUMBER NOT NULL,  -- 글번호
                              WRITER_ID     VARCHAR2(100) NOT NULL,  -- 작성자 (MEMBER 테이블 참조)
                              TITLE         VARCHAR2(255) NOT NULL,  -- 글제목
                              CONTENT       CLOB NOT NULL,  -- 글내용 (긴 글 저장을 위해 CLOB 사용)
                              VIEW_CNT      NUMBER DEFAULT 0 NOT NULL,  -- 조회수
                              IS_NOTICE     NUMBER(1) DEFAULT 0 NOT NULL,  -- 공지글 여부 (0 = 일반글, 1 = 공지글)
                              REG_DATE      DATE NOT NULL,  -- 등록일
                              MODIFIED_DATE DATE NULL,  -- 수정일
                              CONSTRAINT pk_board_thread PRIMARY KEY (seq),
                              CONSTRAINT fk_board_thread_writer FOREIGN KEY (WRITER_ID) REFERENCES MEMBER(ID) ON DELETE CASCADE
);

SELECT * FROM BOARD_THREAD;

--COMMENT ON TABLE BOARD_THREAD IS '게시글';
--COMMENT ON COLUMN BOARD_THREAD.seq IS '글번호';
--COMMENT ON COLUMN BOARD_THREAD.WRITER_ID IS '작성자 (MEMBER 테이블 참조)';
--COMMENT ON COLUMN BOARD_THREAD.title IS '글제목';
--COMMENT ON COLUMN BOARD_THREAD.content IS '글내용';
--COMMENT ON COLUMN BOARD_THREAD.view_cnt IS '조회수';
--COMMENT ON COLUMN BOARD_THREAD.is_notice IS '공지글 여부';
--COMMENT ON COLUMN BOARD_THREAD.reg_date IS '등록일';
--COMMENT ON COLUMN BOARD_THREAD.modified_date IS '수정일';

-- 시퀀스 생성 (자동 증가 번호를 위한 시퀀스)
CREATE SEQUENCE BOARD_THREAD_SEQ START WITH 1 INCREMENT BY 1;

INSERT INTO BOARD_THREAD (SEQ, WRITER_ID, TITLE, CONTENT, VIEW_CNT, IS_NOTICE, REG_DATE, MODIFIED_DATE)
VALUES (
           BOARD_THREAD_SEQ.NEXTVAL,  -- SEQ는 시퀀스를 사용하여 자동 증가
           'user1',                    -- 작성자 ID (홍길동의 ID)
           '첫 번째 게시글 제목',          -- 글 제목
           '안녕하세요, 이것은 첫 번째 게시글입니다. 내용을 여기에 입력합니다. 여러 줄의 텍스트를 CLOB로 저장할 수 있습니다.',  -- 글 내용 (긴 텍스트)
           0,                          -- 조회수 (기본값 0)
           0,                          -- 공지글 여부 (0 = 일반글)
           SYSDATE,                    -- 등록일 (현재 날짜)
           NULL                        -- 수정일 (수정하지 않음)
       );