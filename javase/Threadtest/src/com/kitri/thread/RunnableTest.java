package com.kitri.thread;

public class RunnableTest {
	public static void main(String[] args) {
		Thread t1 = new Thread(new RunnableImpl("퐁"));//내가 호출해야하는 메소드가 어디있냐
		Thread t2 = new Thread(new RunnableImpl("당"));
		Thread t3 = new Thread(new RunnableImpl("!!!"));
		
		System.out.println("testsetsetsetestsetsetse");
		System.out.println("testsetsetsetestsetsetse");
		System.out.println("testsetsetsetestsetsetse");
		System.out.println("testsetsetsetestsetsetse");
		System.out.println("testsetsetsetestsetsetse");
		System.out.println("testsetsetsetestsetsetse");
		System.out.println("testsetsetsetestsetsetse");
		t1.start();
		t2.start();
		t3.start();
		System.out.println("123123123123123123123");
		System.out.println("123123123123123123123");
		System.out.println("123123123123123123123");
		System.out.println("123123123123123123123");
		System.out.println("123123123123123123123");
		System.out.println("123123123123123123123");
	}
}
