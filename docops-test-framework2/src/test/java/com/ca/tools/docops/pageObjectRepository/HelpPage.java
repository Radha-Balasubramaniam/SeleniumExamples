package com.ca.tools.docops.pageObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class HelpPage {
    private WebDriver driver;

    public HelpPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
}
