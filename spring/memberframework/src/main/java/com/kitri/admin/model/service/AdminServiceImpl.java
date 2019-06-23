package com.kitri.admin.model.service;

import java.util.*;

import org.json.JSONArray;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kitri.admin.model.dao.AdminDao;
import com.kitri.member.model.MemberDetailDto;

@Service
public class AdminServiceImpl implements AdminService {
	
	private static final Logger logger = LoggerFactory.getLogger(AdminServiceImpl.class);
	
	@Autowired
	private AdminDao adminDao;
	
	@Override
	public String getMemberList(Map<String, String> map) {
		List<MemberDetailDto> list = adminDao.getMemberList(map);
		
		JSONObject jsonObject = new JSONObject();
		JSONArray jsonArray = new JSONArray(list);
		jsonObject.put("memberList", jsonArray);
//		result += "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n";
//		result += "<memberlist>\n";
//		for(MemberDetailDto memberDetailDto : list) {
//			result += "<member>\n";
//			result += "<id>"+memberDetailDto.getId()+"</id>\n";
//			result += "<name>"+memberDetailDto.getName()+"</name>\n";
//			result += "<email>"+memberDetailDto.getEmailId()+"@"+memberDetailDto.getEmailDomain()+"</email>\n";
//			result += "<tel>"+memberDetailDto.getTel1()+memberDetailDto.getTel2()+memberDetailDto.getTel3()+"</tel>\n";
//			result += "<address><![CDATA["+memberDetailDto.getZipcode()+" "+memberDetailDto.getAddress()+" "+memberDetailDto.getAddressDetail()+"]]></address>\n";
//			result += "<joindate>"+memberDetailDto.getJoindate()+"</joindate>\n";
//			result += "</member>\n";
//		}
//		result += "</memberlist>";
		System.out.println("json : " + jsonObject.toString());
//		logger.info("json : " + jsonObject.toString());
		return jsonObject.toString();
	}

}
