package com.lec.board.service;

import java.util.List;

import com.lec.board.domain.Board;
import com.lec.board.dto.BoardDTO;

public interface BoardService {

	Long register(BoardDTO boardDTO);
	BoardDTO readOne(Long bno);
	void modify(BoardDTO boardDTO);
	void remove(Long bno);
	List<Board> list(Board board);
}
