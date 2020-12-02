package thread;

// 스레드와 공유 객체
public class MusicBox {

    // synchronized 모니터링 락을 걸어준다
    public synchronized void playMusicA() {
        for( int i=0; i<10; i++) {
            System.out.println( "신나는 음악");
            try {
                Thread.sleep( ((int)Math.random())*10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public synchronized void playMusicB() {
        for( int i=0; i<10; i++) {
            System.out.println( "슬픈 음악");
            try {
                Thread.sleep( ((int)Math.random())*10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void playMusicC() {

        // playMusicA 에서 모니터링 락을 해제 했을 경우
        // playMusicC 의 synchronized 블럭 부분이 대기중이었다가 실행이 된다.
        // 그렇기 때문에 블럭 부분만 대기하고있다가 실행하기 때문에 다른 스레드 들이 더 빠르게 접근이 가능하다.
        for( int i=0; i<10; i++) {

            synchronized (this) {
                System.out.println( "카페 음악");
            }
            try {
                Thread.sleep( ((int)Math.random())*10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
