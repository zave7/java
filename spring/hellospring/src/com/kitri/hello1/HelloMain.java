package com.kitri.hello1;

public class HelloMain {
	public static void main(String[] args) {
//		HelloServiceKor helloServiceKor = new HelloServiceKor();
//		String msg = helloServiceKor.helloKor("권영찬");
		HelloServiceEng helloServiceEng = new HelloServiceEng();
		String msg = helloServiceEng.helloEng("권영찬");
		System.out.println(msg);
	}
}