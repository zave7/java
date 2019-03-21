package constructortest;

public class Car extends Object{
    String carName;
    String color;
    String maker;
    int speed;
    char test;

    //this() �� �������� �� ù��° ���๮������ ���డ���ϴ�. �� �� ó�� �� �ѹ�
    // �������� ��� : ��ü�� �޸𸮿� �ø���
    // �ʱ�ȭ �۾��� �Ѵ�

    public Car() {
        /*carName = "�Ÿ";
        color = "����";
        maker = "����";
        //test = 'a';
        */
        this("123", "color", "����");
    }
    public Car(String color) {
        /*
        carName = "�Ÿ"; //this jvm �� �˾Ƽ� �ٿ��ش�
        this.color = color;
        maker = "����";
        //test = 'a';
        */      
        this("123", color, "����");
    }
    public Car(String carName, String color) {
        /*
        this.carName = carName;
        this.color = color;
        maker = "����";
        */
        this(carName, color, "����");
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
        return "�� �̸� : " + carName + "  ���� : " + color + "  ������ : " + maker;
    }
}
