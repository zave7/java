package thread;

public class MyThread5 extends Thread{

    @Override
    public void run() {
        for( int i=0; i<5; i++) {
            System.out.println( "Mythread5 : " + i);

            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
