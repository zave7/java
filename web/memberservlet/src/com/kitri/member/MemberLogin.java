package com.kitri.member;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/login")
public class MemberLogin extends HttpServlet {
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
		ResultSet rs = null;
		
		request.setCharacterEncoding("utf-8");//한글아이디를 포함할때
//		1. get data
		String id = request.getParameter("id");
		String pass = request.getParameter("pass");
		String name = null;
		try {
			conn = DriverManager.getConnection("jdbc:oracle:thin:@192.168.14.52:1521:orcl","kitri","kitri");
//		2. logic
//		select name 
//		from member
//		where id = ?
//		and pass = ?
			StringBuffer sql = new StringBuffer();
			sql.append(" select name \n");
			sql.append(" from member \n");
			sql.append(" where id = ? \n");
			sql.append(" and pass = ?");
			pstmt = conn.prepareStatement(sql.toString());
			int idx = 0;
			pstmt.setString(++idx, id);
			pstmt.setString(++idx, pass);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				name = rs.getString("name");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
//		3. response
//		2의 결과에 따라
//		name != null : ~~님 안녕하세요
//		name == null : 
//		~~님 안녕하세요
//		아이디 또는 비밀번호를 확인하세요 등록되지 않은 아이디거나, 아이디 또는 비밀번호를 잘못 입력하셨습니다
		response.setContentType("text/html;charset=utf-8");// 순서지정이 중요
		PrintWriter out = response.getWriter();
		out.println("<html>"); // ln은 소스상으로만 바뀐다 html단 에서 하나의 공백으로 바꿔버림
		out.println("	<body>");
		if(name != null) {
			out.println(name + "님 안녕하세요");
		} else {
			out.println("<p style=\"color: red\">아이디 또는 비밀번호를 확인하세요"
					+ "<br>등록되지 않은 아이디거나, 아이디 또는 비밀번호를 잘못 입력하셨습니다</p>");
			out.println("<a href='/memberservlet/user/login.html'>로그인</a>");
		}
		out.println("	</body>");
		out.println("</html>");
	}

}
