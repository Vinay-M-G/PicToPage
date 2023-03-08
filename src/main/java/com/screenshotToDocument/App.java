package com.screenshotToDocument;

import com.screenshotToDocument.Session.impl.SessionServiceImpl;

public class App 
{
    public static void main( String[] args )
    {
    	SessionServiceImpl sessionService = new SessionServiceImpl();
    	sessionService.startSession();
    }
}
