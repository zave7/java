package com.kitri.jdbctest;

public class DriverLoadingTest {
	
	public DriverLoadingTest() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
//			classnotfoundexception이 발생할수 있는 경우
//			1. 경로 오타
//			2. 클래스파일이 해당 경로에 없는 경우
			System.out.println("Driver Loading Success!!");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		new DriverLoadingTest();
	}
}
