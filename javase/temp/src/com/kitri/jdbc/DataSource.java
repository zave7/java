package com.kitri.jdbc;

import java.sql.Connection;

public class DataSource {
	public Connection getConnection() { 
		return new OracleConnectionMaker().getConnection(); // 학원에서 디비 연결할때
////		return new HomeOracleConnectionMaker(); 집에서 디비 테스트 할때
	}
//	public MenuDao menuDao() {
//		ConnectionMaker connectionMaker = connectionMaker();
//		MenuDao userDao = new MenuDao(connectionMaker);
//		return userDao;
//	}
}