package com.lec.board.service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.lec.board.domain.Board;
import com.lec.board.dto.BoardDTO;
import com.lec.board.repository.BoardRepository;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Log4j2
@Service
@RequiredArgsConstructor
@Transactional
public class BoardServiceImpl implements BoardService {

	private final ModelMapper modelMapper;
	private final BoardRepository boardRepository;
	
	@Override
	public Long register(BoardDTO boardDTO) {
		Board board = modelMapper.map(boardDTO, Board.class);
		Long bno = boardRepository.save(board).getBno();
		return bno;
	}

	@Override
	public BoardDTO readOne(Long bno) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void modify(BoardDTO boardDTO) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void remove(Long bno) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Board> list(Board board) {
		List<Board> boardList = boardRepository.findAll();
		return boardList;
	}

}
