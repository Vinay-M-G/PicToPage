package com.screenshotToDocument.Components.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.util.Units;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

import com.screenshotToDocument.Components.DocumentWriter;

public class WordDoumentWriter implements DocumentWriter{
	
	private static Logger logger = LogManager.getLogger(WordDoumentWriter.class);
	
	private static final int imageType = XWPFDocument.PICTURE_TYPE_PNG;
	private static final int imageWidth = 450;
	private static final int imageHeight = 345;
	
	private XWPFDocument document;
	private FileOutputStream outputWordFile; 
	
	
	public WordDoumentWriter(String fileName) throws FileNotFoundException {
		 Utilities utility = new Utilities();
		 XWPFDocument document = new XWPFDocument();
		 
		 String documentPath = utility.getResultsFolderPath() + fileName + ".docx";
		 FileOutputStream outputWordFile = new FileOutputStream(new File(documentPath));
		 
		 this.document = document;
		 this.outputWordFile = outputWordFile;
		 
		 logger.info("Created an instance of the word document");
	}
	
	@Override
	public void writeImagesFromFolder(){
		
		List<String> imagePathList = getListOfimageFiles();
		
		imagePathList.stream().forEach( element -> {
			
			File image = new File(element);
			
			try {
				
				logger.info("Writing image from : " + element);
				XWPFParagraph paragraph = document.createParagraph();
				XWPFRun paragraphRun = paragraph.createRun();
				FileInputStream imageData = new FileInputStream(image);
				
				paragraphRun.addPicture(imageData, imageType, image.getName(), Units.toEMU(imageWidth), Units.toEMU(imageHeight));
				
				document.write(outputWordFile);
				imageData.close();
				
			} catch (Exception e) {
				
				logger.debug("Exception while writing image from : " + element);
				e.printStackTrace();
			}
		});
		
		
		try {
			
			outputWordFile.close();
			document.close();
			logger.info("Word File Saved Successfully");
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
	}
	
	private List<String> getListOfimageFiles(){
		
		List<String> imageAbsolutePaths = new ArrayList<String>();
		Utilities utility = new Utilities();
		String imageFolderPath = utility.getFolderPath();
		
		File imageFolder = new File(imageFolderPath);
		for(String element : imageFolder.list()) {

			imageAbsolutePaths.add(imageFolderPath + element);
		}
		
		return imageAbsolutePaths;
		
		
	}
	

}
