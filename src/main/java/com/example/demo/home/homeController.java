package com.example.demo.home;


import com.example.demo.board.Board;
import com.example.demo.board.BoardService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Slf4j
@Controller
@RequestMapping("/home")
@RequiredArgsConstructor
public class homeController {

    private final BoardService boardService;

    @GetMapping
    public String home(Model model) {
        Page<Board> boardList = boardService.list(Pageable.unpaged()); // 게시판 제목 리스트를 가져와야 함
        model.addAttribute("boardList", boardList);
        return "home/home";
    }
}
