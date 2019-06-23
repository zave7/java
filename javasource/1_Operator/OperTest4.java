public class OperTest4 {
	public static void main(String[] args) {
		int jumin = 1;
		String gender = jumin % 2 == 0 ? "여자" : "남자"; // 삼항 연산자
		System.out.println(gender);

		//점수가 80 이상이면 합격, 80 미만이면 불합격
		//당신의 점수는 xx이므로 xx입니다.

		int score = 79;
		String passCheck = score >= 80 ? "합격" : "불합격";
		System.out.println("당신의 점수는 " + score + "점이므로 " + passCheck + "입니다.");
	}
}