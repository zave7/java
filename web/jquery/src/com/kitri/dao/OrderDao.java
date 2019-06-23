package com.kitri.dao;

import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.kitri.dto.*;
import com.kitri.exception.AddException;

public class OrderDao {

	public void insert(OrderInfo info) throws AddException {
		Connection conn = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			// 2)DB연결
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "kitri", "kitri");

			conn.setAutoCommit(false); // 자동 커밋 해제

			insertInfo(conn, info);
			List<OrderLine> lines = info.getLines();
			insertLine(conn, lines);
			conn.commit();
		} catch (Exception e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
			throw new AddException("주문 추가 오류" + e.getMessage());
		} finally {
			// DB닫기
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public void insertInfo(Connection conn, OrderInfo info) throws SQLException {
		PreparedStatement pstmt = null;
		StringBuffer insertInfoSql = new StringBuffer();
		insertInfoSql.append("INSERT INTO order_info (order_no, order_id) \n");
		insertInfoSql.append("values (order_seq.nextval, ?)");
		try {
			pstmt = conn.prepareStatement(insertInfoSql.toString());
			pstmt.setString(1, info.getCustomer().getId());
			pstmt.executeUpdate();
//		} catch (SQLException e) {
//			e.printStackTrace();
		} finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public void insertLine(Connection conn, List<OrderLine> lines) throws SQLException {
		PreparedStatement pstmt = null;
		StringBuffer insertLineSql = new StringBuffer();
		insertLineSql.append("INSERT INTO order_line (order_no, order_prod_no, order_quantity) \n");
		insertLineSql.append("values (order_seq.currval, ?, ?)");
		try {
			pstmt = conn.prepareStatement(insertLineSql.toString());
			for (OrderLine line : lines) {
				String prod_no = line.getProduct().getProd_no();
				pstmt.setString(1, prod_no);
				int quantity = line.getOrder_quantity();
				pstmt.setInt(2, quantity);
				// pstmt.executeUpdate();
				pstmt.addBatch();// 일괄처리에 추가
			}
			pstmt.executeBatch();
//		} catch (SQLException e) {
//			e.printStackTrace();
		} finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public List<OrderInfo> selectById(String id) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<OrderInfo> list = new ArrayList<OrderInfo>();
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			// 2)DB연결
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "kitri", "kitri");
			StringBuffer selectById = new StringBuffer();
			selectById.append("SELECT info.order_no, to_char(order_dt, 'yy-MM-dd') order_dt, \n");
			selectById.append("prod_no, prod_name, prod_price, \n");
			selectById.append("order_quantity \n");
			selectById.append("FROM order_info info JOIN order_line line \n");
			selectById.append("ON info.order_no = line.order_no \n");
			selectById.append("JOIN product p ON p.prod_no = line.order_prod_no \n");
			selectById.append("WHERE order_id = ? \n");
			selectById.append("ORDER BY order_no DESC, prod_no");
			// 3)sql송신
			System.out.println("List orderinfo id = " + id);
			pstmt = conn.prepareStatement(selectById.toString());
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			OrderInfo info= null;
			OrderLine line = null;
			List<OrderLine> lines = null;
			int old_order_no = -1; //이전주문번호 역할
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

			while(rs.next()) {
				int order_no = rs.getInt("order_no");
				if(old_order_no != order_no) { //주문번호가 다를때
					info = new OrderInfo();
					list.add(info);
					info.setOrder_no(order_no);
					info.setOrder_no(rs.getInt("order_no"));
					info.setOrder_dt(sdf.parse(rs.getString("order_dt")));
					lines = new ArrayList<OrderLine>();
					info.setLines(lines);
					old_order_no = order_no;
				}
				line = new OrderLine();
				String prod_no = rs.getString("prod_no");
				String prod_name = rs.getString("prod_name");
				int prod_price = Integer.parseInt(rs.getString("prod_price"));
				Product product = new Product();
				product.setProd_no(prod_no);
				product.setProd_name(prod_name);
				product.setProd_price(prod_price);
				line.setProduct(product);
				line.setOrder_quantity(rs.getInt("order_quantity"));
				
				lines.add(line);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs != null) 
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				if(pstmt != null) 
				pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				if(conn != null) 
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return list;
	}
}
