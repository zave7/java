public class SmartPhoneTest {
    public static void main(String[] args) {
        SmartPhone samsung1 = new SmartPhone("�Ｚ", "�����ó�Ʈ2", 850000);
        SmartPhone iPhone = new SmartPhone("����", "������5", 740000, 30);
        SmartPhone samsung2 = new SmartPhone("�Ｚ", "������S3", 750000, 35);
    
        System.out.println("=== ��ǰ��� ===");
        System.out.println("------------------");
        System.out.println(samsung1.getName() + " [" + samsung1.getMaker() +"]");
        System.out.println("���� : " + samsung1.getPrice());
        samsung1.printDiscountPrice();
        System.out.println("------------------");
        System.out.println(iPhone.getName() + " [" + iPhone.getMaker() +"]");
        System.out.println("���� : " + iPhone.getPrice());
        iPhone.printDiscountPrice();
        System.out.println("------------------");
        System.out.println(samsung2.getName() + " [" + samsung2.getMaker() +"]");
        System.out.println("���� : " + samsung2.getPrice());
        samsung2.printDiscountPrice();
    }
}