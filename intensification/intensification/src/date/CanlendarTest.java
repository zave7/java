package date;
// Since 1.1
// Date가 지역화에 대해 고려되어있지 않아서 보완하여 나옴

// 굉장히 많은 상수값을 가지고있다

import java.util.Calendar;

public class CanlendarTest {

    public static void main(String[] args) {

        // Calendar클래스의 하위 클래스는 GregorianCalendar이다
        // Calendar 클래스는 추상클래스이기 때문에 인스턴스 반환시 항상 GregorianCalendar를 반환한다.

        // 이렇게 한 이유는 나중에 새로운 형식의 표준 달력이 생길 수도 있기 때문이다.
        Calendar cal = Calendar.getInstance();

//        System.out.println(cal.get(Calendar.DAY_OF_MONTH));
//        System.out.println(cal.get(Calendar.DATE));
//        System.out.println(cal.get(Calendar.YEAR));
//        System.out.println(cal.get(Calendar.SUNDAY));
//        System.out.println(cal.get(Calendar.HOUR_OF_DAY));

//        cal.add(Calendar.D, 1);
        System.out.println( cal.get(Calendar.DAY_OF_MONTH));




    }
}
