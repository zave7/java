package com.kitri.lang;

public class StringTest3 {
	public static void main(String[] args) {
		String str = "hello java !!!";
		char c = str.charAt(4);
		System.out.println("c = " + c);

		str = "123";
		int x = str.charAt(0) - 48;
		System.out.println("x == " + x);

		str = "-10";
		int len = str.length();
		System.out.println("lenght == " + len);
		boolean checkNum = true;
		for (int i = 0; i < len; i++) {
			if (str.charAt(i) > 57 || str.charAt(i) < 48) {
				System.out.println(str + " �� ���ڰ� �ƴմϴ�");
				checkNum = false;
				break;
			}
		}
		if (checkNum)
			System.out.println(str + " �� �����Դϴ�");
		String str1 = "hello";
		String str2 = "java";
		System.out.println(str1.concat(str2));
		
		str = "hello java !!!";
		if(str.startsWith("he")) 
			System.out.println(str + " h�� �����Ѵ�");
		if(str.endsWith("!"))
			System.out.println("!�� ������");
		
		String s1 = "jAva";
		String s2 = "JaVa";
		System.out.println("s1.upperCace() == " + s1.toUpperCase());
		System.out.println("s1.upperCace() == " + s1.toLowerCase());
		
		if(s1.equals(s2))
			System.out.println("s1�� s2�� ���� ���ڿ��̴�");
		else
			System.out.println("�ٸ����ڿ��̴�");
		if(s1.equalsIgnoreCase(s2))
			System.out.println(s1 + "�� " + s2 + "�� ��ҹ��� ���о��� �������ڿ��̴�");
		else 
			System.out.println(s1 + "�� " + s2 + "�� ��ҹ��� ���о��� �ٸ����ڿ��̴�");
		
		
	}

}