public class IfTest1 {
	public static void main(String[] args) {
		int x = 10;
		int y = 70;
		/*
		if(x > y) {
			System.out.println("x가 크다");
		}
		*/

		int jumin = 3;
		String gender = "남자";
		if(jumin == 2 || jumin == 4) {
			gender = "여자";
		}
		System.out.println(gender);
	}
}