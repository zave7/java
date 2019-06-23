package com.kitri.array;

public class ArrayTest1 {
	public static void main(String args[]) {
		int x1 = 10;
		int x2 = 20;
		int x3 =30;
		System.out.println("x1 = " + x1 + " x2 = " + x2 + " x3 = " + x3);
		
		int x[] = new int[3];
		x[0]=1;
		x[1]=2;
		x[2]='\u0000';
		
		System.out.println(x[0] + x[1]+ x[2]);
		System.out.println(x.length);
	}
	
}
