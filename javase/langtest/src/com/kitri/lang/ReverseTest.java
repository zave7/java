package com.kitri.lang;

public class ReverseTest {
	public static void main(String[] args) {
		String str = "!!! avajjj olleh";
//		Hello Java !!! �ּ� 3�� �����
//		--------------------------------------------------------------------------------
//		int len = str.length() - 1;					//���ο� char �迭��  str.charAt() �̿�
//		char cpStr[] = new char[str.length()];
//		for (int i = 0; i < str.length(); i++) {
//			cpStr[i] = str.charAt(len);
//			len--;
//		}
//		str = String.valueOf(cpStr);
//		System.out.println(str);
//		System.out.println("e�� " + (str.indexOf('e')+1) + "��°�� �ֽ��ϴ�");
//		--------------------------------------------------------------------------------
//		String cpStr = "";								//���ο� String�� str.charAt() �̿�
//		int len = str.length() - 1;					
//		for (int i = len; i >= 0; i--) {
//			cpStr += str.charAt(i);
//		}
//		str = cpStr;
//		System.out.println(str);
//		
//		System.out.println("e�� " + (str.indexOf('e')+1) + "��°�� �ֽ��ϴ�");
//		--------------------------------------------------------------------------------
		char temp;
		char cpStr[] = str.toCharArray();			//���ο� char �迭�� str.toCharArray() �̿�
		int len = cpStr.length - 1;
		for (int i = 0; i <= len; i++) {	
			temp = cpStr[i];
			cpStr[i] = cpStr[len-i];
			cpStr[len-i] = temp;
			if(len-i*2 <= 2) //len-i-i <= 2
				break;
		}
		str = String.valueOf(cpStr);
		System.out.println(str);
		System.out.println("e�� " + (str.indexOf('e')+1) + "��°�� �ֽ��ϴ�");
//		--------------------------------------------------------------------------------
//		byte temp;
//		byte cpStr[] = str.getBytes();			//���ο� byte �迭�� str.getBytes() �̿�
//		int len = cpStr.length - 1;				//�ѱ��� ��� ������
//		for (int i = 0; i <= len; i++) {		
//			temp = cpStr[i];
//			cpStr[i] = cpStr[len-i];
//			cpStr[len-i] = temp;
//			if(len-i*2 <= 2) //len-i-i <= 2
//				break;
//		}
//		str = new String(cpStr);
//		System.out.println(str);
//		System.out.println("e�� " + (str.indexOf('e')+1) + "��°�� �ֽ��ϴ�");
//		e�� 2��° �ֽ��ϴ�
	}
}