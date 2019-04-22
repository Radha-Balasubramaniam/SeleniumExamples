package com.ca.tools.docops.rally;

import java.util.HashMap;
import java.util.Map;

import javax.swing.JToggleButton.ToggleButtonModel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.FindBy;

import com.ca.tools.docops.pageObjectRepository.ContentPage;

public class Test {
    @FindBy(id = "edit-menu-enabled") private static WebElement provideMenuLinkCheckbox;
    
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        System.setProperty("org.uncommons.reportng.escape-output", "false");
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--start-maximized");
        chromeOptions.addArguments("--disable-web-security");
        chromeOptions.addArguments("--no-proxy-server");
        Map<String, Object> prefs = new HashMap<String, Object>();
        prefs.put("credentials_enable_service", false);
        prefs.put("profile.password_manager_enabled", false);
        chromeOptions.setExperimentalOption("prefs", prefs);
        WebDriver driver = new ChromeDriver(chromeOptions);
        toggleMenuLinkCheckbox(null);
      
    }
    
    public static void toggleMenuLinkCheckbox(Boolean menuLinkCheckbox) {    
        if (!Boolean.valueOf(menuLinkCheckbox)) {
            if (provideMenuLinkCheckbox.isEnabled()) {
                provideMenuLinkCheckbox.click();
            }
        }else{
            if (!provideMenuLinkCheckbox.isEnabled()) {
                provideMenuLinkCheckbox.click();
            } 
        }
    }
}
