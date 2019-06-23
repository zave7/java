public class Store {
    public static void main(String[] args) {

        PointCard p1 = new PointCard("박미래");
        PointCard p2 = new PointCard("황선혜");
        System.out.println(p1.name + "님 물건 구매");
        int point = p1.visit();
        System.out.println(p1.name + "님의 포인트는 " + point + "입니다.");
        System.out.println(p2.name + "님 물건 구매");
        point = p2.visit();
        System.out.println(p2.name + "님의 포인트는 " + point + "입니다.");
        System.out.println(p2.name + "님 물건 구매");
        point = p2.visit();
        System.out.println(p2.name + "님의 포인트는 " + point + "입니다.");
        System.out.println("----------------------------------------------");




        Guest g1 = new Guest("박미래");
        Guest g2 = new Guest("황선혜");
        System.out.println(g1.name + "님 방문");
        int count = g1.visit();
        System.out.println(g1.name + "님은 " + g1.cnt + "번째 방문자입니다.");
        System.out.println(g2.name + "님 방문");
        count = g2.visit();
        System.out.println(g2.name + "님은 " + g2.cnt + "번째 방문자입니다.");
        System.out.println(g2.name + "님 방문");
        count = g2.visit();
        System.out.println(g2.name + "님은 " + g2.cnt + "번째 방문자입니다.");

    }
}
