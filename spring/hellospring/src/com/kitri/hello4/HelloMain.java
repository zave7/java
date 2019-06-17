package com.kitri.hello4;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

public class HelloMain {
	public static void main(String[] args) {
		
		ApplicationContext context = new AnnotationConfigApplicationContext(HelloServiceFactory.class); //ACAC 카멜 케이스로 가능
		HelloService helloService = context.getBean("hs", HelloService.class);
		String msg = helloService.hello("권영찬");
		System.out.println(msg);
		
		HelloService helloService1 = context.getBean("hs", HelloService.class);
		HelloService helloService2 = context.getBean("helloservice", HelloService.class);
		
		System.out.println(helloService1 + " " + helloService2);
		
		//annotation으로 사용가능
	}
}