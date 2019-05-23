package com.kitri.dao;

import java.sql.*;

import com.kitri.dto.RepBoard;
import com.kitri.exception.AddException;

public class RepBoardDao {
	public void insert(RepBoard repBoard) throws AddException{
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "kitri", "kitri");
			StringBuffer insertSQL = new StringBuffer();
			insertSQL.append("insert into repboard ( \n");
			
			insertSQL.append("BOARD_SEQ, \n");
			insertSQL.append("PARENT_SEQ, \n");
			insertSQL.append("BOARD_SUBJECT, \n");
			insertSQL.append("BOARD_WRITER, \n");
			insertSQL.append("BOARD_CONTENTS, \n");
			insertSQL.append("BOARD_DATE, \n");
			insertSQL.append("BOARD_PASSWORD, \n");
			insertSQL.append("BOARD_VIEWCOUNT) \n");
			
			insertSQL.append("VALUES ( \n");
			
			insertSQL.append("BOARD_SEQ.NEXTVAL, \n");
			insertSQL.append("?, \n");
			insertSQL.append("?, \n");
			insertSQL.append("?, \n");
			insertSQL.append("?, \n");
			insertSQL.append("systimestamp, \n");
			insertSQL.append("?, \n");
			insertSQL.append("0)");
			pstmt = conn.prepareStatement(insertSQL.toString());
			int idx = 0;
			pstmt.setInt(++idx, repBoard.getParent_seq());
			pstmt.setString(++idx, repBoard.getBoard_subject());
			pstmt.setString(++idx, repBoard.getBoard_writer());
			pstmt.setString(++idx, repBoard.getBoard_contents());
			pstmt.setString(++idx, repBoard.getBoard_password());
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new AddException("글 작성 예외 발생");
		} finally {
			try {
				if(pstmt != null)
				pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				if(conn != null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	public static void main(String[] args) {
		RepBoardDao repBoardDao = new RepBoardDao();
		RepBoard repBoard = new RepBoard();
		repBoard.setBoard_subject("testsub");
		repBoard.setBoard_contents("내용");
		repBoard.setBoard_writer("zave");
		repBoard.setBoard_password("1234");
		//repBoard.setParent_seq(1);
		try {
			repBoardDao.insert(repBoard);
		} catch (AddException e) {
			e.printStackTrace();
		}
	}
	public void append(String sql) {
	}
}
