package nproj.article.board.service;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import nproj.article.board.mapper.BoardThreadMapper;
import nproj.article.board.entity.BoardThread;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Transactional
@Service
public class BoardThreadServiceImpl implements IBoardThreadService {

    private final BoardThreadMapper boardThreadMapper;

    @Override
    public List<BoardThread> getBoardThreadList() {
        return boardThreadMapper.getBoardThreadList();
    }

    @Override
    public BoardThread findBySeq(int seq) {
        Optional<BoardThread> bySeq = boardThreadMapper.findBySeq(seq);
        //throw 사용으로 없는 글 페이지로 보내는걸 구현해야됨 (예외핸들러, 컨트롤러어드바이저)
        return bySeq.get();
    }

    @Override
    public void addBoardThread(BoardThread boardThread) {
        boardThreadMapper.addBoardThread(boardThread);
    }
}
