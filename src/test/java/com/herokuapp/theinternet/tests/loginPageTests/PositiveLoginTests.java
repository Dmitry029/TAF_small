package com.herokuapp.theinternet.tests.loginPageTests;

import com.herokuapp.theinternet.base.TestUtilities;
import com.herokuapp.theinternet.pages.SecureAreaPage;
import com.herokuapp.theinternet.pages.WelcomePage;
import org.openqa.selenium.Cookie;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PositiveLoginTests extends TestUtilities {

    @Test
    public void logInTest() {

        new WelcomePage(driver, log)
                .openPage()
                .clickFormAuthenticationLink()
                .addNewCookie("username", "tomsmith")
                .loginValidCred("tomsmith", "SuperSecretPassword!");

        takeScreenshot("SecureAreaPage opened");


        // Verifications
        // new url
        String expectedUrl = "http://the-internet.herokuapp.com/secure";
        SecureAreaPage secureAreaPage = new SecureAreaPage(driver, log);

        //set cookie
        Cookie ck = new Cookie("testCookie", "test");
        secureAreaPage.setCookie(ck);

        //Get cookies
        log.info("+++ Username cookie: " + secureAreaPage.getCookie("username"));
        log.info("+++ Test cookie: " + secureAreaPage.getCookie("testCookie"));
        log.info("+++ Session name cookie: " + secureAreaPage.getCookie("rack.session"));

        Assert.assertEquals(secureAreaPage.getPageUrl(), expectedUrl);

        // log out button is visible
        Assert.assertTrue(secureAreaPage.isLogOutButtonVisible(),
                "logOutButton is not visible.");

        // Successful log in message
        String expectedSuccessMessage = "You logged into a secure area!";
        String actualSuccessMessage = secureAreaPage.getSuccessMessage();
        Assert.assertTrue(actualSuccessMessage.contains(expectedSuccessMessage),
                "actualSuccessMessage does not contain expectedSuccessMessage\nexpectedSuccessMessage: "
                        + expectedSuccessMessage + "\nactualSuccessMessage: " + actualSuccessMessage);
    }
}
