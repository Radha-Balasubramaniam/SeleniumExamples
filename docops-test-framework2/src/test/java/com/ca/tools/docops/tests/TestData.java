package com.ca.tools.docops.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import org.testng.log4testng.Logger;

import com.ca.tools.docops.common.CommonActions;
import com.ca.tools.docops.dtos.ArticleData;
import com.ca.tools.docops.utils.DataProviderClass;
import com.relevantcodes.extentreports.LogStatus;

/*
 * This class is dedicated to prepare data.
 *
*/

public class TestData extends BaseTest{
	public static final Logger logger = Logger.getLogger(TestData.class);
	

		@Test ( enabled=true, priority = 0)
		public void createTestDataForSchedulingModerationState() throws Exception{
			SoftAssert verify = new SoftAssert(); 
			logger.debug("create Test Data started");
		    extentLogger = extent.startTest("createTestData");
			userLogin.login(DataProviderClass.getDocAdminUserDetails().getUser(), DataProviderClass.getDocAdminUserDetails().getPw());	
	   	 	ArticleData articleData = DataProviderClass.getArticleData(49);
	   	 	extentLogger.log(LogStatus.INFO, "Adding an article:" +articleData.getTitle());
	   	 	mainPage.clickContent();
	        contentPage.addArticle(articleData);
	    
	      //  verifying whether the article is scheduled for the correct moderation state
	         verify.assertTrue(contentPage.getUpdatedModerationStateFromTable().contentEquals(articleData.getModerationStateToSchedule()), "Updated scheduled moderation state should be as same as provided moderation state");
	         if(contentPage.getUpdatedModerationStateFromTable().contentEquals(articleData.getModerationStateToSchedule())){
	         	extentLogger.log(LogStatus.PASS, "Verifed that Article's moderation state is updated successfully in Add article screen and displayed in the table as: "+contentPage.getUpdatedModerationStateFromTable());
	         }else{
	         	extentLogger.log(LogStatus.FAIL, "Verifed that Article's moderation state could not updated in Add article screen and displayed in the table as: "+contentPage.getUpdatedModerationStateFromTable());
	         }
	        
	         contentPage.saveArticleAsDraft();
	      // Verify that the article is created
	         extentLogger.log(LogStatus.INFO, "Verifying whether the article is created.");
	 	       if(internalUsersHomePage.isArticleCreatedMessageDisplayed(articleData.getTitle())){
	 	    	   extentLogger.log(LogStatus.PASS, "Verified that Article creation message is displayed successfuly and article added: "+articleData.getTitle());
	 	       }else{
	 	    	   extentLogger.log(LogStatus.FAIL, "Verified that Article creation message is Not displayed.");
	 	       }
	        verify.assertTrue(internalUsersHomePage.isArticleCreatedMessageDisplayed(articleData.getTitle()), "Article creation message should be displayed as expected.");
	        internalUsersHomePage.logOutAndCleanCookies(userLogin);
	    
	        verify.assertAll();
	        extent.endTest(extentLogger);
		
		
		}
}
