package thread;

public class MusicBoxTest {

    public static void main(String[] args) {
        // 공유 객체
        MusicBox musicBox = new MusicBox();

        MusicPlayer player1 = new MusicPlayer(1, musicBox);
        MusicPlayer player2 = new MusicPlayer(2, musicBox);
        MusicPlayer player3 = new MusicPlayer(3, musicBox);

        player1.start();
        player2.start();
        player3.start();

        System.out.println( "main end");
    }
}
