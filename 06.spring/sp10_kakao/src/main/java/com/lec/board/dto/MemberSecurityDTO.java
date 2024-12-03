package com.lec.board.dto;

import java.util.Collection;
import java.util.Map;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.oauth2.core.user.OAuth2User;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class MemberSecurityDTO extends User implements OAuth2User {
	
	private String mid;
	private String mpw;
	private String email;
	private boolean del;
	private boolean social;
	
	private Map<String, Object> props; // SSN(kakao) 로그인정보
	
	public MemberSecurityDTO(String username, String password,
			String email, boolean del, boolean social,
			Collection<? extends GrantedAuthority> authorities)  {
		
		super(username, password, authorities);
		
		this.mid = username;
		this.mpw = password;
		this.email = email;
		this.del = del;
		this.social = social;
	}

	@Override
	public Map<String, Object> getAttributes() {
		return this.getProps();
	}

	@Override
	public String getName() {
		return this.mid;
	}

	
	
}
