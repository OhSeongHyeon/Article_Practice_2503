package nproj.article.board;

import lombok.AllArgsConstructor;
import nproj.article.board.model.BoardThread;
import nproj.article.board.service.IBoardThreadService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@AllArgsConstructor
@Controller
public class BoardThreadController {

    IBoardThreadService boardThreadService;

    @ResponseBody
    @RequestMapping(value = "/api/board/list", method = RequestMethod.GET)
    public List<BoardThread> getBoardThreads() {
        return boardThreadService.getBoardThreadList();
    }

    @ResponseBody
    @RequestMapping(value = "/api/board/add", method = RequestMethod.POST)
    public ResponseEntity<BoardThread> addBoardThread(@RequestBody BoardThread boardThread) {
        boardThreadService.addBoardThread(boardThread);
        return ResponseEntity.ok().build();
    }


}
