package com.kitri.hello2;

public class HelloMain {
	public static void main(String[] args) {
//		HelloServiceKor helloServiceKor = new HelloServiceKor();
//		String msg = helloServiceKor.helloKor("권영찬");
		HelloService helloService = new HelloServiceEng();
		String msg = helloService.hello("권영찬");
		System.out.println(msg);
	}
}