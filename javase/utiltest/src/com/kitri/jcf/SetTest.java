package com.kitri.jcf;

import java.util.*;

public class SetTest {
	public static void main(String[] args) {
		Set<String> set = new HashSet<String>();
		set.add("황선혜");
		set.add("박미래");
		set.add("이혜린");
		set.add("조윤영");
		set.add("조윤영");
		System.out.println("set 의 크기 : " + set.size());
		String s[] = set.toArray(new String[0]); // toArray에는 배열의 타입을 가져가는데 new String[0]
		for (int i = 0; i < set.size(); i++) {
			System.out.println(s[i]);
		}
		System.out.println("---------------------");
		Iterator<String> iterator = set.iterator();
		while(iterator.hasNext()) {
			System.out.println(iterator.next());
		}
	}

}
