package com.kitri.question.classQ;

public class MemberService {
	boolean login(String id, String password) {
		if(id.equals("hong") && password.equals("1234"))
			return true;
		else
			return false;
	}
	void logout(String id) {
		System.out.println("로그아웃 되었습니다");
	}
}
