package io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException; 

public class Byte2Test {

    // ByteTest 개선

    // 1byte말고 512byte 읽어 들이기
    public static void main(String[] args) {

        // 우리가 사용하는 운영체제는 보통 512Byte씩 읽어온다
        // 1Byte씩 읽어오면 나머지 Byte는 버린다.
        // 파일을 읽어올때는 512의 배수로 배열의 크기를 정하는것이 성능상 좋다.


        long startTime = System.currentTimeMillis();

        FileInputStream fis = null;
        FileOutputStream fos = null;

        try {
            // 기본 root 경로는 프로젝트
            fis = new FileInputStream( "src/io/ByteTest.java");
            fos = new FileOutputStream( "src/io/byte.txt");

            int readCount = -1;

            byte[] buffer = new byte[ 512];

            while( ( readCount = fis.read(buffer)) != -1) {
                // buffer의 0번째 부터 시작해서 readCount 만큼 쓴다
                fos.write( buffer, 0, readCount);
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
