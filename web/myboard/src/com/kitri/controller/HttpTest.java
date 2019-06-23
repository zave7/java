package com.kitri.controller;

import java.io.*;
import java.net.Socket;

public class HttpTest {
	public static void main(String[] args) {
		Socket socket = null;
		BufferedReader in = null;
		PrintStream out = null;
		try {
			socket = new Socket("www.daum.net", 80);
			in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			out = new PrintStream(socket.getOutputStream());
			
			//1. 요청 라인
			out.println("GET / HTTP/1.1");
			
			//2. 헤더 정보
			out.println("Host: www.daum.net");
			out.println("User-Agent: Mozilla/5.0 (Macintosh; Intel Mac OS x 10_9_0"
					+ " AppleWebkit/537.36 (KHTML, like Gecko"
					+ "Chrome/30.0.1599.101 Safari/537/36");
			//3. 공백 라인
			out.println();
			
			String line = null;
			while((line = in.readLine()) != null) {
				System.out.println(line);
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				in.close();
				out.close();
				socket.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}