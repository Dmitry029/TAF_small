package com.herokuapp.theinternet.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Iterator;
import java.util.Set;

public class BasePage {
    public WebDriver driver;
    public Logger log;

    public BasePage(WebDriver driver, Logger log) {
        this.driver = driver;
        this.log = log;
        PageFactory.initElements(driver, this);
    }

    public void openUrl(String url) {
        driver.get(url);
    }

    public String getPageUrl() {
        return driver.getCurrentUrl();
    }

    /**
     * Get title of current page
     */
    public String getCurrentPageTitle() {
        return driver.getTitle();
    }

    /**
     * Get source of current page
     */
    public String getCurrentPageSource() {
        return driver.getPageSource();
    }

    public void click(WebElement element) {
        element.click();
    }

    public void type(String text, WebElement element) {
        element.sendKeys(new CharSequence[]{text});
    }

    /**
     * Wait for alert present and then switch to it
     */
    protected Alert switchToAlert() {
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.alertIsPresent());
        return driver.switchTo().alert();
    }

    /**
     * Switch to iFrame using it's locator
     */
    protected void switchToFrame(WebElement element) {
        driver.switchTo().frame(element);
    }




    private void waitFor(ExpectedCondition<WebElement> condition, Integer timeOutInSeconds) {
        timeOutInSeconds = timeOutInSeconds != null ? timeOutInSeconds : 30;
        WebDriverWait wait = new WebDriverWait(this.driver, (long) timeOutInSeconds);
        wait.until(condition);
    }

    protected void waitForVisibilityOf(By locator, Integer... timeOutInSeconds) {
        int attempts = 0;
        while (attempts < 2) {
            try {
                waitFor(ExpectedConditions.visibilityOfElementLocated(locator),
                        (timeOutInSeconds.length > 0 ? timeOutInSeconds[0] : null));
                break;
            } catch (StaleElementReferenceException e) {
            }
            attempts++;
        }
    }

    public void switchToWindowWithTitle(String expectedTitle) {
        // Switching to new window
        String firstWindow = driver.getWindowHandle();

        Set<String> allWindows = driver.getWindowHandles();
        Iterator<String> windowsIterator = allWindows.iterator();

        while (windowsIterator.hasNext()) {
            String windowHandle = windowsIterator.next();
            if (!windowHandle.equals(firstWindow)) {
                driver.switchTo().window(windowHandle);
                if (getCurrentPageTitle().equals(expectedTitle)) {
                    break;
                }
            }
        }
    }

    /**
     * Perform scroll to the bottom
     */
    public void scrollToBottom() {
        log.info("Scrolling to the bottom of the page");
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("window.scrollTo(0, document.body.scrollHeight)");
    }

    /**
     * Add cookie
     */
    public void setCookie(Cookie ck) {
        log.info("Adding cookie " + ck.getName());
        driver.manage().addCookie(ck);
        log.info("Cookie added");
    }

    /**
     * Get cookie value using cookie name
     */
    public String getCookie(String name) {
        log.info("Getting value of cookie " + name);
        return driver.manage().getCookieNamed(name).getValue();
    }
}
