package com.lec.board.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lec.board.domain.Board;
import com.lec.board.service.BoardService;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Log4j2
@Controller
@RequestMapping("/board")
@RequiredArgsConstructor
public class BoardController {

	private final BoardService boardService;
	
	@GetMapping("/list")
	public void list(Board board, Model model) {
		log.info("list....................");
		List<Board> boardList = boardService.list(board);
		log.info("..........." + boardList);
		model.addAttribute("boardList", boardList);
	}
	
	@GetMapping({"/read", "/modify"})
	public void read() {
		log.info("read or modify....................");
	}
	
	@GetMapping("/resigter")
	public void refisterGet() {
		log.info("register.GET....................");
	}
	
	@PostMapping("/resigter")
	public void refisterPost() {
		log.info("register.Post....................");
	}
	
	@PostMapping("/modify")
	public void modify() {
		log.info("modify.Post....................");
	}
	
	@PostMapping("/remove")
	public void remove() {
		log.info("remove.Post....................");
	}
	
}
