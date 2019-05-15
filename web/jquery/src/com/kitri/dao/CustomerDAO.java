package com.kitri.dao;

import java.sql.*;
import java.util.List;

import com.kitri.dto.Customer;
import com.kitri.exception.NotFoundException;

public class CustomerDAO {
	
	public Customer selectById(String id) throws com.kitri.exception.NotFoundException{
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			//1.jdbc driver load
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//2.db 연결
			conn = DriverManager.getConnection("jdbc:oracle:thin:@192.168.14.65:1521:orcl", "kitri", "kitri");
			System.out.println("디비연결!!");
			//3.SQL 구문 DB서버로 송신
			StringBuffer selectByIdSql = new StringBuffer();
			selectByIdSql.append("select * from customer where id = ?");
			System.out.println("id = "+id);
			pstmt = conn.prepareStatement(selectByIdSql.toString());
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				System.out.println("rs.next()");
				Customer customer = new Customer();
				customer.setId(rs.getString("id"));
				customer.setPass(rs.getString("pass"));
				customer.setName(rs.getString("name"));
				return customer;
			} else {
				System.out.println("dao exception");
				throw new NotFoundException("아이디에 해당하는 고객이 없습니다");
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			throw new NotFoundException(e.getMessage());
		} catch (SQLException e) {
			e.printStackTrace();
			throw new NotFoundException(e.getMessage());
		} finally {
			try {
				if(rs != null) {
					rs.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				if(pstmt != null) {
					pstmt.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				if(conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	public List<Customer> selectByName(String name) {
		return null;
	}
	public void insert(Customer customer) {
		
	}
	public List<Customer> selectAll() {
		return null;
	}
}
