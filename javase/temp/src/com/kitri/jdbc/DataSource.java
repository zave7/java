package com.kitri.jdbc;

import java.sql.Connection;

public class DataSource {
	public Connection getConnection() { 
		return new OracleConnectionMaker().getConnection(); // �п����� ��� �����Ҷ�
////		return new HomeOracleConnectionMaker(); ������ ��� �׽�Ʈ �Ҷ�
	}
//	public MenuDao menuDao() {
//		ConnectionMaker connectionMaker = connectionMaker();
//		MenuDao userDao = new MenuDao(connectionMaker);
//		return userDao;
//	}
}