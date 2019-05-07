<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.DriverManager" %>
<%@ page import="java.sql.PreparedStatement" %>
<%@ page import="java.sql.SQLException" %>

    <%!
    	int totalLen;
    	int cnt;
    	public void init() {
    		try {
    			Class.forName("oracle.jdbc.driver.OracleDriver");
    			System.out.println("Driver Loading Success!!");
    		totalLen = 8;
    		cnt = 0;
    		} catch (ClassNotFoundException e) {
    			e.printStackTrace();
    		}
    	}
    	public void countViews() {
    		Connection conn = null;
    		PreparedStatement psmt = null;
    		try {
//    			prop = new Properties();
//    			prop.load(new FileReader("src/com/kitri/basic/jdbc.properties")); //이 경로가 틀렸다??
//    			conn = DriverManager.getConnection("jdbc:oracle:thin:@192.168.14.52:1521:orcl", prop); 
    			conn = DriverManager.getConnection("jdbc:oracle:thin:@192.168.14.52:1521:orcl", "kitri", "kitri");
    			System.out.println("connection success!!");
    			String sql = "update counter set no = no+1";
    			psmt = conn.prepareStatement(sql);
    			if(psmt.executeUpdate()==1)
    				System.out.println("조회수 1회 증가");
    			else 
    				System.out.println("???");
//    		} catch (FileNotFoundException e) {
//    			e.printStackTrace();
//    		} catch (IOException e) {
//    			e.printStackTrace();
    		} catch (SQLException e) {
    			e.printStackTrace();
    		} finally {
    			if(psmt != null) {
    				try {
    					psmt.close();
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
    	}
    		
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<% 
	cnt++;
	countViews();
	response.setContentType("text/html;charset=UTF-8;");
	out.println("<html>");
	out.println("<body>");
	out.println("당신은");
	String count = Integer.toString(cnt);
	int n = 0;
	int len = totalLen - count.length();
	for (int i = 0; i < totalLen; i++) {
		out.println("<img src='/basicservlet/img/"+ (i >= len ? count.charAt(n++) : '0') +".png' width='50'>");
	}
	out.println("번째 방문자 입니다!");
	out.println("</body>");
	out.println("</html>");
	%>
</body>
</html>