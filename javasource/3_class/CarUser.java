public class CarUser {
    public static void main(String[] args) {

        Car car1 = new Car();

        
        System.out.println("1. 차 이름 : " + car1.carName + "\t\t\t\t색상 : " + car1.color + "\t\t\t\t제조사 : " + car1.maker);
        car1.carName = "쏘나타";
        car1.color = "blue";
        car1.maker = "현대";
        System.out.println("2. 차 이름 : " + car1.carName + "\t\t\t\t색상 : " + car1.color + "\t\t\t\t제조사 : " + car1.maker);
        
        Car car2 = new Car();
        System.out.println("z. 차 이름 : " + car2.carName + "\t\t\t\t색상 : " + car2.color + "\t\t\t\t제조사 : " + car2.maker);
        car2.carName = "123타";
        car2.color = "b123lue";
        car2.maker = "기아";
        System.out.println("z. 차 이름 : " + car2.carName + "\t\t\t\t색상 : " + car2.color + "\t\t\t\t제조사 : " + car2.maker);

        System.out.println(car1);
        System.out.println(car2);

        System.out.println("최초 " + car1.carName + "의 속도 : " + car1.speed);
        System.out.println("car1의 속도를 2회 증가");
        car1.speedUp();
        car1.speedUp();
        System.out.println("속도 2회 증가 후 " + car1.carName + "의 속도 : " + car1.speed);
        System.out.println("car1의 속도를 8회 증가");
        for(int i=0; i<8; i++) {
            car1.speedUp();
        }
        System.out.println("속도 8회 증가 후 " + car1.carName + "의 속도 : " + car1.speed);
        System.out.println("car1의 속도를 4회 감소");
        for(int i=0; i<4; i++) {
            car1.speedDown();
        }
        System.out.println("속도 4회 감소 후 " + car1.carName + "의 속도 : " + car1.speed);
        System.out.println("car1의 속도를 10회 감소");
        for(int i=0; i<10; i++) {
            car1.speedDown();
        }
        System.out.println("속도 10회 감소 후 " + car1.carName + "의 속도 : " + car1.speed);
    }
}