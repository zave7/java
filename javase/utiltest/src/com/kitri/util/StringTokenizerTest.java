package com.kitri.util;

import java.util.StringTokenizer;
import java.util.UUID;

public class StringTokenizerTest {
	public static void main(String[] args) {
		String str = "hello java !!";
		StringTokenizer st = new StringTokenizer(str); // hello java !! 자를 준비가 끝났음
		int cnt = st.countTokens();
		System.out.println(cnt); // default는 공백을 이용한다.
		while(st.hasMoreTokens()) { //토큰 있냐 물어본다
			System.out.println(st.nextToken()); //다음 토큰을 얻어온다
		}
		
		str = "TO|안효인|안녕하세요";
		StringTokenizer st2 = new StringTokenizer(str, "|"); // hello java !! 자를 준비가 끝났음
		String protocol = st2.nextToken();
		String to = st2.nextToken();
		String msg = st2.nextToken();
		System.out.println("기능 : " +protocol+ "\n누구에게 : "+ to + "\n메세지 : " + msg);
		
		System.out.println(UUID.randomUUID());
	}
}
