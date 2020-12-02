package io;

import java.io.*;

public class CharIOTest02 {

    public static void main(String[] args) {
        // 파일에서부터 받아들이려면 파일에서 읽어들이는 FileReader와 한줄씩 읽어들이는 BufferedReader가 필요하다

        BufferedReader br = null;
        PrintWriter pw = null;
        try {
            br = new BufferedReader( new FileReader( "src/io/CharIOTest02.java"));
            // System.out 의 객체가 PrintWriter 이다
            pw = new PrintWriter( new FileWriter("src/io/test.txt"));
            // PrintWriter 가 발전되어서 FileWriter를 쓰지 않아도 된다.

            String line = null;
            // 파일의 끝에는 null 을 리턴한다
            while( (line = br.readLine()) != null) {
                pw.println( line);
            }

            // IO는 어디에서 읽을거냐
            // 어디에 쓸거냐
            // 어떤 방법으로 읽어낼꺼냐
            // 어떤 방법으로 써줄거냐에 따라 상황에 맞게 사용해야한다.
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 리소스는 무조건 닫아줘야한다
            pw.close();
            try {
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }
}
