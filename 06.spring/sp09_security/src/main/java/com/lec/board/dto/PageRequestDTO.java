package com.lec.board.dto;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PageRequestDTO {

	@Builder.Default
	private int page = 1;
	
	@Builder.Default
	private int size = 10;
	
	private String type = "t";  // 검색유형, t/c/w/tc/tcw
	
	private String keyword; // 검색어
	
	public String[] getTypes() {
		if(type == null || type.isEmpty()) {
			return null;
		}
		return type.split("");
	}
	
	public Pageable getPageable(String...props) {
		return PageRequest.of(this.page-1, this.size, Sort.by(props).descending());
	}
	
	private String link; // localhost:8090/board/list?page=10&size=10&type=w&keyword=홍길
	
	public String getLink() {
		if(link == null) {
			StringBuilder builder = new StringBuilder();
			
			builder.append("page=" + this.page);
			builder.append("&size=" + this.size);
			
			if(type != null && type.length() > 0) {
				builder.append("&type=" + type);
			}
			
			if(keyword != null) {
				try {
					builder.append("&keyword=" + URLEncoder.encode(keyword, "utf-8"));
				} catch (UnsupportedEncodingException e) {
					// dummy
				}
			}
			
			link = builder.toString();
		}
		
		return link;
	}
	
}
