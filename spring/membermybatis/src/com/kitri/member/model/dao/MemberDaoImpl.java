package com.kitri.member.model.dao;

import java.util.*;

import org.apache.ibatis.session.SqlSession;

import com.kitri.member.model.*;
import com.kitri.sqlmap.MyBatisConfiguration;

public class MemberDaoImpl implements MemberDao {
	// 전역변수에서는 객체를 만드는 것은 지양해야한다
	private static MemberDao memberDao;
	private final String NAME_SPACE = "com.kitri.member.model.dao.MemberDao.";
	static {
		memberDao = new MemberDaoImpl();
	}

	private MemberDaoImpl() {
	}

	public static MemberDao getMemberDao() {
		return memberDao;
	}

	@Override
	public int idCheck(String id) {
		// 아이디 중복 체크
		SqlSession session = MyBatisConfiguration.getSqlSessionFactory().openSession();
		try {
			return session.selectOne(NAME_SPACE + "idCheck", id);
		} finally {
			session.close();
		}
	}

	@Override
	public List<ZipcodeDto> zipSearch(String doro) {
		// 집코드!!
		SqlSession session = MyBatisConfiguration.getSqlSessionFactory().openSession();
		try {
			return session.selectList(NAME_SPACE + "zipsearch", doro);
		} finally {
			session.close();
		}
	}

	@Override
	public int registerMember(MemberDetailDto memberDetailDto) {
		// 회원가입!!
		SqlSession session = MyBatisConfiguration.getSqlSessionFactory().openSession();
		try {
			session.insert(NAME_SPACE + "registerMember", memberDetailDto);
			session.commit();
			return 1;
		} finally {
			session.close();
		}
	}

	@Override
	public MemberDto loginMember(Map<String, String> map) {
		// TODO 로그인
		SqlSession session = MyBatisConfiguration.getSqlSessionFactory().openSession();
		try {
			return session.selectOne(NAME_SPACE + "loginMember", map);
		} finally {
			session.close();
		}
	}

	@Override
	public MemberDetailDto getMember(String id) {
		// TODO 상세보기
		SqlSession session = MyBatisConfiguration.getSqlSessionFactory().openSession();
		System.out.println(id);
		try {
			return session.selectOne(NAME_SPACE + "getMember", id);
		} finally {
			session.close();
		}
	}

	@Override
	public int modifyMember(MemberDetailDto memberDetailDto) {
		// TODO 회원 정보 수정
		SqlSession session = MyBatisConfiguration.getSqlSessionFactory().openSession();
		return 0;
	}

	@Override
	public int deleteMember(String id) {
		// TODO 회원 삭제
		SqlSession session = MyBatisConfiguration.getSqlSessionFactory().openSession();
		return 0;
	}

	@Override
	public int updateByMemberId(MemberDetailDto memberDetailDto) {
		SqlSession session = MyBatisConfiguration.getSqlSessionFactory().openSession();
		System.out.println("memberDetailDto : " + memberDetailDto);
		try {
			session.insert(NAME_SPACE + "updateByMemberId", memberDetailDto);
			session.commit();
			return 1;
		} finally {
			session.close();
		}
	}
}
