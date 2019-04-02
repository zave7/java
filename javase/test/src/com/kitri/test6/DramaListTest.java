package com.kitri.test6;

import java.util.ArrayList;
import java.util.List;

public class DramaListTest {
	public static void main(String[] args) {
		Drama d1 = new Drama("그 겨울, 바람이 분다.", "SBS", "김규태", "조인성", "송혜교");
		Drama d2 = new Drama("백년의 유산.", "MBC", "주성우", "", "");
		Drama d3 = new Drama("아이리스2.", "KBS", "표민수", "장혁", "이다혜");
		Drama d4 = new Drama("최고다 이순신", "KBS", "윤성식", "", "아이유");
		
		List<Drama> list = new ArrayList<Drama>();
		list.add(d1);
		list.add(d2);
		list.add(d3);
		list.add(d4);
		int size = list.size();
		System.out.println("<< ArrayList를 이용한 드라마정보 >> ");
		for (int i = 0; i < size; i++) {
			System.out.println((i+1) + ". " + list.get(i)+"\n");
		}
		
	}
}
