package com.ca.tools.docops.pageObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ca.tools.docops.common.CommonActions;
import com.ca.tools.docops.utils.ConfigReader;

public class MainPage {
    private WebDriver driver;
    private ConfigReader configReader;
    public MainPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        configReader = new ConfigReader();
    }
    @FindBy(linkText = "Content") private WebElement content;
    @FindBy(id = "toolbar-link-system-admin_structure") private WebElement structure;
    @FindBy(id = "toolbar-link-system-themes_page") private WebElement appearance;
    @FindBy(linkText = "Extend") private WebElement extend;
    @FindBy(linkText = "Configuration") private WebElement configuration;
    @FindBy(id = "toolbar-link-entity-group-collection") private WebElement groups;
    @FindBy(linkText = "People") private WebElement people;
    @FindBy(id = "toolbar-link-lingotek-config-dashboard") private WebElement translation;
    @FindBy(id = "toolbar-link-system-admin_reports") private WebElement reports;
    @FindBy(id = "toolbar-link-help-main") private WebElement help;

    public void clickContent() {
        driver.navigate().to(configReader.getAdminURL());
        CommonActions.javaScriptClick(content, driver);
    }

    public void clickStructure() {
        driver.navigate().to(configReader.getAdminURL());
        CommonActions.javaScriptClick(structure, driver);
    }

    public void clickAppearance() {
        driver.navigate().to(configReader.getAdminURL());
        CommonActions.javaScriptClick(appearance, driver);
    }

    public void clickExtend() {
        driver.navigate().to(configReader.getAdminURL());
        CommonActions.javaScriptClick(extend, driver);
    }

    public void clickConfiguration() {
        driver.navigate().to(configReader.getAdminURL());
        CommonActions.javaScriptClick(configuration, driver);
    }

    public void clickGroups() {
        driver.navigate().to(configReader.getAdminURL());
        CommonActions.javaScriptClick(groups, driver);
    }

    public void clickPeople() {
        driver.navigate().to(configReader.getAdminURL());
        CommonActions.javaScriptClick(people, driver);
    }

    public void clickTranslation() {
        driver.navigate().to(configReader.getAdminURL());
        CommonActions.javaScriptClick(translation, driver);
    }

    public void clickReports() {
        driver.navigate().to(configReader.getAdminURL());
        CommonActions.javaScriptClick(reports, driver);
    }

    public void clickHelp() {
        driver.navigate().to(configReader.getAdminURL());
        CommonActions.javaScriptClick(help, driver);
    }
}
