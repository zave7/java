package com.kitri.lang;

public class StringTest1 {
	public static void main(String args[]) {
		String s1 = "java";
		String s2 = "java";
		String s3 = new String("java"); //  ��ü�� �� ������ ���������� ���ͷ� ������ �ִ� �ּҸ� �����Ѵ�
		String s4 = new String("java");
		if(s1 == s2)
			System.out.println("s1 �ּҰ��� ���� s2");//o
		if(s1 == s3)
			System.out.println("s1 �ּҰ��� ���� s3");//x
		if(s1 == s4)
			System.out.println("s1 �ּҰ��� ���� s4");//x
		if(s2 == s3)
			System.out.println("s2 �ּҰ��� ���� s3");//x
		if(s2 == s4)
			System.out.println("s2 �ּҰ��� ���� s4");//x
		if(s3 == s4)
			System.out.println("s3 �ּҰ��� ���� s4");//x �ּҰ��� ���Ѵ�
		System.out.println("----------------------------");
		
		if(s1.equals(s2)) //�̰Ŵ� �� ��ü�� ���Ѵ�
			System.out.println("s1 ���ڿ����� ���� s2");//o
		if(s1.equals(s3))
			System.out.println("s1 ���ڿ����� ���� s3");//o
		if(s1.equals(s4))
			System.out.println("s1 ���ڿ����� ���� s4");//o
		if(s2.equals(s4))
			System.out.println("s2 ���ڿ����� ���� s3");//o
		if(s2.equals(s4))
			System.out.println("s2 ���ڿ����� ���� s4");//o
		if(s3.equals(s4))
			System.out.println("s3 ���ڿ����� ���� s4");//o �ּҰ��� ���Ѵ�
	}
} 
//������ ���ڿ��� �����ϴ� ������ ������ �ִ�
//���ڿ��� �����Ҷ� ������ �ִ� ���� ���� ���� �ִ��� ���ϰ� ������ ���� ������ ����
//�����ϴ� ���� ��ü�� �ٸ��� ������ �ּ� �� �� �Ұ� 
//��Ʈ���� �Һ��̴� ���θ���������� ��������� ������ �ʴ´�