/*
1. ������ radius
2. ���� : calcArea()
   �ѷ� : calcRound()
*/
public class Circle {
    int radius;
    static int test = 5;
    public Circle() {
        //this(4);
        this.radius = 4;
    }
    public Circle(int radius) {
        this.radius = radius;
    }

    double calcArea() {
        return Math.PI * (radius ^ 2);
    }
    double calcRound() {
        //static int test = 5; �޼ҵ� �ȿ��� ����ƽ ���� �Ұ�
        return Math.PI * radius;
    }
}
