public class CarUser {
    public static void main(String[] args) {

        Car car1 = new Car();

        
        System.out.println("1. �� �̸� : " + car1.carName + "\t\t\t\t���� : " + car1.color + "\t\t\t\t������ : " + car1.maker);
        car1.carName = "�Ÿ";
        car1.color = "blue";
        car1.maker = "����";
        System.out.println("2. �� �̸� : " + car1.carName + "\t\t\t\t���� : " + car1.color + "\t\t\t\t������ : " + car1.maker);
        
        Car car2 = new Car();
        System.out.println("z. �� �̸� : " + car2.carName + "\t\t\t\t���� : " + car2.color + "\t\t\t\t������ : " + car2.maker);
        car2.carName = "123Ÿ";
        car2.color = "b123lue";
        car2.maker = "���";
        System.out.println("z. �� �̸� : " + car2.carName + "\t\t\t\t���� : " + car2.color + "\t\t\t\t������ : " + car2.maker);

        System.out.println(car1);
        System.out.println(car2);

        System.out.println("���� " + car1.carName + "�� �ӵ� : " + car1.speed);
        System.out.println("car1�� �ӵ��� 2ȸ ����");
        car1.speedUp();
        car1.speedUp();
        System.out.println("�ӵ� 2ȸ ���� �� " + car1.carName + "�� �ӵ� : " + car1.speed);
        System.out.println("car1�� �ӵ��� 8ȸ ����");
        for(int i=0; i<8; i++) {
            car1.speedUp();
        }
        System.out.println("�ӵ� 8ȸ ���� �� " + car1.carName + "�� �ӵ� : " + car1.speed);
        System.out.println("car1�� �ӵ��� 4ȸ ����");
        for(int i=0; i<4; i++) {
            car1.speedDown();
        }
        System.out.println("�ӵ� 4ȸ ���� �� " + car1.carName + "�� �ӵ� : " + car1.speed);
        System.out.println("car1�� �ӵ��� 10ȸ ����");
        for(int i=0; i<10; i++) {
            car1.speedDown();
        }
        System.out.println("�ӵ� 10ȸ ���� �� " + car1.carName + "�� �ӵ� : " + car1.speed);
    }
}