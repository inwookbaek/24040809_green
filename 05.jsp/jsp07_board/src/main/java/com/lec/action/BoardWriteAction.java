package com.lec.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lec.vo.ActionForward;

public class BoardWriteAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse res) {
		System.out.println("===> 게시글등록성공!!!!");
		ActionForward forward = new ActionForward();
		forward.setPath("boardList.do");
		return forward;
	}

}
