package com.kitri.excetion.runtime;

public class IndexBoundsTest {
	public static void main(String[] args) {
		String s[] = {"1", "2", "3", "4"};
//		for (int i = 0; i <= 4; i++) {
//			System.out.println(s[i]);// java.lang.ArrayIndexOutOfBoundsException 발생
//		}
		int len = s.length;
		for (int i = 0; i < len; i++) {
			System.out.println(s[i]); // 발생할 일이 없다
		}
		String str = "hell";
		for (int i = 0; i < 5; i++) {
			System.out.println(str.charAt(i));	//java.lang.StringIndexOutOfBoundsException 발생
		}
		
		len = str.length();
		for (int i = 0; i < 5; i++) {
			System.out.println(str.charAt(i));	//java.lang.StringIndexOutOfBoundsException 발생 X 
		}
	}
}
