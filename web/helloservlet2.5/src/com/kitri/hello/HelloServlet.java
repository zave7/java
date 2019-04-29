package com.kitri.hello;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HelloServlet extends HttpServlet {
	// 이클립스가 사용할려고 만듦
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");// 순서지정을 잘 해야한다
		PrintWriter out = response.getWriter();
		out.println("<html>"); // ln은 소스상으로만 바뀐다 html단 에서 하나의 공백으로 바꿔버림
		out.println("	<body>");
		out.println("		HelloServlet!!<hr>");
		out.println("		안녕 서블릿");
		out.println("	</body>");
		out.println("</html>");
	}

}
