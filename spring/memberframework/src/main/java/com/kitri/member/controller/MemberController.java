package com.kitri.member.controller;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.context.annotation.SessionScope;

import com.kitri.member.model.MemberDetailDto;
import com.kitri.member.model.MemberDto;
import com.kitri.member.model.service.MemberService;

@Controller
@RequestMapping("/user")
@SessionAttributes("userInfo")//1개 쓸때
//@SessionAttributes(names = {"",""})//여러개개 쓸때
//model 이나 ModelAndView 에 담을때 이름을 지정한다. 지정한 이름으로 담는 객체는 request가 아니라 session에 담기기 된다
public class MemberController {
	
	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);
	
	@Autowired
//	@Qualifier("Impl1")
	private MemberService memberService;
	
	@RequestMapping(value = "/register.kitri", method = RequestMethod.GET)
	public String register() {
		return "user/member/member";
	}
	
	@RequestMapping(value = "/register.kitri", method = RequestMethod.POST)
	public String register(MemberDetailDto memberDetailDto, Model model) {
		int cnt = memberService.registerMember(memberDetailDto);
		if(cnt != 0) {
			model.addAttribute("registerInfo", memberDetailDto);
			return "user/member/registerok";
		}
		return "user/member/registerfail";
	}
	
	@RequestMapping(value = "/idcheck.kitri", method = RequestMethod.GET)
//	@ResponseBody
	public @ResponseBody String idcheck(@RequestParam(name = "checkid", defaultValue = "") String id) {
		logger.info("검색 아이디 : " + id);
		String json = memberService.idCheck(id);
//		@ResponseBody 리턴 타입의 스트링이 응답 해줄 데이터 이다
		return json;// /WEB_INF/views/{"idcount" : 0}.jsp
	}
	
	@RequestMapping(value = "/zipsearch.kitri", method = RequestMethod.GET)
	@ResponseBody
	public String zipSearch(@RequestParam("doro") String doro) {
		logger.info("검색 도로명 : " + doro);
		String json = memberService.zipSearch(doro);
//		@ResponseBody 리턴 타입의 스트링이 응답 해줄 데이터 이다
		return json;
	}
	
	@RequestMapping(value = "/login.kitri", method = RequestMethod.GET)
	public String login() {
		return "user/login/login";
	}
	
//	@RequestMapping(value = "/login.kitri", method = RequestMethod.POST)
//	public String login(@RequestParam("id") String id, @RequestParam("pass") String pass, HttpSession session) {//인터셉터
//		MemberDto memberDto = memberService.loginMember(id, pass);
//		if(memberDto != null) {
//			//세션 필요
//			session.setAttribute("loginInfo", memberDto);
//			return "user/login/loginok";
//		} else {
//			return "user/login/loginfail";
//		}
//	}
	
	@RequestMapping(value = "/login.kitri", method = RequestMethod.POST)
	public String login(@RequestParam Map<String, String> map, Model model) {//인터셉터 //map 이 모델과 같이 넘겨줄 데이터를 담는 model이 된다.
						//이제 파라미터를 담는 map 객체가 된다.
		MemberDto memberDto = memberService.loginMember(map); // key는 파라미터 이름으로 저장된다. 
		if(memberDto != null) {
			//세션 필요
			model.addAttribute("userInfo", memberDto);
			return "user/login/loginok";
		} else {
			return "user/login/loginfail";
		}
	}
	
//	@RequestMapping("/logout")
//	public String logout(HttpSession session) {
//		session.removeAttribute("userInfo");
//		return "redirect:/index.jsp"; //redirect: prefix 지정해주면 리다이렉트 한다.
//	}
	
	@RequestMapping("/logout.kitri")
	public String logout(@ModelAttribute("userInfo") MemberDto memberDto, SessionStatus sessionstatus) {
							// 세션에 있는 어트리뷰트를 가져온다
							// 그냥 MemberDto memberDto 만 쓰면 스프링이 객체를 만들어준다.
							// 해당하는 값이 없을 경우 HttpSessionRequiredException 발생
			sessionstatus.setComplete(); // invalidate 와 같은 기능을 한다.
			return "redirect:/index.jsp"; //redirect: prefix 지정해주면 리다이렉트 한다.
	}
}












