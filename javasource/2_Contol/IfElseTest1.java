public class IfElseTest1 {
	public static void main(String[] args) {
		int x = 10;
		int y = 90;
		/*
		if (x > y) {
			System.out.println(x + " �� " + y + "���� ũ��");
		}
		else {
			System.out.println(x + " �� " + y + "���� �۴�");
		}
		*/
		String result;
		if (x == y) {
			result = "����";
		}
		else {
			if ( x > y)
			{
					result = "ũ��";
			}
			else {
					result = "�۴�";
			}
		}

		System.out.println("x " + x + ", y " + y + " -> " + result);
		System.out.println("���α׷�����");
	}
}
