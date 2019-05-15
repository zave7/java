public class TaxiGuest {
    public static void main(String[] args) {
        Taxi t1 = new Taxi();
        System.out.println(t1.toString());

        Taxi t2 = new Taxi("k5", "감홍색", "기아");
        System.out.println(t2.toString());

        int km;
        /*System.out.println(t2.toString() + "을(를) 타고 구디에서 강남까지 " + km + "km 이동");
        int price = t2.calcPrice(km);
        System.out.println("요금은 : " + t2.price + "원");
        System.out.println("누적 수익 : " + t2.totalPrice + "원");

        km = 20;
        System.out.println(t2.toString() + "을(를) 타고 강남에서 구디까지 " + km + "km 이동");
        price = t2.calcPrice(km);
        System.out.println("요금은 : " + t2.price + "원");
        System.out.println("누적 수익 : " + t2.totalPrice + "원");*/
        km = 10;
        t2.initPrice();
        System.out.println(t2.toString() + "을(를) 타고 강남에서 구디까지 " + km + "km 이동");
        t2.sumPrice(km);
        System.out.println("요금은 : " + t2.price + "원");
        t2.initPrice();
        t2.sumPrice(20);
        System.out.println("요금은 : " + t2.price + "원");
        System.out.println("누적 수익 : " + t2.totalPrice + "원");

        int upDown = 50;
        System.out.println("t2의 속도를 " + upDown + " 만큼 가속!!");
        int speed = t2.speedUp(upDown);
        System.out.println("t2의 속도를 " + speed + " " + t2.speed);

        upDown = 250;
        System.out.println("t2의 속도를 " + upDown + " 만큼 가속!!");
        speed = t2.speedUp(upDown);
        System.out.println("t2의 속도를 " + speed + " " + t2.speed);
        // 오브젝트만 쓰면 자동으로 toString 을 호출한다

        Taxi t3 = new Taxi("k5", "감홍색", "기아");
        System.out.println(t2 + "  " + t3);
        System.out.println(t2.hashCode() + "  " + t3.hashCode());
        if(t2 == t3) // == 비교연산자는 기본 DT일 경우에 값을 비교만 참조형 DT 주소값을 비교
            System.out.println("주소 값이 같은 차이다");
        else
            System.out.println("주소 값이 다른 차이다");
        if(t2.equals(t3)) // == 비교연산자는 기본 DT일 경우에 값을 비교만 참조형 DT 주소값을 비교
            System.out.println("차이름이 같은 차이다");
        else
            System.out.println("차이름이 다른 차이다");
    }
        Car car = new Taxi();
        //System.out.println(car);
}