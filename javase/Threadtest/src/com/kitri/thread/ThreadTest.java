package com.kitri.thread;

public class ThreadTest {
	public static void main(String[] args) {
		Thread t1 = new ThreadExt("퐁");
		Thread t2 = new ThreadExt("당");
		Thread t3 = new ThreadExt("!!");
		
//		t1.run(); //스레드가 가지고 있는 run을 직접 호출하면 일반 메소드가 돼버린다
//		t2.run();
//		t3.run();
		t1.start(); //스케줄링을 하고 실행한다
		t2.start();
		t3.start();
		
		System.out.println("프로그램 종료");
		System.out.println("프로그램 종료222");
	}
}