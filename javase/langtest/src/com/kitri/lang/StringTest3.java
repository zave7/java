package com.kitri.lang;

public class StringTest3 {
	public static void main(String[] args) {
		String str = "hello java !!!";
		char c = str.charAt(4);
		System.out.println("c = " + c);

		str = "123";
		int x = str.charAt(0) - 48;
		System.out.println("x == " + x);

		str = "-10";
		int len = str.length();
		System.out.println("lenght == " + len);
		boolean checkNum = true;
		for (int i = 0; i < len; i++) {
			if (str.charAt(i) > 57 || str.charAt(i) < 48) {
				System.out.println(str + " 은 숫자가 아닙니다");
				checkNum = false;
				break;
			}
		}
		if (checkNum)
			System.out.println(str + " 은 숫자입니다");
		String str1 = "hello";
		String str2 = "java";
		System.out.println(str1.concat(str2));
		
		str = "hello java !!!";
		if(str.startsWith("he")) 
			System.out.println(str + " h로 시작한다");
		if(str.endsWith("!"))
			System.out.println("!로 끝난다");
		
		String s1 = "jAva";
		String s2 = "JaVa";
		System.out.println("s1.upperCace() == " + s1.toUpperCase());
		System.out.println("s1.upperCace() == " + s1.toLowerCase());
		
		if(s1.equals(s2))
			System.out.println("s1과 s2는 같은 문자열이다");
		else
			System.out.println("다른문자열이다");
		if(s1.equalsIgnoreCase(s2))
			System.out.println(s1 + "과 " + s2 + "는 대소문자 구분없이 같은문자열이다");
		else 
			System.out.println(s1 + "과 " + s2 + "는 대소문자 구분없이 다른문자열이다");
		
		
	}

}