package com.kitri.hello4;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration //설정파일 이라는 의미 있는 주석
public class HelloServiceFactory {
	
	@Bean(name = {"hs", "helloservice"})
//	@Scope(value = "prototype")
	public HelloService getHelloService() {
		return new HelloServiceKor();
	}
	
}
