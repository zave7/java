package io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class ByteTest {

    public static void main(String[] args) {

        long startTime = System.currentTimeMillis();
        FileInputStream fis = null;
        FileOutputStream fos = null;

        try {
            // 기본 root 경로는 프로젝트
            fis = new FileInputStream( "src/io/ByteTest.java");
            fos = new FileOutputStream( "src/io/byte.txt");

            int readDate = -1;

            // read()는 한 바이트씩 읽을 수 있다. 리턴 타임은 정수이다. 정수의 4byte중에서 마지막 바이트에 읽어들인 바이트를 저장한다.
            // byte 를 리턴하게되면 끝을 나타내는 값을 표현할 수 없기 때문이다.

            // 파일이 끝났을때는 -1를 리턴한다.
            while( ( readDate = fis.read()) != -1) {
                fos.write( readDate);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // IO의 모든 인스턴스 객체는 close 해줘야 한다.
            try {
                fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        long endTime = System.currentTimeMillis();
        System.out.println(endTime - startTime);
    }

}
