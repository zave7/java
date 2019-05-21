package com.kitri.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import com.kitri.service.CustomerService;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String pass = request.getParameter("pass");
		System.out.println("controller id = "+id);
		System.out.println("controller pass = "+pass);
		String result = CustomerService.getCustomerService().login(id, pass);
		System.out.println("result = "+result);
		HttpSession session = request.getSession();
		session.removeAttribute("loginInfo");
		if("1".equals(result)) {
			session.setAttribute("loginInfo", id);
		}
		request.setAttribute("result", result);
		RequestDispatcher rd = request.getRequestDispatcher("/loginresult.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		doGet(request, response);
	}

}
