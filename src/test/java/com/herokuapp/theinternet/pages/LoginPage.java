package com.herokuapp.theinternet.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

    @FindBy(id = "username")
    WebElement usernameLink;

    @FindBy(id = "password")
    WebElement passwordLink;

    @FindBy(className = "radius")
    WebElement loginButton;

    @FindBy(id = "flash")
    WebElement errorMessage;


    public LoginPage(WebDriver driver, Logger log) {
        super(driver, log);
    }

    public LoginPage addNewCookie(String name, String value) {
        Cookie ck = new Cookie(name, value);
        new LoginPage(driver, log).setCookie(ck);
        return this;
    }

    public SecureAreaPage loginValidCred(String username, String password) {
        login(username, password);
        return new SecureAreaPage(driver, log);
    }

    public LoginPage loginInvalidCred(String username, String password) {
        login(username, password);
        return this;
    }

    private void login(String username, String password) {
        log.info("*** Executing LogIn with username [" + username + "] and password [" + password + "]");
        type(username, usernameLink);
        type(password, passwordLink);
        click(loginButton);
    }


    public String getErrorMessage() {
        return errorMessage.getText();
    }
}
