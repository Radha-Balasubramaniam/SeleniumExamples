package com.ca.tools.docops.pageObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.ca.tools.docops.common.CommonActions;
import com.ca.tools.docops.utils.ConfigReader;
import com.ca.tools.docops.utils.DataProviderClass;

import static com.ca.tools.docops.utils.StringConstants.*;

public class UserLoginPage {
    private WebDriver driver;

    public UserLoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    @FindBy(id = "edit-name") private WebElement userName;
    @FindBy(id = "edit-pass") private WebElement password;
    @FindBy(id = "edit-submit") private WebElement loginBtn;
    ConfigReader configReader = new ConfigReader();

    public void enterUsername(String un) {
        CommonActions.waitForElementToBeClickable(driver, userName);
        userName.clear();
        userName.sendKeys(un);
    }

    public void enterPassword(String pw) {
        CommonActions.waitForElementToBeClickable(driver, password);
        password.clear();
        password.sendKeys(pw);
    }

    public void clickLogin() {
        loginBtn.click();
    }    

    public void logout() {
        driver.navigate().to(configReader.getDrupalLogoutURL());
    }

    public void login(String un, String pw) {
        driver.navigate().to(configReader.getDrupalLoginURL());
        enterUsername(un);
        enterPassword(pw);
        clickLogin();
    }
}
