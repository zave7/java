package string;

public class StringBufferTest {
    // String 클래스는 자기 자신이 변하지 않는 불변 클래스이다.
    // StringBuffer 클래스는 자기 자신이 변하는 클래스이다.

    public static void main(String[] args) {

        StringBuffer sb = new StringBuffer();

        sb.append("hello");
        sb.append(" ");
        sb.append("world");

        String str = sb.toString();

        System.out.println(str);

        // StringBuffer 가 가진 메서드의 대부분은 자기 자신을 반한다. Method Chaining

        StringBuffer sb2 = new StringBuffer();
        StringBuffer sb3 = sb2.append("hello");

        if( sb2 == sb3) {
            System.out.println( "sb2 == sb3");
        }


    }
}
