package com.kitri.lang;


//	Wrapper Class : 기본 데이터 타입을 클래스화
//	기본 DT 	WrapperClass
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
		int x = Integer.parseInt(s); // 문자열을 기본데이터 형으로 바꿀때 많이 써요
		System.out.println(x);
		
		s = "123.45";
		double d = Double.parseDouble(s);
		System.out.println(d + 4 );
		
		//autoBoxing 래퍼클래스에서 같은 1.5 부터 지원 
		Integer i2 = new Integer(3);
		Integer i3 = new Integer(3);
		//unboxing
		int y = i2;
		//boxing
		//double x = i3;
		System.out.println(y + " -- " + i2);
	}
}
