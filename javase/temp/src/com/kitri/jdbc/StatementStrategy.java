package com.kitri.jdbc;

import java.sql.*;

public interface StatementStrategy {
	PreparedStatement makePreparedStatement(Connection c) throws SQLException;
}
