package com.kitri.lang;

import java.io.UnsupportedEncodingException;

public class StringTest2 {
	public static void main(String[] args) throws UnsupportedEncodingException {
//		String str = null;
//		System.out.println("\n");
		String str1 = new String();//����ִ� ���ڿ��� �����
		System.out.println("\nString()");
		System.out.println("new String() ���ڿ� ���� = " + str1.length());
		//��û���� �߿��ϴ�!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
		System.out.println("\nString(byte[] bytes, String charsetName)");
//		byte b[] = {97, 98, 99, 100};
		byte b[] = {-66, -56, -77, -25, -57, -49, -68, -68, -65, -28, 46}; //�ϼ��� �ѱ�
		String str2 = new String(b);
//		String str2 = new String(b, "euc-kr") // ����Ʈ �ɼ�
		System.out.println(str2);
		
		byte b2[] = {-20, -107, -120, -21, -123, -107, -19, -107, -104, -20, -124, -72, -20, -102, -108, 46};
		String str3 = new String(b2, "utf-8"); //������ ��繮�� ó�� 3byte ���ڸ� �׸���
		System.out.println(str3);
		
		System.out.println("\nString(byte[] bytes, int offset, int length)");
		byte b3[] = {97, 98, 99, 100, 101, 102, 103, 104};
		String str4 = new String(b3, 2, 4); //�迭�� ���۰� ���� �����ؼ� �����´�
		System.out.println(str4);
		
		System.out.println("\nString(char[] value)");
//		char c[] = {'a', 'b', 'c', 'd', 'e', 'f'};
		char c[] = {'��', '��', '��', '��', '��', '.'};
		String str5 = new String(c);
		System.out.println(str5);
		
		String str6 = new String(c, 2, 4);
		System.out.println(str6);
		
	}
}
