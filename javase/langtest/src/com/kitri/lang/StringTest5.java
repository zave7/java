package com.kitri.lang;

public class StringTest5 {
	public static void main(String[] args) {
		String str = "hello java";
		int x = str.indexOf('ㅑ');
		System.out.println(x);
		x = str.indexOf('l', 8); //없으면 -1 리턴 하는듯, 8부터 찾는다
		System.out.println(x);
		x = str.indexOf("java"); // java 가 몇번째 부터 시작하냐
		System.out.println(x);
		x = str.lastIndexOf('a'); //마지막에 나오는 a가 몇번째에 있냐
		System.out.println(x);
		
		String str2 = "";
		System.out.println(str2 + "의 길이 : " + str2.length());
		if(str2.isEmpty()) //문자열의 길이가 0일 경우 true리턴
			System.out.println("빈문자열이다");
		else 
			System.out.println("str2 == " + str2);
		
		String str3 = "  hello     . "; //문자열 앞뒤의 공백은 제거하는데 문자열 사이의 공백은 제거x
		System.out.println(str3 + "의 길이 : " + str3.length()); //trim 많이 쓴다
		System.out.println(str3.trim() + "의 공백 제거 후 길이 : " + str3.trim().length());
		
		String str4 = "jaba";
		System.out.println(str4 + "::::" +str4.replace('b', 'v')); //문자도 바꿀 수 있고 
		System.out.println(str4 + "::::" +str4.replace("jaba", "java")); 
		//문자열도 바꿀 수 있다 ( 버전 체크도 해봐야 한다) 1.4 미만의 버전은 문자열 바꾸는 기능이 없다
		System.out.println(str4 + "::::" +str4.replaceAll("jaba", "java")); 
		//문자열도 바꿀 수 있다 ( 버전 체크도 해봐야 한다)
		
		String str5 = "hello java !!";
		String s[] = str5.split("a");
		int len = s.length;
		for (int i = 0; i < len; i++) {
			System.out.println(s[i]);
		}
		
		System.out.println(str5.substring(6, 9)); //6부터 9 전까지
		
//		숫자 >> 문자열
		int num = 100;
		String sn1 = num + "";
		System.out.println(sn1 + 100);
		String sn2 = String.valueOf(num);
		System.out.println(sn2 + 100);
		String sn3 = Integer.toString(num);
		System.out.println(sn3 + 100);
		
//		문자열 >> 숫자
		String ns = "100";
		num = Integer.parseInt(ns);
		System.out.println(num + 100);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
}