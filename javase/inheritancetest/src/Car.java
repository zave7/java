import java.util.*;

public class Car {
    String carName;
    String color;
    String maker;
    int speed;
    char test;

    public Car() {

        this("�Ÿ", "���", "����"); //�� ó�� ����
    }
    public Car(String color) {
   
        this("�Ÿ", color, "����"); //�� ó�� ����
    }
    public Car(String carName, String color) {

        this(carName, color, "����"); //�� ó�� ����
    }
    public Car(String carName, String color, String maker) {
        //super() ��⿡ ����
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
        return maker + "���� ���� " + color + " " + carName;
    }
    @Override   
    public boolean equals(Object obj) {
        Car car = (Car)obj;
        //if (carName == car.carName)  "" ��쿡��  true  new String() �ϰ��� false
        if (carName.equals(car.carName))
            return true;
        return false;
    }
}
