package com.kitri.lang;

import java.io.UnsupportedEncodingException;

public class StringTest2 {
	public static void main(String[] args) throws UnsupportedEncodingException {
//		String str = null;
//		System.out.println("\n");
		String str1 = new String();//비어있는 문자열을 만든다
		System.out.println("\nString()");
		System.out.println("new String() 문자열 길이 = " + str1.length());
		//엄청나게 중요하다!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
		System.out.println("\nString(byte[] bytes, String charsetName)");
//		byte b[] = {97, 98, 99, 100};
		byte b[] = {-66, -56, -77, -25, -57, -49, -68, -68, -65, -28, 46}; //완성형 한글
		String str2 = new String(b);
//		String str2 = new String(b, "euc-kr") // 디폴트 옵션
		System.out.println(str2);
		
		byte b2[] = {-20, -107, -120, -21, -123, -107, -19, -107, -104, -20, -124, -72, -20, -102, -108, 46};
		String str3 = new String(b2, "utf-8"); //전세계 모든문자 처리 3byte 글자를 그린다
		System.out.println(str3);
		
		System.out.println("\nString(byte[] bytes, int offset, int length)");
		byte b3[] = {97, 98, 99, 100, 101, 102, 103, 104};
		String str4 = new String(b3, 2, 4); //배열의 시작과 끝을 지정해서 가져온다
		System.out.println(str4);
		
		System.out.println("\nString(char[] value)");
//		char c[] = {'a', 'b', 'c', 'd', 'e', 'f'};
		char c[] = {'안', '녕', '하', '세', '요', '.'};
		String str5 = new String(c);
		System.out.println(str5);
		
		String str6 = new String(c, 2, 4);
		System.out.println(str6);
		
	}
}
