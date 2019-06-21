package com.kitri.admin.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kitri.admin.model.service.AdminService;

@Controller
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired
	private AdminService adminService;
	
	@RequestMapping("memberlist.kitri")
	@ResponseBody
	public String getMemberList(@RequestParam Map<String, String> map) {
		System.out.println(map);
		String json = adminService.getMemberList(map);
		return json;
	}
	
	@RequestMapping("mvmemberlist.kitri")
	public String memberListPage(@RequestParam Map<String, String> map) {
		return "admin/member/memberlist";
	}
	
}