package com.kitri.member.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kitri.member.model.MemberDetailDto;
import com.kitri.member.model.ZipcodeDto;
import com.kitri.member.model.dao.MemberDao;
import com.kitri.member.model.service.MemberServiceImpl;
import com.kitri.util.SiteConstance;

@WebServlet("/user")
public class MemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String act = request.getParameter("act");
		if("mvjoin".equals(act)) {
			response.sendRedirect("/membermvc/user/member/member.jsp");
		} else if("mvlogin".equals(act)) {
			response.sendRedirect("/membermvc/user/login/login.jsp");
		} else if("idcheck".equals(act)) {
			String sid = request.getParameter("sid");
			String resultXML = MemberServiceImpl.getMemberService().idCheck(sid);
			
			response.setContentType("text/xml;charset=utf-8");
			PrintWriter out = response.getWriter();
			out.println(resultXML);
		} else if("zipsearch".equals(act)) {
			System.out.println("들어옴");
			String doro = request.getParameter("doro");
			String resultXML = MemberServiceImpl.getMemberService().zipSearch(doro);
			
			response.setContentType("text/xml;charset=utf-8"); //xml은 무조건 utf-8
			PrintWriter out = response.getWriter();
			out.println(resultXML);
		} else if("register".equals(act)) {
			MemberDetailDto memberDetailDto = new MemberDetailDto();
			memberDetailDto.setName(request.getParameter("name"));
			memberDetailDto.setId(request.getParameter("id"));
			memberDetailDto.setPass(request.getParameter("pass"));
			memberDetailDto.setEmailId(request.getParameter("emailid"));
			memberDetailDto.setEmailDomain(request.getParameter("emaildomain"));
			memberDetailDto.setTel1(request.getParameter("tel1"));
			System.out.println("tel1 = "+memberDetailDto.getTel1());
			memberDetailDto.setTel2(request.getParameter("tel2"));
			memberDetailDto.setTel3(request.getParameter("tel3"));
			memberDetailDto.setZipcode(request.getParameter("zipcode"));
			memberDetailDto.setAddress(request.getParameter("address"));
			memberDetailDto.setAddressDetail(request.getParameter("address_detail"));
			int cnt = MemberServiceImpl.getMemberService().registerMember(memberDetailDto);
			System.out.println("cnt = " + cnt);
		}
		
			
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding(SiteConstance.ENCODE);
		doGet(request, response);
	}

}
