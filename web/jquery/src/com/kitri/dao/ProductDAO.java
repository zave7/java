package com.kitri.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.kitri.dto.Product;
import com.kitri.dto.ProductCategory;
import com.kitri.exception.NotFoundException;

public class ProductDAO {
	
	private static ProductDAO productDAO;
	
	static {
		productDAO = new ProductDAO();
	}
	private ProductDAO() {
		
	}
	public static ProductDAO getProductDAO() {
		return productDAO;
	}
	
	public List<Product> selectAll() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<Product> list = new ArrayList<Product>();
		try {
			//1)JDBC드라이버로드
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//2)DB연결
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "kitri", "kitri");
			//3)SQL송신
			String selectAllSQL = "SELECT cate_no, cate_name, \n" + 
					"	prod_no, prod_name, prod_price, prod_detail \n" + 
					"FROM product p JOIN product_category pc \n" + 
					"ON p.prod_cate = pc.cate_no \n" + 
					"ORDER BY cate_no, prod_name ";
			pstmt = conn.prepareStatement(selectAllSQL);
			//4)결과수신
			rs = pstmt.executeQuery();
			while(rs.next()) {
				String prod_no = rs.getString("prod_no");
				String prod_name = rs.getString("prod_name");
				int prod_price = rs.getInt("prod_price");
				String prod_detail = rs.getString("prod_detail");
				
				String cate_no = rs.getString("cate_no");
				String cate_name = rs.getString("cate_name");
				
				ProductCategory productCategory = new ProductCategory(cate_no, cate_name);
				Product product = new Product(prod_no, prod_name, prod_price, prod_detail, productCategory);
				list.add(product);
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			//5)연결 닫기
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
		return list;
	}
	public Product selectByNo(String prod_no) throws NotFoundException {
		Product product = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			//1)JDBC드라이버로드
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//2)DB연결
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "kitri", "kitri");
			//3)SQL송신
			String selectAllSQL = "SELECT cate_no, cate_name, \n" + 
					"	prod_no, prod_name, prod_price, prod_detail \n" + 
					"FROM product p JOIN product_category pc \n" + 
					"ON p.prod_cate = pc.cate_no \n" + 
					"WHERE p.prod_no = ?";
			pstmt = conn.prepareStatement(selectAllSQL);
			pstmt.setString(1, prod_no);
			//4)결과수신
			rs = pstmt.executeQuery();
				if(rs.next()) {
					String prod_num = rs.getString("prod_no");
					String prod_name = rs.getString("prod_name");
					int prod_price = rs.getInt("prod_price");
					String prod_detail = rs.getString("prod_detail");
					
					String cate_no = rs.getString("cate_no");
					String cate_name = rs.getString("cate_name");
					
					ProductCategory productCategory = new ProductCategory(cate_no, cate_name);
					product = new Product(prod_num, prod_name, prod_price, prod_detail, productCategory);
				} else {
					throw new NotFoundException("해당하는 상품을 찾을 수 없습니다");
				}

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			//5)연결 닫기
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
		return product;
	}
}
