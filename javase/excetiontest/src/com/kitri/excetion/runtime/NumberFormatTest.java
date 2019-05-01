package com.kitri.excetion.runtime;

public class NumberFormatTest {
	public static void main(String[] args) {
		String s = " 123";
//		try {
//			int x = Integer.parseInt(s);
//			System.out.println(x + 100);
//		} catch(NumberFormatException e) {
//			System.out.println("숫자가 아닙니다");
//		}
		if(isNumber(s)) { // 로직적으로 NumberFormatException이 발생하지 않도록 해야한다
			int x = Integer.parseInt(s);
			System.out.println(x + 100);
		} else {
			System.out.println("숫자가 아닙니다");
		}
	}
	
	private static boolean isNumber(String str) {
		boolean flag = true;
		int len = str.length();
		for (int i = 0; i < len; i++) {
			if (str.charAt(i) > 57 || str.charAt(i) < 48) {
				System.out.println(str + " 은 숫자가 아닙니다");
				flag = false;
				break;
			}
		}
		return flag;
	}
}
