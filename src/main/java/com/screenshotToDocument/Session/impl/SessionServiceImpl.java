package com.screenshotToDocument.Session.impl;

import com.screenshotToDocument.Components.impl.Utilities;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

import com.screenshotToDocument.GUI.impl.UIComponentsImpl;
import com.screenshotToDocument.Session.SessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.File;

public class SessionServiceImpl implements SessionService {
	
	private static final Logger LOGGER = LogManager.getLogger(SessionServiceImpl.class);
	@Autowired
	Utilities utility;
	@Autowired
	UIComponentsImpl uiComponents;

	@Override
	public void startSession() {

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

		uiComponents.renderStartWindow();
		LOGGER.info("Session Started Successfully");
	}

}
