package com.lec.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lec.vo.ActionForward;

public interface Action {

	public ActionForward execute(HttpServletRequest req, HttpServletResponse res);
}