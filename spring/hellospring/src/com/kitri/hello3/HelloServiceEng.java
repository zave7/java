package com.kitri.hello3;

public class HelloServiceEng implements HelloService{
	
	public HelloServiceEng() {
		System.out.println("HelloServiceEng 생성자 호출!");
	}
	public String hello(String name) {
		return "Hello " + name + "!!";
	}
}