package nproj.article.board;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import nproj.article.board.entity.BoardThread;
import nproj.article.board.model.BoardRequest;
import nproj.article.board.service.IBoardThreadService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@RequestMapping(value = "/")
@Controller
public class BoardThreadController {

    private final IBoardThreadService boardThreadService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String boardPage(Model model) {
        List<BoardThread> list = boardThreadService.getBoardThreadList();
        model.addAttribute("list", list);
        return "index";
    }

    @RequestMapping(value = "/update", method = RequestMethod.GET)
    public String board(Model model, Integer id) {
        BoardThread bySeq = boardThreadService.findBySeq(id);
        model.addAttribute("board", bySeq);
        return "board/update";
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String boardModify(@ModelAttribute BoardRequest BoardRequest) {
        BoardThread boardThread = BoardThread.builder()
                .seq(BoardRequest.getSeq())
                .writerId(BoardRequest.getWriterId())
                .title(BoardRequest.getTitle())
                .content(BoardRequest.getContent())
                .build();
        log.info("Board Thread: {}", boardThread);
        //boardThreadService.updateBoardThread();
        return "redirect:/";
    }

    @ResponseBody
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public List<BoardThread> getBoardThreads() {
        return boardThreadService.getBoardThreadList();
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addBoardThread(@ModelAttribute BoardRequest BoardRequest) {
        BoardThread boardThread = BoardThread.builder()
                .writerId(BoardRequest.getWriterId())
                .title(BoardRequest.getTitle())
                .content(BoardRequest.getContent())
                .build();
        boardThreadService.addBoardThread(boardThread);
        return "redirect:/";
    }



}
