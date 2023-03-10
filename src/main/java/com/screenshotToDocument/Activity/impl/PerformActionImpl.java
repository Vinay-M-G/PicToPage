package com.screenshotToDocument.Activity.impl;

import java.io.FileNotFoundException;

import com.screenshotToDocument.Activity.PerformAction;
import com.screenshotToDocument.Components.impl.ScreenShotHandler;
import com.screenshotToDocument.Components.impl.WordDoumentWriter;

public class PerformActionImpl implements PerformAction{
	
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
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
