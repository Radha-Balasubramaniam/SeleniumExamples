package com.ca.tools.docops.pageObjectRepository;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.ca.tools.docops.common.CommonActions;
import com.ca.tools.docops.dtos.User;

import static com.ca.tools.docops.utils.StringConstants.*;

public class PeoplePage {
    private WebDriver driver;

    public PeoplePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    @FindBy(linkText = "Add user") private WebElement addUser;
    @FindBy(id = "edit-user") private WebElement filterUser;
    @FindBy(id = "edit-status") private WebElement userStatus;
    @FindBy(id = "edit-role") private WebElement userRole;
    @FindBy(id = "edit-permission") private WebElement userPermission;
    @FindBy(id = "edit-action") private WebElement actionDropDown;
    @FindBy(id = "edit-submit--2") private WebElement applyToSelectedItems;
    @FindBy(id = "edit-submit-user-admin-people") private WebElement userFilterButton;
    @FindBy(id = "edit-mail") private WebElement emailField;
    @FindBy(id = "edit-name") private WebElement userNameField;
    @FindBy(id = "edit-pass-pass1") private WebElement passwordField;
    @FindBy(id = "edit-pass-pass2") private WebElement confirmPasswordField;
    @FindBy(id = "edit-status-0") private WebElement statusBlockedButton;
    @FindBy(id = "edit-status-1") private WebElement statusActiveButton;
    @FindBy(id = "edit-roles-customer") private WebElement customerRoleCheckbox;
    @FindBy(id = "edit-roles-doc-reviewer") private WebElement docReviewerRoleCheckbox;
    @FindBy(id = "edit-roles-doc-admin") private WebElement docAdminRoleCheckbox;
    @FindBy(id = "edit-roles-doc-author") private WebElement docAuthorRoleCheckbox;
    @FindBy(id = "edit-roles-all-authors") private WebElement allAuthorsRoleCheckbox;
    @FindBy(id = "edit-preferred-langcode") private WebElement siteLanguageField;
    @FindBy(id = "edit-timezone--2") private WebElement TimeZoneField;
    @FindBy(id = "edit-submit") private WebElement submitButton;
    @FindBy(id = "edit-delete") private WebElement deleteAccountButton;
    @FindBy(id = "edit-user-cancel-method-user-cancel-delete") private WebElement deleteEntireAccountData;
    @FindBy(xpath = "//*[@title='Select all rows in this table']") private WebElement selectAllRows;
    String editUserLocator = "//*[text()='AAAAA']/parent::td/following-sibling::td//a[text()='Edit']";

    public void clickAddUser() {
        addUser.click();
    }

    public void saveUser() {
        submitButton.click();
    }

    public void activateUser() {
        if (!statusActiveButton.isSelected()) {
            statusActiveButton.click();
        }
    }

    public void blockUser() {
        if (!statusBlockedButton.isSelected()) {
            statusBlockedButton.click();
        }
    }

    public void assignRole(String role) {
        switch (role) {
        case CUSTOMER:
            if (!customerRoleCheckbox.isSelected()) {
                customerRoleCheckbox.click();
            }
            break;
        case DOC_REVIEWER:
            if (!docReviewerRoleCheckbox.isSelected()) {
                docReviewerRoleCheckbox.click();
            }
            break;
        case DOC_ADMIN:
            if (!docAdminRoleCheckbox.isSelected()) {
                docAdminRoleCheckbox.click();
            }
            break;
        case DOC_AUTHOR:
            if (!docAuthorRoleCheckbox.isSelected()) {
                docAuthorRoleCheckbox.click();
            }
            break;
        case ALL_AUTHORS:
            if (!allAuthorsRoleCheckbox.isSelected()) {
                allAuthorsRoleCheckbox.click();
            }
            break;
        default:
            break;
        }
    }

    public void selectSiteLanguage(String language) {
        Select select = new Select(siteLanguageField);
        switch (language) {
        case ENGLISH:
            select.selectByVisibleText(ENGLISH);
            break;
        case FRENCH:
            select.selectByVisibleText(FRENCH);
            break;
        case GERMAN:
            select.selectByVisibleText(GERMAN);
            break;
        case JAPANESE:
            select.selectByVisibleText(JAPANESE);
            break;
        default:
            break;
        }
        
        
    }

    public void unAssignRole(String role) {
        switch (role) {
        case CUSTOMER:
            if (customerRoleCheckbox.isSelected()) {
                customerRoleCheckbox.click();
            }
            break;
        case DOC_REVIEWER:
            if (docReviewerRoleCheckbox.isSelected()) {
                docReviewerRoleCheckbox.click();
            }
            break;
        case DOC_ADMIN:
            if (docAdminRoleCheckbox.isSelected()) {
                docAdminRoleCheckbox.click();
            }
            break;
        case DOC_AUTHOR:
            if (docAuthorRoleCheckbox.isSelected()) {
                docAuthorRoleCheckbox.click();
            }
            break;
        default:
            break;
        }
    }

    public void addUser(User user) {
        if (!userPresent(user.getUser())) {
            addUser.click();
            emailField.sendKeys(user.getUser() + "@ca.com");
            userNameField.sendKeys(user.getUser());
            passwordField.sendKeys(user.getPw());
            confirmPasswordField.sendKeys(user.getPw());
            if (BLOCKED.equalsIgnoreCase(user.getStatus())) {
                blockUser();
            }
            assignRole(user.getRole());
            selectSiteLanguage(user.getLanguage());
            if(user.getUser().contains("DocAdmin")){
            	selectTimeZoneAsNewYork();
            }
            saveUser();
        }
    }

    public void selectTimeZoneAsNewYork(){
    	CommonActions.javaScriptClick(TimeZoneField, driver);
    	CommonActions.selectByValue(driver, TimeZoneField, "America/New_York");
    	
    }
    
    
    public void blockUser(User user) {
        addUser(user);
        CommonActions.javaScriptClick(getEditUserLocator(user.getUser()), driver);
        blockUser();
        saveUser();
    }

    private WebElement getEditUserLocator(String user) {
        return driver.findElement(By.xpath(editUserLocator.replace("AAAAA", user)));
    }

    public void ChangeUserRole(User user, String newRole) {
        if (userPresent(user.getUser())) {
            CommonActions.javaScriptClick(getEditUserLocator(user.getUser()), driver);
            unAssignRole(user.getRole());
            assignRole(newRole);
            saveUser();
        }
    }

    public boolean userPresent(User user) {
        filterUser.clear();
        filterUser.sendKeys(user.getUser());
        if (StringUtils.isNotEmpty(user.getStatus())) {
            new Select(userStatus).selectByVisibleText(user.getStatus());
        }
        if (StringUtils.isNotEmpty(user.getRole())) {
            new Select(userRole).selectByVisibleText(user.getRole());
        }
        userFilterButton.click();
        if (driver.findElements(By.id("edit-user-bulk-form-0")).size() == 0) {
            return false;
        } else {
            return true;
        }
    }

    public boolean userPresent(String user) {
        filterUser.clear();
        filterUser.sendKeys(user);
        userFilterButton.click();
        if (driver.findElements(By.id("edit-user-bulk-form-0")).size() == 0) {
            return false;
        } else {
            return true;
        }
    }

    public void setAction(String action) {
        Select select = new Select(actionDropDown);
        switch (action) {
        case ADD_ADMIN_ROLE:
            select.selectByVisibleText(ADD_ADMIN_ROLE);
            break;
        case ADD_ALL_AUTHORS_ROLE:
            select.selectByVisibleText(ADD_ALL_AUTHORS_ROLE);
            break;
        case ADD_CUSTOMER_ROLE:
            select.selectByVisibleText(ADD_CUSTOMER_ROLE);
            break;
        case ADD_DOCADMIN_ROLE:
            select.selectByVisibleText(ADD_DOCADMIN_ROLE);
            break;
        case ADD_DOCAUTHOR_ROLE:
            select.selectByVisibleText(ADD_DOCAUTHOR_ROLE);
            break;
        case ADD_DOCREVIEWER_ROLE:
            select.selectByVisibleText(ADD_DOCREVIEWER_ROLE);
            break;
        case BLOCK_USERS:
            select.selectByVisibleText(BLOCK_USERS);
            break;
        case CANCEL_ACCOUNTS:
            select.selectByVisibleText(CANCEL_ACCOUNTS);
            break;
        case REMOVE_ADMIN_ROLE:
            select.selectByVisibleText(REMOVE_ADMIN_ROLE);
            break;
        case REMOVE_ALL_AUTHORS_ROLE:
            select.selectByVisibleText(REMOVE_ALL_AUTHORS_ROLE);
            break;
        case REMOVE_CUSTOMER_ROLE:
            select.selectByVisibleText(REMOVE_CUSTOMER_ROLE);
            break;
        case REMOVE_DOCADMIN_ROLE:
            select.selectByVisibleText(REMOVE_DOCADMIN_ROLE);
            break;
        case REMOVE_DOCAUTHOR_ROLE:
            select.selectByVisibleText(REMOVE_DOCAUTHOR_ROLE);
            break;
        case REMOVE_DOCREVIEWER_ROLE:
            select.selectByVisibleText(REMOVE_DOCREVIEWER_ROLE);
            break;
        case UNBLOCK_USERS:
            select.selectByVisibleText(UNBLOCK_USERS);
            break;
        default:
            break;
        }
    }

    public void deleteUser(String user) {
        if (userPresent(user)) {
            getEditUserLocator(user).click();
            deleteAccountButton.click();
            deleteEntireAccountData.click();
            submitButton.click();
        }
    }
}