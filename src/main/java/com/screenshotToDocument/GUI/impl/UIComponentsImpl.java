package com.screenshotToDocument.GUI.impl;

import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.screenshotToDocument.GUI.BaseFrame;
import com.screenshotToDocument.GUI.UIComponents;

public class UIComponentsImpl implements UIComponents{
	
	private static String START_SESSION = "Start Session";
	private static String NEW_SESSION_TITLE = "Start";
	private static String NEW_SCREENSHOT_WINDOW_TITLE = "CS";
	
	private ActionListener startScreenShotProcess(final JFrame frame) {
		
		return new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				UIComponentsImpl uiComponentsImpl = new UIComponentsImpl();
				uiComponentsImpl.renderScreenShotWindow();	
			}
			
		};
		
	}
	
	
	@Override
	public void renderStartWindow() {
		BaseFrame baseFrame = new BaseFrame(75, 300);
		JFrame frame = baseFrame.createFrame(NEW_SESSION_TITLE);
		
		JPanel panel = new JPanel();
		panel.setLayout(new FlowLayout());
		
		JButton startSessionButton = new JButton();
		startSessionButton.setText(START_SESSION);
		startSessionButton.addActionListener(startScreenShotProcess(frame));
		
		panel.add(startSessionButton);
		frame.add(panel);
		frame.setVisible(true);

	}

	@Override
	public void renderScreenShotWindow() {
		BaseFrame baseFrame = new BaseFrame(75, 200);
		JFrame frame = baseFrame.createFrame(NEW_SCREENSHOT_WINDOW_TITLE);
		
		JButton captureSSButton = new JButton();
		captureSSButton.setText("SS");
		captureSSButton.setBounds(0, 10, 20, 10);
		
		JLabel screenShotIndexLable = new JLabel();
		screenShotIndexLable.setText("10");
		screenShotIndexLable.setBounds(0, 35, 20, 10);
		screenShotIndexLable.setFont(new Font("Serif", Font.BOLD, 16));
		JButton endSSSession = new JButton();
		endSSSession.setText("End");
		endSSSession.setBounds(0, 60, 20, 10);
		
		JPanel panel = new JPanel();
		panel.setLayout(new FlowLayout());
		
		panel.add(captureSSButton);
		panel.add(screenShotIndexLable);
		panel.add(endSSSession);
		
		frame.add(panel);
		frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		frame.setVisible(true);
	}

	@Override
	public void renderSaveWindow() {
		// TODO Auto-generated method stub
	}

}
