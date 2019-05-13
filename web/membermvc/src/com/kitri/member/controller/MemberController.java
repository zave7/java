package com.kitri.member.controller;

import javax.servlet.http.*;

import com.kitri.member.model.MemberDetailDto;
import com.kitri.member.model.MemberDto;
import com.kitri.member.model.service.MemberServiceImpl;

public class MemberController {
	
	private static MemberController memberController;
	
	static {
		memberController = new MemberController();
	}
	
	private MemberController() {
	}
	
	public static MemberController getMemberController() {
		return memberController;
	}
	
	public String register(HttpServletRequest request, HttpServletResponse response) {
		String path = "index.jsp";
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
		if(cnt != 0) {
			System.out.println("레지스터 메소드");
			request.setAttribute("userInfo", memberDetailDto);
			path = "/user/member/registerok.jsp";
		} else {
			path = "/user/member/registerfail.jsp";
		}
		return path;
	}

	public String login(HttpServletRequest request, HttpServletResponse response) {
		String path = "index.jsp";
		String id = request.getParameter("id");
		String pass = request.getParameter("pass");
		
		MemberDto memberDto = MemberServiceImpl.getMemberService().loginMember(id, pass);
		if(memberDto != null) {
			/////////////////////Cookie///////////////////////
			String idsave = request.getParameter("idsave");
			if("idsave".equals(idsave)) {
				Cookie cookie = new Cookie("kid_inf", id); //쿠키는 여러개 가능
				cookie.setDomain("localhost"); // 도메인
				cookie.setPath(request.getContextPath()); // 프로젝트 컨텍스트 패스
				//마지막으로 엑세스는 브라우져가 우리는 만료날짜만
				cookie.setMaxAge(60*60*24*365*50);
				response.addCookie(cookie); // 서버에서 만들어서 들어온 친구한테 주자
				
//				Cookie cookie2 = new Cookie("kid_inf", id);
//				cookie.setDomain("localhost");
//				cookie.setPath(request.getContextPath());
//				cookie.setMaxAge(60*60*24*365*50);
//				response.addCookie(cookie);
			} else {
				Cookie[] cookie = request.getCookies();
				if(cookie != null) {
					for(Cookie c : cookie) {
						if("kid_inf".equals(c.getName())) {
							c.setDomain("localhost"); // 도메인
							c.setPath(request.getContextPath()); // 프로젝트 컨텍스트 패스
							//마지막으로 엑세스는 브라우져가 우리는 만료날짜만
							c.setMaxAge(0);
							response.addCookie(c); // 서버에서 만들어서 들어온 친구한테 주자
							break;
						}
					}
				}
			}
			//////////////////////////////////////////////////
			
			/////////////////////Session//////////////////////
			HttpSession session = request.getSession();
			session.setAttribute("userInfo", memberDto);
			//////////////////////////////////////////////////
			path = "/user/login/loginok.jsp";
		} else {
			path = "/user/login/loginfail.jsp";
		}
		return path;
	}

	public String logout(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
//		session.setAttribute("userInfo", null);
//		session.removeAttribute("userInfo");
		session.invalidate();//세션안의 전부를 지운다
		//세션을 마지막으로 접근한 시간을 기준으로 카운트다운이 된다
		return "/user/login/login.jsp";
	}

	public String getMember(HttpServletRequest request, HttpServletResponse response) {
		String path = "";
		HttpSession session = request.getSession();
		//1. 아이디 정보 get
		//2. dao 호출 return type -> MemberDetail 
		MemberDetailDto memberDetailDto = MemberServiceImpl.getMemberService().getMember(((MemberDto)(session.getAttribute("userInfo"))).getId());
		//3. request에 넣고 페이지 이동
		if(memberDetailDto != null) {
			request.setAttribute("userInfo", memberDetailDto);
			path = "/user/member/membermodify.jsp";
		} else {
			path = "/user/member/membermodifyfail.jsp";
		}
		return path;
	}
}












