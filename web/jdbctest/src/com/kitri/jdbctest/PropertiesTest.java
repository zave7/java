package com.kitri.jdbctest;

import java.io.*;
import java.util.Properties;

public class PropertiesTest {
	public static void main(String[] args) {
		Properties prop = new Properties();
		try {
			prop.load(new FileReader(new File("src/com/kitri/jdbctest/test.properties")));
			String name = prop.getProperty("name_kor");
			System.out.println(name);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
