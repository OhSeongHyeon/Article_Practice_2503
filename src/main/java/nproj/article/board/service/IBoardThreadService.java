package nproj.article.board.service;

import nproj.article.board.entity.BoardThread;

import java.util.List;

public interface IBoardThreadService {

    List<BoardThread> getBoardThreadList();

    BoardThread findBySeq(int seq);

    void addBoardThread(BoardThread boardThread);
}
