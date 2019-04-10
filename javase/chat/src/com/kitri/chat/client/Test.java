package com.kitri.chat.client;

import java.util.ArrayList;
import java.util.List;

class Test2 {
	int n = 1;
}
public class Test {
	public static void main(String[] args) {
		List<Test2> list = new ArrayList<Test2>();
		Test2 test2 = new Test2();
		list.add(test2);
		for(Test2 t2 : list) {
			System.out.println(t2.n);
			t2.n = 2;
			System.out.println(t2.n);
		}
	}
}
