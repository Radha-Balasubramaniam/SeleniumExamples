package com.ca.tools.docops.tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import org.testng.log4testng.Logger;

import com.ca.tools.docops.dtos.ArticleData;
import com.ca.tools.docops.pageObjectRepository.InternalUsersHomePage;
import com.ca.tools.docops.utils.DataProviderClass;
import com.ca.tools.docops.utils.StringConstants;
import com.relevantcodes.extentreports.LogStatus;
/**
 * Test the end-end flow for all-author users
 * 
 * @author Team - Tools - Development <Team-Tools-Development@ca.com>
 *
 */
public class AllAuthorOperations extends BaseTest {
    private static final Logger logger = Logger.getLogger(AllAuthorOperations.class);
    /**
     * Test Case : All Authors User Article Creation and the end-end workflow
     * @throws Exception
     */
    @Test(groups = { "TC92455" }, priority = 0)
    public void TC92455_testAllAuthorsWorkFlow() throws Exception {
    	SoftAssert verify = new SoftAssert();
    	logger.info("TC92455_testAllAuthorsWorkFlow Test started");
        extentLogger = extent.startTest("TC92455_Test end-to-end workflow for All-Authors user");
        extentLogger.log(LogStatus.INFO, "TC92455_All Authors workflow Test has started");
        internalUsersHomePage.logOutAndCleanCookies(userLogin);
        /* Step 1 : login as all-authors user, create a draft of Agile central help topic*/
        userLogin.login(DataProviderClass.getAllAuthorUserDetails().getUser(),
                DataProviderClass.getAllAuthorUserDetails().getPw());
        ArticleData articleData = DataProviderClass.getArticleData(2);
        extentLogger.log(LogStatus.INFO, "Logged in as All Authors user");
        extentLogger.log(LogStatus.INFO, "Adding an article:" +articleData.getTitle());
        articleData.setArticleType(StringConstants.AGIlE_CENTRAL_HELP_TOPIC);
        mainPage.clickContent();
        contentPage.addArticle(articleData);
        contentPage.saveArticleAsDraft();
        //  Step 2 : Verify that the article is created as a draft. 
       
        extentLogger.log(LogStatus.INFO, "Verifying whether the article is created");
        //Verify that the article is created as a draft
          verify.assertTrue(internalUsersHomePage.isArticleCreatedMessageDisplayed(articleData.getTitle()), "Article creation message should be displayed as expected.");
  	       if(internalUsersHomePage.isArticleCreatedMessageDisplayed(articleData.getTitle())){
  	    	   extentLogger.log(LogStatus.PASS, "Verified that Article creation message is displayed successfuly.");
  	       }else{
  	    	   extentLogger.log(LogStatus.FAIL, "Verified that Article creation message is Not displayed.");
  	       }
        
        mainPage.clickContent();
       
        extentLogger.log(LogStatus.INFO, "Verifying whether the article's moderation state is 'Draft'");
        verify.assertTrue(contentPage.isArticleADraft(articleData.getTitle()), "Article's moderation state should be 'Draft'");
        if(contentPage.isArticleADraft(articleData.getTitle())){
	    	   extentLogger.log(LogStatus.PASS, "Verified that Article's moderation state is 'Draft'");
	       }else{
	    	   extentLogger.log(LogStatus.FAIL, "Verified that Article's moderation is not 'Draft'");
	       }
        
        // access the article from the TOC and assert that the page title contains the article title 
        extentLogger.log(LogStatus.INFO, "Verifying whether the Article is accessible from the TOC");
        driver.navigate().to(configReader.getAgileCentralHome());
        internalUsersHomePage.accessArticleWithUrlAlias(articleData.getUrlAlias());
        // 
        verify.assertTrue(driver.getTitle().contains(articleData.getTitle()), "Article could not accessed from the TOC");
        if(driver.getTitle().contains(articleData.getTitle())){
	    	   extentLogger.log(LogStatus.PASS, "Verified that Article is accessed successfully from the TOC");
	       }else{
	    	   extentLogger.log(LogStatus.FAIL, "Article could not accessed from the TOC");
	       }
        
        /*Step 3 : Edit article and request for review*/
        extentLogger.log(LogStatus.INFO, "Editing article and requesting for review");
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
        
        mainPage.clickContent();
        
        extentLogger.log(LogStatus.INFO, "Verify that the article is changed to Request Review state");
        verify.assertTrue(contentPage.isArticleReadyForReview(articleData.getTitle()), "Article's moderation state should be 'Request Review'");
        if(contentPage.isArticleReadyForReview(articleData.getTitle())){
	    	   extentLogger.log(LogStatus.PASS, "Verified that Article's moderation state is updated as 'Request Review'");
	       }else{
	    	   extentLogger.log(LogStatus.FAIL, "Verified that Article's moderation is not updated as 'Request Review'");
	       }
        
        internalUsersHomePage.logOutAndCleanCookies(userLogin);
        userLogin.login(DataProviderClass.getDocReviewerUserDetails().getUser(),
                DataProviderClass.getDocReviewerUserDetails().getPw());
        extentLogger.log(LogStatus.INFO, "Logged out as All authors user and logged in as doc reviewer user");
        extentLogger.log(LogStatus.INFO, "Accessing the article with url alias: "+articleData.getTitle());
        internalUsersHomePage.accessArticleWithUrlAlias(articleData.getUrlAlias());
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
       
        extentLogger.log(LogStatus.INFO, "Verify that the article is changed to Review completed");
        verify.assertTrue(contentPage.isArticleReviewCompleted(articleData.getTitle()), "Article's moderation state should be 'Review completed'");
        if(contentPage.isArticleReviewCompleted(articleData.getTitle())){
	    	   extentLogger.log(LogStatus.PASS, "Verified that Article's moderation state is updated as 'Review completed'");
	       }else{
	    	   extentLogger.log(LogStatus.FAIL, "Verified that Article's moderation is not updated as 'Review completed'");
	       }
        
        /*Step 7 : Logout and login as all authors again and make the article as ready to publish*/
        internalUsersHomePage.logOutAndCleanCookies(userLogin);
        userLogin.login(DataProviderClass.getAllAuthorUserDetails().getUser(),
                DataProviderClass.getAllAuthorUserDetails().getPw());
        extentLogger.log(LogStatus.INFO, "Logged out as doc reviewer user and logged in as all authors user");
        extentLogger.log(LogStatus.INFO, "Accessing the article with url alias: "+articleData.getTitle());
       
        internalUsersHomePage.accessArticleWithUrlAlias(articleData.getUrlAlias());
        extentLogger.log(LogStatus.INFO, "Editing the article and changing the moderation state as 'Ready to Published'");
        internalUsersHomePage.editDraftArticle();
        contentPage.saveAndReadyToPublishForThisTranslation();
        /* Step 8 : Verify that the article is updated and the moderation status is now changed to Published */
        extentLogger.log(LogStatus.INFO, "Verifying whether article updattion message is displayed.");
        verify.assertTrue(internalUsersHomePage.isArticleUpdatedMessageDisplayed(articleData.getTitle()), "Article updation message should be displayed as expected.");
        if(internalUsersHomePage.isArticleUpdatedMessageDisplayed(articleData.getTitle())){
	    	   extentLogger.log(LogStatus.PASS, "Verified that Article updation message has displayed as expected.");
	       }else{
	    	   extentLogger.log(LogStatus.FAIL, "Article updation message could not be displayed as expected.");
	       }
      
        mainPage.clickContent();
      
        extentLogger.log(LogStatus.INFO, "Verify that the article is changed to 'Ready to Publish'");
        verify.assertTrue(contentPage.isArticleReadyToPublish(articleData.getTitle()), "Article's moderation state should be changed as 'Ready to Publish' by the all authors user");
        if(contentPage.isArticleReadyToPublish(articleData.getTitle())){
	    	   extentLogger.log(LogStatus.PASS, "Verified that Article's moderation state is updated as 'Ready to Publish' by the all authors user");
	       }else{
	    	   extentLogger.log(LogStatus.FAIL, "Verified that Article's moderation is not updated as 'Ready to Publish'");
	       }
       
        internalUsersHomePage.logOutAndCleanCookies(userLogin);
        userLogin.login(DataProviderClass.getDocAdminUserDetails().getUser(),
                DataProviderClass.getDocAdminUserDetails().getPw());
        extentLogger.log(LogStatus.INFO, "Logged out as all authors user and logged in as doc admin user");
        extentLogger.log(LogStatus.INFO, "Accessing the article with url alias: "+articleData.getTitle());
        internalUsersHomePage.accessArticleWithUrlAlias(articleData.getUrlAlias());
        extentLogger.log(LogStatus.INFO, "Editing the article and changing the moderation state as Published");
        internalUsersHomePage.editDraftArticle();
        contentPage.saveAndPublishForThisTranslation();
        /* Step 10 : Verify that the article is updated and the moderation status is now changed to Published */
        
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
        
        internalUsersHomePage.logOutAndCleanCookies(userLogin);
        userLogin.login(DataProviderClass.getCustomerUserDetails().getUser(),
                DataProviderClass.getCustomerUserDetails().getPw());
        extentLogger.log(LogStatus.INFO, "Logged out as doc admin user and logged in as customer user");
        
        driver.navigate().to(configReader.getDrupalBaseURL());
        internalUsersHomePage.accessArticleWithUrlAlias(articleData.getUrlAlias());
        
      //Verifying whether the article is accessible by customer
        verify.assertTrue(driver.getTitle().contains(articleData.getTitle()), "Article is accessible by customer");
        if(driver.getTitle().contains(articleData.getTitle())){
	    	   extentLogger.log(LogStatus.PASS, "Verified that Article is accessed successfully by customer");
	       }else{
	    	   extentLogger.log(LogStatus.FAIL, "Article is not accessble by customer");
	       }
       
      verify.assertAll();
        extent.endTest(extentLogger);
    }
    
}