package nproj.article.board.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class BoardRequest {
    private long seq;
    private String writerId;
    private String title;
    private String content;
}
