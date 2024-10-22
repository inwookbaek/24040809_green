package com.lec.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lec.vo.ActionForward;

public class BoardListAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse res) {
		System.out.println("===> 게시글조회하기");
		ActionForward forward = new ActionForward();
		forward.setPath("/board/board_list.jsp?p=100&f=writer&q=홍길");
		return forward;
	}

}
