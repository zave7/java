package com.kitri.util;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class CalendarTest {
	public static void main(String[] args) {
		Calendar cal = new GregorianCalendar();
		int y = cal.get(Calendar.YEAR);
		int m = cal.get(Calendar.MONTH);
		int d = cal.get(Calendar.DAY_OF_MONTH);
		int h = cal.get(Calendar.HOUR);
		int mi = cal.get(Calendar.MINUTE);
		int s = cal.get(Calendar.SECOND);
		System.out.println(plusZero(y)+ "년 " + plusZero(m)+ "월 "+ plusZero(d)+ "일 "+ plusZero(h)+ "시 "
								+ plusZero(mi)+ "분 "+ plusZero(s)+ "초 ");
		//2019년 03월 06일 오후 01시 07시 05초
		
		Date date = new Date();
		System.out.println(date);
	}
	private static String plusZero(int x) {
		return x < 10 ? "0"+x : x+"";
	}
}