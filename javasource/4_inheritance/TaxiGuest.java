public class TaxiGuest {
    public static void main(String[] args) {
        Taxi t1 = new Taxi();
        System.out.println(t1.toString());

        Taxi t2 = new Taxi("k5", "��ȫ��", "���");
        System.out.println(t2.toString());

        int km;
        /*System.out.println(t2.toString() + "��(��) Ÿ�� ���𿡼� �������� " + km + "km �̵�");
        int price = t2.calcPrice(km);
        System.out.println("����� : " + t2.price + "��");
        System.out.println("���� ���� : " + t2.totalPrice + "��");

        km = 20;
        System.out.println(t2.toString() + "��(��) Ÿ�� �������� ������� " + km + "km �̵�");
        price = t2.calcPrice(km);
        System.out.println("����� : " + t2.price + "��");
        System.out.println("���� ���� : " + t2.totalPrice + "��");*/
        km = 10;
        t2.initPrice();
        System.out.println(t2.toString() + "��(��) Ÿ�� �������� ������� " + km + "km �̵�");
        t2.sumPrice(km);
        System.out.println("����� : " + t2.price + "��");
        t2.initPrice();
        t2.sumPrice(20);
        System.out.println("����� : " + t2.price + "��");
        System.out.println("���� ���� : " + t2.totalPrice + "��");

        int upDown = 50;
        System.out.println("t2�� �ӵ��� " + upDown + " ��ŭ ����!!");
        int speed = t2.speedUp(upDown);
        System.out.println("t2�� �ӵ��� " + speed + " " + t2.speed);

        upDown = 250;
        System.out.println("t2�� �ӵ��� " + upDown + " ��ŭ ����!!");
        speed = t2.speedUp(upDown);
        System.out.println("t2�� �ӵ��� " + speed + " " + t2.speed);
        // ������Ʈ�� ���� �ڵ����� toString �� ȣ���Ѵ�

        Taxi t3 = new Taxi("k5", "��ȫ��", "���");
        System.out.println(t2 + "  " + t3);
        System.out.println(t2.hashCode() + "  " + t3.hashCode());
        if(t2 == t3) // == �񱳿����ڴ� �⺻ DT�� ��쿡 ���� �񱳸� ������ DT �ּҰ��� ��
            System.out.println("�ּ� ���� ���� ���̴�");
        else
            System.out.println("�ּ� ���� �ٸ� ���̴�");
        if(t2.equals(t3)) // == �񱳿����ڴ� �⺻ DT�� ��쿡 ���� �񱳸� ������ DT �ּҰ��� ��
            System.out.println("���̸��� ���� ���̴�");
        else
            System.out.println("���̸��� �ٸ� ���̴�");
    }
        Car car = new Taxi();
        System.out.println(car);
}