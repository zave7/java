public class DohyungTest {
    public static void main(String[] args) {
        Rect r1; 
        r1 = new Rect();
        System.out.println("���ΰ� " + r1.width + "�̰� ���ΰ� " + r1.height + "�� �簢���� ���̴� "
                            + r1.calcArea() + "�̰� �ѷ��� " + r1.calcRound() + " �Դϴ�.");
        // ���ΰ� 4�̰� ���ΰ� 3�� �簢���� ���̴� 12�̰� �ѷ��� 14 �Դϴ�.

        Rect r2;
        r2 = new Rect(5, 7);
        System.out.println("���ΰ� " + r2.width + "�̰� ���ΰ� " + r2.height + "�� �簢���� ���̴� "
                            + r2.calcArea() + "�̰� �ѷ��� " + r2.calcRound() + " �Դϴ�.");
        // ���ΰ� x�̰� ���ΰ� y�� �簢���� ���̴� xy�̰� �ѷ��� 2x + 2y �Դϴ�.

        Circle c1;
        c1 = new Circle();
        System.out.println("�������� " + c1.radius + "�� ���� ���̴� " 
                            + c1.calcArea() + " �̰� �ѷ��� " + c1.calcRound() + " �Դϴ�.");
        // �������� 4�� ���� ���̴� 48.xxx �̰� �ѷ��� 24.xxx �Դϴ�.

        Circle c2;
        c2 = new Circle(5);
        System.out.println("�������� " + c2.radius + "�� ���� ���̴� " 
                            + c2.calcArea() + " �̰� �ѷ��� " + c2.calcRound() + " �Դϴ�.");
        // �������� 5�� ���� ���̴� 75.xxx �̰� �ѷ��� 30.xxx �Դϴ�.

    }
}
