package com.kitri.jdbc.v6;

import java.sql.Connection;
import java.sql.SQLException;

public interface ConnectionMaker { //인터페이스의 도입
	public Connection makeConnection() throws ClassNotFoundException, SQLException;
}
