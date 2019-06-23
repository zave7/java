package com.kitri.member.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import com.kitri.member.model.service.MemberServiceImpl;
import com.kitri.util.MoveUrl;
import com.kitri.util.SiteConstance;

@WebServlet("/user")
public class MemberFrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Override
	public void init() {
		System.out.println("user 서블릿 생성!!@");
	}
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String act = request.getParameter("act");
		
		System.out.println("act = " + act);
		String path = "/index.jsp";
		if("mvjoin".equals(act)) {
			MoveUrl.redirect(request, response, "/user/member/member.jsp");
		} else if("mvlogin".equals(act)) {
			MoveUrl.redirect(request, response, "/user/login/login.jsp");
		} else if("idcheck".equals(act)) {
			String sid = request.getParameter("sid");
			String resultXML = MemberServiceImpl.getMemberService().idCheck(sid);
			
			response.setContentType("text/xml;charset=utf-8");
			PrintWriter out = response.getWriter();
			out.println(resultXML);
			System.out.println(resultXML);
		} else if("zipsearch".equals(act)) {
			System.out.println("들어옴");
			String doro = request.getParameter("doro");
			String resultXML = MemberServiceImpl.getMemberService().zipSearch(doro);
			
			response.setContentType("text/xml;charset=utf-8"); //xml은 무조건 utf-8
			PrintWriter out = response.getWriter();
			out.println(resultXML);
		} else if("register".equals(act)) {
			path = MemberController.getMemberController().register(request, response);
			MoveUrl.forward(request, response, path);
		} else if("logout".equals(act)) {
			path = MemberController.getMemberController().logout(request, response);
			MoveUrl.redirect(request, response, path);
		} else if("login".equals(act)) {
			path = MemberController.getMemberController().login(request, response);
			MoveUrl.forward(request, response, path);
		} else if("mvmodify".equals(act)) {
			path = MemberController.getMemberController().getMember(request, response);
			MoveUrl.forward(request, response, path);
		} else if("submitUserInfo".equals(act)) {
			MemberController.getMemberController().userInfoModify(request, response);
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding(SiteConstance.ENCODE);
		response.setCharacterEncoding(SiteConstance.ENCODE);
		doGet(request, response);
	}

}
