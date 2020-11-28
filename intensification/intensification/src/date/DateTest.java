package date;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;

public class DateTest {

    // Since 1.0

    // 제일 최초에 만들어진 만큼 지역화에 대한 고려가 되어있지 않음

    // Date 클래스의 단점을 해결하려고 등장한 클래스가 Canlender 클래스이다.

    public static void main(String[] args) throws InterruptedException {
        Date date = new Date();

        System.out.println( date.toString());

        SimpleDateFormat ft = new SimpleDateFormat("yyyy.MM.dd 'at' hh:mm:ss a zzz");
        // 'at' : 싱클 쿼테이션은 문자그대로 나타낸다
        // a    : 오전인지 오후인지 출력해줌
        // zzz  : 타임존

        System.out.println(ft.format( date));

        // 현재 시간을 Long값으로 구하기
        System.out.println(date.getTime());

        // 시스템의 현재 시간을 Long값으로 구해서 반환해줌

        System.out.println(System.currentTimeMillis());

        Date date2 = new Date();
//        date.wait(111);

        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println(System.nanoTime());

    }
}
