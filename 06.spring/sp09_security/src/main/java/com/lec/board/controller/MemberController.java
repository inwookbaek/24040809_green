package com.lec.board.controller;

import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Log4j2
@Controller
@RequestMapping("/member")
@RequiredArgsConstructor
public class MemberController {

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
}
