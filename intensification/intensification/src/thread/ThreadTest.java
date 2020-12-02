package thread;

public class ThreadTest {

    public static void main(String[] args) {
        MyThread1 thread1 = new MyThread1("*");
        MyThread1 thread2 = new MyThread1("-");

        // Java 에서 스레드는 start() 메서드로 시작된다.
        // start 메서드는 스레드가 실행할 준비를 해주게한다. 그리고 run 메서드가 호출된다.
        thread1.start();
        thread2.start();
        // 메인스레드가 종료 된다 하더라도 모든 스레드가 종료가 되어야 프로그램이 종료된다.
        System.out.println( "main end");

    }
}
