package com.kitri.lang;

public class StringTest1 {
	public static void main(String args[]) {
		String s1 = "java";
		String s2 = "java";
		String s3 = new String("java"); //  객체는 힙 영역에 생성되지만 리터럴 영역에 있는 주소를 참조한다
		String s4 = new String("java");
		if(s1 == s2)
			System.out.println("s1 주소값이 같다 s2");//o
		if(s1 == s3)
			System.out.println("s1 주소값이 같다 s3");//x
		if(s1 == s4)
			System.out.println("s1 주소값이 같다 s4");//x
		if(s2 == s3)
			System.out.println("s2 주소값이 같다 s3");//x
		if(s2 == s4)
			System.out.println("s2 주소값이 같다 s4");//x
		if(s3 == s4)
			System.out.println("s3 주소값이 같다 s4");//x 주소값을 비교한다
		System.out.println("----------------------------");
		
		if(s1.equals(s2)) //이거는 값 자체를 비교한다
			System.out.println("s1 문자열값이 같다 s2");//o
		if(s1.equals(s3))
			System.out.println("s1 문자열값이 같다 s3");//o
		if(s1.equals(s4))
			System.out.println("s1 문자열값이 같다 s4");//o
		if(s2.equals(s4))
			System.out.println("s2 문자열값이 같다 s3");//o
		if(s2.equals(s4))
			System.out.println("s2 문자열값이 같다 s4");//o
		if(s3.equals(s4))
			System.out.println("s3 문자열값이 같다 s4");//o 주소값을 비교한다
	}
} 
//힙에는 문자열을 저장하는 별도의 공간이 있다
//문자열을 생성할때 기존에 있는 값과 같은 값이 있는지 비교하고 없으면 생성 있으면 참조
//저장하는 영역 자체가 다르기 때문에 주소 값 비교 불가 
//스트링은 불변이다 새로만들어졌으면 만들어졌지 변하지 않는다