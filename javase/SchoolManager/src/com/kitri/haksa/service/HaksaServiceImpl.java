package com.kitri.haksa.service;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import com.kitri.haksa.dao.HaksaDao;
import com.kitri.haksa.data.HaksaDto;

public class HaksaServiceImpl implements HaksaService{

	private List<HaksaDto> list;
	private String job[] = {"학번", "과목", "부서"};
	private BufferedReader br;
	private HaksaDao haksaDao = new HaksaDao();
	public HaksaServiceImpl() {
		this.list = new ArrayList<HaksaDto>();
		this.br = new BufferedReader(new InputStreamReader(System.in));
	}
	
	@Override
	public void menu() {
		String inNum;
		char charNum;
		int intNum;
		String checkExit;
		while(true) {
			System.out.println("========== 메뉴 선택 ============");
			System.out.println("1. 등록\n2. 찾기\n3. 삭제\n4. 전체 출력\n-------------------\n0. 종료\n------------------" );
			System.out.print("번호를 선택해 주세요.. : ");
			try {
				while(true) {
					inNum = br.readLine();
					if(!inNum.isEmpty()) {
						charNum = inNum.charAt(0);
						if(inNum.length() == 1 && charNum>='0' && charNum<='4') {
							intNum = Integer.parseInt(inNum);
							break;
						}
					}
					System.out.print("0~4번 중 하나를 입력해주세요 : ");
				}
				switch(intNum) {
					case 0: processExit();
						break;
					case 1: registerMenu();
						break;
					case 2: findNameMenu();
						break;
					case 3: deleteMenu();
						break;
					case 4: selectAll();
						break;
				}
				System.out.print("계속 하시려면 1, 종료 하시려면 0을 입력해 주세요 : ");
				
				while(true) {
					checkExit = br.readLine();
					if(!checkExit.isEmpty()) {
						if(checkExit.equals("1")) {
							break;
						} else if (checkExit.equals("0")){
							processExit();
						}
					}
					System.out.print("1 또는 0을 입력해주세요 : ");
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void registerMenu() {
		String temp;
		int age;
		String name;
		String value;
		int inNum;
		
		try {
			System.out.println("========== 메뉴 선택 ============");
			System.out.println("1. 학생\n2. 교수\n3. 관리자\n4. 이전메뉴" );
			System.out.print("번호를 선택해 주세요.. : ");
			while(true) {
				
				temp = br.readLine();
				if(temp.length() == 1 && Character.isDigit(temp.charAt(0))) {
					inNum = Integer.parseInt(temp);
					break;
				}
				else {
					System.out.print("1~4번 중 하나를 입력해주세요");					
				}
			}
			while(true) {
				boolean check = true;
				System.out.print("나 이 : ");
				temp = br.readLine();
				int len = temp.length();
				for(int i=0; i<len; i++) {
					if(!Character.isDigit(temp.charAt(i))) {
						System.out.println("나이를 정확히 입력해주세요");
						check = false;
						break;
					}
				}
				if(check) {
					age = Integer.parseInt(temp);
					break;
				}
			}
			while(true) {
				boolean check = true;
				System.out.print("이 름 : ");
				temp = br.readLine();
				int len = temp.length();
				System.out.println("len : " + len);
				for(int i=0; i<len; i++) {
					if(Character.isDigit(temp.charAt(i))) {
						System.out.println("이름을 정확히 입력해주세요");
						check = false;
						break;
					}
				}
				if(check) {
					name = temp;
					break;
				}
			}
				System.out.print(job[inNum-1] + " : ");
				value = br.readLine();
				haksaDao.register(new HaksaDto(age, name, inNum, value));
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

//	@Override
//	public void register(HaksaDto haksa) {
//		list.add(haksa);
//		System.out.println("등록 되었습니다.");
//	}

	@Override
	public void findNameMenu() {
		String name;
		System.out.println("찾을 이름을 입력해 주세요.");
		System.out.print("이름 : ");
		try {
			while(true) {
				name = br.readLine();
				if(name.isEmpty())
					System.out.print("이름을 입력해주세요 : ");
				else
					break;
			}
			HaksaDto haksaDto = findName(name);
			if(haksaDto==null)
				System.out.println(name + " 이라는 사람은 없습니다.");
			else {
				System.out.println("나이 : " + haksaDto.getAge() + "\t\t이름 : " + haksaDto.getName()
									+ "\t\t" + job[haksaDto.getKey()] + " : " + haksaDto.getValue());
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public HaksaDto findName(String name) { // 리턴 타입이 HaksaDto 이기 때문에 이름이 같은 여러명을 불러올 수 는 없다
		int len = list.size();
		for(int i=0; i < len; i++) {
			if(list.get(i).getName().equals(name)) 
				return list.get(i);
		}
		return null;
	}

	@Override
	public void deleteMenu() {
		String name;
		System.out.println("삭제할 사람의 이름을 입력해 주세요.");
		System.out.println("이름 : ");
		try {
			name = br.readLine();
			int i;
			i = delete(name);
			if(i==1)
				System.out.println(name+"님을 삭제 하였습니다");
			else
				System.out.println(name+"님은 등록되어 있지 않습니다");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public int delete(String name) {
		int len = list.size();
		for(int i=0; i < len; i++) {
			if(list.get(i).getName().equals(name)) { 
				list.remove(i);
				return 1;
			}
		}
		return 0;
	}

	@Override
	public void selectAll() {
		int len = list.size();
		if(len==0) {
			System.out.println("등록 되어있는 사람이 없습니다.");
		} else {
			for (int i = 0; i < len; i++) {
				System.out.println("이름 : " + list.get(i).getName() + "\t나이 : " + list.get(i).getAge()
									+"\t" + job[list.get(i).getKey()] + " : " + list.get(i).getValue());
			}
		}
	}

	@Override
	public void processExit() {
		System.out.println("종료되었습니다");
		System.exit(0);
	}

}
