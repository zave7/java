package com.kitri.listener;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

@WebListener
public class MySessionAttributeListener implements HttpSessionAttributeListener {
	private int loginCount;
    public MySessionAttributeListener() {
    	
    }

    public void attributeAdded(HttpSessionBindingEvent e)  {
    	if("loginInfo".equals(e.getName())) {
    		loginCount++;
    		System.out.println(e.getValue() + "님이 로그인하셨습니다");
    		System.out.println("현재 접속중인 유저 : " + loginCount + "명");
    	}
    }

    public void attributeRemoved(HttpSessionBindingEvent e)  {
    	System.out.println("remove");
    	if("loginInfo".equals(e.getName())) {
    		loginCount--;
    		System.out.println(e.getValue() + "님이 로그아웃하셨습니다");
    		System.out.println("현재 접속중인 유저 : " + loginCount + "명");
    	}
    }

    public void attributeReplaced(HttpSessionBindingEvent arg0)  {
    	
    }
	
}
