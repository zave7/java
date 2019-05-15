<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*, java.net.URLEncoder" %>
    <%!
    	public void init() {
    	try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
    	}
    %>
    <%
    Connection conn = null;
	PreparedStatement pstmt = null;

	// 요기는 포스트 io가 일어나기때문에
	request.setCharacterEncoding("utf-8");
//	1. data get(이름, 아이디, 비번, 이메일1, 이메일2, 전번1, 전번2, 전번3, 우편번호, 주소, 상세주소)
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
	
	response.setContentType("text/html;charset=utf-8");// 순서지정이 중요
String root = request.getContextPath();
if(cnt != 0) {
	response.sendRedirect(root + "/user/registerok.jsp?name=" + URLEncoder.encode(name, "utf-8"));
} else {
	response.sendRedirect(root + "/user/registerfail.jsp");
}
%>
