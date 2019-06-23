package com.kitri.jdbc;

import java.sql.*;

public class OracleConnectionMaker implements ConnectionMaker{

	public Connection getConnection() {
		Connection c = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			c = DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521:orcl", "kitri", "kitri");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return c;
	}
	
}
