package com.lec.sec.security;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Log4j2
@Service
// @RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {
	
	private PasswordEncoder passwordEncoder;

	public CustomUserDetailsService() {
		this.passwordEncoder = new BCryptPasswordEncoder();
	}
	
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		log.info("loadUserByUserName = " + username);
		
		UserDetails userDetails = User.builder()
									  .username("user1")
									  //.password("12345")   // PasswordEncoder가 없어서 에러 발생
									  //.password("{noop}12345")   // PasswordEncoder사용하지 않을 경우 {noop}를 prefix로 정의
									  // p690
									  .password(passwordEncoder.encode("12345"))
									  .authorities("ROLE_USER")
									  .build();
		
		return userDetails;
	}

}
