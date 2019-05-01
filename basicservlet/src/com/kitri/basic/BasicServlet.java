package com.kitri.basic;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
@WebServlet("/basic")
public class BasicServlet extends HttpServlet{
	String name;
	int age;
	public BasicServlet() {
		// TODO Auto-generated constructor stub
	}
	@Override
	public void init() throws ServletException {
		//이쯤에서 jdbc 드라이버 로딩
		this.name = "권영찬";
		this.age = 25;
	}
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8;");
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<body>");
		out.println("<font color='steelblue'>" + name + "</font>(</font color='" + checkAge() + "'>" + age + "</font>)님 안녕하세요");
		out.println("</body>");
		out.println("</html>");
	}
	private String checkAge() {
		return (this.age > 18 ? "blue" : "red");
	}
}
