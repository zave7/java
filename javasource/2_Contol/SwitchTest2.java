/*
score(����) ��
	90�̻��̸� ������ A
	80�̻��̸� ������ B
	70�̻��̸� ������ C
	60�̻��̸� ������ D
	60�̸��̸� ������ F
X5�� �̻��̸� X+
��� : ������ xx�� �̹Ƿ� x�����Դϴ�.

����	int score
		char grade

����� ���� if
*/
public class SwitchTest2 {
	public static void main(String[] args) {
		int score = 1;
		String grade;
			switch(score/10) {
				case 10 : 
				case 9 : grade = "A"; break;
				case 8 : grade = "B"; break;
				case 7 : grade = "C"; break;
				case 6 : grade = "D"; break;
				default : grade = "F";
			}
			if(score > 60 && (score % 10 >= 5 || score == 100)) {
				grade += "+";
			}
			System.out.println("���� : " + grade);
	}
}
