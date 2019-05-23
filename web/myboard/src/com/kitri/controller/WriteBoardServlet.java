package com.kitri.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kitri.dto.RepBoard;
import com.kitri.exception.AddException;
import com.kitri.service.RepBoardService;

@WebServlet("/writeboard")
public class WriteBoardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private RepBoardService service;
	public WriteBoardServlet() {
		service = new RepBoardService();
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String subject = request.getParameter("subject");
		String writer = request.getParameter("writer");
		String password = request.getParameter("password");
		String contents = request.getParameter("contents");
		RepBoard repBoard = new RepBoard();
		repBoard.setBoard_subject(subject);
		repBoard.setBoard_writer(writer);
		repBoard.setBoard_password(password);
		repBoard.setBoard_contents(contents);
		String result = "글쓰기에 실패했습니다";
		try {
			service.write(repBoard);
			result = "글쓰기 성공!!";
		} catch (AddException e) {
			e.printStackTrace();
		}
		request.setAttribute("result", result);
		String path = "writeresult.jsp";
		RequestDispatcher rd = request.getRequestDispatcher(path);
		rd.forward(request, response);
	}

}
