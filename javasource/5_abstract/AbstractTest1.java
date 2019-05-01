import java.util.*;
public class AbstractTest1 {
    public static void main(String[] args) {
        //api문서를 볼때 항상 클래스 종류와 생성자, 다이렉트 서브클래스를 확인
        //1. 하위 클래스 참조
        //Calendar car = new GregorianCalendar();
        //2. 자신의 객체를 return 하는 static method.
        Calendar cal = Calendar.getInstance();
        int y = cal.get(Calendar.YEAR);
        int m = cal.get(Calendar.MONTH) + 1;
        int d = cal.get(Calendar.DAY_OF_MONTH);
        int h = cal.get(Calendar.HOUR_OF_DAY);
        int mi = cal.get(Calendar.MINUTE);
        int s = cal.get(Calendar.SECOND);
        System.out.println(y + "년 " + m + "월 " + d + "일 " + h + "시 " + mi + "분 " + s + "초");
    }
}
