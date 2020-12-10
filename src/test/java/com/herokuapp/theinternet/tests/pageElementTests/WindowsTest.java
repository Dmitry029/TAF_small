package com.herokuapp.theinternet.tests.pageElementTests;

import com.herokuapp.theinternet.base.TestUtilities;
import com.herokuapp.theinternet.pages.WelcomePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class WindowsTest extends TestUtilities {

    @Test
    public void newWindowTest() {

        String pageSource = new WelcomePage(driver, log)
                .openPage()
                .clickMultipleWindowsLink()
                .openNewWindow()
                .switchToNewWindowPage()
                .getCurrentPageSource();

        // Verification that new page contains expected text in source
        Assert.assertTrue(pageSource.contains("New Window"), "New page source doesn't contain expected text");
    }
}
