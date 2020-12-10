package com.herokuapp.theinternet.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EditorPage extends BasePage {

	@FindBy(id = "tinymce")
	WebElement editorLocator;

	@FindBy(tagName = "iframe")
	WebElement frame;

	public EditorPage(WebDriver driver, Logger log) {
		super(driver, log);
	}

	/** Get text from TinyMCE WYSIWYG Editor */
	public String getEditorText() {
		switchToFrame(frame);
		String text = editorLocator.getText();
		log.info("Text from TinyMCE WYSIWYG Editor: " + text);
		return text;
	}
}
