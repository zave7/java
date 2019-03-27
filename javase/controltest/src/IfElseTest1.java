public class IfElseTest1 {
	public static void main(String[] args) {
		int x = 10;
		int y = 90;
		/*
		if (x > y) {
			System.out.println(x + " 는 " + y + "보다 크다");
		}
		else {
			System.out.println(x + " 는 " + y + "보다 작다");
		}
		*/
		String result;
		if (x == y) {
			result = "같다";
		}
		else {
			if ( x > y)
			{
					result = "크다";
			}
			else {
					result = "작다";
			}
		}

		System.out.println("x " + x + ", y " + y + " -> " + result);
		System.out.println("프로그램종료");
	}
}
