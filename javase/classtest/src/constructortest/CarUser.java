package constructortest;

public class CarUser {
    public static void main(String[] args) {
        Car car2 = new Car("흰색");

        System.out.println("car2 의 속도를 3회 증가!!");
        for(int i=0; i<3; i++) {
            car2.speedUp();
        }
        System.out.println(car2.speed);
        System.out.println("car2 의 속도를 85 증가!!");
        int speed = car2.speedUp(85);
        System.out.println(speed);
        
        car2.toString();
    }
}