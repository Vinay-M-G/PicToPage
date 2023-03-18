package com.screenshotToDocument.Session.impl;

import com.screenshotToDocument.Components.impl.Utilities;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

import com.screenshotToDocument.GUI.impl.UIComponentsImpl;
import com.screenshotToDocument.Session.SessionService;

import java.io.File;

public class SessionServiceImpl implements SessionService {
	
	private static Logger LOGGER = LogManager.getLogger(SessionServiceImpl.class);

	public SessionServiceImpl(){

		Utilities utility = new Utilities();

		File documentFolder = new File(utility.getResultsFolderPath());
		File imageFolder = new File(utility.getFolderPath());

		if(!documentFolder.isDirectory()){
			boolean directoryCreationStatus = documentFolder.mkdirs();

			if(directoryCreationStatus){
				LOGGER.info("Created Directory : " + utility.getResultsFolderPath());
			}
		}

		if(!imageFolder.isDirectory()) {
			boolean directoryCreationStatus = imageFolder.mkdirs();

			if (directoryCreationStatus) {
				LOGGER.info("Created Directory : " + utility.getFolderPath());
			}
		}

	}
	@Override
	public void startSession() {
		
		UIComponentsImpl uiComponents = new UIComponentsImpl();
		uiComponents.renderStartWindow();
		LOGGER.info("Session Started Successfully");
	}

}
