package com.kitri.io2;

import java.io.IOException;

public class StdInOutTest {
	public static void main(String[] args) {
		System.out.print("입력1 : ");
			try {
//				int x = System.in.read(); 	//엔터 누를 때 까지 대기한다
//											// read는 입력한 캐릭터의 제일 앞의 아스키 코드를 받는다
//											// 한글 못받음 byteStream만 처리한다 1byte만!!!
//				System.out.println(x);
//				
//				System.out.print("입력2 : ");
				byte b[] = new byte[100];
				int x = System.in.read(b); // 
				System.out.println(x); //
				int len = b.length;
				for (int i = 0; i < len; i++) {
					System.out.println(b[i]);
				}
				String s = new String(b, 0, x-2);
			} catch (IOException e) {
				e.printStackTrace();
			} // tasks 에서 주석에 TODO 한 부분을 바로 찾아갈 수 있다 
		System.out.println();
	}
}
