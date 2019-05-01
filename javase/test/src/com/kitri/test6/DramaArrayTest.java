package com.kitri.test6;

import java.util.ArrayList;
import java.util.List;

public class DramaArrayTest {
	public static void main(String[] args) {
		TVProgram d1 = new Drama("그 겨울, 바람이 분다.", "SBS", "김규태", "조인성", "송혜교");
		TVProgram d2 = new Drama("백년의 유산.", "MBC", "주성우", "", "");
		TVProgram d3 = new Drama("아이리스2.", "KBS", "표민수", "장혁", "이다혜");
		TVProgram d4 = new Drama("최고다 이순신", "KBS", "윤성식", "", "아이유");
		
		TVProgram list[] = new Drama[4];
		list[0] = d1;
		list[1] = d2;
		list[2] = d3;
		list[3] = d4;

		int size = list.length;
		System.out.println("<< 배열를 이용한 드라마정보 >> ");
		for (int i = 0; i < size; i++) {
			System.out.println((i+1) + ". " + list[i]+"\n");
		}
		
	}
}