public class SmartPhoneTest {
    public static void main(String[] args) {
        SmartPhone samsung1 = new SmartPhone("삼성", "갤럭시노트2", 850000);
        SmartPhone iPhone = new SmartPhone("애플", "아이폰5", 740000, 30);
        SmartPhone samsung2 = new SmartPhone("삼성", "갤럭시S3", 750000, 35);
    
        System.out.println("=== 제품목록 ===");
        System.out.println("------------------");
        System.out.println(samsung1.getName() + " [" + samsung1.getMaker() +"]");
        System.out.println("가격 : " + samsung1.getPrice());
        samsung1.printDiscountPrice();
        System.out.println("------------------");
        System.out.println(iPhone.getName() + " [" + iPhone.getMaker() +"]");
        System.out.println("가격 : " + iPhone.getPrice());
        iPhone.printDiscountPrice();
        System.out.println("------------------");
        System.out.println(samsung2.getName() + " [" + samsung2.getMaker() +"]");
        System.out.println("가격 : " + samsung2.getPrice());
        samsung2.printDiscountPrice();
    }
}