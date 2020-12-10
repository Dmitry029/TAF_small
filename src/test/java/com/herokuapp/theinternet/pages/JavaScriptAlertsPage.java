package com.herokuapp.theinternet.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class JavaScriptAlertsPage extends BasePage {

    @FindBy(xpath = "//button[text()='Click for JS Alert']")
    WebElement clickForJSAlertButton;

    @FindBy(xpath = "//button[text()='Click for JS Confirm']")
    WebElement clickForJSConfirmButton;

    @FindBy(xpath = "//button[text()='Click for JS Prompt']")
    WebElement clickForJSPromptButton;

    @FindBy(css = "#result")
    WebElement resultText;


    public JavaScriptAlertsPage(WebDriver driver, Logger log) {
        super(driver, log);
    }

    public JavaScriptAlertsPage openJsAlert() {
        log.info("*** Clicking on 'Click for JS Alert' button to open alert");
        clickForJSAlertButton.click();
        return this;
    }

    public JavaScriptAlertsPage openJSConfirm() {
        log.info("*** Clicking on 'Click for JS Confirm' button to open alert");
        clickForJSConfirmButton.click();
        return this;
    }

    public JavaScriptAlertsPage openJSPrompt() {
        log.info("*** Clicking on 'Click for JS Prompt' button to open alert");
        clickForJSPromptButton.click();
        return this;
    }

    public String getAlertText() {
        Alert alert = switchToAlert();
        String alertText = alert.getText();
        log.info("*** Alert says: " + alertText);
        return alertText;
    }

    public JavaScriptAlertsPage acceptAlert() {
        log.info("*** Switching to alert and pressing OK");
        Alert alert = switchToAlert();
        alert.accept();
        return this;
    }

    public JavaScriptAlertsPage dismissAlert() {
        log.info("*** Switching to alert and pressing Cancel");
        Alert alert = switchToAlert();
        alert.dismiss();
        return this;
    }

    /** Type text into alert and press OK */
    public void typeTextIntoAlert(String text) {
        log.info("*** Typing text into alert and pressing OK");
        Alert alert = switchToAlert();
        alert.sendKeys(text);
        alert.accept();
    }

    /** Get result text */
    public String getResultText() {
        String result = resultText.getText();
        log.info("*** Result text: " + result);
        return result;
    }
}
