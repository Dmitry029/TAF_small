package com.herokuapp.theinternet.tests.loginPageTests;

import com.herokuapp.theinternet.base.TestUtilities;
import com.herokuapp.theinternet.pages.WelcomePage;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class NegativeLoginTests extends TestUtilities {

    @Parameters({"username", "password", "expectedMessage"})
    @Test(priority = 1)
    public void negativeLogInTest(String username, String password, String expectedErrorMessage) {
        log.info("*** Starting negativeTest");

        String actualErrorMessage = new WelcomePage(driver, log)
                .openPage()
                .clickFormAuthenticationLink()
                .loginInvalidCred(username, password)
                .getErrorMessage();

        // Verification
        Assert.assertTrue(actualErrorMessage.contains(expectedErrorMessage),
                "actualErrorMessage does not contain expectedErrorMessage\nexpectedErrorMessage: "
                        + expectedErrorMessage + "\nactualErrorMessage: " + actualErrorMessage);
    }

}
