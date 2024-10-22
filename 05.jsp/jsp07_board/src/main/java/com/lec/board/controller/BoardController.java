package com.lec.board.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lec.action.Action;
import com.lec.action.BoardListAction;
import com.lec.action.BoardWriteAction;
import com.lec.vo.ActionForward;

@WebServlet("*.do")
public class BoardController extends HttpServlet {

	Action action = null;
	ActionForward forward = null;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) 
			throws ServletException, IOException {
		process(req, res);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) 
			throws ServletException, IOException {
		process(req, res);
	}

	private void process(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
	
		req.setCharacterEncoding("utf-8");
		String requestURI = req.getRequestURI();
		String contextPath = req.getContextPath(); 
		String command = requestURI.substring(contextPath.length()+1, requestURI.length()-3); // *.do
		
		RequestDispatcher dispatcher = null;

		if(command.equalsIgnoreCase("boardWriteForm")) {
			forward = new ActionForward();
			forward.setPath("/board/board_write.jsp");
		} else if(command.equalsIgnoreCase("boardWrite")) {
			action = new BoardWriteAction();
			forward = action.execute(req, res);
		} else if(command.equalsIgnoreCase("boardList")) {
			action = new BoardListAction();
			forward = action.execute(req, res);
		} else {
			System.out.println("====> 요청없슴!!!");
		}
		
		if(forward != null) {
			if(forward.isRedirect()) {
				res.sendRedirect(forward.getPath());
			} else {
				dispatcher = req.getRequestDispatcher(forward.getPath());
				dispatcher.forward(req, res);
			}
		}
	}	
}
