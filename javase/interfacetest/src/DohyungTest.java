public class DohyungTest {
    public static void main(String[] args) {
        Rect r1 = new Rect(6, 7);
        System.out.println("가로가 " + r1.width + " 세로가 " + r1.height + "인 사각형의 넓이는 " +
            r1.getArea() + ", 둘레는 " + r1.getRound());

        Circle c1 = new Circle(5);
        System.out.println("반지름이 " + c1.radius + "인 원의 넓이는 " +
            c1.getArea());
        //System.out.println(DohyungRound.x+=1); default 로 final 이 지정되기 때문에 에러가 난다
        //Circle c2 = (Circle)d1; //컴파일 시에는 문법만 검사한다 //런타임시에 에러가 발생한다
    }
}
