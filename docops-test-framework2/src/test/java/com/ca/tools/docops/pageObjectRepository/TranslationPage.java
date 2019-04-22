package com.ca.tools.docops.pageObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class TranslationPage {
    private WebDriver driver;

    public TranslationPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
}
