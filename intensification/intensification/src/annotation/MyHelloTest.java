package annotation;

import java.lang.reflect.Method;

public class MyHelloTest {

    public static void main(String[] args) {
        MyHello hello = new MyHello();

        try {
        // 메서드 정보 얻는 부분
        // getClass() 는 Object가 갖고잇는 메서드
        // 해당 인스턴스를 만들때 사용한 클래스의 정보를 리턴함
            Method method = hello.getClass().getDeclaredMethod( "hello");

            // 특정 어노테이션이 메서드에 적용되어있는지 확인
            if( method.isAnnotationPresent( Count100.class)) {
                for( int i=0; i<100; i++) {
                    hello.hello();
                }
            } else {
                hello.hello();
            }
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }
}
