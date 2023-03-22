package com.screenshotToDocument;

import com.screenshotToDocument.Session.impl.SessionServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class App 
{
    public static void main( String[] args )
    {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring_beans.xml");
        System.out.println(context.containsBean("utility"));
        SessionServiceImpl sessionService = (SessionServiceImpl) context.getBean("sessionServiceImpl");
    	sessionService.startSession();
    	
    }
}
