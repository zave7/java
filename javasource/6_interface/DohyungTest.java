public class DohyungTest {
    public static void main(String[] args) {
        Rect r1 = new Rect(6, 7);
        System.out.println("���ΰ� " + r1.width + " ���ΰ� " + r1.height + "�� �簢���� ���̴� " +
            r1.getArea() + ", �ѷ��� " + r1.getRound());

        Circle c1 = new Circle(5);
        System.out.println("�������� " + c1.radius + "�� ���� ���̴� " +
            c1.getArea());
        //System.out.println(DohyungRound.x+=1); default �� final �� �����Ǳ� ������ ������ ����
        //Circle c2 = (Circle)d1; //������ �ÿ��� ������ �˻��Ѵ� //��Ÿ�ӽÿ� ������ �߻��Ѵ�
    }
}
