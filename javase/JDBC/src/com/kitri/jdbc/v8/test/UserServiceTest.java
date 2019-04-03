package com.kitri.jdbc.v8.test;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.kitri.jdbc.v8.dto.UserDto;
import com.kitri.jdbc.v8.service.UserService;

public class UserServiceTest {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {

		UserService userService = new UserService();
		List<UserDto> list = new ArrayList<UserDto>();
		list = userService.getAllUser();
		for(UserDto user : list) {
			System.out.println("유저 아이디 : " + user.getId() + "유저 비밀번호 : " + user.getPassword()
								+ "유저 이름 " + user.getName());
		}
		// dao의 메소드를 활용하여 비즈니스 로직을 구현
//		user.setId("new1234");
//		user.setName("testname");
//		user.setPassword("testpass");
//
//		userService.addUser(user);
//		System.out.println("마침");
//		User resultUser;
//		resultUser = userService.getUser("new123");
//		System.out.println(resultUser);
	}
}