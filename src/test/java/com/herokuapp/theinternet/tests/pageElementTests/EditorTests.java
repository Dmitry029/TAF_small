package com.herokuapp.theinternet.tests.pageElementTests;

import com.herokuapp.theinternet.base.TestUtilities;
import com.herokuapp.theinternet.pages.EditorPage;
import com.herokuapp.theinternet.pages.WelcomePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class EditorTests extends TestUtilities {

    @Test
    public void defaultEditorValueTest() {
        log.info("*** Starting defaultEditorValueTest");
        WelcomePage welcomePage = new WelcomePage(driver, log);
        welcomePage.openPage().scrollToBottom();
        String editorText = new WelcomePage(driver, log)
                .clickWYSIWYGEditorLink()
                .getEditorText();
        // Verification that new page contains expected text in source
        Assert.assertTrue(editorText.equals("Your content goes here."),
                "Editor default text is not expected. It is: " + editorText);
    }
}
