package io;

import java.io.DataInputStream;
import java.io.FileInputStream;

public class VarietyTypeInputTest {
    public static void main(String[] args) {
        // File 을 읽어들일때 사용하는 FileInputStream 이 있지만 다양한 데이터 타임으로 읽어 들여야 하기 때문에 DataFileInputStream 사용
        try(
                DataInputStream in = new DataInputStream( new FileInputStream("src/io/data.txt"))
                 ) {

            // 저장된 순서대로 읽어들인다.

            // 내부적으로 FileInputStream 의 read 메서드를 통해 읽어들인다.
            int i = in.readInt();
            boolean b = in.readBoolean();
            double d = in.readDouble();

            System.out.println(i);
            System.out.println(b);
            System.out.println(d);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
