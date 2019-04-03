package com.kitri.io2;

import java.io.*;

public class FileTest {
	public static void main(String[] args) {
		InputStream in = null;
		OutputStream out = null;
		//파일의 내용을 읽기
		try { // in out 을 열었으면 닫아야 한다 (연결 했으면 끊어라)
			File infile = new File("f:\\iotest\\hello.txt"); // filepath 입력
			in = new FileInputStream(infile);  // 엔터도 인식하기 때문에 
			long length = infile.length();
			byte b[] = new byte[(int)length];
			int x = in.read(b);
			String str = new String(b, 0 , x);
			System.out.println(str);
			
			File outfile = new File("f:\\iotest\\hello_copy.txt"); // filepath 입력
			out = new FileOutputStream(outfile);
			out.write(b);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
			if(in != null) {
					in.close();
			}
			if(out != null) {
					out.close();
			}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
