package com.screenshotToDocument;

import com.screenshotToDocument.Configurations.ApplicationBeanProvider;
import com.screenshotToDocument.Session.impl.SessionServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App 
{
    public static void main( String[] args )
    {
        ApplicationContext context = new AnnotationConfigApplicationContext(ApplicationBeanProvider.class);
        SessionServiceImpl sessionService = (SessionServiceImpl) context.getBean("sessionServiceImpl");
        sessionService.startSession();
    }
}
