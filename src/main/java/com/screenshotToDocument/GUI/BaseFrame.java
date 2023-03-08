package com.screenshotToDocument.GUI;

import java.awt.Rectangle;

import javax.swing.JFrame;

public class BaseFrame {
	
	private static int positionX = 200;
	private static int positionY = 300;
	private int height;
	private int width;
	
	public BaseFrame(int height , int width) {
		this.height = height;
		this.width = width;
	}
	
	public JFrame createFrame(String title) {
		
		JFrame frame = new JFrame(title);
		frame.setBounds(positionX, positionY, width, height);
		frame.setAlwaysOnTop(true);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
		return frame;
		
	}
}
