public class IfElseIfTest1 {
	public static void main(String[] args) {
		int x = 90;
		int y = 90;
		String result;
		if ( x == y ) {
			result = "����";
		}	else if (x > y) {
			result = "x�� ũ��";
		}	else {
			result = "x�� �۴�";
		}
		System.out.println("x y �� ��� : " + result);
	}
}
