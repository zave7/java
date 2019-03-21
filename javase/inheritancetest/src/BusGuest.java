public class BusGuest {
    public static void main(String[] args) {
        Bus b24 = new Bus(40, 3, 17);
        String busStatus;
        busStatus = b24.getOn(5, 8);
        System.out.println(busStatus);
        busStatus = b24.getOn(6, 1);
        System.out.println(busStatus);
        busStatus = b24.getOn(9, 17);
        System.out.println(busStatus);
        busStatus = b24.getOut(10, 10);
        System.out.println(busStatus);
        busStatus = b24.getOut(3, 50);
        System.out.println(busStatus);
    }
}
