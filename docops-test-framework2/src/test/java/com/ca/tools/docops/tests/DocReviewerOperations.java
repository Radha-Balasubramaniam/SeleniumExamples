package com.ca.tools.docops.tests;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import org.testng.log4testng.Logger;

import com.ca.tools.docops.dtos.ArticleData;
import com.ca.tools.docops.utils.DataProviderClass;
import com.ca.tools.docops.utils.StringConstants;
import com.relevantcodes.extentreports.LogStatus;

public class DocReviewerOperations extends BaseTest {
    private static final Logger logger = Logger.getLogger(DocReviewerOperations.class);


    @Test(groups = { "TC92457"}, priority = 0)
    public void TC92457_testDocReviewerWorkFlow() throws Exception {
    	SoftAssert verify = new SoftAssert();
    	logger.info("testDocReviewerWorkFlow Test started");
        extentLogger = extent.startTest("Test end-to-end workflow for Doc-Reviewer user");
        extentLogger.log(LogStatus.INFO, "Doc Reviewer workflow Test has started");
        internalUsersHomePage.logOutAndCleanCookies(userLogin);
        /* Step 1 : login as doc admin, create a draft of Agile central help topic*/
        userLogin.login(DataProviderClass.getAllAuthorUserDetails().getUser(),
                DataProviderClass.getAllAuthorUserDetails().getPw());
        extentLogger.log(LogStatus.INFO, "Logged in as All Author user");
        
        ArticleData articleData = DataProviderClass.getArticleData(3);
        extentLogger.log(LogStatus.INFO, "Adding an article:" +articleData.getTitle());
        articleData.setArticleType(StringConstants.AGIlE_CENTRAL_HELP_TOPIC);
        mainPage.clickContent();
        contentPage.addArticle(articleData);
        contentPage.saveArticleAndRequestReview();
        
      //Verify that the article is created as a draft
        verify.assertTrue(internalUsersHomePage.isArticleCreatedMessageDisplayed(articleData.getTitle()), "Article creation message should be displayed as expected.");
	       if(internalUsersHomePage.isArticleCreatedMessageDisplayed(articleData.getTitle())){
	    	   extentLogger.log(LogStatus.PASS, "Verified that Article creation message is displayed successfuly.");
	       }else{
	    	   extentLogger.log(LogStatus.FAIL, "Verified that Article creation message is Not displayed.");
	       }
        
        mainPage.clickContent();
        
        extentLogger.log(LogStatus.INFO, "Verify that the article is changed to Request Review");
        verify.assertTrue(contentPage.isArticleReadyForReview(articleData.getTitle()), "Article's moderation state should be 'Request Review'");
        if(contentPage.isArticleReadyForReview(articleData.getTitle())){
	    	   extentLogger.log(LogStatus.PASS, "Verified that Article got created in state as 'Request Review'");
	       }else{
	    	   extentLogger.log(LogStatus.FAIL, "Verified that Article not created in state as 'Request Review'");
	       }
        
        // access the article using url alias and assert that the page title contains the article title
        driver.navigate().to(configReader.getAgileCentralHome());
        internalUsersHomePage.accessArticleWithUrlAlias(articleData.getUrlAlias());
        
        extentLogger.log(LogStatus.INFO, "Navigating the the added article: "+articleData.getTitle());
        verify.assertTrue(driver.getTitle().contains(articleData.getTitle()), "Could not redirected to the added article through URL alias");
        if(driver.getTitle().contains(articleData.getTitle())){
	    	   extentLogger.log(LogStatus.PASS, "Verified that Article is accessed successfully using url alias");
	       }else{
	    	   extentLogger.log(LogStatus.FAIL, "could not be navigated to the added article.");
	       }
    
        /*Step 2 :  Logout and login as doc reviewer and complete review*/
        internalUsersHomePage.logOutAndCleanCookies(userLogin);
        userLogin.login(DataProviderClass.getDocReviewerUserDetails().getUser(),
                DataProviderClass.getDocReviewerUserDetails().getPw());
        extentLogger.log(LogStatus.INFO, "Logged out as doc author user and logged in as doc reviewer user");
        internalUsersHomePage.accessArticleWithUrlAlias(articleData.getUrlAlias());
        // edit article and complete review
        extentLogger.log(LogStatus.INFO, "Editing the article and changing the moderation state as review completed");
        internalUsersHomePage.editDraftArticle();
        contentPage.saveAndCompleteReviewForThisTranslation();
        /* Step 6 : Verify that the article is updated and the moderation status is now changed to Review completed */
        
        extentLogger.log(LogStatus.INFO, "Verifying whether article updation message is displayed.");
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
        
        extentLogger.log(LogStatus.INFO, "Doc reviewer's review of the article is completed");
        verify.assertAll();
        extent.endTest(extentLogger);
    }

    
}
