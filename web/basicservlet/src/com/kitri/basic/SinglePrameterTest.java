package com.kitri.basic;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/singleparam")
public class SinglePrameterTest extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		1.data get
		String name = request.getParameter("name");
		String id = request.getParameter("id");
		int age = Integer.parseInt(request.getParameter("age"));
//		2.logic
		String color = age == 10 ? "red" : "blue";
//		3.response page : 안효인(java2)님 안녕하세요. 영찬아 안녕?
		response.setContentType("text/html;charset=utf-8;");
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<body>");
		out.println("<span>" + name + "(<span style='color:" + color + "'>" + id +"</span>"+ ") 님 안녕하세요</span>");
		out.println("</body>");
		out.println("</html>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		1.data get
		request.setCharacterEncoding("utf-8");//요청이 들어온 놈의 캐릭터 셋을 uft-8해라
		String name = request.getParameter("name");
		String id = request.getParameter("id");
		int age = Integer.parseInt(request.getParameter("age"));
//		2.logic
		String color = age == 10 ? "red" : "blue";
//		3.response page : 안효인(java2)님 안녕하세요.
		response.setContentType("text/html;charset=utf-8;");
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<body>");
		out.println("<span>" + name + "(<span style='color:" + color + "'>" + id +"</span>"+ ") 님 안녕하세요</span>");
		out.println("</body>");
		out.println("</html>");
	}

}
