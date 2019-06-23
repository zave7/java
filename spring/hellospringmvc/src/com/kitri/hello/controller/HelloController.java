package com.kitri.hello.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.kitri.hello.model.service.HelloService;

@Controller
public class HelloController {
	
	private HelloService helloService;
	
	public void setHelloService(HelloService helloService) {
		this.helloService = helloService;
	}

	@RequestMapping("/hello.kitri")
	public ModelAndView greeting() {
		ModelAndView mav = new ModelAndView();
		String msg = helloService.hello("권영찬");
		mav.addObject("msg", msg); // request.setAttribute
		mav.setViewName("result"); // ViewResolver 가 prefix와 suffix를 붙여 준다.
		return mav;
	}
}
