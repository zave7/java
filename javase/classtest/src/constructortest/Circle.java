package constructortest;
/*
1. 반지름 radius
2. 넓이 : calcArea()
   둘레 : calcRound()
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
        //static int test = 5; 메소드 안에는 스태틱 선언 불가
        return Math.PI * radius;
    }
}
