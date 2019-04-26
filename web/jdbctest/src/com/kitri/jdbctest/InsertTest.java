package com.kitri.jdbctest;

import java.io.*;
import java.sql.*;
import java.util.Properties;

public class InsertTest {
	
	public InsertTest() {
	}
	public Connection makeConnection() throws ClassNotFoundException, FileNotFoundException, IOException, SQLException {
		Connection conn = null;
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("Driver Loading Success!!");
			Properties prop = new Properties();
			prop.load(new FileReader("src/com/kitri/jdbctest/test.properties"));
			conn = DriverManager.getConnection("jdbc:oracle:thin:@192.168.14.52:1521:orcl", prop);
			System.out.println("DB Connection Success!!");

		return conn;
	}
	public static void main(String[] args) {
		InsertTest it = new InsertTest();
		String name = "범인은";
		String id = "병욱이형!?";
		Connection conn = null;
		Statement stmt = null;
		int cnt = 0;
		try {
			conn = it.makeConnection();
			String sql = "";
			
//		insert into jdbctest (no, name, id, joindate)
//		values (jdbctest_no_sql.nextval, '권영찬', 'java2', sysdate);
			
			sql += "insert into jdbctest (no, name, id, joindate) \n";
			sql += "values (jdbctest_no_seq.nextval, '"+ name +"', '"+ id +"', sysdate)";
//		System.out.println(sql);
			stmt = conn.createStatement();
			cnt = stmt.executeUpdate(sql);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
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
		if(cnt != 0) {
			System.out.println("insert success!!");
		} else {
			System.out.println("insert fail!!");
		}
	}
}
