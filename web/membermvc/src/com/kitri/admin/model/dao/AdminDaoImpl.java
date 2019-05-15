package com.kitri.admin.model.dao;

import java.sql.*;
import java.util.*;

import com.kitri.member.model.MemberDetailDto;
import com.kitri.util.DBClose;
import com.kitri.util.DBConnection;

public class AdminDaoImpl implements AdminDao {
	
	private static AdminDao adminDao;
	
	static {
		adminDao = new AdminDaoImpl();
	}
	
	private AdminDaoImpl() {};
	
	public static AdminDao getAdminDao() {
		return adminDao;
	}
	
	@Override
	public List<MemberDetailDto> getMemberList(Map<String, String> map) {
		List<MemberDetailDto> list = new ArrayList<MemberDetailDto>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DBConnection.makeConnection();
			StringBuffer sql = new StringBuffer();
			sql.append(" select m.name name, m.id id, m.emailid emailid, m.emaildomain emaildomain, m.joindate joindate, \n");
			sql.append(" d.tel1 tel1, d.tel2 tel2, d.tel3 tel3, d.zipcode zipcode, d.address address, d.address_detail address_detail \n");
			sql.append(" from member m, member_detail d \n");
			sql.append(" where m.id = d.id \n");
			String key = map.get("key");
			String word = map.get("word");
			System.out.println("key = " + key);
			System.out.println("word = " + word);
			if(word != null && !word.isEmpty()) { //true && true 값이 있을때
				System.out.println("여길들어온다고??");
				if("id".equals(key)) {
					System.out.println("id로 들어옴");
					sql.append(" and m.id = ? \n");
				} else {
					System.out.println("id아닌거로로 들어옴");
					sql.append(" and d."+ key +" like '%'||?||'%'");
				}
			}
			pstmt = conn.prepareStatement(sql.toString());
			if(word != null && !word.isEmpty()) {
				System.out.println("여기도");
				pstmt.setString(1, word);
			}
			rs = pstmt.executeQuery();
			while(rs.next()) {
				MemberDetailDto memberDetailDto = new MemberDetailDto();
				memberDetailDto.setName(rs.getString("name"));
				memberDetailDto.setId(rs.getString("id"));
				memberDetailDto.setEmailId(rs.getString("emailid"));
				memberDetailDto.setEmailDomain(rs.getString("emaildomain"));
				memberDetailDto.setJoindate(rs.getString("joindate"));
				memberDetailDto.setTel1(rs.getString("tel1"));
				memberDetailDto.setTel2(rs.getString("tel2"));
				memberDetailDto.setTel3(rs.getString("tel3"));
				memberDetailDto.setZipcode(rs.getString("zipcode"));
				memberDetailDto.setAddress(rs.getString("address"));
				memberDetailDto.setAddressDetail(rs.getString("address_detail"));
				System.out.println("집코드 = "+memberDetailDto.getZipcode());
				list.add(memberDetailDto);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBClose.close(conn, pstmt, rs);
		}
		return list;
	}
}

