public class DohyungTest {
    public static void main(String[] args) {
        Rect r1 = new Rect(6, 7);
        System.out.println("���ΰ� " + r1.width + " ���ΰ� " + r1.height + "�� �簢���� ���̴� " +
            r1.getArea() + ", �ѷ��� " + r1.getRound());

        Circle c1 = new Circle(5);
        System.out.println("�������� " + c1.radius + "�� ���� ���̴� " + c1.getArea());
        Dohyung d1 = new Rect(2, 3);
        System.out.println("������ ���̴� " +
            d1.getArea() + ", �ѷ��� " + d1.getRound());
        Rect r2 = (Rect)d1;
        System.out.println("���ΰ� " + r2.width + " ���ΰ� " + r2.height + "�� �簢���� ���̴� " +
            r2.getArea() + ", �ѷ��� " + r2.getRound());
        Circle c2 = (Circle)d1; //������ �ÿ��� ������ �˻��Ѵ� //��Ÿ�ӽÿ� ������ �߻��Ѵ�
    }
}
