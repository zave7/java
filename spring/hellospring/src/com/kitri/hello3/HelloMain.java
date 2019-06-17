package com.kitri.hello3;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

public class HelloMain {
	public static void main(String[] args) {
//		HelloServiceKor helloServiceKor = new HelloServiceKor();
//		String msg = helloServiceKor.helloKor("권영찬");
//		HelloService helloService = new HelloServiceEng();
		
//		빈을 만드는 공장 2.x
//		Resource resource = new ClassPathResource("com/kitri/hello3/applicationContext.xml"); //경로로 써야한다
//																							//.은 패키지를 접근할 때
//		BeanFactory beanFactory = new XmlBeanFactory(resource);
//		HelloService helloService = (HelloService) beanFactory.getBean("hs");
		
		System.out.println("프로그램 시작함");
		ApplicationContext context = new ClassPathXmlApplicationContext("com/kitri/hello3/applicationContext.xml"); //CPXAC 카멜 케이스로 가능
		System.out.println("설정파일 읽음");
		HelloService helloService = context.getBean("hs", HelloService.class);
		System.out.println("service 얻음");
		String msg = helloService.hello("권영찬");
		System.out.println(msg);
	}
}