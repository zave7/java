package com.kitri.basic;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

public class CountDao {
	public CountDao() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("Driver Loading Success!!");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public void countViews() {
		Connection conn = null;
		PreparedStatement psmt = null;
		Properties prop = null;
		try {
//			prop = new Properties();
//			prop.load(new FileReader("src/com/kitri/basic/jdbc.properties")); //이 경로가 틀렸다??
//			conn = DriverManager.getConnection("jdbc:oracle:thin:@192.168.14.52:1521:orcl", prop); 
			conn = DriverManager.getConnection("jdbc:oracle:thin:@192.168.14.52:1521:orcl", "kitri", "kitri");
			System.out.println("connection success!!");
			String sql = "update counter set no = no+1";
			psmt = conn.prepareStatement(sql);
			if(psmt.executeUpdate()==1)
				System.out.println("조회수 1회 증가");
			else 
				System.out.println("???");
//		} catch (FileNotFoundException e) {
//			e.printStackTrace();
//		} catch (IOException e) {
//			e.printStackTrace();
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
}
