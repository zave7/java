
public class ArrayTest2 {
	public static void main(String[] args) {
		Car car[] = new Car[6]; //����â�� ����� ���� �ڵ����� ����°��� �ƴϴ�
		car[0] = new Car("�ҳ�Ÿ", "����", "����");
		car[1] = new Car("�ΰ�Ƽ", "����", "�κ�");
		car[2] = new Car("k5", "����", "kia");
		car[3] = new Car("sm55", "����", "�Ｚ");
		car[4] = new Car("�Ͼ��", "��ѱ�", "���");
		car[5] = new Car("��Ÿ��", "����", "����");
		System.out.println(car[0].getCarName());
		System.out.println("-----------------------");
//		for(Car c : car) {
//			System.out.println(c);
//		}
		String name = "�Ͼ��";
		name = "sm5"; //�����ϴ�
		Car findCar = null;
		int area = 0;
		for(int i = 0; i<car.length; i++) {
			if(name.equals(car[i].getCarName())) {
				area = i+1;
				findCar = car[i];
				break;
			}

		}
		if (findCar == null) 
			System.out.println(name + "�����ϴ�");
		else {
			System.out.println(findCar.getColor() + "�� " + findCar.getCarName() + "(" + 
					findCar.getMaker() + ") �� " + area + "��°�� �ֽ��ϴ�.");
		}
		// ��ѱ�� �Ͼ�� ( ���)�� 5��°�� �ֽ��ϴ�
	}
}
