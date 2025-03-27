package nproj.article.board.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class BoardThread {
    private Long seq;          // 글번호
    private String writerId;   // 작성자 (Member 테이블 참조)
    private String title;      // 글제목
    private String content;    // 글내용
    private int viewCnt;       // 조회수
    private boolean isNotice;  // 공지글 여부 (0 = 일반글, 1 = 공지글)
    private boolean isDeleted; // 삭제여부
    private boolean isAdminAllow; // 어드민만 볼 수 있는지
    private Date regDate;      // 등록일
    private Date modifiedDate; // 수정일
}
