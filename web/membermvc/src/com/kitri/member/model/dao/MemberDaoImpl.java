package com.kitri.member.model.dao;

import java.sql.*;
import java.util.*;

import com.kitri.member.model.*;
import com.kitri.util.DBClose;
import com.kitri.util.DBConnection;

public class MemberDaoImpl implements MemberDao {
	//전역변수에서는 객체를 만드는 것은 지양해야한다
	private static MemberDao memberDao;
	
	static {
		memberDao = new MemberDaoImpl();
	}
	
	private MemberDaoImpl() {}
	
	public static MemberDao getMemberDao() {
		return memberDao;
	}
	
	@Override
	public int idCheck(String id) {
		int cnt = 1;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DBConnection.makeConnection();
			StringBuffer sql = new StringBuffer();
			sql.append("select count(id) id \n");
			sql.append("from member \n");
			sql.append("where id = ? ");
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			rs.next(); //현재 커서가 얻어온 결과의 마지막에 위치해있기 때문에 맨 처음으로 올려주는 작업
						// 최초 1회 실행한 next()만 first()의 기능을 한다
			cnt = rs.getInt("id");
		} catch (SQLException e) {
			cnt = 1; // 익셉션이 났을때
			e.printStackTrace();
		} finally {
			DBClose.close(conn, pstmt, rs);
		}
		return cnt; //리턴 변수을 지정해놓고 코딩!!!
	}

	@Override
	public List<ZipcodeDto> zipSearch(String doro) {
		System.out.println(doro);
		List<ZipcodeDto> list = new ArrayList<ZipcodeDto>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DBConnection.makeConnection();
			StringBuffer sql = new StringBuffer();
			sql.append("select 	case  \n");
			sql.append("			when length(new_post_code) = 4 then '0'||new_post_code \n");
			sql.append("			else new_post_code \n");
			sql.append("		end zipcode,  \n");
			sql.append("		sido_kor sido, gugun_kor gugun,  \n");
			sql.append("		nvl(upmyon_kor, ' ') upmyon, doro_kor doro,  \n");
			sql.append("		case when building_refer_number != '0' \n");
			sql.append("			then building_origin_number||'-'||building_refer_number  \n");
			sql.append("			else trim(to_char(building_origin_number, '99999')) \n");
			sql.append("		end building_number, sigugun_building_name \n");
			sql.append("from 	postcode \n");
			sql.append("where 	doro_kor like '%'||?||'%' \n");
			sql.append("or sigugun_building_name like '%'||?||'%' \n");
			pstmt = conn.prepareStatement(sql.toString());
			int idx = 0;
			pstmt.setString(++idx, doro);
			pstmt.setString(++idx, doro);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				ZipcodeDto zipcodeDto = new ZipcodeDto();
				zipcodeDto.setZipcode(rs.getString("zipcode"));
				zipcodeDto.setSido(rs.getString("sido"));
				zipcodeDto.setGugun(rs.getString("gugun"));
				zipcodeDto.setUpmyon(rs.getString("upmyon"));
				zipcodeDto.setBuildingNumber(rs.getString("building_number"));
				zipcodeDto.setSigugunBuildingName(rs.getString("sigugun_building_name"));
				list.add(zipcodeDto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBClose.close(conn, pstmt, rs);
		}
		return list;
	}

	@Override
	public int registerMember(MemberDetailDto memberDetailDto) {
		int cnt = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBConnection.makeConnection();
			// 가급적 스트링 버퍼를 쓰자
			StringBuffer sql = new StringBuffer();
			sql.append(" insert all \n");
			sql.append(" 	into member (id, name, pass, emailid, emaildomain, joindate) \n");
			sql.append(" 	values (?, ?, ?, ?, ?, sysdate) \n");
			sql.append(" 	into member_detail (id, tel1, tel2, tel3, zipcode, address, address_detail) \n");
			sql.append(" 	values (?, ?, ?, ?, ?, ? ,?) \n");
			sql.append(" select * \n");
			sql.append(" from dual \n");
			// 최초1번 문법검사
			pstmt = conn.prepareStatement(sql.toString());
			int idx = 0;
			// 타입만 검사하면 된다
			pstmt.setString(++idx, memberDetailDto.getId());
			pstmt.setString(++idx, memberDetailDto.getName());
			pstmt.setString(++idx, memberDetailDto.getPass());
			pstmt.setString(++idx, memberDetailDto.getEmailId());
			pstmt.setString(++idx, memberDetailDto.getEmailDomain());
			pstmt.setString(++idx, memberDetailDto.getId());
			pstmt.setString(++idx, memberDetailDto.getTel1());
			pstmt.setString(++idx, memberDetailDto.getTel2());
			pstmt.setString(++idx, memberDetailDto.getTel3());
			pstmt.setString(++idx, memberDetailDto.getZipcode());
			pstmt.setString(++idx, memberDetailDto.getAddress());
			pstmt.setString(++idx, memberDetailDto.getAddressDetail());
			cnt = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBClose.close(conn, pstmt);
		}
		return cnt;
	}

	@Override
	public MemberDto loginMember(Map<String, String> map) {
		MemberDto memberDto = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DBConnection.makeConnection();
			StringBuffer sql = new StringBuffer();
			sql.append(" select name, id, emailid, emaildomain, joindate \n");
			sql.append(" from member \n");
			sql.append(" where id = ? \n");
			sql.append(" and pass = ?"); //요즘에는 아이디랑 비밀번호 한번에 비교한다 아이디 알아내지 못하게 하기 위해
			pstmt = conn.prepareStatement(sql.toString());
			int idx = 0;
			pstmt.setString(++idx, map.get("userid"));
			pstmt.setString(++idx, map.get("userpwd"));
			rs = pstmt.executeQuery();
			if(rs.next()) {
				memberDto = new MemberDetailDto();
				memberDto.setName(rs.getString("name"));
				memberDto.setId(rs.getString("id"));
				memberDto.setEmailId(rs.getString("emailid"));
				memberDto.setEmailDomain(rs.getString("emaildomain"));
				memberDto.setJoindate(rs.getString("joindate"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBClose.close(conn, pstmt, rs);
		}
		return memberDto;
	}

	@Override
	public MemberDetailDto getMember(String id) {
		return null;
	}

	@Override
	public int modifyMember(MemberDetailDto memberDetailDto) {
		return 0;
	}

	@Override
	public int deleteMember(String id) {
		return 0;
	}

}
