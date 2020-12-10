package com.herokuapp.theinternet.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.stream.Collectors;

public class CheckboxesPage extends BasePage {

    @FindBy(css = "[type=checkbox]")
    List<WebElement> checkboxes;


    public CheckboxesPage(WebDriver driver, Logger log) {
        super(driver, log);
    }

    public void selectAllCheckboxes() {
        log.info("*** Find all unchecked checkboxes and check them");
        checkboxes.stream()
                .filter(element -> !element.isSelected())
                .collect(Collectors.toList())
                .forEach(this::click);
    }

    public boolean areAllCheckboxesChecked() {
        log.info("*** Verify that all checkboxes are checked");
        return checkboxes.stream().allMatch(WebElement::isSelected);
    }

}
