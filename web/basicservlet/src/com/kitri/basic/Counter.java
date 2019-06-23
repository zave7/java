package com.kitri.basic;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/counter")
public class Counter extends HttpServlet {
	private static final long serialVersionUID = 1L;
	int cnt;
	int totalLen;
	CountDao countDao;
	@Override
	public void init() throws ServletException {
		cnt = 56889;
		totalLen = 8;
		countDao = new CountDao();
		System.out.println("Dao 생성");
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		cnt++;
		countDao.countViews();
		response.setContentType("text/html;charset=UTF-8;");
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<body>");
		out.println("당신은");
		//8자리 cnt 37 자릿수 다 뽑아내고 String으로 0~~0 하고 for
		String count = Integer.toString(cnt);
		int n = 0;
		int len = totalLen - count.length();
		for (int i = 0; i < totalLen; i++) {
			out.println("<img src='/basicservlet/img/"+ (i >= len ? count.charAt(n++) : '0') +".png' width='50'>");
		}
		out.println("번째 방문자 입니다!");
		out.println("</body>");
		out.println("</html>");
	}
}
