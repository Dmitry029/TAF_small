package com.herokuapp.theinternet.tests.pageElementTests;

import com.herokuapp.theinternet.base.TestUtilities;
import com.herokuapp.theinternet.pages.WelcomePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DropdownTests extends TestUtilities {

    @Test
    public void optionTwoTest() {
        log.info("*** Start selectingTwoCheckboxesTest");
        String selectedOption = new WelcomePage(driver, log)
                .openPage()
                .clickDropdown()
                .selectOption(2)
                .getSelectedOption();

        Assert.assertEquals(selectedOption, "Option 2",
                "Option 2 is not selected. Instead selected - " + selectedOption);
    }
}
