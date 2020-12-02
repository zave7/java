package thread;

public class DeamonThread implements Runnable{

    @Override
    public void run() {
        while(true) {
            System.out.println( "데몬 스레드가 실행중입니다.");
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
                break;
            }
        }
    }

    public static void main(String[] args) {
        Thread thread = new Thread( new DeamonThread());
        thread.setDaemon(true); // 데몬 스레드 설정
        thread.start();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println( "메인 스레드가 종료됩니다.");
    }
}
