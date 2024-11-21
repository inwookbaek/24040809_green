package com.lec.board.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.lec.board.domain.Board;
import com.lec.board.dto.BoardDTO;
import com.lec.board.dto.PageRequestDTO;
import com.lec.board.dto.PageResponseDTO;
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
	public String list(PageRequestDTO pageRequestDTO, Model model) {
		PageResponseDTO<BoardDTO> responseDTO = boardService.list(pageRequestDTO);
		log.info("..........." + responseDTO);
		model.addAttribute("responseDTO", responseDTO);
		return "board/list";
	}
	
	@GetMapping({"/read", "/modify"})
	public void read(@RequestParam("bno") Long bno
			, PageRequestDTO pageRequestDTO, Model model) {
		log.info("read or modify....................");		
		BoardDTO boardDTO = boardService.readOne(bno);
		model.addAttribute("dto", boardDTO);
	}
	
	@PostMapping("/modify")
	public void modify() {
		log.info("modify.Post....................");
	}

	@GetMapping("/resigter")
	public void refisterGet() {
		log.info("register.GET....................");
	}
	
	@PostMapping("/resigter")
	public void refisterPost() {
		log.info("register.Post....................");
	}
	
	
	@PostMapping("/remove")
	public void remove() {
		log.info("remove.Post....................");
	}
	
}
