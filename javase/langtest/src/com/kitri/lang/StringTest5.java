package com.kitri.lang;

public class StringTest5 {
	public static void main(String[] args) {
		String str = "hello java";
		int x = str.indexOf('��');
		System.out.println(x);
		x = str.indexOf('l', 8); //������ -1 ���� �ϴµ�, 8���� ã�´�
		System.out.println(x);
		x = str.indexOf("java"); // java �� ���° ���� �����ϳ�
		System.out.println(x);
		x = str.lastIndexOf('a'); //�������� ������ a�� ���°�� �ֳ�
		System.out.println(x);
		
		String str2 = "";
		System.out.println(str2 + "�� ���� : " + str2.length());
		if(str2.isEmpty()) //���ڿ��� ���̰� 0�� ��� true����
			System.out.println("���ڿ��̴�");
		else 
			System.out.println("str2 == " + str2);
		
		String str3 = "  hello     . "; //���ڿ� �յ��� ������ �����ϴµ� ���ڿ� ������ ������ ����x
		System.out.println(str3 + "�� ���� : " + str3.length()); //trim ���� ����
		System.out.println(str3.trim() + "�� ���� ���� �� ���� : " + str3.trim().length());
		
		String str4 = "jaba";
		System.out.println(str4 + "::::" +str4.replace('b', 'v')); //���ڵ� �ٲ� �� �ְ� 
		System.out.println(str4 + "::::" +str4.replace("jaba", "java")); 
		//���ڿ��� �ٲ� �� �ִ� ( ���� üũ�� �غ��� �Ѵ�) 1.4 �̸��� ������ ���ڿ� �ٲٴ� ����� ����
		System.out.println(str4 + "::::" +str4.replaceAll("jaba", "java")); 
		//���ڿ��� �ٲ� �� �ִ� ( ���� üũ�� �غ��� �Ѵ�)
		
		String str5 = "hello java !!";
		String s[] = str5.split("a");
		int len = s.length;
		for (int i = 0; i < len; i++) {
			System.out.println(s[i]);
		}
		
		System.out.println(str5.substring(6, 9)); //6���� 9 ������
		
//		���� >> ���ڿ�
		int num = 100;
		String sn1 = num + "";
		System.out.println(sn1 + 100);
		String sn2 = String.valueOf(num);
		System.out.println(sn2 + 100);
		String sn3 = Integer.toString(num);
		System.out.println(sn3 + 100);
		
//		���ڿ� >> ����
		String ns = "100";
		num = Integer.parseInt(ns);
		System.out.println(num + 100);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
}