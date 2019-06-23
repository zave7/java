package com.kitri.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.kitri.dto.RepBoard;
import com.kitri.exception.AddException;
import com.kitri.exception.NotFoundException;

public class RepBoardDao {
	public void insert(RepBoard repBoard) throws AddException {
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
				if (pstmt != null)
					pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public List<RepBoard> selectByRows(int startRow, int endRow) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<RepBoard> list = new ArrayList<RepBoard>();
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "kitri", "kitri");
			StringBuffer selectByRowsSQL = new StringBuffer();
			selectByRowsSQL.append("SELECT * \n");
			selectByRowsSQL.append("FROM	(SELECT rownum r, repboard.* \n");
			selectByRowsSQL.append("FROM repboard \n");
			selectByRowsSQL.append("START WITH parent_seq = 0 \n");
			selectByRowsSQL.append("CONNECT BY PRIOR board_seq = parent_seq \n");
			selectByRowsSQL.append("ORDER SIBLINGS BY board_seq DESC) \n");
			selectByRowsSQL.append("WHERE r BETWEEN ? AND ?");
			pstmt = conn.prepareStatement(selectByRowsSQL.toString());
			int idx = 0;
			pstmt.setInt(++idx, startRow);
			pstmt.setInt(++idx, endRow);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				RepBoard board = new RepBoard();
				board.setBoard_contents(rs.getString("board_contents"));
				board.setBoard_date(rs.getTimestamp("board_date"));
				board.setBoard_password(rs.getString("board_password"));
				board.setBoard_seq(rs.getInt("board_seq"));
				board.setBoard_subject(rs.getString("board_subject"));
				board.setBoard_viewCount(rs.getInt("board_viewcount"));
				board.setBoard_writer(rs.getString("board_writer"));
				board.setParent_seq(rs.getInt("parent_seq"));
				list.add(board);
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				if (pstmt != null)
					pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return list;

	}

	public int selectTotalCnt() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int totalCnt = -1;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:orcl", "kitri", "kitri");
			String selectTotalCntSQL = "SELECT count(*) FROM repboard";
			pstmt = conn.prepareStatement(selectTotalCntSQL);
			rs = pstmt.executeQuery();
			rs.next();
			totalCnt = rs.getInt("count(*)");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				if (pstmt != null)
					pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return totalCnt;
	}

	public RepBoard selectByBoardSeq(String board_seq) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		RepBoard board = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "kitri", "kitri");
			StringBuffer selectByBoard = new StringBuffer();
			selectByBoard.append("SELECT board_seq, \n");
			selectByBoard.append("board_subject, \n");
			selectByBoard.append("board_writer, \n");
			selectByBoard.append("board_contents, \n");
			selectByBoard.append("board_date, \n");
			selectByBoard.append("parent_seq, \n");
			selectByBoard.append("board_viewcount \n");
			
			selectByBoard.append("FROM repboard \n");
			
			selectByBoard.append("WHERE board_seq = ?");

			pstmt = conn.prepareStatement(selectByBoard.toString());
			
			pstmt.setString(1, board_seq);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				board.setBoard_contents(rs.getString("board_contents"));
				board.setBoard_date(rs.getTimestamp("board_date"));
				board.setBoard_seq(rs.getInt("board_seq"));
				board.setBoard_subject(rs.getString("board_subject"));
				board.setBoard_viewCount(rs.getInt("board_viewcount"));
				board.setBoard_writer(rs.getString("board_writer"));
				board.setParent_seq(rs.getInt("parent_seq"));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				if (pstmt != null)
					pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return board;
	}
	public RepBoard selectByBoardSeq(Connection conn, String board_seq) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		RepBoard board = null;
		try {
			StringBuffer selectByBoard = new StringBuffer();
			selectByBoard.append("SELECT board_seq, \n");
			selectByBoard.append("board_subject, \n");
			selectByBoard.append("board_writer, \n");
			selectByBoard.append("board_contents, \n");
			selectByBoard.append("board_date, \n");
			selectByBoard.append("parent_seq, \n");
			selectByBoard.append("board_viewcount \n");
			
			selectByBoard.append("FROM repboard \n");
			
			selectByBoard.append("WHERE board_seq = ?");

			pstmt = conn.prepareStatement(selectByBoard.toString());
			
			pstmt.setString(1, board_seq);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				board = new RepBoard();
				board.setBoard_contents(rs.getString("board_contents"));
				board.setBoard_date(rs.getTimestamp("board_date"));
				board.setBoard_seq(rs.getInt("board_seq"));
				board.setBoard_subject(rs.getString("board_subject"));
				board.setBoard_viewCount(rs.getInt("board_viewcount"));
				board.setBoard_writer(rs.getString("board_writer"));
				board.setParent_seq(rs.getInt("parent_seq"));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				if (pstmt != null)
					pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return board;
	}
	
	public void countBoardView(Connection conn, String board_seq) throws SQLException {
		PreparedStatement pstmt = null;
		
		StringBuffer updateViewSQL = new StringBuffer();
		try {
		updateViewSQL.append("UPDATE repboard set board_viewcount = board_viewcount + 1 \n");
		updateViewSQL.append("WHERE board_seq = ?");
		pstmt = conn.prepareStatement(updateViewSQL.toString());
		pstmt.setString(1, board_seq);
		
		pstmt.executeUpdate();
		
		} finally {
			if(pstmt != null)
				pstmt.close();
		}
		
	}
	
	public RepBoard viewByBoardSeq (String board_seq) {
		Connection conn = null;
		RepBoard repBoard = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "kitri", "kitri");
			conn.setAutoCommit(false);
			repBoard = selectByBoardSeq(conn, board_seq);
			countBoardView(conn, board_seq);
			conn.commit();
		} catch (Exception e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
		return repBoard;
	}

}
