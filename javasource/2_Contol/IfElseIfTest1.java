public class IfElseIfTest1 {
	public static void main(String[] args) {
		int x = 90;
		int y = 90;
		String result;
		if ( x == y ) {
			result = "같다";
		}	else if (x > y) {
			result = "x가 크다";
		}	else {
			result = "x가 작다";
		}
		System.out.println("x y 비교 결과 : " + result);
	}
}
