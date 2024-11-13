package com.lec.spmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.extern.log4j.Log4j2;

@Log4j2
@Controller
public class HelloContoller {

	@GetMapping("/")
	public String index() {
		log.info("index.............");
		return "index";
	}
	
	@GetMapping("/hello")
	public String hello() {
		log.info("hello.............");
		return "hello";
	}
}
