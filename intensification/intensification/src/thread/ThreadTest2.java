package thread;

public class ThreadTest2 {

    public static void main(String[] args) {
        MyThread2 thread2 = new MyThread2("*");
        MyThread2 thread3 = new MyThread2("-");

        // 스레드는 start를 호출해야 한다.

        Thread t2 = new Thread( thread2);
        Thread t3 = new Thread( thread3);

        t2.start();
        t3.start();

        System.out.println( "main end");
    }
}
