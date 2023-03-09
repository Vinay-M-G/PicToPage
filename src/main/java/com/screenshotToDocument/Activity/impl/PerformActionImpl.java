package com.screenshotToDocument.Activity.impl;

import com.screenshotToDocument.Activity.PerformAction;
import com.screenshotToDocument.Components.impl.ScreenShotHandler;

public class PerformActionImpl implements PerformAction{
	
	private int screenShotIndex = 0;
	
	private void setScreenShotIndex(int index) {
		this.screenShotIndex = screenShotIndex + 1;
	}
	
	public String getScreenShotIndex() {
		return Integer.toString(screenShotIndex);
	}
	
	@Override
	public void saveDocument() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void createScreenShot() { 
		ScreenShotHandler screenShotHandler = new ScreenShotHandler();
		boolean status = screenShotHandler.takeScreenShot(screenShotIndex);
		
		if(status) {
			setScreenShotIndex(screenShotIndex);
	
		}
	}

}
