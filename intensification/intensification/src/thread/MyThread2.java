package thread;

// 자바는 단일 상속이기 때문에 Runnable 인터페이스가 존재!!
public class MyThread2 implements Runnable{

    String str;

    public MyThread2( String str) {
        this.str = str;
    }

    @Override
    public void run() {
        for( int i=0; i<10; i++) {
            System.out.println( str);

            try {
                Thread.sleep( ((int)Math.random()) * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
