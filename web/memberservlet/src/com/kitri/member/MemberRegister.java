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

@WebServlet("/register")
public class MemberRegister extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	public void init(ServletConfig config) throws ServletException {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Connection conn = null;
		PreparedStatement pstmt = null;

		// 요기는 포스트 io가 일어나기때문에
		request.setCharacterEncoding("utf-8");
//		1. data get(이름, 아이디, 비번, 이메일1, 이메일2, 전번1, 전번2, 전번3, 우편번호, 주소, 상세주소)
		String name = request.getParameter("name");
		String id = request.getParameter("id");
		String pass = request.getParameter("pass");
		String emailid = request.getParameter("emailid");
		String emaildomain = request.getParameter("emaildomain");
		String tel1 = request.getParameter("tel1");
		String tel2 = request.getParameter("tel2");
		String tel3 = request.getParameter("tel3");
		String zipcode = request.getParameter("zipcode");
		String address = request.getParameter("address");
		String addressDetail = request.getParameter("address_detail");
		System.out.println(name);

//		2. Logic : 1의 data를 insert
//		sql 문 insert all은 트랙잭션 처리를 해준다
//		insert all
//			into member (name, id, pass, emailid, emaildomain, joindate)
//			values (?, ?, ?, ?, ?, sysdate)
//			into member_detail (tel1, tel2, tel3, zipcode, address, address_detail)
//			values (?, ?, ?, ?, ?, ? ,?)
//		select *
//		from dual
		int cnt = 0;
		try {
			conn = DriverManager.getConnection("jdbc:oracle:thin:@192.168.14.52:1521:orcl", "kitri", "kitri");
			// 가급적 스트링 버퍼를 쓰자
			StringBuffer sql = new StringBuffer();
			sql.append(" insert all \n");
			sql.append(" 	into member (id, name, pass, emailid, emaildomain, joindate) \n");
			sql.append(" 	values (?, ?, ?, ?, ?, sysdate) \n");
			sql.append(" 	into member_detail (id, tel1, tel2, tel3, zipcode, address, address_detail) \n");
			sql.append(" 	values (?, ?, ?, ?, ?, ? ,?) \n");
			sql.append(" select * \n");
			sql.append(" from dual \n");
			// 최초1번 문법검사
			pstmt = conn.prepareStatement(sql.toString());
			int idx = 0;
			// 타입만 검사하면 된다
			pstmt.setString(++idx, id);
			pstmt.setString(++idx, name);
			pstmt.setString(++idx, pass);
			pstmt.setString(++idx, emailid);
			pstmt.setString(++idx, emaildomain);
			pstmt.setString(++idx, id);
			pstmt.setString(++idx, tel1);
			pstmt.setString(++idx, tel2);
			pstmt.setString(++idx, tel3);
			pstmt.setString(++idx, zipcode);
			pstmt.setString(++idx, address);
			pstmt.setString(++idx, addressDetail);
			cnt = pstmt.executeUpdate();
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
		
//		3. response page : 2의 결과에 따라
//			3-1. != 0 : xxx님 회원가입을 환영합니다
//			3-2. == 0 : 서버 문제로 회원가입이 실패하였습니다.
//					다음에 다시 시도하세요.
		response.setContentType("text/html;charset=utf-8");// 순서지정이 중요
		PrintWriter out = response.getWriter();
		out.println("<html>"); // ln은 소스상으로만 바뀐다 html단 에서 하나의 공백으로 바꿔버림
		out.println("	<body>");
		if(cnt != 0) {
			out.println(name + "님 회원가입을 환영합니다<br>");
			out.println("로그인 후 모든 서비스를 이용할 수 있습니다<br>");
			out.println("<a href='/memberservlet/user/login.html'>로그인</a>");
		} else {
			out.println("서버 문제로 회원가입이 실패하였습니다");
			out.println("다시 시도해주세요");
		}
		out.println("	</body>");
		out.println("</html>");
	}

}
