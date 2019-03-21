package com.kitri.test;

import com.kitri.car.Car;

public class CarUser {
	public static void main(String[] args) {
		Car car = new Car("쏘나타", "검정색", "현대");

		System.out.println("이름 : " + car.getName());
		System.out.println("이름 : " + car.getColor());
		System.out.println("이름 : " + car.getMaker());
		car.setColor("빨강");
		System.out.println("이름 : " + car.getColor());
		System.out.println(car);
	}
}
//이클립스 단축키 Alt 아래 또는 위방향키