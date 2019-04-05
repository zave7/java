package com.kitri.haksa.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.kitri.haksa.data.HaksaDto;

public class HaksaDao {
	public HaksaDao() {
	}
	public void register(HaksaDto haksa) {
		Connection c = null;
		PreparedStatement ps = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			c = DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521:orcl", "kitri", "kitri");
			ps = c.prepareStatement(
					"insert into haksa_main(name, age, job_code, job_value) values(?,?,?,?)");
			ps.setString(1, haksa.getName());
			ps.setInt(2, haksa.getAge());
			ps.setInt(3, haksa.getKey());
			ps.setString(4, haksa.getValue());
			ps.executeUpdate();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if(ps != null) {
				try {
					ps.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(c != null) {
				try {
					c.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			
		}
		
	}
	public HaksaDto findName(String name) {
		return null;
	}
	public int delete(String name) {
		return 0;
	}
	public ArrayList<HaksaDto> selectAllList() {
		ArrayList<HaksaDto> list = null;
		return list;
	}
}
