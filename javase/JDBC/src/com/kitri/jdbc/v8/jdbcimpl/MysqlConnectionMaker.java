package com.kitri.jdbc.v8.jdbcimpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.kitri.jdbc.v8.jdbcinterface.ConnectionMaker;

public class MysqlConnectionMaker implements ConnectionMaker{
	
	@Override
	public Connection makeConnection() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");
		Connection c = DriverManager.getConnection(
				"jdbc:mysql://Localhost/springbook", "spring", "bool");
		return c;
	}
}
