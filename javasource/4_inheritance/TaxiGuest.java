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
        t2.initPrice();
        int km = 10;
        System.out.println(t2.toString() + "��(��) Ÿ�� �������� ������� " + km + "km �̵�");
        t2.sumPrice(km);
        System.out.println("����� : " + t2.price + "��");
        t2.initPrice();
        t2.sumPrice(20);
        System.out.println("����� : " + t2.price + "��");
        System.out.println("���� ���� : " + t2.totalPrice + "��");
    }
}