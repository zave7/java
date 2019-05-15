<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.sql.*, java.net.URLEncoder" %>
    <%
    Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	request.setCharacterEncoding("utf-8");//한글아이디를 포함할때
//	1. get data
	String id = request.getParameter("id");
	String pass = request.getParameter("pass");
	String name = null;
	try {
		conn = DriverManager.getConnection("jdbc:oracle:thin:@192.168.14.52:1521:orcl","kitri","kitri");
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
	
	response.setContentType("text/html;charset=utf-8");// 순서지정이 중요
	String root = request.getContextPath();
	if(name != null) {
		response.sendRedirect(root + "/user/loginok.jsp?name=" + URLEncoder.encode(name, "utf-8"));
	} else {
		response.sendRedirect(root + "/user/loginfail.jsp");
	}
    %>
