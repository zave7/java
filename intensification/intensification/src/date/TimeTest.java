package date;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;

public class TimeTest {

    // 오랜시간 동안 자바에서 제공했던 Date 와 Time 클래스는 부족한 기능 지원을 포함한 여러가지 문제점을 가지고 있었다.
    // Java SE 8 부터 새롭게 다시 디자인한 Date 와 Time API 를 제공

    public static void main(String[] args) {
        // 현재 날짜와 시간을 가진 객체를 생성
        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println( "LocalDateTime.now() : " + localDateTime);

        // 원하는 날짜을 갖고 있는 객체 생성
        LocalDate ld1 = LocalDate.of(2012, Month.DECEMBER, 12);
        System.out.println( "LocalDate.of(2012, Month.DECEMBER, 12) : " + ld1);

        // 원하는 시간을 갖고 있는 객체 생성
        LocalTime lt = LocalTime.of(13, 13);
        System.out.println("LocalTime.of(13, 13) : " + lt);

        // LocalDate로
        LocalDate ld2 = localDateTime.toLocalDate();
        System.out.println("localDateTime.toLocalDate() : " + ld2);

        //Month 얻기
        Month month = localDateTime.getMonth();
        System.out.println(localDateTime.getMonth());
        System.out.println(month);

    }

}
