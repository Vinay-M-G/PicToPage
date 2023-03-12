package com.screenshotToDocument.Components.impl;

import org.apache.logging.log4j.Logger;
import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;

import java.io.File;
import java.io.IOException;

public class Utilities {
	
	private static Logger logger = LogManager.getLogger(Utilities.class);
	
	private static final String tempFilePath = "E://TempFolder//";
	private static final String imageFormat = "png";
	private static final String resultsFolder = "E://Results//";
	
	public String getFolderPath() {
		return tempFilePath;
	}
	
	public String getImageFormat() {
		return imageFormat;
	}
	
	public String getResultsFolderPath() {
		return resultsFolder;
	}
	
	public void performTempFolderCleanUp() {
		 
	      try {
	    	File directory = new File(tempFilePath);
			FileUtils.cleanDirectory(directory);
			logger.info("Temp Image Directory Cleaned Succssfully");
		} catch (IOException e) {
			
			logger.error("An Error occured while cleaning Temp Images");
			e.printStackTrace();
		}
	}
}
