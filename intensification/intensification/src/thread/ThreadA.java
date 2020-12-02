package thread;

public class ThreadA {

    public static void main(String[] args) {

        ThreadB b = new ThreadB();
        b.start();

        synchronized (b) {
            try {
                System.out.println("b가 완료될때까지 기다립니다.");
                b.wait(); // 메인 스레드 정지
                // notify() 를 호출되면 그때 wait에서 깨어나게 됨
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Total is : " + b.total);
        }

        // 메인 ㅅ레드가 아래 블럭을 위에 스레드 보다 먼저 실해앟면 모니터링 락을 놓고 대기하게됨
    }
}
