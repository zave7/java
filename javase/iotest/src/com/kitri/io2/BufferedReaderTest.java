package com.kitri.io2;

import java.io.*;

public class BufferedReaderTest {
	public static void main(String[] args) {
		BufferedReader fin = null; // 문자열로 입력받을 수 있는 것은 이거밖에 없다
		FileWriter fw = null;
		try {
//		InputStreamReader is = System.in;
//		Reader r = new InputStreamReader(is);
//		BufferedReader in = new BufferedReader(r);
			BufferedReader in = new BufferedReader(new InputStreamReader(System.in)); // 어디서 읽어들일지 근원지를 생각
			System.out.print("읽을 파일 이름 : ");
			String inFile = in.readLine(); // readLine 는 엔터를 기준으로 읽어 들인다
//			System.out.print("inFile name : " + inFile);
			
			System.out.print("복사할 파일 이름 : ");
			String outFile = in.readLine(); // readLine 는 엔터를 기준으로 읽어 들인다
			
			fw = new FileWriter(new File(outFile));
					
			fin = new BufferedReader(new InputStreamReader(new FileInputStream(new File(inFile)))); 
			String str;
			while((str = fin.readLine())!=null) {
				System.out.println(str);
				fw.write(str + "\r\n");
				
			}
			
		} catch (IOException e) {
				try {
					if(fin != null)
						fin.close();
					if(fw != null)
						fw.close();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
		}
		
	}
}
