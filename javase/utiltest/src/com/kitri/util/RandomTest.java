package com.kitri.util;

import java.util.Random;

public class RandomTest {
	public static void main(String[] args) {
		Random random = new Random();
		boolean b = random.nextBoolean();
		System.out.println(b);
		double d = random.nextDouble();
		System.out.println(d);
		int i = random.nextInt(2);
		System.out.println(i);
	}
}
