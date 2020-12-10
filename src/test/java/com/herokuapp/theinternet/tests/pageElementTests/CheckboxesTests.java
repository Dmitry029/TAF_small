package com.herokuapp.theinternet.tests.pageElementTests;

import com.herokuapp.theinternet.base.TestUtilities;
import com.herokuapp.theinternet.pages.CheckboxesPage;
import com.herokuapp.theinternet.pages.WelcomePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckboxesTests extends TestUtilities {
    @Test
    public void selectingTwoCheckboxesTest() {

        new WelcomePage(driver, log)
                .openPage()
                .clickCheckboxes()
                .selectAllCheckboxes();
        Assert.assertTrue(new CheckboxesPage(driver, log).areAllCheckboxesChecked());
    }
}
