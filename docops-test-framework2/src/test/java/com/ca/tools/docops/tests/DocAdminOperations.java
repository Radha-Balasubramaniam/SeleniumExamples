package com.ca.tools.docops.tests;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import org.testng.log4testng.Logger;

import com.ca.tools.docops.dtos.ArticleData;
import com.ca.tools.docops.utils.DataProviderClass;
import com.ca.tools.docops.utils.StringConstants;
import com.relevantcodes.extentreports.LogStatus;

import junit.framework.Assert;
/**
 * Test the end-end flow for doc-admin users
 * 
 * @author Team - Tools - Development <Team-Tools-Development@ca.com>
 *
 */
public class DocAdminOperations extends BaseTest {
    private static final Logger logger = Logger.getLogger(DocAdminOperations.class);
    
    @Test(groups = { "TC92456", "TC92460"}, priority = 0)
    public void TC92456_testDocAdminWorkFlow() throws Exception {
    	SoftAssert verify = new SoftAssert();
    	logger.info("TC92456_testDocAdminWorkFlow Test started");
        extentLogger = extent.startTest("TC92456_Test end-to-end workflow for Doc-Admin user");
        extentLogger.log(LogStatus.INFO, "TC92456_Doc Admin workflow Test has started");
        internalUsersHomePage.logOutAndCleanCookies(userLogin);
        /* Step 1 : login as doc admin, create a draft of Agile central help topic*/
        userLogin.login(DataProviderClass.getDocAdminUserDetails().getUser(),
                DataProviderClass.getDocAdminUserDetails().getPw());
        extentLogger.log(LogStatus.INFO, "Logged in as Doc Admin user");
        ArticleData articleData = DataProviderClass.getArticleData(1);
        extentLogger.log(LogStatus.INFO, "Adding an article:" +articleData.getTitle());
        articleData.setArticleType(StringConstants.AGIlE_CENTRAL_HELP_TOPIC);
        mainPage.clickContent();
        contentPage.addArticle(articleData);
        contentPage.saveArticleAsDraft();
        /* Step 2 : Verify that the article is created as a draft and is accessible using url alias*/
        extentLogger.log(LogStatus.INFO, "Verifying whether the article is created");
      //Verify that the article is created as a draft
        verify.assertTrue(internalUsersHomePage.isArticleCreatedMessageDisplayed(articleData.getTitle()), "Article creation message should be displayed as expected.");
	       if(internalUsersHomePage.isArticleCreatedMessageDisplayed(articleData.getTitle())){
	    	   extentLogger.log(LogStatus.PASS, "Verified that Article creation message is displayed successfuly.");
	       }else{
	    	   extentLogger.log(LogStatus.FAIL, "Verified that Article creation message is Not displayed.");
	       }
        mainPage.clickContent();
        //Verify that the article's moderation state is 'Draft'
        extentLogger.log(LogStatus.INFO, "Verifying whether the article's moderation state is 'Draft'");
        verify.assertTrue(contentPage.isArticleADraft(articleData.getTitle()), "Article's moderation state should be 'Draft'");
        if(contentPage.isArticleADraft(articleData.getTitle())){
	    	   extentLogger.log(LogStatus.PASS, "Verified that Article's moderation state is 'Draft'");
	       }else{
	    	   extentLogger.log(LogStatus.FAIL, "Verified that Article's moderation is not 'Draft'");
	       }
      
        // access the article with url alias and assert that the page title contains the article title 
        internalUsersHomePage.accessArticleWithUrlAlias(articleData.getUrlAlias());
        extentLogger.log(LogStatus.INFO, "Navigating the the added article: "+articleData.getTitle());
        verify.assertTrue(driver.getTitle().contains(articleData.getTitle()), "Could not redirected to the added article");
        if(driver.getTitle().contains(articleData.getTitle())){
	    	   extentLogger.log(LogStatus.PASS, "Verified that Article is accessed successfully using url alias");
	       }else{
	    	   extentLogger.log(LogStatus.FAIL, "could not be navigated to the added article.");
	       }
        
        /*Step 3 : Edit article and request for review*/
        extentLogger.log(LogStatus.INFO, "Editing the article and requesting for review");
        internalUsersHomePage.editDraftArticle();
        contentPage.saveArticleAndRequestReviewForThisTranslation();
        /* Step 4 : Verify that the article is updated and the moderation status is now changed to Request review */
        extentLogger.log(LogStatus.INFO, "Verifying whether the article is updated");
        verify.assertTrue(internalUsersHomePage.isArticleUpdatedMessageDisplayed(articleData.getTitle()), "Article updation message should be displayed as expected.");
        if(internalUsersHomePage.isArticleUpdatedMessageDisplayed(articleData.getTitle())){
	    	   extentLogger.log(LogStatus.PASS, "Verified that Article updation message has displayed as expected.");
	       }else{
	    	   extentLogger.log(LogStatus.FAIL, "Article updation message could not be displayed as expected.");
	       }

        // Verify that the article is listed in request review state
        mainPage.clickContent();

        extentLogger.log(LogStatus.INFO, "Verify that the article is changed to Request Review");
        verify.assertTrue(contentPage.isArticleReadyForReview(articleData.getTitle()), "Article's moderation state should be 'Request Review'");
        if(contentPage.isArticleReadyForReview(articleData.getTitle())){
	    	   extentLogger.log(LogStatus.PASS, "Verified that Article's moderation state is updated as 'Request Review'");
	       }else{
	    	   extentLogger.log(LogStatus.FAIL, "Verified that Article's moderation is not updated as 'Request Review'");
	       }

        /*Step 5 :  Logout and login as doc reviewer and complete review*/
        internalUsersHomePage.logOutAndCleanCookies(userLogin);
        userLogin.login(DataProviderClass.getDocReviewerUserDetails().getUser(),
                DataProviderClass.getDocReviewerUserDetails().getPw());
        extentLogger.log(LogStatus.INFO, "Logged out as doc admin user and logged in as doc reviewer user");
        internalUsersHomePage.accessArticleWithUrlAlias(articleData.getUrlAlias());
        extentLogger.log(LogStatus.INFO, "Accessing the article with url alias: "+articleData.getTitle());
        extentLogger.log(LogStatus.INFO, "Editing the article and changing the moderation state as review completed");
        // edit article and complete review 
        internalUsersHomePage.editDraftArticle();
        contentPage.saveAndCompleteReviewForThisTranslation();
        /* Step 6 : Verify that the article is updated and the moderation status is now changed to Review completed */
        extentLogger.log(LogStatus.INFO, "Verifying whether article updattion message is displayed.");
        verify.assertTrue(internalUsersHomePage.isArticleUpdatedMessageDisplayed(articleData.getTitle()), "Article updation message should be displayed as expected.");
        if(internalUsersHomePage.isArticleUpdatedMessageDisplayed(articleData.getTitle())){
	    	   extentLogger.log(LogStatus.PASS, "Verified that Article updation message has displayed as expected.");
	       }else{
	    	   extentLogger.log(LogStatus.FAIL, "Article updation message could not be displayed as expected.");
	       }
        
        mainPage.clickContent();
        extentLogger.log(LogStatus.INFO, "Verifying that the article's state is changed to Review completed");
        verify.assertTrue(contentPage.isArticleReviewCompleted(articleData.getTitle()), "Article's moderation state should be 'Review completed'");
        if(contentPage.isArticleReviewCompleted(articleData.getTitle())){
	    	   extentLogger.log(LogStatus.PASS, "Verified that Article's moderation state is updated as 'Review completed'");
	       }else{
	    	   extentLogger.log(LogStatus.FAIL, "Verified that Article's moderation is not updated as 'Review completed'");
	       }
       
        /*Step 7 : Logout and login as docAdmin again and publish the article*/
        internalUsersHomePage.logOutAndCleanCookies(userLogin);
        userLogin.login(DataProviderClass.getDocAdminUserDetails().getUser(),
                DataProviderClass.getDocAdminUserDetails().getPw());
        extentLogger.log(LogStatus.INFO, "Logged out as doc reviewer user and logged in as doc admin user");
        
        internalUsersHomePage.accessArticleWithUrlAlias(articleData.getUrlAlias());
        extentLogger.log(LogStatus.INFO, "Accessing the article with url alias: "+articleData.getTitle());
        extentLogger.log(LogStatus.INFO, "Editing the article and changing the moderation state as Published");
        
        internalUsersHomePage.editDraftArticle();
        contentPage.saveAndPublishForThisTranslation();
        
        /* Step 8 : Verify that the article is updated and the moderation status is now changed to Published */
        extentLogger.log(LogStatus.INFO, "Verifying whether article updation message is displayed.");
        verify.assertTrue(internalUsersHomePage.isArticleUpdatedMessageDisplayed(articleData.getTitle()), "Article updation message should be displayed as expected.");
        if(internalUsersHomePage.isArticleUpdatedMessageDisplayed(articleData.getTitle())){
	    	   extentLogger.log(LogStatus.PASS, "Verified that Article updation message has displayed as expected.");
	       }else{
	    	   extentLogger.log(LogStatus.FAIL, "Article updation message could not be displayed as expected.");
	       }
        
        mainPage.clickContent();
        
        extentLogger.log(LogStatus.INFO, "Verify that the article is changed to Published");
        verify.assertTrue(contentPage.isArticlePublished(articleData.getTitle()), "Article's moderation state should be 'Published'");
        if(contentPage.isArticlePublished(articleData.getTitle())){
	    	   extentLogger.log(LogStatus.PASS, "Verified that Article's moderation state is updated as 'Published'");
	       }else{
	    	   extentLogger.log(LogStatus.FAIL, "Verified that Article's moderation is not updated as 'Published'");
	       }
       
        /*Step 9 : Logout and login as customer and verify if the article is accessible*/
        internalUsersHomePage.logOutAndCleanCookies(userLogin);
        userLogin.login(DataProviderClass.getCustomerUserDetails().getUser(),
                DataProviderClass.getCustomerUserDetails().getPw());
        extentLogger.log(LogStatus.INFO, "Logged out as doc admin user and logged in as customer user");
        
        driver.navigate().to(configReader.getDrupalBaseURL());
        extentLogger.log(LogStatus.INFO, "Navigating the the added article: "+articleData.getTitle()+" using url alias.");
        internalUsersHomePage.accessArticleWithUrlAlias(articleData.getUrlAlias());
        
        //Verifying whether the article is accessible by customer
        verify.assertTrue(driver.getTitle().contains(articleData.getTitle()), "Article is not accessible by customer");
        if(driver.getTitle().contains(articleData.getTitle())){
	    	   extentLogger.log(LogStatus.PASS, "Verified that Article is accessed successfully by customer");
	       }else{
	    	   extentLogger.log(LogStatus.FAIL, "Article is not accessble by customer");
	       }
        
        verify.assertAll();
        extent.endTest(extentLogger);
    }
}
