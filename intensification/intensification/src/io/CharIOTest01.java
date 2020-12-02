package io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CharIOTest01 {

    public static void main(String[] args) {

        // System.in 이 바로 들어갈 수 없기때문에 InputStreamReader 생성 ( 데코레이터 패턴 )
        BufferedReader br = new BufferedReader( new InputStreamReader( System.in));
        String line = null;
        try {
            line = br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(line);
    }
}
