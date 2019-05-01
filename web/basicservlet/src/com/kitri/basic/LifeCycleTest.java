package com.kitri.basic;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/life")
public class LifeCycleTest extends HttpServlet {
	//이 서블릿 객체의 생성 행동 소멸
	private static final long serialVersionUID = 1L;
	public LifeCycleTest() {
		System.out.println("생성자 호출!");
	}
	@Override
	//웹에서 필요한 설정
	public void init() throws ServletException {
		System.out.println("init() 호출!");
	}
	//접속한 클라이언트 당 스레드가 발생한다
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("service() 호출!");
	}
	@Override
	public void destroy() {
		System.out.println("destroy() 호출!");
	}

}
