package nproj.article.member.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.Date;

@AllArgsConstructor
@Builder
@Data
public class Member {
    private String id;          // 회원 아이디
    private String password;    // 회원 비밀번호
    private String role;        // 권한 및 등급
    private String name;        // 이름
    private String nickName;    // 가명
    private String email;       // 이메일
    private int point;          // 포인트
    private Date regDate;       // 등록일
    private Date connDate;      // 접속일
    private boolean isDeleted;  // 회원탈퇴 여부 (0 = 유지, 1 = 탈퇴)
}
