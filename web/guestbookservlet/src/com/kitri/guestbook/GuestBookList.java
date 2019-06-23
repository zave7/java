package com.kitri.guestbook;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/gblist")
public class GuestBookList extends HttpServlet {
	private static final long serialVersionUID = 1L;
	//이미 메모리에 로딩되어있기 때문에 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			StringBuffer sql = new StringBuffer();
			sql.append("select seq, name, subject, content, to_char(logtime, 'yyyy-MM-dd hh24:mi:ss') logtime \n");
			sql.append("from guestbook \n");
			sql.append("order by seq desc");
			
			conn = DriverManager.getConnection("jdbc:oracle:thin:@192.168.14.52:1521:orcl", "kitri", "kitri");
			pstmt = conn.prepareStatement(sql.toString());
			rs = pstmt.executeQuery();
			
			response.setContentType("text/html;charset=utf-8");
			PrintWriter out = response.getWriter();
			out.println("<!DOCTYPE html>\n");
			out.println("<html lang=\"ko\">\n");
			out.println("<head>\n");
			out.println("<title>글목록</title>\n");
			out.println("<meta charset=\"utf-8\">\n");
			out.println("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n");
			out.println("<link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css\">\n");
			out.println("<script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js\"></script>\n");
			out.println("<script src=\"https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.6/umd/popper.min.js\"></script>\n");
			out.println("<script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.2.1/js/bootstrap.min.js\"></script>\n");
			out.println("<script type=\"text/javascript\">\n");
			out.println("\n");
			out.println("</script>\n");
			out.println("</head>\n");
			out.println("<body>\n");
			out.println("\n");
			out.println("<div class=\"container\" align=\"center\">\n");
			out.println("  <div class=\"col-lg-8\" align=\"center\">\n");
			out.println("  <h2>글목록</h2>\n");
			out.println("  <table class=\"table table-borderless\">\n");
			out.println("  	<tr>\n");
			out.println("  		<td align=\"right\"><button type=\"button\" class=\"btn btn-link\">글쓰기</button></td>\n");
			out.println("  	</tr>\n");
			out.println("\n");
			out.println("  </table>\n");
				while(rs.next()) {
					out.println("<table class=\"table table-active\">");
					out.println("<tbody>");
					out.println("<tr>");
						out.println("<td>작성자 : "+rs.getString("name")+"</td>");
						out.println("<td style=\"text-align: right;\">작성일 : "+rs.getString("logtime")+"</td>");
						out.println("</tr>");
							out.println("<tr>");
							out.println("<td colspan=\"2\"><strong>"+rs.getInt("seq")+". "+rs.getString("subject")+"</strong></td>");
							out.println("</tr>");
							out.println("<tr>");
							out.println("<td colspan=\"2\">"+rs.getString("content").replace("\n", "<br>")+"</td>");
						out.println("</tr>");
					out.println("</tbody>");
					out.println("</table>");
				}
				out.println("  </div>\n");
				out.println("</div>\n");
				out.println("</body>\n");
				out.println("</html>\n");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if(rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
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
	}
	
}
