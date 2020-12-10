package com.herokuapp.theinternet.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SecureAreaPage extends BasePage {

    @FindBy(xpath = "//a[@class='button secondary radius']")
    WebElement logOutButton;

    @FindBy(id = "flash")
    WebElement actualSuccessMessage;

    public SecureAreaPage(WebDriver driver, Logger log) {
        super(driver, log);
    }

    public boolean isLogOutButtonVisible() {
        return logOutButton.isDisplayed();
    }

    public String getSuccessMessage() {
        return actualSuccessMessage.getText();
    }
}
