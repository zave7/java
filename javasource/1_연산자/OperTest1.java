public class OperTest1 
{
	public static void main(String[] args) 
	{
		int x = 10;
		System.out.println(x);
		System.out.println(x++);
		System.out.println(--x);
		System.out.println(x++);
		System.out.println(++x);
		System.out.println(x--);
		System.out.println(--x);
		System.out.println(x++);
		System.out.println(x);

		char c = 'a';
		System.out.println("c == " + c);
		System.out.println((int)c); // 강제 형변환

		int y = c;
		System.out.println("y == " + y); //자동 형변환

		c = (char)y;
		System.out.println("c == " + c);

		boolean b = true;
		//int z = b; //error 형 변환은 type 변환이 가능한 것만 된다.

		int p = 30;
		double d = p;
		// p = d; error
		p = (int)d;
	}
	
}