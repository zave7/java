public class CarUser {
    public static void main(String[] args) {
        Car car2 = new Car("���");

        System.out.println("car2 �� �ӵ��� 3ȸ ����!!");
        for(int i=0; i<3; i++) {
            car2.speedUp();
        }
        System.out.println(car2.speed);
        System.out.println("car2 �� �ӵ��� 85 ����!!");
        int speed = car2.speedUp(85);
        System.out.println(speed);
        
        car2.toString();
    }
}