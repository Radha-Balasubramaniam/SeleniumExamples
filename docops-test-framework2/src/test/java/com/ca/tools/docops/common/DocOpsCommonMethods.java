package com.ca.tools.docops.common;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.ca.tools.docops.pageObjectRepository.UserLoginPage;
import com.ca.tools.docops.tests.BaseTest;

/**
 * This class holds all the common methods and functions across docops pages
 * 
 * @author Team - Tools - Development Team-Tools-Development@ca.com
 *
 */
public class DocOpsCommonMethods extends BaseTest {
    WebDriver driver;
    UserLoginPage userLoginObject;

    public DocOpsCommonMethods(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        this.userLoginObject = new UserLoginPage(driver);
    }
    String nextPage = "//*[@title='Go to next page']";
    String lastPage = "//*[@title='Go to last page']";

    /**
     * This Method can be used for Login to the docops as an User
     */
    public boolean locateElementInAllPages(By locator) {
        java.util.List<WebElement> pagination = driver.findElements(By.xpath("//nav[@class='pager']//a"));
        // checkif pagination link exists
        if (pagination.size() > 0) {
            System.out.println("pagination exists " + pagination.size());
            // click on pagination link
            for (int i = 1; i < pagination.size(); i++) {
                pagination.get(i).click();
                System.out.println("Clicked page: " + (i + 1));
                try {
                    driver.findElement(locator);
                    return true;
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
                System.out.println("Element not found");
            }
            return false;
        } else {
            System.out.println("pagination not exists");
            return false;
        }
    }
}