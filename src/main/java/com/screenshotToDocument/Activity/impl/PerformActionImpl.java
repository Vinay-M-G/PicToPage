package com.screenshotToDocument.Activity.impl;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

import com.screenshotToDocument.Activity.PerformAction;
import com.screenshotToDocument.Components.impl.ScreenShotHandler;
import com.screenshotToDocument.Components.impl.WordDoumentWriter;

public class PerformActionImpl implements PerformAction{
	
	private static Logger logger = LogManager.getLogger(PerformActionImpl.class);
	
	private int screenShotIndex = 0;
	
	private void setScreenShotIndex(int index) {
		this.screenShotIndex = screenShotIndex + 1;
	}
	
	public String getScreenShotIndex() {
		return Integer.toString(screenShotIndex);
	}
	
	@Override
	public void saveDocument(String fileName) {
		try {
			WordDoumentWriter wordDocumentWriter = new WordDoumentWriter(fileName);
			wordDocumentWriter.writeImagesFromFolder();
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}

	@Override
	public void createScreenShot() { 
		ScreenShotHandler screenShotHandler = new ScreenShotHandler();
		boolean status = screenShotHandler.takeScreenShot(screenShotIndex);
		
		if(status) {
			logger.info("ScreenShot with index : " + screenShotIndex + " saved successfully");
			setScreenShotIndex(screenShotIndex);	
		}
	}

}
