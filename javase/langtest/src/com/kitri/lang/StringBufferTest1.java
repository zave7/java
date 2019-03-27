package com.kitri.lang;

public class StringBufferTest1 { //문자열 조작
	public static void main(String[] args) {
		System.out.println("\nStringBuffer-----");
		StringBuffer sb1 = new StringBuffer("hello"); 	//16자리의 임시저장공간 생성
		System.out.println(sb1);							//여유공간을 16칸을 만든다
		int cap = sb1.capacity(); 	// 공간용량 구하기 capacity()
		System.out.println("초기크기 : "+cap + " / 문자열 수 : " + sb1.length());
		sb1.append("java");			// 문자열 더하기 append()
		System.out.println(sb1);
		sb1.append("!!!");
		System.out.println(sb1);
		cap = sb1.capacity();
		System.out.println("초기크기 : "+cap + " / 문자열 수 : " + sb1.length());
		sb1.append("!!!!!!!!!!");
		System.out.println(sb1);
		cap = sb1.capacity();
		System.out.println("초기크기 : "+cap + " / 문자열 수 : " + sb1.length());//여유공간이 계속 생긴다
		
		sb1.insert(10, "***"); 		// 인덱스 10 부터 삽입 insert()
		System.out.println(sb1);
		sb1.delete(10, 12); 		// ~부터 ~전까지 지우기 delete()
		System.out.println(sb1);
		sb1.deleteCharAt(10);		// 인덱스 하나만 지우기 deleteCharAt()
		System.out.println(sb1);
		sb1.replace(5, 9, "자바"); 	// ~부터 ~전까지 교체 replace()
		System.out.println(sb1);
		sb1.reverse();
		sb1.reverse();
		System.out.println(sb1); 	// 문자열 뒤집기 영문한글 알아서 reverse()
		sb1.setCharAt(0, 'H');		// 몇번째의 문자를 바꿔라
		System.out.println(sb1);
		String s1 = new String(sb1);
		String s2 = sb1.toString();
		System.out.println(s2 + " + s2");
		
		String str = "hello 자바 !!";
		String findStr1 = "자바";
		String findStr2 = "오라클";
		String replaceStr = "java";
		StringBuffer rs = new StringBuffer(str);
		int start = str.indexOf(findStr1);
		if(start != -1) {
			for (int i = 0; i < args.length; i++) {
				
			}
			rs.replace(start, start + findStr1.length(), replaceStr);
		} else {
			System.out.println(findStr1 + " 은 없습니다");
		}
		System.out.println(rs);
		
		
		
		
		System.out.println("\nString-----");
		String s = "hello"; 		//이렇게 새로 만들어 지지 않는다
		s.concat("java");
		System.out.println(s);
		
	}
}
