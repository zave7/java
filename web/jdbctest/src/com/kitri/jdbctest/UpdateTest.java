package com.kitri.jdbctest;

import java.io.*;
import java.sql.*;
import java.util.Properties;

//zave의 가입일을 현재시간으로 수정.
public class UpdateTest {
	public UpdateTest() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("Driver Loading Success!!");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
	}
	private Connection makeConnection() throws FileNotFoundException, IOException, SQLException {
		Connection conn = null;
		Properties prop = new Properties();
		prop.load(new FileReader(new File("src/com/kitri/jdbctest/test.properties")));
		conn = DriverManager.getConnection("jdbc:oracle:thin:@192.168.14.52:1521:orcl", prop);
		System.out.println("Connection Success!!");
		return conn;
	}
	public static void main(String[] args) {
		UpdateTest ut = new UpdateTest();
		Connection conn = null;
		Statement stmt = null;
		int cnt = 0;
		try {
			conn = ut.makeConnection();
			String sql = "";
			String id = "zave";
			sql += "update jdbctest set joindate = sysdate \n";
			sql += "where id ='" + id +"'";
			stmt = conn.createStatement();
			cnt = stmt.executeUpdate(sql);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if(stmt != null) {
				try {
					stmt.close();
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
		System.out.println(cnt + "개 update!!!!");
	}

}
