package com.kitri.jdbc;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MenuDao {

	private JdbcContext jdbcContext;

	public void setJdbcContext(JdbcContext jdbcContext) {
		this.jdbcContext = jdbcContext;
	}

	public void deleteAll() throws SQLException {
		this.jdbcContext.executeSql("dfsd");
	}

	

}
//	//ī�װ� �޴� Ŭ���� ���� �޴� ������
//	public List<FoodDto> getMenubyCategory(int categori_id) {
//		List<FoodDto> list = new ArrayList<FoodDto>();
//		Connection c = null; 
//		PreparedStatement ps = null; 
//		ResultSet rs = null;
//		try {
//			c = connectionMaker.makeConnection();
//			ps = c.prepareStatement("select food_name, image_address, food_id from fook_food where category_id = ?");
//			ps.setInt(1, categori_id);
//			rs = ps.executeQuery();
//			//���� �̸�, �̹����ּ�, ���̵� (�޴� ����Ʈ�� �������� ������)
//			while (rs.next()) {
//				FoodDto food = new FoodDto();
//				food.setFoodName(rs.getString("food_name"));
//				food.setImageAddress(rs.getString("image_address"));
//				food.setFoodId(rs.getString("food_id"));
//				list.add(food);
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} finally {
//			if(rs != null) {
//				try {
//					rs.close();
//				} catch (SQLException e) {
//					e.printStackTrace();
//				}
//			}
//			if(ps != null) {
//				try {
//					ps.close();
//				} catch (SQLException e) {
//					e.printStackTrace();
//				}
//			}
//			if(c != null) {
//				try {
//					c.close();
//				} catch (SQLException e) {
//					e.printStackTrace();
//				}
//			}
//		}
//
//		return list;
//	}
//}