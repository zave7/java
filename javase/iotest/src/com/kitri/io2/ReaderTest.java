package com.kitri.io2;

import java.io.*;

public class ReaderTest {
	public static void main(String[] args) {
		Reader in = null;
		try {
			in = new InputStreamReader(System.in);// 항상 어디서 읽어 들일꺼냐가 온다 여기서는 시스템에서 읽어 들일꺼라서
			// 시스템.인 을 쓴다
			char c[] = new char[100];
			System.out.print("입력 : ");
//			int x = in.read();  // 맨 첫번째문자를 char로 받아들이고 아스키 코드 리턴 (c[]에 char형으로 입력된 값을 집어 넣는다)
			int x = in.read(c); // 엔터는 \n \r 이라서 문자의 갯수 + 2 가 리턴 된다 (c[]에 char형으로 입력된 값을 집어 넣는다)
			System.out.println(" x = " + x);
			
			int len = c.length;
			for (int i = 0; i < len; i++) {
				System.out.println(c[i]);
			}
			
			String str = new String(c, 0, x-2);
			System.out.println(str);
			
		} catch (IOException e) {
			e.printStackTrace();
		} // Reader라서 char[] 가져간다
	}
}
