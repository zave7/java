package com.kitri.basic;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/ggd")
public class Gugudan extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public Gugudan() {
    	
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("<style>");
		out.println("span { "
				+ "display: inline-block; "
				+ "width: 150px; "
				+ "border: 2px solid black; "
				+ "height: 30px; valign='center'}");
		out.println("span[class='0'] { "
				+ "background-color: orange; "
				+ "}");
		out.println("span[class='1'] {"
				+ " background-color: cyan; "
				+ "}");
		out.println("</style>");
		out.println("</head>");
		out.println("<div align='center'>");
		out.println("<h1>*** 구구단 ***</h1>");
		for (int i = 1; i <= 9 ; i++) {
			for (int j = 2; j <= 9; j++) {
				out.println("<span class='"+(j%2)+"'>"+j+" * " + i + " = " + (j*i) +"</span>");
			}
			out.println("<br>");
		}
		out.println("</div>");
		out.println("</html>");
	}

}
