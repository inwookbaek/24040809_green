package com.lec.board.controller;

import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.lec.board.dto.MemberJoinDTO;
import com.lec.board.service.MemberService;
import com.lec.board.service.MemberService.MidExistException;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Log4j2
@Controller
@RequestMapping("/member")
@RequiredArgsConstructor
public class MemberController {

	private final MemberService memberService;
	
	@GetMapping({"/login", "/login/{error}/{logout}", "/login/{logout}"})
	public void loginGet(
			@RequestParam(name = "error", defaultValue = "") @PathVariable Optional<String> error, 
			@RequestParam(name = "logout", defaultValue = "") @PathVariable Optional<String> logout) {
		log.info("login get ................... ");
		log.info("logout ................... " + logout);
		
		if(logout != null) {
			log.info("user logout ................... ");
		}
	}
	
	@GetMapping("/join")
	public void joinGet() {
		log.info("회원가입 GET방식.....");
	}
	
	@PostMapping("/join")
	public String joinPost(MemberJoinDTO memberJoinDTO, RedirectAttributes redirectAttributes) {
		
		log.info("회원가입 POST방식.....");
		log.info(memberJoinDTO);
		
		try {
			memberService.join(memberJoinDTO);
		} catch (MemberService.MidExistException e) {
			redirectAttributes.addFlashAttribute("error", memberJoinDTO.getMid() + "는 이미 존재하는 아이디 입니다!!");
			return "redirect:/member/join";
		}
		
		redirectAttributes.addFlashAttribute("result", "회원가입성공!!!");
				
		return "redirect:/member/login";
	}
	
	@GetMapping("/modify")
	public void chagePassword() {
		log.info("비밀번호변경하기 GET방식.....");
	}
}

















