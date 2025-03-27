package nproj.article.board.mapper;

import nproj.article.board.entity.BoardThread;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Mapper
@Repository
public interface BoardThreadMapper {

    List<BoardThread> getBoardThreadList();

    void addBoardThread(BoardThread boardThread);

    Optional<BoardThread> findBySeq(int seq);
}
