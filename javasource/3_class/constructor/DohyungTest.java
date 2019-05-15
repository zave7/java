public class DohyungTest {
    public static void main(String[] args) {
        Rect r1; 
        r1 = new Rect();
        System.out.println("가로가 " + r1.width + "이고 세로가 " + r1.height + "인 사각형의 넓이는 "
                            + r1.calcArea() + "이고 둘레는 " + r1.calcRound() + " 입니다.");
        // 가로가 4이고 세로가 3인 사각형의 넓이는 12이고 둘레는 14 입니다.

        Rect r2;
        r2 = new Rect(5, 7);
        System.out.println("가로가 " + r2.width + "이고 세로가 " + r2.height + "인 사각형의 넓이는 "
                            + r2.calcArea() + "이고 둘레는 " + r2.calcRound() + " 입니다.");
        // 가로가 x이고 세로가 y인 사각형의 넓이는 xy이고 둘레는 2x + 2y 입니다.

        Circle c1;
        c1 = new Circle();
        System.out.println("반지름이 " + c1.radius + "인 원의 넓이는 " 
                            + c1.calcArea() + " 이고 둘레는 " + c1.calcRound() + " 입니다.");
        // 반지름이 4인 원의 넓이는 48.xxx 이고 둘레는 24.xxx 입니다.

        Circle c2;
        c2 = new Circle(5);
        System.out.println("반지름이 " + c2.radius + "인 원의 넓이는 " 
                            + c2.calcArea() + " 이고 둘레는 " + c2.calcRound() + " 입니다.");
        // 반지름이 5인 원의 넓이는 75.xxx 이고 둘레는 30.xxx 입니다.

    }
}
