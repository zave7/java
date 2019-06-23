package com.kitri.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kitri.dto.RepBoard;
import com.kitri.service.RepBoardService;

@WebServlet("/boarddetail")
public class RepBoardDetailSetvlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private RepBoardService service;
	
	public RepBoardDetailSetvlet() {
		service = new RepBoardService();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String board_seq = request.getParameter("board_seq");
		
		RepBoard repBoard =  service.viewBoard(board_seq);
		
		request.setAttribute("repBoard", repBoard);
		
		String path = "boarddetailresult.jsp";
		RequestDispatcher rd = request.getRequestDispatcher(path);
		rd.forward(request, response);
	}


}
