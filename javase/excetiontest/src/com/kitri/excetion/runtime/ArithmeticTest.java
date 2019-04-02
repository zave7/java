package com.kitri.excetion.runtime;

import java.util.Random;

public class ArithmeticTest {
	public static void main(String[] args) {
		Random random = new Random();	// java.lang.ArithmeticException 발생
		int x = 30;
////		RuntimeException은 Logic으로 처리해야 합니다
//		int y = random.nextInt(5);		
//		try {
//			int z = x / y;
//		} catch(ArithmeticException e) {
//			System.out.println(e.getMessage()); // 왜 에러가 났는지
//			System.out.println("0으로 나눌 수 없습니다");
//		}
		
		// 1.
//		int y = random.nextInt(4)+1;
//		int z = x / y;
//		if(y!=0)
//			System.out.println("x 나누기 y = " + z);
//		else
//			System.out.println("0으로 나눌 수 없습니다");
		
		
		
		int y = random.nextInt(4+1);
		int z = x / y;
			System.out.println("x 나누기 y = " + z);
	}
}
