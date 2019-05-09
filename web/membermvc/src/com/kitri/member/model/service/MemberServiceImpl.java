package com.kitri.member.model.service;

import java.util.List;

import com.kitri.member.model.*;
import com.kitri.member.model.dao.MemberDao;
import com.kitri.member.model.dao.MemberDaoImpl;

public class MemberServiceImpl implements MemberService{
	
	private static MemberService memberService;
	
	static {
		memberService = new MemberServiceImpl();
	}
	
	private MemberServiceImpl() {}
	
	public static MemberService getMemberService() {
		return memberService;
	}

	@Override
	public String idCheck(String id) {
		int cnt = MemberDaoImpl.getMemberDao().idCheck(id);
//		System.out.println("cnt = " + cnt);
		String result = "";
		result += "<idcount>";
		result += "<cnt>" + cnt + "</cnt>";
		result += "</idcount>";
		return result;
	}

	@Override
	public String zipSearch(String doro) {
		String result = "";
		
		List<ZipcodeDto> list = MemberDaoImpl.getMemberDao().zipSearch(doro);
		result += "<ziplist>";
		for(ZipcodeDto zipcodeDto : list) {
			result += "<zip>\n";
			result += "<zipcode>" + zipcodeDto.getZipcode() + "</zipcode>\n";
			result += "<address>" + "<![CDATA["+zipcodeDto.getSido()+
									zipcodeDto.getGugun()+
									zipcodeDto.getUpmyon()+
									zipcodeDto.getBuildingNumber()+
									zipcodeDto.getSigugunBuildingName()+ "]]>" +
					"</address>\n";
			result += "</zip>\n";
		}
		result += "</ziplist>";
		
		return result;
	}

	@Override
	public int registerMember(MemberDetailDto memberDetailDto) {
		return MemberDaoImpl.getMemberDao().registerMember(memberDetailDto);
	}

	@Override
	public MemberDto loginMember(String id, String pass) {
		return null;
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
		// TODO Auto-generated method stub
		return 0;
	}

}
