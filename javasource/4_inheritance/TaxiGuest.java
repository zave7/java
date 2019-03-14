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
        t2.initPrice();
        int km = 10;
        System.out.println(t2.toString() + "을(를) 타고 강남에서 구디까지 " + km + "km 이동");
        t2.sumPrice(km);
        System.out.println("요금은 : " + t2.price + "원");
        t2.initPrice();
        t2.sumPrice(20);
        System.out.println("요금은 : " + t2.price + "원");
        System.out.println("누적 수익 : " + t2.totalPrice + "원");
    }
}