package string;

public class StringTest {
    // String 클래스는 문자열을 다룰때 사용하는 클래스이다. (불변 클래스)

    public static void main(String[] args) {

        String str1 = "hello world";
        // 5번째 부터 잘라서 출력
        String str2 = str1.substring(5);
        System.out.println(str1);
        System.out.println(str2);

        String str3 = str1 + str2;
        System.out.println(str3);

        // 문자열 + 내부 동작 메커니즘

        String str4 = new StringBuffer().append(str1).append(str2).toString();
        System.out.println(str4);

        String str5 = "";
        // 100번 동안 StringBuffer 객체가 100번 만들어진다.
        for( int i = 0; i < 100; i++) {
            str5 += "*";
        }
        System.out.println(str5);

        // 자바는 new 연산을 하면 할수록 느려진다. ( 아마도 GC 때문 )
    }
}
