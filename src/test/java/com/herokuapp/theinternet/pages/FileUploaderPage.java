package com.herokuapp.theinternet.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FileUploaderPage extends BasePage {

	private String pageUrl = "http://the-internet.herokuapp.com/upload";


	@FindBy(id = "file-upload")
	WebElement choseFileFieldLocator;

	@FindBy(id = "file-submit")
	WebElement uploadButtonLocator;

	@FindBy(id = "uploaded-files")
	WebElement uploadedFilesLocator;


	public FileUploaderPage(WebDriver driver, Logger log) {
		super(driver, log);
	}

	/** Open FileUploaderPage with it's url */
	public void openPage() {
		log.info("*** Opening page: " + pageUrl);
		openUrl(pageUrl);
		log.info("*** Page opened!");
	}

	/** Push Upload button */
	public void pushUploadButton() {
		log.info("Clicking on upload button");
		uploadButtonLocator.click();
	}

	/** Push Upload button */
	public void selectFile(String fileName) {
		log.info("*** Selecting '" + fileName + "' file from Files folder");
		// Selecting file
		// String filePath = "C:\\Users\\Dmitry\\Downloads\\some-file.txt";
		String filePath = System.getProperty("user.dir") + "//src//main//resources//files//" + fileName;
		type(filePath, choseFileFieldLocator);
		log.info("File selected");
	}

	/** Get names of uploaded files */
	public String getUploadedFilesNames() {
		String names = uploadedFilesLocator.getText();
		log.info("*** Uploaded files: " + names);
		return names;
	}
}