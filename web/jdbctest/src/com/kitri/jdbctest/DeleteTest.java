package com.kitri.jdbctest;

import java.io.*;
import java.sql.*;
import java.util.Properties;

public class DeleteTest {
	public DeleteTest() {
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
		return conn;
	}
	public static void main(String[] args) {
		DeleteTest dt = new DeleteTest();
		Connection conn = null;
		Statement stmt = null;
		int cnt = 0;
		try {
			conn = dt.makeConnection();
			String name = "내아래로모여";
			String sql = "delete jdbctest \n";
			sql += "where name = '" + name + "'";
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
					stmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		System.out.println(cnt + "개 delete!!");
	}
		
}
