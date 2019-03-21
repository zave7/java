package constructortest;

public class Car extends Object{
    String carName;
    String color;
    String maker;
    int speed;
    char test;

    //this() 는 생성자의 맨 첫번째 실행문에서만 실행가능하다. 즉 맨 처음 단 한번
    // 생성자의 기능 : 객체를 메모리에 올린다
    // 초기화 작업을 한다

    public Car() {
        /*carName = "쏘나타";
        color = "검정";
        maker = "현대";
        //test = 'a';
        */
        this("123", "color", "현대");
    }
    public Car(String color) {
        /*
        carName = "쏘나타"; //this jvm 이 알아서 붙여준다
        this.color = color;
        maker = "현대";
        //test = 'a';
        */      
        this("123", color, "현대");
    }
    public Car(String carName, String color) {
        /*
        this.carName = carName;
        this.color = color;
        maker = "현대";
        */
        this(carName, color, "현대");
    }
    public Car(String carName, String color, String maker) {
        this.carName = carName;
        this.color = color;
        this.maker = maker;
        //test = 'a';
    }
    void speedUp() {
        this.speed += 10;
    }

    int speedUp(int speed) {
        this.speed += speed;
        return this.speed;
    }

    void speedDown() {
        this.speed -= 10;   
        checkSpeed();
    }

    int speedDown(int speed) {
        this.speed -= speed;
        checkSpeed();
        return this.speed;
    }

    void stop() {
        speed = 0;
    }
    
    void checkSpeed() {
        if(speed < 0)
            stop();
    }

    public String toString() {
        return "차 이름 : " + carName + "  색상 : " + color + "  제조사 : " + maker;
    }
}
