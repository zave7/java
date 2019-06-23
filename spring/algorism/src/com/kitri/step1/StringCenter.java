package com.kitri.step1;

public class StringCenter {
	
	public static void main(String[] args) {
		StringCenter center = new StringCenter();
		System.out.println(3-0.5);
	}

	public String solution(String s) {
		int len = s.length();
		if(len%2 == 0) {
			s = s.substring((len/2-1), len/2+1);
		} else {
			s = s.substring(len/2, len/2+1);
		}
		System.out.println(s.substring((len/2-1), len/2+1));
		System.out.println(3-1.5);
		return s;
	}
}
