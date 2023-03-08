package com.screenshotToDocument.GUI.impl;

import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.screenshotToDocument.Activity.impl.PerformActionImpl;
import com.screenshotToDocument.GUI.BaseFrame;
import com.screenshotToDocument.GUI.UIComponents;

public class UIComponentsImpl implements UIComponents{
	
	private static String START_SESSION = "Start Session";
	private static String NEW_SESSION_TITLE = "Start";
	private static String NEW_SCREENSHOT_WINDOW_TITLE = "CS";
	private static String NEW_SAVE_WINDOW_TITLE = "Save Doc";
	
	PerformActionImpl performActionImpl = new PerformActionImpl();
	JLabel screenShotIndexLable = new JLabel();
	
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
	
	private ActionListener endScreenShotProcess(final JFrame frame) {

		return new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				UIComponentsImpl uiComponentsImpl = new UIComponentsImpl();
				uiComponentsImpl.renderSaveWindow();
			}

		};

	}
	
	private ActionListener endSession(final JFrame frame) {

		return new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}

		};

	}
	
	private ActionListener continueSession(final JFrame frame) {

		return new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				UIComponentsImpl uiComponentsImpl = new UIComponentsImpl();
				uiComponentsImpl.renderStartWindow();
			}

		};

	}
	
	private ActionListener initiateScreenShot(final JFrame frame) {

		return new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				performActionImpl.createScreenShot();
				String index = performActionImpl.getScreenShotIndex();
				screenShotIndexLable.setText(" " + index + " ");
				
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
		BaseFrame baseFrame = new BaseFrame(70, 200);
		JFrame frame = baseFrame.createFrame(NEW_SCREENSHOT_WINDOW_TITLE);
		
		JButton captureSSButton = new JButton();
		captureSSButton.setText("SS");
		captureSSButton.setBounds(0, 10, 20, 10);
		captureSSButton.addActionListener(initiateScreenShot(frame));
		
		screenShotIndexLable.setText(" " + performActionImpl.getScreenShotIndex() + " ");
		screenShotIndexLable.setBounds(0, 35, 20, 10);
		screenShotIndexLable.setFont(new Font("Serif", Font.BOLD, 20));
		
		JButton endSSSession = new JButton();
		endSSSession.setText("End");
		endSSSession.setBounds(0, 60, 20, 10);
		endSSSession.addActionListener(endScreenShotProcess(frame));
		
		JPanel panel = new JPanel();
		panel.setLayout(new FlowLayout());
		
		panel.add(captureSSButton);
		panel.add(screenShotIndexLable);
		panel.add(endSSSession);
		
		frame.add(panel);
		frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
	}

	@Override
	public void renderSaveWindow() {
		BaseFrame baseFrame = new BaseFrame(150, 400);
		JFrame frame = baseFrame.createFrame(NEW_SAVE_WINDOW_TITLE);
		
		JLabel documentName = new JLabel();
		documentName.setText("Document Name : ");
		documentName.setFont(new Font("Serif", Font.BOLD, 16));
		
		JTextField fileName = new JTextField("" , 30);
		
		JButton saveAndContinue = new JButton();
		saveAndContinue.addActionListener(continueSession(frame));
		saveAndContinue.setText("Save and Continue");
		
		JButton saveAndExit = new JButton();
		saveAndExit.addActionListener(endSession(frame));
		saveAndExit.setText("Save and Exit");
		
		JPanel panel = new JPanel();
		panel.setLayout(new FlowLayout());
		
		panel.add(documentName);
		panel.add(fileName);
		panel.add(saveAndContinue);
		panel.add(saveAndExit);
		
		frame.add(panel);
		frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
	}

}
