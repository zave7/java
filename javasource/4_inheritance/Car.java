import java.util.*;

public class Car {
    String carName;
    String color;
    String maker;
    int speed;
    char test;

    public Car() {

        this("쏘나타", "흰색", "현대"); //맨 처음 실행
    }
    public Car(String color) {
   
        this("쏘나타", color, "현대"); //맨 처음 실행
    }
    public Car(String carName, String color) {

        this(carName, color, "현대"); //맨 처음 실행
    }
    public Car(String carName, String color, String maker) {
        //super() 요기에 생략
        this.carName = carName;
        this.color = color;
        this.maker = maker;
    }

   int speedUp(int speed) {
        this.speed += speed;
        return this.speed;
    }

    int speedDown(int speed) {
        this.speed -= speed;
        checkSpeedZero();
        return this.speed;
    }

    void stop() {
        speed = 0;
    }
    
    void checkSpeedZero() {
        if(speed < 0)
            stop();
    }
    public String toString() {
        return maker + "에서 만든 " + color + " " + carName;
    }
    @Override   
    public boolean equals(Object obj) {
        Car car = (Car)obj;
        //if (carName == car.carName)  "" 경우에는  true  new String() 일경우는 false
        if (carName.equals(car.carName))
            return true;
        return false;
    }
}
