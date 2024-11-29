package com.lec.board.domain;

import groovy.transform.ToString;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString(excludes = "releSet")
public class Member extends BaseEntity{

	@Id
	private String mid;
	
	private String mw;
	private String email;
	private boolean del;
	
	private boolean social;
	
	//private
}
