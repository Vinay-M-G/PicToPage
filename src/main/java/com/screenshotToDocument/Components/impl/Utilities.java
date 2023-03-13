package com.screenshotToDocument.Components.impl;

import org.apache.logging.log4j.Logger;
import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;

import java.io.File;
import java.io.IOException;

import java.awt.Toolkit;

public class Utilities {
	
	private static Logger LOGGER = LogManager.getLogger(Utilities.class);
	
	private static final String tempFilePath = "C://Temp execution//TempImage//";
	private static final String imageFormat = "png";
	private static final String resultsFolder = "C://Temp execution//";
	
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
			LOGGER.info("Temp Image Directory Cleaned Succssfully");
		} catch (IOException e) {
			
			LOGGER.error("An Error occured while cleaning Temp Images");
			e.printStackTrace();
		}
	}
}
