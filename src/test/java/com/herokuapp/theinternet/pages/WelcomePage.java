package com.herokuapp.theinternet.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WelcomePage extends BasePage {

    private String pageUrl = "http://the-internet.herokuapp.com/";

    @FindBy(linkText = "Form Authentication")
    WebElement formAuthenticationLink;

    @FindBy(linkText = "Checkboxes")
    WebElement checkboxesLink;

    @FindBy(linkText = "Dropdown")
    WebElement dropdownLink;

    @FindBy(linkText = "JavaScript Alerts")
    WebElement jsAlertsLink;

    @FindBy(linkText = "Multiple Windows")
    WebElement multipleWindowsLink;

    @FindBy(linkText = "WYSIWYG Editor")
    WebElement editorLinkLocator;



    public WelcomePage(WebDriver driver, Logger log) {
        super(driver, log);
    }

    public WelcomePage openPage() {
        log.info("*** Open page: " + pageUrl);
        openUrl(pageUrl);
        log.info("*** Page opened.");
        return this;
    }

    public LoginPage clickFormAuthenticationLink() {
        log.info("*** Click Form Authentication link in the Welcome page");
        click(formAuthenticationLink);
        return new LoginPage(driver, log);
    }

    public CheckboxesPage clickCheckboxes() {
        log.info("*** Click Checkboxes link on Welcome page");
        click(checkboxesLink);
        return new CheckboxesPage(driver, log);
    }

    public DropdownPage clickDropdown() {
        log.info("*** Click Dropdown link on Welcome page");
        click(dropdownLink);
        return new DropdownPage(driver, log);
    }

    public JavaScriptAlertsPage clickJavaScriptAlerts() {
        log.info("*** Click JavaScript Alerts link on Welcome page");
        click(jsAlertsLink);
        return new JavaScriptAlertsPage(driver, log);
    }

    public WindowsPage clickMultipleWindowsLink() {
        log.info("*** Clicking Multiple Windows link on Welcome Page");
        multipleWindowsLink.click();
        return new WindowsPage(driver, log);
    }

    public EditorPage clickWYSIWYGEditorLink() {
        log.info("Clicking WYSIWYG Editor link on Welcome Page");
        editorLinkLocator.click();
        return new EditorPage(driver, log);
    }
}
