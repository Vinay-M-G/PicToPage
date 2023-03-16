package com.screenshotToDocument.Components.impl;

import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

public class ScreenShotHandler {
	
	public boolean takeScreenShot(int index) {
		
		Utilities utility = new Utilities();
		
		try {
			String path = createImageDynamicPath(index, utility);
			Robot robot = new Robot();
			
			Rectangle resolution = new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());
			BufferedImage image = robot.createScreenCapture(resolution);
			
			ImageIO.write(image, utility.getImageFormat() , new File(path));
			
		} catch (Exception ex) {
			
			ex.printStackTrace();
			return false;
		}
		
		
		return true;
	}

	private String createImageDynamicPath(int index, Utilities utility){
		return utility.getFolderPath() + Integer.toString(index) + "." + utility.getImageFormat();
	}
}
