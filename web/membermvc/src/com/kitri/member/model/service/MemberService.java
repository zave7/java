package com.kitri.member.model.service;

import java.util.List;

import com.kitri.member.model.*;

public interface MemberService {
	String idCheck(String id);
	String zipSearch(String dong);
	int registerMember(MemberDetailDto memberDetailDto);
	MemberDto loginMember(String id, String pass);//이름아이디이메일
	
	MemberDetailDto getMember(String id);//회원정보수정 회원1명
	int modifyMember(MemberDetailDto memberDetailDto);
	int deleteMember(String id);
}