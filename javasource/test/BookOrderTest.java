public class BookOrderTest {
    public static void main(String[] args) {
        // ��������
        String book1 = "JAVA";
        String book2 = "JQuery";
        String book3 = "����Ŭ";
        String book4 = "������";
        int book1Price = 24000;
        int book2Price = 21000;
        int book3Price = 19000;
        int book4Price = 35000;
        int sumPrice = book1Price + book2Price + book3Price + book4Price;
        double discountCard = 0.15;
        int discountPrice = (int)(sumPrice - (sumPrice * discountCard));

        System.out.println("===== ���� ���� ��� =====");
        System.out.println(book1 + " : " + book1Price);
        System.out.println(book2 + " : " + book2Price);
        System.out.println(book3 + " : " + book3Price);
        System.out.println(book4 + " : " + book4Price);
        System.out.println("--------------------------");
        System.out.println("�ֹ� �ѱݾ� : " + sumPrice + "��");
        System.out.println("������ ���� �ݾ� : " + discountPrice + "��");
    }
}
