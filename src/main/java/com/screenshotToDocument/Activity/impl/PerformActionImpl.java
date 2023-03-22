package com.screenshotToDocument.Activity.impl;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

import com.screenshotToDocument.Activity.PerformAction;
import com.screenshotToDocument.Components.impl.ScreenShotHandler;
import com.screenshotToDocument.Components.impl.Utilities;
import com.screenshotToDocument.Components.impl.WordDoumentWriter;
import org.springframework.beans.factory.annotation.Autowired;

public class PerformActionImpl implements PerformAction{
	
	private static final Logger LOGGER = LogManager.getLogger(PerformActionImpl.class);
	
	private int screenShotIndex = 0;

	@Autowired
	Utilities utility;

	@Autowired
	ScreenShotHandler screenShotHandler;

	@Autowired
	WordDoumentWriter wordDocumentWriter;
	private void setScreenShotIndex(int index) {
		this.screenShotIndex = screenShotIndex + 1;
	}
	
	public String getScreenShotIndex() {
		return Integer.toString(this.screenShotIndex);
	}

	@Override
	public void saveDocument(String fileName) {
		try {
			wordDocumentWriter.initialise(fileName);
			wordDocumentWriter.writeImagesFromFolder();
			utility.performTempFolderCleanUp();
			this.screenShotIndex = 0;

		} catch (Exception e) {

			this.screenShotIndex = 0;
			e.printStackTrace();
		}
	}

	@Override
	public void createScreenShot() {
		boolean status = screenShotHandler.takeScreenShot(screenShotIndex);
		
		if(status) {
			LOGGER.info("ScreenShot with index : " + screenShotIndex + " saved successfully");
			setScreenShotIndex(screenShotIndex);	
		}
	}

}
