package com.lec.board.service;

import com.lec.board.dto.PageRequestDTO;
import com.lec.board.dto.TodoDTO;

public interface TodoService {

	Long register(TodoDTO todoDTO);
//	TodoDTO read(Long tno);
//	PageRequestDTO list(PageRequestDTO pageRequestDTO);
//	void remove(Long tno);
//	void modify(Long tno);
}