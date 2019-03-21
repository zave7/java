package com.kitri.lang;


//	Wrapper Class : �⺻ ������ Ÿ���� Ŭ����ȭ
//	�⺻ DT 	WrapperClass
//	boolean		Boolean
//	char		Character
//	byte		Byte
//	short		Short
//	int			Integer
//	long		Long
//	float		Float
//	double		Double
public class WrapperTestClass {
	public static void main(String[] args) {
		Boolean b1 = new Boolean("true");
		boolean b2 = b1.booleanValue();
		boolean b3 = Boolean.parseBoolean("true");
		boolean b4 = Boolean.getBoolean("true");
		if(b2)
			System.out.println("b2" + b2);
		if(b3)
			System.out.println("b3" + b3);
		if(b4)
			System.out.println("b4" + b4);
		String s = "123";
//		Integer integer = new Integer(s);
//		int x = integer.intValue();
//		System.out.println(x + 4);
		int x = Integer.parseInt(s); // ���ڿ��� �⺻������ ������ �ٲܶ� ���� ���
		System.out.println(x);
		
		s = "123.45";
		double d = Double.parseDouble(s);
		System.out.println(d + 4 );
		
		//autoBoxing ����Ŭ�������� ���� 1.5 ���� ���� 
		Integer i2 = new Integer(3);
		Integer i3 = new Integer(3);
		//unboxing
		int y = i2;
		//boxing
		//double x = i3;
		System.out.println(y + " -- " + i2);
	}
}
