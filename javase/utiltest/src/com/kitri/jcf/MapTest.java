package com.kitri.jcf;

import java.util.*;

public class MapTest {
	public static void main(String[] args) {
//		Map<String, PlayerDto> map = new HashMap<String, PlayerDto>(); // 같은 키 값으로 put하면 덮어 쓴다
		Map<String, PlayerDto> map = new Hashtable<String, PlayerDto>(); // 같은 키 값으로 put하면 덮어 쓴다
		map.put("DS24", new PlayerDto(24,"오재원", 4, 0.321));
		map.put("Ds9", new PlayerDto(9, "페르난데스", 3, 0.421));
		map.put("KW24", new PlayerDto(24, "박병호", 3, 0.431));
		map.put("HH19", new PlayerDto(9, "정근우", 7, 0.321));
		
		int size = map.size();
		System.out.println("등록 인원 : " + size);
		
		int number = 24;
		System.out.println("두산의 " + number + "번 선수의 정보!!");
		PlayerDto playerDto = map.get("DS" + number);
		System.out.println(playerDto);
		
	}
}
