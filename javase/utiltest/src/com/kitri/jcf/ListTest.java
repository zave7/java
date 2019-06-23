package com.kitri.jcf;

import java.util.ArrayList;
import java.util.List;

public class ListTest {
	public static void main(String[] args) {
		List<String> list  = new ArrayList<String>();
		System.out.println("리스트 사이즈 : " + list.size());
		list.add("응1");
		list.add("응2");
		list.add("정수빈");
		list.add("응4");
		System.out.println("리스트 사이즈 : " + list.size());
		System.out.println("두산의 타순");
		String name[] = list.toArray(new String[0]);
		String name1 = "정수빈";
		String name2 = "오재원";
		
		for (int i = 0; i < name.length; i++) {
			System.out.println(name[i]);
		}
		int size = list.size();
		for (int i = 0; i < size; i++) {
			if(list.get(i).equals(name1)) {
				System.out.println(name1 + "은 " + (i+1) + "번 타자 입니다");
				list.set(i, name2);
				System.out.println(name1 + "을 " + name2 + "으로 교체");
				break;
			}
		}
		for (int i = 0; i < size; i++) {
			System.out.println(list.get(i));
			
		}
//		for(String s : list) { // 향상된 for문
//			System.out.println(s);
//		}
		

	}
}
