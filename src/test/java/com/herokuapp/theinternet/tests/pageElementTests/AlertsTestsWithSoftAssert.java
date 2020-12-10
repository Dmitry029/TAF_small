package com.herokuapp.theinternet.tests.pageElementTests;

import com.herokuapp.theinternet.base.TestUtilities;
import com.herokuapp.theinternet.pages.JavaScriptAlertsPage;
import com.herokuapp.theinternet.pages.WelcomePage;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class AlertsTestsWithSoftAssert extends TestUtilities {

    @Test
    public void jsAlertsTest() {
        log.info("*** Start jsAlertsTest");
        SoftAssert softAssert = new SoftAssert();

        String alertMessage = new WelcomePage(driver, log)
                .openPage()
                .clickJavaScriptAlerts()
                .openJsAlert()
                .getAlertText();
        softAssert.assertTrue(alertMessage.equals("I am a JS Alert"),
                "Alert message is not expected. \nShould be 'I am a JS Alert', but it is '" + alertMessage + "'");

        String result = new JavaScriptAlertsPage(driver, log)
                .acceptAlert()
                .getResultText();
        softAssert.assertTrue(result.equals("You successfuly clicked an alert"),
                "result is not expected. \nShould be 'You successfuly clicked an alert', but it is '" + result + "'");
        softAssert.assertAll();
    }

    @Test
    public void jsDismissTest() {
        log.info("*** Starting jsDismissTest");
        SoftAssert softAssert = new SoftAssert();

        String alertMessage = new WelcomePage(driver, log)
                .openPage()
                .clickJavaScriptAlerts()
                .openJSConfirm()
                .getAlertText();

        String result = new JavaScriptAlertsPage(driver, log)
                .dismissAlert()
                .getResultText();

        // Verifications
        // 1 - Alert text is expected
        softAssert.assertTrue(alertMessage.equals("I am a JS Confirm"),
                "Alert message is not expected. \nShould be 'I am a JS Confirm', but it is '" + alertMessage + "'");

        // 2 - Result text is expected
        softAssert.assertTrue(result.equals("You clicked: Cancel"),
                "result is not expected. \nShould be 'You clicked: Cancel', but it is '" + result + "'");
        softAssert.assertAll();
    }

    @Test
    public void jsPromptTest() {
        log.info("*** Starting jsDismissTest");
        SoftAssert softAssert = new SoftAssert();
        String alertMessage = new WelcomePage(driver, log)
                .openPage()
                .clickJavaScriptAlerts()
                .openJSPrompt()
                .getAlertText();

        JavaScriptAlertsPage alertsPage = new JavaScriptAlertsPage(driver, log);
        // Type text into alert
        alertsPage.typeTextIntoAlert("Hello Alert, it's Dmitry here");
        String result = alertsPage.getResultText();

        // Verifications
        // 1 - Alert text is expected
        softAssert.assertTrue(alertMessage.equals("I am a JS prompt"),
                "Alert message is not expected. \nShould be 'I am a JS prompt', but it is '" + alertMessage + "'");

        // 2 - Result text is expected
        softAssert.assertTrue(result.equals("You entered: Hello Alert, it's Dmitry here"),
                "result is not expected. \nShould be 'You entered: Hello Alert, it's Dmitry here', but it is '" + result
                        + "'");
        softAssert.assertAll();
    }
}
