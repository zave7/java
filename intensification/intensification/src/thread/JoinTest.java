package thread;

public class JoinTest {
    public static void main(String[] args) {
        MyThread5 thread5 = new MyThread5();

        System.out.println( "main start");

        thread5.start();

        // main 도 하나의 스레드이다
        // join() 을 호출하면 해당 스레드가 종료될때 까지 기다린다
        try {
            thread5.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println( "main end");
    }
}
