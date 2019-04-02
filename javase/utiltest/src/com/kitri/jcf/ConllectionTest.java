package com.kitri.jcf;

import java.util.*;

public class ConllectionTest {
	public static void main(String[] args) {
//		Collection coll = new HashSet();
		Collection coll = new ArrayList();
		System.out.println("초기 크기 :" + coll.size());
		coll.add("test1");
		coll.add("test2");
		coll.add("test3");
		coll.add("test4");
		coll.add("test4");
		Object s[] = coll.toArray();
		for (int i = 0; i < s.length; i++) {
			System.out.println((String)s[i]);
		}
		System.out.println("마지막 크기 : " + coll.size());
	}
}