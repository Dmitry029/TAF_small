package com.herokuapp.theinternet.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WindowsPage extends BasePage{

    @FindBy(linkText = "Click Here")
    WebElement clickHereLinkLocator;

    public WindowsPage(WebDriver driver, Logger log) {
        super(driver, log);
    }

    /** Click 'Click Here' link to open new window */
    public WindowsPage openNewWindow() {
        log.info("*** Clicking 'Click Here' link");
        clickHereLinkLocator.click();
        return new WindowsPage(driver, log);
    }

    /** Find page with title "New Window" and switch to it */
    public NewWindowPage switchToNewWindowPage() {
        log.info("*** Looking for 'New Window' page");
        switchToWindowWithTitle("New Window");
        return new NewWindowPage(driver, log);
    }
}
