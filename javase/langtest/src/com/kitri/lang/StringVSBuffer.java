package com.kitri.lang;

public class StringVSBuffer {
	public static void main(String[] args) {
//		String str = "hello ";
//		long st = System.nanoTime();
//		for (int i = 0; i < 5000; i++) {
//			str += i;
//		}
//		System.out.println(System.nanoTime() - st);
		
		StringBuffer sb = new StringBuffer("hello");	//문자열을 더할때는 버퍼를 쓰는게 좋다
		long st = System.nanoTime();
		for (int i = 0; i < 5000; i++) {
			sb.append(i);
		}
		System.out.println(System.nanoTime() - st);
	}
}
//500  5배
//	1004547	938476
//	202385	203026


//5000 40배
//	1148558		1057789
//	40702452	42224347	41418016
