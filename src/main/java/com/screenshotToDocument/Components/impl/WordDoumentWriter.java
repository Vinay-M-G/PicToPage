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
	
	private static final Logger LOGGER = LogManager.getLogger(WordDoumentWriter.class);
	
	private static final int IMAGE_TYPE = XWPFDocument.PICTURE_TYPE_PNG;
	private static final int IMAGE_WIDTH = 480;
	private static final int IMAGE_HEIGHT = 250;
	
	private XWPFDocument document;
	private FileOutputStream outputWordFile; 
	
	
	public WordDoumentWriter(String fileName) throws FileNotFoundException {
		 Utilities utility = new Utilities();
		 XWPFDocument document = new XWPFDocument();
		 
		 String documentPath = utility.getResultsFolderPath() + fileName + ".docx";
		 FileOutputStream outputWordFile = new FileOutputStream(new File(documentPath));
		 
		 this.document = document;
		 this.outputWordFile = outputWordFile;

		 LOGGER.info("Created an instance of the word document");
	}
	
	@Override
	public void writeImagesFromFolder(){
		
		List<String> imagePathList = getListOfimageFiles();
		
		imagePathList.stream().forEach( element -> {
			
			File image = new File(element);
			
			try {
				
				LOGGER.info("Writing image from : " + element);
				XWPFParagraph paragraph = document.createParagraph();
				XWPFRun paragraphRun = paragraph.createRun();
				FileInputStream imageData = new FileInputStream(image);

				paragraphRun.addBreak();
				paragraphRun.addPicture(imageData, IMAGE_TYPE, image.getName(), Units.toEMU(IMAGE_WIDTH), Units.toEMU(IMAGE_HEIGHT));
				
				imageData.close();
				
			} catch (Exception e) {
				
				LOGGER.debug("Exception while writing image from : " + element);
				e.printStackTrace();
			}
		});
		
		
		try {
			document.write(outputWordFile);
			outputWordFile.close();
			document.close();

			LOGGER.info("Word File Saved Successfully");
			
		} catch (Exception e) {
			
			LOGGER.error("An Error Occured while saving word Document");
			e.printStackTrace();
		}
		
	}
	
	private List<String> getListOfimageFiles(){
		int fileCount = 0;

		List<String> imageAbsolutePaths = new ArrayList<String>();
		Utilities utility = new Utilities();
		String imageFolderPath = utility.getFolderPath();
		
		File imageFolder = new File(imageFolderPath);

		if(imageFolder.list().length != 0){
			fileCount  = imageFolder.list().length;
		}


		for(int index = 0; index < fileCount; index++){
			imageAbsolutePaths.add(utility.getFolderPath() + index + "." + utility.getImageFormat());
		}
		
		return imageAbsolutePaths;
		
		
	}
	

}
