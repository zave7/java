package com.kitri.guestbook;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/gbwrite")
public class GuestBookWrite extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@Override
	public void init(ServletConfig config) throws ServletException {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int cnt = 0;
		
		try {
			conn = DriverManager.getConnection("jdbc:oracle:thin:@192.168.14.52:1521:orcl", "kitri", "kitri");
			request.setCharacterEncoding("utf-8");
			
			String name = request.getParameter("name");
			String subject = request.getParameter("subject");
			String content = request.getParameter("content");
			StringBuffer sql = new StringBuffer();
			sql.append("insert into guestbook (seq, name, subject, content) \n");
			sql.append("values (guestbook_seq.nextval, '" + name + "', '" + subject +"', '" + content + "')");
			
			pstmt = conn.prepareStatement(sql.toString());
			cnt = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if(pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		if(cnt != 0) {
			response.sendRedirect("/guestbookservlet/gblist");
		} else {
			response.setContentType("text/html;charset=utf-8");
			PrintWriter out = response.getWriter();
			out.println("<html>");
			out.println("<body>");
			out.println("글작성에 실패했습니다!!!");
			
			out.println("</body>");
			out.println("</html>");
		}
		
	}

}