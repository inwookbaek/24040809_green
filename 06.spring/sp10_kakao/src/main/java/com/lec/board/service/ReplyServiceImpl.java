package com.lec.board.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.lec.board.domain.Reply;
import com.lec.board.dto.PageRequestDTO;
import com.lec.board.dto.PageResponseDTO;
import com.lec.board.dto.ReplyDTO;
import com.lec.board.repository.ReplyRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Log4j2
@Service
@RequiredArgsConstructor
public class ReplyServiceImpl implements ReplyService {

	private final ReplyRepository replyRepository;
	private final ModelMapper modelMapper;

	@Override
	public Long register(ReplyDTO replyDTO) {	
		Reply reply = modelMapper.map(replyDTO, Reply.class);
		Long rno = replyRepository.save(reply).getRno();
		return rno;
	}	
	
    public Long saveReply(ReplyDTO replyDTO) {
    	Reply reply = modelMapper.map(replyDTO, Reply.class);
        return 0L; //replyRepository.save();
    }


	@Override
	public ReplyDTO read(Long rno) {
		Optional<Reply> result = replyRepository.findById(rno);
		Reply reply = result.orElseThrow();
		return modelMapper.map(reply, ReplyDTO.class);
	}

	@Override
	public void modify(ReplyDTO replyDTO) {
		Optional<Reply> result = replyRepository.findById(replyDTO.getRno());
		Reply reply = result.orElseThrow();
		reply.changeText(replyDTO.getReplyText());
		replyRepository.save(reply);	
	}

	@Override
	public void remove(Long rno) {
		replyRepository.deleteById(rno);
	}

	@Override
	public PageResponseDTO<ReplyDTO> getListOfBoard(Long bno, PageRequestDTO pageRequestDTO) {
		
		Pageable pageable = PageRequest.of(pageRequestDTO.getPage() <= 0 ? 0 : pageRequestDTO.getPage() - 1
				, pageRequestDTO.getSize(), Sort.by("rno").ascending());
		
		Page<Reply> result = replyRepository.listOfBoard(bno, pageable);
		List<ReplyDTO> dtoList = 
			result.getContent()
				  .stream()
				  .map(reply -> modelMapper.map(reply, ReplyDTO.class))
				  .collect(Collectors.toList());
		
		return PageResponseDTO.<ReplyDTO>withAll()
				.pageRequestDTO(pageRequestDTO)
				.dtoList(dtoList)
				.total((int) result.getTotalElements())
				.build();
	}
	
}
