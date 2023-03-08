package com.screenshotToDocument.Session.impl;

import com.screenshotToDocument.GUI.impl.UIComponentsImpl;
import com.screenshotToDocument.Session.SessionService;

public class SessionServiceImpl implements SessionService {

	@Override
	public void startSession() {
		
		UIComponentsImpl uiComponents = new UIComponentsImpl();
		uiComponents.renderStartWindow();
		System.out.println("After");
	}

}
