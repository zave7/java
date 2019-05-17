package com.kitri.basic;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/multiparam")
public class MultiPrameterTest extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		String id = request.getParameter("id");
		int age = Integer.parseInt(request.getParameter("age"));
		String[] fruit = request.getParameterValues("fruit");
		
		String color = age == 10 ? "red" : "blue";
		
		response.setContentType("text/html;charset=utf-8;");
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<body>");
		out.println("<style>");
		out.println("span { color: " + color +"  }");
		out.println("</style>");
		out.println(name+"("+id+")" +"(<span>"+age+"</span>)"+ "님 안녕하세요<br>");
		out.println("당신이 좋아하는 과일은<br>");
		String fruitStr = "";
		int len = 0;
		if(fruit != null)
			len = fruit.length;
		if(len != 0) {
			fruitStr += fruit[0];
			for (int i = 1; i < len; i++) {
				fruitStr += ", " + fruit[i];
			}
			out.println(fruitStr + "입니다");
		} else {
			out.println("없습니다.");
		}
		out.println("</body>");
		out.println("</html>");
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		doGet(request, response);
	}

}
