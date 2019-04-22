package com.ca.tools.docops.pageObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ca.tools.docops.common.CommonActions;

public class ConfigPage {
    private WebDriver driver;

    public ConfigPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    @FindBy(linkText = "Account settings") private WebElement accountSettings;
    @FindBy(linkText = "Login destinations") private WebElement loginDestinations;
    @FindBy(linkText = "Comment notification") private WebElement commentNotification;
    @FindBy(linkText = "SimpleSAMLphp Auth Settings") private WebElement simpleSAMLphpAuthSettings;
    @FindBy(linkText = "Diff") private WebElement diff;
    @FindBy(linkText = "Entity Print") private WebElement entityPrint;
    @FindBy(linkText = "Entity browsers") private WebElement entityBrowsers;
    @FindBy(linkText = "Geshifilter") private WebElement geshifilter;
    @FindBy(linkText = "Linkit") private WebElement linkit;
    @FindBy(linkText = "Text formats and editors") private WebElement textFormatsAndEditors;
    @FindBy(linkText = "Text editor embed buttons") private WebElement textEditorEmbedButtons;
    @FindBy(xpath = "//span[text()='URL aliases']") private WebElement urlAliases;
    @FindBy(id = "edit-filter") private WebElement filterTextField;
    @FindBy(id = "edit-submit") private WebElement submitButton;
    @FindBy(xpath = "//a[text()='Delete']") private WebElement deleteButton;
    String listAdditionalActions = "//*[@title='AAAA']/parent::td/following-sibling::td//*[text()='List additional actions']";

    public void filterAlias(String alias) {
        filterTextField.clear();
        filterTextField.sendKeys(alias);
        submitButton.click();
    }

    public void deleteAlias(String alias) {
        if (driver.findElements(By.xpath(listAdditionalActions.replace("AAAA", alias))).size() != 0) {
            CommonActions.javaScriptClick(driver.findElement(By.xpath(listAdditionalActions.replace("AAAA", alias))),
                    driver);
            CommonActions.javaScriptClick(deleteButton, driver);
            submitButton.click();
        }
    }

    public void goToUrlAliases() {
        urlAliases.click();
    }
}
