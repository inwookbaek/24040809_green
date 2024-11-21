package com.lec.board.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.lec.board.domain.Board;
import com.lec.board.dto.BoardDTO;
import com.lec.board.dto.PageRequestDTO;
import com.lec.board.dto.PageResponseDTO;
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
	public PageResponseDTO<BoardDTO> list(PageRequestDTO pageRequestDTO) {

		String[] types = pageRequestDTO.getTypes();
		String keyword = pageRequestDTO.getKeyword();
		Pageable pageable = pageRequestDTO.getPageable("bno");
		
		Page<Board> result = boardRepository.searchAllImpl(types, keyword, pageable);
		List<BoardDTO> dtoList = result.getContent()
									   .stream()
									   .map(board -> modelMapper.map(board, BoardDTO.class))
									   .collect(Collectors.toList());
		
		
		return PageResponseDTO.<BoardDTO>withAll()
				.pageRequestDTO(pageRequestDTO)
				.dtoList(dtoList)
				.total((int)result.getTotalElements())
				.build();
	}
	
	
	
	@Override
	public Long register(BoardDTO boardDTO) {
		Board board = modelMapper.map(boardDTO, Board.class);
		Long bno = boardRepository.save(board).getBno();
		return bno;
	}

	@Override
	public BoardDTO readOne(Long bno) {
		Optional<Board> result = boardRepository.findById(bno);
		Board board = result.orElseThrow();
		BoardDTO boardDTO = modelMapper.map(board, BoardDTO.class);
		return boardDTO;
	}

	@Override
	public void modify(BoardDTO boardDTO) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void remove(Long bno) {
		// TODO Auto-generated method stub
		
	}
}
