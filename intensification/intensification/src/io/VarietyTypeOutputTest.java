package io;

import java.io.DataOutputStream;
import java.io.FileOutputStream;

public class VarietyTypeOutputTest {

    // 자바 IO 객체는 인스턴스를 만들고 모두 사용하면 close()를 호출해야한다.
    // close 메서를 호출하지 않아도 Exception이 발생하지 않았다면 자동으로 close되게하는 방법이 있다.
    // try(){} : try-with-resources 사용한 자원을 자동으로 종료 시켜주는 기능

    public static void main(String[] args) {
        // DataOutputStream 클래스는 다양한 타입을 저장할 수 있다
        // 생성자로 OutputStream 클래스를 매개변수롤 받아들인다

        // DataOutputStream 클래스가 장식의 역할을 한다는 것이다.
        // 장식의 역할을 한다는 것은 다양한 메서드를 제공한다는 것이다.
        // 장식이기 때문에 어디에 써라하는 것은 작성할 수 가 없다.
        // 그래서 어디에다가 쓸지 지정하는 클래스를 같이 사용해야한다.

        try(
                DataOutputStream out = new DataOutputStream( new FileOutputStream("src/io/data.txt"));
                ) {
            // int 4Byte 저장
            out.writeInt(100);
            // boolean 1Byte
            out.writeBoolean(true);
            // double 8Byte 저장
            out.writeDouble(50.5);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
