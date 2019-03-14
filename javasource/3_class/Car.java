public class Car {

    String carName; // 객체 생성시 초기화 안해도 null로 자동으로 초기화 함
    String color;
    String maker;
    int speed; // 객체 생성시 초기화 안해도 0으로 자동으로 초기화 함

    // 생성자를 따로 만들지 않으면 디폴트 컨스트럭터가 만들어짐
    // 디폴트 생성자와 커스텀 생성자를 둘다 만들 수 도 있다

    public void speedUp() {
        int pp;
        speed += 10;
    }
    public void speedDown() {
        speed -= 10;
        if(speed < 0)
            stop();
    }
    public void stop() {
        speed = 0;
    }
/*
    public static void main(String args[]) {
        Car car = new Car("1");
        System.out.println(car.toString());
    }
*/
}
