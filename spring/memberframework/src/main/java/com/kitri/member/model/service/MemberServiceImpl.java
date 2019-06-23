package com.kitri.member.model.service;

import java.util.*;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kitri.member.model.*;
import com.kitri.member.model.dao.MemberDao;

@Service
public class MemberServiceImpl implements MemberService{
	@Autowired
	private MemberDao memberDao;
	
	@Override
	public String idCheck(String id) {
		int cnt = memberDao.idCheck(id);
//		System.out.println("cnt = " + cnt);
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("idcount", cnt);
		return jsonObject.toString(); //{"idcount" : 0}
	}

	@Override
	public String zipSearch(String doro) {
		JSONObject jsonObject = new JSONObject();
		List<ZipcodeDto> list = memberDao.zipSearch(doro);
		JSONArray jsonArray = new JSONArray(list);
//		for(ZipcodeDto z : list) {
//			JSONObject zipcode = new JSONObject();
//			zipcode.put("zipcode", z.getZipcode());
//			zipcode.put("address", z.getSido() + 
//					z.getGugun() + 
//					z.getUpmyon() + 
//					z.getDoro() + 
//					z.getBuildingNumber() + 
//					z.getSigugunBuildingName());
//			jsonArray.put(zipcode);
//		}
		jsonObject.put("ziplist", jsonArray);
//		System.out.println("jsonObject : " + jsonObject);
		return jsonObject.toString();
	}

	@Override
	public int registerMember(MemberDetailDto memberDetailDto) {
		return memberDao.registerMember(memberDetailDto);
	}

	@Override
	public MemberDto loginMember(Map<String, String> map) {
		return memberDao.loginMember(map);
	}

	@Override
	public MemberDetailDto getMember(String id) {
		return memberDao.getMember(id);
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

	@Override
	public String userInfoModify(MemberDetailDto memberDetailDto) {
		int result = memberDao.updateByMemberId(memberDetailDto);
		if(result != 0)
			return "true";
		else
			return "false";
	}

}
