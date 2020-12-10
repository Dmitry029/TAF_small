package com.herokuapp.theinternet.tests.loginPageTests;

import com.herokuapp.theinternet.base.CsvDataProviders;
import com.herokuapp.theinternet.base.TestUtilities;
import com.herokuapp.theinternet.pages.WelcomePage;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Map;

public class NegativeLoginWithCsvDataProviderTest extends TestUtilities {

    @Test(priority = 1, dataProvider = "csvReader", dataProviderClass = CsvDataProviders.class)
    public void negativeLogInTest(Map<String, String> testData) {
        //Data
        String no = testData.get("no");
        String username  = testData.get("username");
        String password = testData.get("password");
        String expectedErrorMessage = testData.get("expectedMessage");
        String description = testData.get("description");

        log.info("*** Starting negativeLogInTest #" + no + " for " + description);

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
