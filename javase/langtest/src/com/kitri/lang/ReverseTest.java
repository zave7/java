package com.kitri.lang;

public class ReverseTest {
	public static void main(String[] args) {
		String str = "!!! avajjj olleh";
//		Hello Java !!! 최소 3개 만들기
//		--------------------------------------------------------------------------------
//		int len = str.length() - 1;					//새로운 char 배열에  str.charAt() 이용
//		char cpStr[] = new char[str.length()];
//		for (int i = 0; i < str.length(); i++) {
//			cpStr[i] = str.charAt(len);
//			len--;
//		}
//		str = String.valueOf(cpStr);
//		System.out.println(str);
//		System.out.println("e는 " + (str.indexOf('e')+1) + "번째에 있습니다");
//		--------------------------------------------------------------------------------
//		String cpStr = "";								//새로운 String에 str.charAt() 이용
//		int len = str.length() - 1;					
//		for (int i = len; i >= 0; i--) {
//			cpStr += str.charAt(i);
//		}
//		str = cpStr;
//		System.out.println(str);
//		
//		System.out.println("e는 " + (str.indexOf('e')+1) + "번째에 있습니다");
//		--------------------------------------------------------------------------------
//		char temp;
//		char cpStr[] = str.toCharArray();			//새로운 char 배열에 str.toCharArray() 이용
//		int len = cpStr.length - 1;
//		for (int i = 0; i <= len; i++) {	
//			temp = cpStr[i];
//			cpStr[i] = cpStr[len-i];
//			cpStr[len-i] = temp;
//			if(len-i*2 <= 2) //len-i-i <= 2
//				break;
//		}
//		str = String.valueOf(cpStr);
//		System.out.println(str);
//		System.out.println("e는 " + (str.indexOf('e')+1) + "번째에 있습니다");
//		--------------------------------------------------------------------------------
		byte temp;
		byte cpStr[] = str.getBytes();			//새로운 byte 배열에 str.getBytes() 이용
		int len = cpStr.length - 1;				//한글일 경우 깨진다
		for (int i = 0; i <= len; i++) {		
			temp = cpStr[i];
			cpStr[i] = cpStr[len-i];
			cpStr[len-i] = temp;
			if(len-i*2 <= 2) //len-i-i <= 2
				break;
		}
		str = new String(cpStr);
		System.out.println(str);
		System.out.println("e는 " + (str.indexOf('e')+1) + "번째에 있습니다");
//		e는 2번째 있습니다
	}
}