package com.herokuapp.theinternet.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class DropdownPage extends BasePage {

    @FindBy(css = "#dropdown")
    WebElement dropdownElement;


    public DropdownPage(WebDriver driver, Logger log) {
        super(driver, log);
    }

    public DropdownPage selectOption(int i) {
        log.info("*** Selecting option " + i + " from dropdown");
        Select dropdown = new Select(dropdownElement);

        // There are three ways to use Select class
         /*#1
         dropdown.selectByIndex(i);*/

        // #2
        dropdown.selectByValue("" + i); //!!! The way how to convert int to String

        /*#3
         dropdown.selectByVisibleText("Option " + i);*/
        return this;
    }

    public String getSelectedOption() {
        return new Select(dropdownElement)
                .getFirstSelectedOption().getText();
    }
}
