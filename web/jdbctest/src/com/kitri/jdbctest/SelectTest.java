package com.kitri.jdbctest;

import java.io.*;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.*;

public class SelectTest {
	
	public SelectTest() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("Driver Loading Success!!");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	public Connection makeConnection() throws FileNotFoundException, IOException, SQLException {
		Connection conn = null;
		Properties prop = new Properties();
		prop.load(new FileReader(new File("src/com/kitri/jdbctest/test.properties")));
			conn = DriverManager.getConnection("jdbc:oracle:thin:@192.168.14.52:1521:orcl", prop);
			System.out.println("Connection get success!!");
		return conn;
	}
	private List<MemberDto> memberList(String searchName) {
		List<MemberDto> list = new ArrayList<MemberDto>();
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			conn = makeConnection();
			String sql = "";
			sql += "select no, name, id, joindate\n";
			sql += "from jdbctest\n";
			if(searchName != null)
				sql += "where id = '" + searchName +"'";
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
//			MemberDto memberDto = new MemberDto();
			while(rs.next()) {
				MemberDto memberDto = new MemberDto();
//				memberDto.setNo(rs.getInt(1)); //불편
				memberDto.setNo(rs.getInt("no")); //항상 우리눈에 보이는 컬럼이름을 써야한다
				memberDto.setId(rs.getString("id"));
				memberDto.setJoindate(rs.getString("joindate"));
				memberDto.setName(rs.getString("name"));
				list.add(memberDto);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if(rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(stmt != null) {
				try {
					stmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return list;
	}
	
	private MemberDto memberSearch(int no) {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		MemberDto memberDto = null; 
		try {
			conn = makeConnection();
			stmt = conn.createStatement();
			String sql = "";
			sql += "select no, id, name, ";
			sql += "CASE WHEN to_char(joindate, 'yymmdd') != to_char(sysdate, 'yymmdd') THEN to_char(joindate, 'yyyy-mm-dd')\n";
			sql += "ELSE 'Today [' || to_char(joindate, 'hh24-mi-ss') || ']' END AS joindate\n";
//			sql += "WHEN to_char(joindate, 'yymmdd') != to_char(sysdate, 'yymmdd') THEN to_char(joindate, 'yyyy-mm-dd') END AS joindate\n";
			sql += "from jdbctest\n";
			sql += "where no = " + no + "";
			rs = stmt.executeQuery(sql);
			if(rs.next()) { // 처음 호출되는 next 메소드는 first의 기능을 가진다
				memberDto = new MemberDto();
				memberDto.setNo(rs.getInt("no"));
				memberDto.setId(rs.getString("no"));
				memberDto.setName(rs.getString("name"));
				memberDto.setJoindate(rs.getString("joindate"));
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return memberDto;
	}
	public static void main(String[] args) {
		SelectTest st = new SelectTest();
//		String searchName = null;
		String searchName = "갓지영";
		List<MemberDto> list = st.memberList(searchName);
		System.out.println("회원번호\t이름\t아이디\t가입일");
		System.out.println("------------------------------");
		for(MemberDto memberDto : list) {
			System.out.println(memberDto.getNo() + "\t" + memberDto.getName() + "\t" + memberDto.getId() + "\t" + memberDto.getJoindate());
		}
		
//		int no = 10;
		int no = 201;
		System.out.println("회원번호가 " + no + "인 회원 검색!!!!");
		MemberDto memberDto = null;
		memberDto = st.memberSearch(no);
		if(memberDto != null) {
			String result = "";
			result += "이름 : " + memberDto.getName() + "\n";
			result += "id : " + memberDto.getId() + "\n";
			result += "가입일 : " + memberDto.getJoindate() + "\n";
			System.out.println(result);
		} else {
			System.out.println(no + "번 회원은 존재하지 않습니다.");
		}
//		이름 : 홍길동
//		id : hong
//		가입일 : 10:27:24 (오늘)
//		가입일 : 2019.04.25 (오늘x)
		
//		10번 회원은 존재하지 않습니다
				
	}
	
}
