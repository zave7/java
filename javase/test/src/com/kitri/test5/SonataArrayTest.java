package com.kitri.test5;

import java.util.ArrayList;
import java.util.List;

public class SonataArrayTest {
	public static void main(String[] args) {
		Car car1 = new Sonata("흰색", 5000, "NF", "승용");
		Car car2 = new Sonata("은색", 7000, "Brilliant", "업무");
		Car car3 = new Sonata("감홍색", 4000, "EF", "택시");
		Car car4 = new Sonata("검정색", 6000, "Hybrid", "승용");
		Car carList[] = new Car[4];
		carList[0] = (car1);
		carList[1] = (car2);
		carList[2] = (car3);
		carList[3] = (car4);
		int size = 4;
		for (int i = 0; i < size; i++) {
			System.out.println(carList[i]);
		}
	}
}