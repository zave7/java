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
		System.out.println((int)c); // ���� ����ȯ

		int y = c;
		System.out.println("y == " + y); //�ڵ� ����ȯ

		c = (char)y;
		System.out.println("c == " + c);

		boolean b = true;
		//int z = b; //error �� ��ȯ�� type ��ȯ�� ������ �͸� �ȴ�.

		int p = 30;
		double d = p;
		// p = d; error
		p = (int)d;
	}
	
}