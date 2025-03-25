package nproj.article.board.service;

import nproj.article.board.model.BoardThread;

import java.util.List;

public interface IBoardThreadService {
    List<BoardThread> getBoardThreadList();

    void addBoardThread(BoardThread boardThread);
}
