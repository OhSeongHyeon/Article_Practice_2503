package nproj.article.board.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.Date;

@AllArgsConstructor
@Builder
@Data
public class BoardThread {
    private Long seq;          // 글번호
    private String writerId;   // 작성자 (Member 테이블 참조)
    private String title;      // 글제목
    private String content;    // 글내용 (CLOB → String)
    private int viewCnt;       // 조회수
    private boolean isNotice;  // 공지글 여부 (0 = 일반글, 1 = 공지글)
    private Date regDate;      // 등록일
    private Date modifiedDate; // 수정일
}
