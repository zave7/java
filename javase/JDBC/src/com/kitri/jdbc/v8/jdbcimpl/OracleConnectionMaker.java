package com.kitri.jdbc.v8.jdbcimpl;

import java.sql.*;

import com.kitri.jdbc.v8.jdbcinterface.ConnectionMaker;

public class OracleConnectionMaker implements ConnectionMaker{

	public Connection makeConnection() {
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
