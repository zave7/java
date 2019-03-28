package com.kitri.jdbc.v7;

import java.sql.SQLException;

public class UserServiceTest {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {

		UserService userService = new UserService();
		User user = new User();
		// dao의 메소드를 활용하여 비즈니스 로직을 구현
		user.setId("testid");
		user.setName("testname");
		user.setPassword("testpass");

		userService.add(user);
	}
}