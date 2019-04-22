package com.ca.tools.docops.tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import org.testng.log4testng.Logger;

import com.ca.tools.docops.dtos.User;
import com.ca.tools.docops.utils.DataProviderClass;
import com.ca.tools.docops.utils.StringConstants;
import com.relevantcodes.extentreports.LogStatus;
/**
 * Test the user CRUD operations
 * 
 * @author Team - Tools - Development <Team-Tools-Development@ca.com>
 *
 */
public class UserOperations extends BaseTest {
    private static final Logger logger = Logger.getLogger(UserOperations.class);

    @Test(groups = { "TC91723" }, priority = 0)
    public void createUsers() {
        logger.debug("TC91723_create Users Test started");
        extentLogger = extent.startTest("TC91723_create user");
        extentLogger.log(LogStatus.INFO, "TC91723_create_user Test has started.");
        
        //Logging in as the admin. 
        userLogin.login(configReader.getDocOpsUserName(StringConstants.USER_NAME),
              configReader.getDocOpsPassword(StringConstants.PASSWORD));
        extentLogger.log(LogStatus.INFO, "Logged in as Admin user");
        mainPage.clickPeople();
        peoplePage.addUser(DataProviderClass.getTestUserDetails());
        extentLogger.log(LogStatus.INFO, "Test user is created");
        // Create a doc admin user
        mainPage.clickPeople();
        peoplePage.addUser(DataProviderClass.getDocAdminUserDetails());
        extentLogger.log(LogStatus.INFO, "DocAdmin user is created");
        // Create a doc reviewer user
        mainPage.clickPeople();
        peoplePage.addUser(DataProviderClass.getDocReviewerUserDetails());
        extentLogger.log(LogStatus.INFO, "DocReviewer user is created");
        //Create a customer user
        mainPage.clickPeople();
        peoplePage.addUser(DataProviderClass.getCustomerUserDetails());
        extentLogger.log(LogStatus.INFO, "Customer user is created");
        //Create all authors user
        mainPage.clickPeople();
        peoplePage.addUser(DataProviderClass.getAllAuthorUserDetails());
        extentLogger.log(LogStatus.INFO, "AllAuthors user is created");
        extent.endTest(extentLogger);
    }

    @Test(groups = { "TC91833" }, priority = 1)
    public void blockUser() {
        logger.debug("BlockUser Test started");
        extentLogger = extent.startTest("BlockUser");
        extentLogger.log(LogStatus.INFO, "TC91833_BlockUser Test started.");
        userLogin.login(configReader.getDocOpsUserName(StringConstants.USER_NAME),
                configReader.getDocOpsPassword(StringConstants.PASSWORD));
        extentLogger.log(LogStatus.INFO, "Logged in as Admin user");
        mainPage.clickPeople();
        User user = DataProviderClass.getTestUserDetails();
        peoplePage.blockUser(user);
        extentLogger.log(LogStatus.INFO, "User blocking successful");
        user.setStatus(StringConstants.BLOCKED);
        Assert.assertTrue(peoplePage.userPresent(user.getUser()));
        extentLogger.log(LogStatus.INFO, "User is listed as bolcked in the users list");
        userLogin.logout();
        userLogin.login(DataProviderClass.getTestUserDetails().getUser(),
                DataProviderClass.getTestUserDetails().getPw());
        extentLogger.log(LogStatus.INFO, "login as blocked user");
        String userBlockedMessage = "//*[@role='alert' and contains(.,'has not been activated or is blocked')]/em[text()='autoUserForTesting']";
        Assert.assertTrue(driver.findElements(By.xpath(userBlockedMessage)).size()!=0);
        extentLogger.log(LogStatus.INFO, "User blocked message is diaplyed on the login page");
        extent.endTest(extentLogger);
    }

    @Test(groups = { "TC85084" }, priority = 2)
    public void changeRoleOfUser() {
        logger.debug("TC85084_changeRoleOfUser Test started");
        extentLogger = extent.startTest("changeRoleOfUser");
        extentLogger.log(LogStatus.INFO, "TC85084_changeRoleOfUser Test started.");
        userLogin.login(configReader.getDocOpsUserName(StringConstants.USER_NAME),
                configReader.getDocOpsPassword(StringConstants.PASSWORD));
        extentLogger.log(LogStatus.INFO, "Logged in as Admin user");
        mainPage.clickPeople();
        User user = DataProviderClass.getTestUserDetails();
        peoplePage.ChangeUserRole(user, DataProviderClass.getTestUserNewRole());
        extentLogger.log(LogStatus.INFO, "Role changed successfully for the customer user");
        user.setRole(DataProviderClass.getTestUserNewRole());
        Assert.assertTrue(peoplePage.userPresent(user));
        extentLogger.log(LogStatus.INFO, "User is listed with the changed role in users list");
        extent.endTest(extentLogger);
    }
    
    @Test(groups = { "TC121478" }, priority = 3)
    public void TC121478_Check_URL_redirection_when_a_user_logs_into_DocOps() {
    	SoftAssert verify = new SoftAssert();
    	logger.debug("TC121478_Check_URL_redirection_when_a_user_logs_into_DocOps has started");
        extentLogger = extent.startTest("TC121478_Check_URL_redirection_when_a_user_logs_into_DocOps has started");
       
        //Verifying if the DocAdmin is getting redirected to Home Page after login
        userLogin.login(DataProviderClass.getDocAdminUserDetails().getUser(),
                DataProviderClass.getDocAdminUserDetails().getPw());
        extentLogger.log(LogStatus.INFO, "Logged in as Doc Admin");
        extentLogger.log(LogStatus.INFO, "Verifying if the DocAdmin is getting redirected to Home Page after login");
        verify.assertTrue(driver.getTitle().equals(StringConstants.HomePageTitle),"DocAdmin user login redirection failed");
        if(driver.getTitle().equals(StringConstants.HomePageTitle)){
        	extentLogger.log(LogStatus.PASS, "Verified that DocAdmin user login redirection to the Home Page was successful");
        }else{
        	extentLogger.log(LogStatus.FAIL, "DocAdmin user login redirection failed");
        } 
        internalUsersHomePage.logOutAndCleanCookies(userLogin);
        
        //Verifying if the DocAuthor is getting redirected to Home Page after login
        userLogin.login(DataProviderClass.getAllAuthorUserDetails().getUser(),
                DataProviderClass.getAllAuthorUserDetails().getPw());
        extentLogger.log(LogStatus.INFO, "Logged in as Doc Author");
        extentLogger.log(LogStatus.INFO,"Verifying if the All-Author is getting redirected to Home Page after login");
        verify.assertTrue(driver.getTitle().equals(StringConstants.HomePageTitle),"DocAuthor login redirection failed");
        if(driver.getTitle().equals(StringConstants.HomePageTitle)){
        	extentLogger.log(LogStatus.PASS, "Verified that All-Author user login redirection to the Home Page was successful");
        }else{
        	extentLogger.log(LogStatus.FAIL, "All-Author user login redirection failed");
        } 
        internalUsersHomePage.logOutAndCleanCookies(userLogin);
        
        //Verifying if the DocReviewer is getting redirected to Home Page after login
        userLogin.login(DataProviderClass.getDocReviewerUserDetails().getUser(),
        		DataProviderClass.getDocReviewerUserDetails().getPw());
        extentLogger.log(LogStatus.INFO, "Logged in as Doc Reviewer");
        extentLogger.log(LogStatus.INFO,"Verified that DocReviewer is getting redirection to Home Page after login");
        verify.assertTrue(driver.getTitle().equals(StringConstants.HomePageTitle),"DocReviewer user login redirection failed was successful");
        if(driver.getTitle().equals(StringConstants.HomePageTitle)){
        	extentLogger.log(LogStatus.PASS, "Verified if DocReviewer user login redirected to the Home Page");
        }else{
        	extentLogger.log(LogStatus.FAIL, "DocReviewer user login redirection failed");
        } 
        internalUsersHomePage.logOutAndCleanCookies(userLogin);
        
        //Verifying if the Customer is getting redirected to Home Page after login
        userLogin.login(DataProviderClass.getCustomerUserDetails().getUser(),
        		DataProviderClass.getCustomerUserDetails().getPw());
        extentLogger.log(LogStatus.INFO, "Logged in as Customer");
        extentLogger.log(LogStatus.INFO,"Verified that Customer is getting redirection to Home Page after login was successful");
        verify.assertTrue(driver.getTitle().equals(StringConstants.HomePageTitle),"Customer login redirection failed");
        if(driver.getTitle().equals(StringConstants.HomePageTitle)){
        	extentLogger.log(LogStatus.PASS, "Verified if Customer login redirected to the Home Page");
        }else{
        	extentLogger.log(LogStatus.FAIL, "Customer login redirection failed");
        } 
        internalUsersHomePage.logOutAndCleanCookies(userLogin);
        
        verify.assertAll();
    	extent.endTest(extentLogger);       
     }

}
