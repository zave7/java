package com.kitri.jdbc.v7;

public class DaoFactory {
	public UserDao userDao() {
		ConnectionMaker connectionMaker = new OracleConnectionMaker();
		UserDao userDao = new UserDao(connectionMaker);
		return userDao;
	}
	
//	public MemberDto memberDao() {
//		ConnectionMaker connectionMaker = new OracleConnectionMaker();
//		MemberDto memberDao = new MemberDto(connectionMaker);
//		return memberDao;
//	}
}