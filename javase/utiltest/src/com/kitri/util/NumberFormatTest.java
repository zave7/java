package com.kitri.util;

import java.text.DecimalFormat;
import java.text.Format;

public class NumberFormatTest {
	public static void main(String[] args) {
		double number = 25425.31623432;
//		1,234,325,425.32
		Format f = new DecimalFormat("#,###,###,###.00"); //샘플들을 보고 작성을 한다.
		System.out.println(f.format(number));
	}
}
