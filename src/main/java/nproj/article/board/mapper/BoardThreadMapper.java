package nproj.article.board.mapper;

import nproj.article.board.model.BoardThread;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface BoardThreadMapper {

    List<BoardThread> getBoardThreadList();

    void addBoardThread(BoardThread boardThread);
}
