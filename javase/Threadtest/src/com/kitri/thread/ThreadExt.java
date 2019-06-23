package com.kitri.thread;

public class ThreadExt extends Thread{ // 상속받거나 implements하는 방법
			//Ext는 다른 클래스를 상속받는 클래스임를 표현한 것
	String msg;
	public ThreadExt(String msg)  {
		this.msg = msg;
	}
	
	@Override
	public void run() {
		for (int i = 0; i < 500; i++) {
			System.out.println(msg);
		}
	}
}
