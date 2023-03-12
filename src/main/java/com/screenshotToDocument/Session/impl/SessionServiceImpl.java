package com.screenshotToDocument.Session.impl;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

import com.screenshotToDocument.GUI.impl.UIComponentsImpl;
import com.screenshotToDocument.Session.SessionService;

public class SessionServiceImpl implements SessionService {
	
	private static Logger logger = LogManager.getLogger(SessionServiceImpl.class);
	
	@Override
	public void startSession() {
		
		UIComponentsImpl uiComponents = new UIComponentsImpl();
		uiComponents.renderStartWindow();
		logger.info("Session Started Successfully");
	}

}
