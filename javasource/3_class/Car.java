public class Car {

    String carName; // ��ü ������ �ʱ�ȭ ���ص� null�� �ڵ����� �ʱ�ȭ ��
    String color;
    String maker;
    int speed; // ��ü ������ �ʱ�ȭ ���ص� 0���� �ڵ����� �ʱ�ȭ ��

    // �����ڸ� ���� ������ ������ ����Ʈ ����Ʈ���Ͱ� �������
    // ����Ʈ �����ڿ� Ŀ���� �����ڸ� �Ѵ� ���� �� �� �ִ�

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
