package com.lec.board.security;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
/*
	스프링시큐리티에서 가장 중요한 객체는 UserDetailsService로서 이 객체는
	실제로 인증처리를 하는 인터페이스의 구현체이다.
	
	UserDetailsService인터페이스는 단 한개의 메서드인 loadUserByUsername()가
	실제 인증처리를 할 때 호출되는 메서드이다.
	실제 개발작업은 UserDetailsService를 구현해서 username이라하는 사용자의
	인증코드를 구현하는 것 이다.
	
	UserDetails 반환타입은 사용자 인증과 관련된 정보를 저장하는 객체이다.
	스프링시큐리티는 내부적으로 UserDetails타입객체를 이용해서 패스워드를
	검사하고 사용자권한을 확인하는 방식으로 동작한다.
	
	추상메서드는 getAuthorities, getPassword, getUserName, isAccountNonExpired,
	isAccountNonLocked, isEnabled, isCredentialsNonExpired가 있다. getAuthorities는 
	사용자가 가진 모든 인가정보를 반환해야 한다.
	
	결론은 개발단계에서 UserDetails객체가 필요하고 구현객체(CutomUserDetailsService)에서
	인가관련된 정보를 반환하는 로직을 구현해야 한다.
*/

@Log4j2
@Service
// @RequiredArgsConstructor
public class CutomUserDetailsService implements UserDetailsService {
	
	private PasswordEncoder passwordEncoder;
	
	public CutomUserDetailsService() {
		this.passwordEncoder = new BCryptPasswordEncoder();
	}
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		log.info("--------------> loadUserByUsername ..... " + username);
		
		UserDetails userDetails = User.builder()
				.username("user1")
				// .password("{noop}12345")
				.password(passwordEncoder.encode("12345"))
				.authorities("ROLE_USER")
				.build();
		
		return userDetails;
	}

}
