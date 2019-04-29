package com.kitri.hello;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/hs")
/*<servlet>
  	<servlet-name>hs</servlet-name>
  	<servlet-class>com.kitri.hello.HelloServlet</servlet-class>
  </servlet>
  
  <servlet-mapping>
  	<servlet-name>hs</servlet-name>
  	<url-pattern>/hello</url-pattern>	
  </servlet-mapping>
 */
public class HelloServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public HelloServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");// 순서지정이 중요
		PrintWriter out = response.getWriter();
		out.println("<html>"); // ln은 소스상으로만 바뀐다 html단 에서 하나의 공백으로 바꿔버림
		out.println("	<body>");
		out.println("		HelloServlet!!<hr>");
		out.println("		안녕 서블릿3.0");
		out.println("	</body>");
		out.println("</html>");
	}

}
