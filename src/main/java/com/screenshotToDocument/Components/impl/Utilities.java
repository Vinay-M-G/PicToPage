package com.screenshotToDocument.Components.impl;

public class Utilities {
	
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
}
