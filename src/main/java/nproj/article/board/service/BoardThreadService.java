package nproj.article.board.service;

import lombok.AllArgsConstructor;
import nproj.article.board.mapper.BoardThreadMapper;
import nproj.article.board.model.BoardThread;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@AllArgsConstructor
@Transactional
@Service
public class BoardThreadService implements IBoardThreadService {

    BoardThreadMapper boardThreadMapper;

    @Override
    public List<BoardThread> getBoardThreadList() {
        return boardThreadMapper.getBoardThreadList();
    }

    @Override
    public void addBoardThread(BoardThread boardThread) {
        boardThreadMapper.addBoardThread(boardThread);
    }
}
