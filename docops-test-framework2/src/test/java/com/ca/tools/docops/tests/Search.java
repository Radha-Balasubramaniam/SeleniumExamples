package com.ca.tools.docops.tests;

import static org.testng.Assert.assertTrue;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.testng.Assert;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;


import com.ca.tools.docops.dtos.ArticleData;
import com.ca.tools.docops.dtos.SearchData;
import com.ca.tools.docops.utils.DataProviderClass;
import com.ca.tools.docops.utils.StringConstants;

import com.relevantcodes.extentreports.LogStatus;

public class Search extends BaseTest{

	public static final Logger logger  = Logger.getLogger(Search.class);
	
	@Test(groups = {"TC92487"}, enabled=true, priority=0)
	public void TC92487_Basic_Search() throws InterruptedException {
		
		logger.info("TC92487_Test Basic_search is started.");
		extentLogger = extent.startTest("TC92487_Basic_Search");
		extentLogger.log(LogStatus.INFO, "TC92487 Basic_Search is started.");
		//Login as customer
		userLogin.login(DataProviderClass.getCustomerUserDetails().getUser(), DataProviderClass.getCustomerUserDetails().getPw());
		extentLogger.log(LogStatus.INFO, "Loggedin as a customer");
		driver.navigate().to(configReader.getAgileCentralHome());
		extentLogger.log(LogStatus.INFO, "Navigated to Agile Central Drupal site.");
		
		SearchData searchData = DataProviderClass.getSearchData(11);
		extentLogger.log(LogStatus.INFO, "Seaching the Keyword: "+searchData.getKeyword());
		homePage.filterSearchKeyword(searchData.getKeyword());
		//Extracting the total count of the result	
		
		int resultCount= homePage.getTotalResultCount();
		extentLogger.log(LogStatus.INFO, "Search count for the above Keyword is: "+resultCount);
		
		extentLogger.log(LogStatus.INFO, "Verifying whether the results found should be greater than 300 results.");
		Assert.assertTrue(resultCount>300, "Result count should be atleast 300 as it is normally more than 500.");
		extentLogger.log(LogStatus.INFO, "Test Basic_search has succesfully Passed.");
		extent.endTest(extentLogger);
		
	}
	
	@Test(groups = {"TC88842"}, enabled=true, priority=1)
	public void TC88842_Search_With_No_Search_Terms() throws InterruptedException {
		
		logger.info("TC88842_Test Search With No_Search_Term is started.");
		extentLogger = extent.startTest("TC88842_Search_With_No_Search_Terms");
		extentLogger.log(LogStatus.INFO, "TC88842 Test Search With No_Search_Term is started.");
		//Login as customer
		userLogin.login(DataProviderClass.getCustomerUserDetails().getUser(), DataProviderClass.getCustomerUserDetails().getPw());
		extentLogger.log(LogStatus.INFO, "Loggedin as a customer");
		driver.navigate().to(configReader.getAgileCentralHome());
		extentLogger.log(LogStatus.INFO, "Navigated to Agile Central Drupal site.");
		
		//CASE:1
		
		SearchData searchData1 = DataProviderClass.getSearchData(1);
	
		extentLogger.log(LogStatus.INFO, "Navigating to : "+searchData1.getKeyword());
		
		extentLogger.log(LogStatus.INFO, "Searching the keyword as space");
		driver.navigate().to(configReader.getDrupalBaseURL()+"/"+configReader.getLocale()+"/Search");
		
		//Verifying whether No result found page is displayed.
		extentLogger.log(LogStatus.INFO, "Verifying whether No result found page is displayed.");
		Assert.assertTrue(homePage.isNoResultFound(), "No Result found should be displayed");
	
	
/*		//CASE:2
		SearchData searchData2 = DataProviderClass.getSearchData(2);
		//searching the 2nd Keyword
		driver.navigate().to(configReader.getDrupalURL()+ searchData2.getKeyword());
		extentLogger.log(LogStatus.INFO, "Title of the Page is : "+driver.getTitle());
		assertTrue(homePage.isNoResultFound(), "No Result found should be displayed" );

		
		//Case:3
		
		SearchData searchData3 = DataProviderClass.getSearchData(3);
		//searching the 3rd Keyword
		driver.navigate().to(configReader.getDrupalURL()+ searchData3.getKeyword());
		extentLogger.log(LogStatus.INFO, "Title of the Page is : "+driver.getTitle());
		assertTrue(homePage.isNoResultFound(), "No Result found should be displayed" );
	
		
		//Case:4
		
		SearchData searchData4 = DataProviderClass.getSearchData(4);
		//searching the 4th Keyword
		driver.navigate().to(configReader.getDrupalURL()+ searchData4.getKeyword());
		extentLogger.log(LogStatus.INFO, "Title of the Page is : "+driver.getTitle());
		assertTrue(homePage.isNoResultFound(), "No Result found should be displayed" );
*/		
		
		extent.endTest(extentLogger);

	}
	
	@Test(groups={"TC88545"}, enabled=true, priority=2)
	public void TC88545_Display_Of_No_Result_Message() throws InterruptedException{
		
		logger.info("TC88545 Display of No Result Messgae Test case Started");
		extentLogger=extent.startTest("TC88545 Display of No Result Messgae");
		extentLogger.log(LogStatus.INFO, "TC88545 Display of No Result Messgae Test case Started");
		//Login as customer
            userLogin.login(DataProviderClass.getCustomerUserDetails().getUser(), DataProviderClass.getCustomerUserDetails().getPw());
            extentLogger.log(LogStatus.INFO, "Loggedin as a customer");
         //Navigating to Home Page	
		driver.navigate().to(configReader.getAgileCentralHome());
		extentLogger.log(LogStatus.INFO, "Navigated to Agile Central Home Page.");
		
		SearchData searchData = DataProviderClass.getSearchData(5);
		extentLogger.log(LogStatus.INFO, "Seaching the Keyword: "+searchData.getKeyword());
		//Searching the keyword.	
		homePage.filterSearchKeyword(searchData.getKeyword());
		//Verifying the result	
		extentLogger.log(LogStatus.INFO, "Verifying the results");
		 if(homePage.isNoResultFound()){
	    	   extentLogger.log(LogStatus.PASS, "'No result found' message is displayed");
	       }else{
	    	   extentLogger.log(LogStatus.FAIL, "'No result found' message could not be displayed as expected.");
	       }
		Assert.assertTrue(homePage.isNoResultFound(), "No result found should be displayed" );
		
		extent.endTest(extentLogger);
		
	}

	@Test(groups={"TC90571"}, enabled=true, priority=3)
	public void TC90571_Verify_Case_Insensitivity() throws InterruptedException{
		
		SoftAssert verify = new SoftAssert();
		logger.info("Verify Case Insensitivity Test case is started");
		extentLogger = extent.startTest("TC90571_Verify_Case_Insensitivity");
		extentLogger.log(LogStatus.INFO, "Verify Case Insensitivity Test case is started");
		//Login as customer
                userLogin.login(DataProviderClass.getCustomerUserDetails().getUser(), DataProviderClass.getCustomerUserDetails().getPw());
                extentLogger.log(LogStatus.INFO, "Loggedin as a customer");
		extentLogger.log(LogStatus.INFO, "Navigating to Agile Central Home page.");
		driver.navigate().to(configReader.getAgileCentralHome());
	
		//Getting the data to Search	
		SearchData searchData1 = DataProviderClass.getSearchData(6);
		extentLogger.log(LogStatus.INFO, "Seaching the Keyword: "+searchData1.getKeyword());
		homePage.filterSearchKeyword(searchData1.getKeyword());
		//Extracting the total count of the result	
		int resultCount1= homePage.getTotalResultCount();
		extentLogger.log(LogStatus.INFO, "Search count for the above Keyword is: "+resultCount1);
	
		//Getting the data to Search	
		SearchData searchData2 = DataProviderClass.getSearchData(7);
		extentLogger.log(LogStatus.INFO, "Seaching the Keyword: "+searchData2.getKeyword());
		homePage.filterSearchKeyword(searchData2.getKeyword());
	//Extracting the total count of the result	
		int resultCount2= homePage.getTotalResultCount();
		extentLogger.log(LogStatus.INFO, "Search count for the above Keyword is: "+resultCount2);
	//Verifying the result count with previous search	
		verify.assertTrue(resultCount1==resultCount2, "result count for 2nd search keyword should be equal as the 1st search result count as the search keywords are same.");
	
	//Getting the data to Search	
		SearchData searchData3 = DataProviderClass.getSearchData(8);
		extentLogger.log(LogStatus.INFO, "Seaching the Keyword: "+searchData3.getKeyword());
		homePage.filterSearchKeyword(searchData3.getKeyword());
	//Extracting the total count of the result	
		int resultCount3= homePage.getTotalResultCount();
		extentLogger.log(LogStatus.INFO, "Search count for the above Keyword is: "+resultCount3);
	//Verifying the result count with previous search	
		verify.assertTrue(resultCount1==resultCount3, "result count for 3rd search keyword should be equal as the 1st search result count as the search keywords are same.");
		
	//Getting the data to Search
		SearchData searchData4 = DataProviderClass.getSearchData(9);
		extentLogger.log(LogStatus.INFO, "Seaching the Keyword: "+searchData4.getKeyword());
		homePage.filterSearchKeyword(searchData4.getKeyword());
	//Extracting the total count of the result
		int resultCount4= homePage.getTotalResultCount();
		extentLogger.log(LogStatus.INFO, "Search count for the above Keyword is: "+resultCount4);
	//Verifying the result count with previous search	
		verify.assertTrue(resultCount1==resultCount4, "result count for 4th search keyword should be equal as the 1st search result count as the search keywords are same.");
		
		verify.assertAll();
		
		extent.endTest(extentLogger);
		
	}

	@Test(groups={"TC88546"},enabled=false, priority=4)
	public void TC88546_Run_Indexing_Job(){

		logger.info("Running Indexing Job");
		extentLogger = extent.startTest("TC88546_Run_Indexing_Job");
		extentLogger.log(LogStatus.INFO, "Running Indexing Job");
                userLogin.login(configReader.getDocOpsUserName(StringConstants.USER_NAME), configReader.getDocOpsPassword(StringConstants.PASSWORD));
                mainPage.clickExtend();
		extendPage.runIndexingJob();		
		if(extendPage.isSuccessIndexingMsgDisplayed()){
			extentLogger.log(LogStatus.INFO, "Indexing has run successfully.");
		}else{
			extentLogger.log(LogStatus.INFO, "Indexing has Not run successfully.");
		}
		
		extent.endTest(extentLogger);
	}

	@Test(groups={"TC92342"}, enabled=false, priority=5)
	public void TC92342_Verify_Prior_Revisions_Not_included_in_Search() throws Exception{
		
		SoftAssert verify = new SoftAssert();
		logger.info("Verify Prior Revisions Not included in Search");
		extentLogger = extent.startTest("TC92342_Verify_Prior_Revisions_Not_included_in_Search");
		extentLogger.log(LogStatus.INFO, "Verify Prior Revisions Not included in Search");
		
		//Logging in as Doc Admin to Add an article.	
		userLogin.login(DataProviderClass.getDocAdminUserDetails().getUser(), DataProviderClass.getDocAdminUserDetails().getPw());
		driver.navigate().to(configReader.getAgileCentralHome());
		extentLogger.log(LogStatus.INFO, "Navigated to Agile Central Drupal site.");
			
		//Getting the data from Excel sheet to add and edit the article.
		ArticleData articleData1 = DataProviderClass.getArticleData(26);
		ArticleData articleData2 = DataProviderClass.getArticleData(27);
		ArticleData articleData3 = DataProviderClass.getArticleData(28);
		// Adding a new article.	
		extentLogger.log(LogStatus.INFO, "Adding an Article");
		mainPage.clickContent();
		contentPage.addArticle(articleData1);
		contentPage.saveAndPublish();
		//verifying whether article is created.	
		verify.assertEquals(internalUsersHomePage.isArticleCreatedMessageDisplayed(articleData1.getTitle()), true, "Article should be Created");
		extentLogger.log(LogStatus.INFO, "Article is created successfully");
		logger.info("Accessing Article from ToC");
		homePage.accessToCArticle(articleData1.getMenuLinkTitle());
		logger.info("Accessed Article from ToC");
		//Editing the article for 2nd revision.
		internalUsersHomePage.editPublishedArticle();
		extentLogger.log(LogStatus.INFO, "Editing the Article's Title for 2nd revison");
		contentPage.enterArticleTitle(articleData2.getTitle());
		contentPage.saveAndPublishForThisTranslation();
		//verifying whether article is Updated.
		verify.assertEquals(internalUsersHomePage.isArticleUpdatedMessageDisplayed(articleData2.getTitle()), true, "Article should be Updated");
		extentLogger.log(LogStatus.INFO, "Article is Updated successfully");
		extentLogger.log(LogStatus.INFO, "Revision 2 is done");
		homePage.accessToCArticle(articleData1.getMenuLinkTitle());
		//Editing the same article for 3rd revision.	
		internalUsersHomePage.editPublishedArticle();
		extentLogger.log(LogStatus.INFO, "Editing the Article's Title for 3rd revison");
		contentPage.enterArticleTitle(articleData3.getTitle());
		contentPage.saveAndPublishForThisTranslation();
		//verifying whether article is Updated.		
		verify.assertEquals(internalUsersHomePage.isArticleUpdatedMessageDisplayed(articleData3.getTitle()), true, "Article should be Updated");
		extentLogger.log(LogStatus.INFO, "Article is Updated successfully");
		extentLogger.log(LogStatus.INFO, "Revision 3 is done");
		homePage.accessToCArticle(articleData1.getMenuLinkTitle());
		//Run indexing job 
		internalUsersHomePage.logOutAndCleanCookies(userLogin);
		userLogin.login(configReader.getDocOpsUserName(StringConstants.USER_NAME), configReader.getDocOpsPassword(StringConstants.PASSWORD));
                mainPage.clickExtend();
                extendPage.runIndexingJob();
		//Logging out from admin control.	
		internalUsersHomePage.logOutAndCleanCookies(userLogin);
		extentLogger.log(LogStatus.INFO, "Signing Out from the Administration account and getting customer's view.");
		//Login as customer
                userLogin.login(DataProviderClass.getCustomerUserDetails().getUser(), DataProviderClass.getCustomerUserDetails().getPw());
        
		extentLogger.log(LogStatus.INFO, "Navigating to drupal home page");
		driver.navigate().to(configReader.getAgileCentralHome());
		extentLogger.log(LogStatus.INFO, "Searching the title of the article");
		//Searching the article by its Menu link title.	
		homePage.filterSearchKeyword(articleData1.getMenuLinkTitle());
		
		String SearchContent= "//*[@id='page-content']/div/div/div/div[2]//a[contains(text(),'"+articleData1.getMenuLinkTitle()+"')]";
		String SearchContentText = "//*[@id='page-content']/div/div/div/div[2]//a";
		//getting the count of result	
		extentLogger.log(LogStatus.INFO, "Total search count: "+driver.findElements(By.xpath(SearchContent)).size());
		verify.assertEquals(driver.findElements(By.xpath(SearchContent)).size()==1, true, "Search count should be 1");
		//getting the article title of result
		extentLogger.log(LogStatus.INFO, "search content is: "+driver.findElement(By.xpath(SearchContentText)).getText());
		//Verifying whether the search Result is last Revised title of the Article
		verify.assertEquals(driver.findElement(By.xpath(SearchContentText)).getText().equalsIgnoreCase(articleData3.getTitle()), true, "Search Result should be last Revision title of the Article");
		verify.assertAll();
		
		extent.endTest(extentLogger);
	}
	
	@Test(groups={"TC93186"}, enabled=true, priority=6)
	public void TC93186_Verify_Annonymous_User_Cannot_See_Unpublished_Content() throws Exception{
		
		SoftAssert verify = new SoftAssert();
		logger.info("Verify Annonymous User Cannot See Unpublished Content");
		extentLogger = extent.startTest("TC93186 Verify Annonymous User Cannot See Unpublished Content");
		extentLogger.log(LogStatus.INFO, "Verify Prior Revisions Not included in Search");
		
		//Logging in as Doc Admin.	
		userLogin.login(DataProviderClass.getDocAdminUserDetails().getUser(), DataProviderClass.getDocAdminUserDetails().getPw());
		 extentLogger.log(LogStatus.INFO, "Loggedin as a DocAdmin user");
		driver.navigate().to(configReader.getAgileCentralHome());

		
		logger.info("Navigated to Agile Central Drupal site.");
		extentLogger.log(LogStatus.INFO, "Navigated to Agile Central Drupal site.");
		//Getting the data from Excel sheet.
		ArticleData articleData = DataProviderClass.getArticleData(38);	
	
		// Commenting it because now checking the Previously added article in Test TC92452.
		// AS issue persist for Indexing search
	/*	extentLogger.log(LogStatus.INFO, "Adding an Article");
		//Adding an article	as draft.
		mainPage.clickContent();
		contentPage.addArticle(articleData);
		contentPage.saveArticleAsDraft();
		//Verifying whether article is created.
		verify.assertEquals(internalUsersHomePage.isArticleCreatedMessageDisplayed(articleData.getTitle()), true, "Article should be Created");
		extentLogger.log(LogStatus.INFO, "Article is created successfully");
		homePage.accessToCArticle(articleData.getMenuLinkTitle());
		extentLogger.log(LogStatus.INFO, "Article is accessed from ToC");
		extentLogger.log(LogStatus.INFO, "Running the Index job manually.");
		//Run Indexing Job.
		internalUsersHomePage.logOutAndCleanCookies(userLogin);
                userLogin.login(configReader.getDocOpsUserName(StringConstants.USER_NAME), configReader.getDocOpsPassword(StringConstants.PASSWORD));
                mainPage.clickExtend();
                extendPage.runIndexingJob();
	 	extentLogger.log(LogStatus.INFO, "Indexing Job has ran successfully.");
		
		
	*/
		
		logger.info("Filtering the search Keyword : " +articleData.getKeywordSearchTermsInCAAgileCentralHelpTopic());
		extentLogger.log(LogStatus.INFO, "Filtering the search Keyword : " +articleData.getKeywordSearchTermsInCAAgileCentralHelpTopic());
		//Searching a unique keyword to filter added article.	
		homePage.filterSearchKeyword(articleData.getKeywordSearchTermsInCAAgileCentralHelpTopic());
		//getting a result count for searched keyword.	
		int ResultCount = homePage.getTotalResultCount();
		extentLogger.log(LogStatus.INFO, "Result count in Admin view found as : "+ResultCount);
		verify.assertFalse(ResultCount==0, "Result count for Admin View should not be zero");
		
		//Logging out from DocAdmin Rights. Getting Anonymous user/Customer Rights.	
		extentLogger.log(LogStatus.INFO, "Logging out from Admin Rights. Getting Customer Rights.");
		internalUsersHomePage.logOutAndCleanCookies(userLogin);
	
		//Login as customer
                userLogin.login(DataProviderClass.getCustomerUserDetails().getUser(), DataProviderClass.getCustomerUserDetails().getPw());
                extentLogger.log(LogStatus.INFO, "Logged in as a customer");
		//Filtering the search Keyword as customer
                logger.info("Filtering the search Keyword as Annonymous User: " +articleData.getKeywordSearchTermsInCAAgileCentralHelpTopic());
                extentLogger.log(LogStatus.INFO, "Filtering the search Keyword as Annonymous User: " +articleData.getKeywordSearchTermsInCAAgileCentralHelpTopic());
		driver.navigate().to(configReader.getAgileCentralHome());
		homePage.filterSearchKeyword(articleData.getKeywordSearchTermsInCAAgileCentralHelpTopic());
		//getting a result count for searched keyword.		
		int ResultCount2 = homePage.getTotalResultCount();
		extentLogger.log(LogStatus.INFO, "Result count in Customer view found as : "+ResultCount2);
		
		//Comparing the result counts fetched by Admin view and Annonymous View.	
		extentLogger.log(LogStatus.INFO, "Comparing the result counts fetched by Admin view and Annonymous View.");
		verify.assertEquals(ResultCount2<ResultCount, true, "Customer user search result count should be Less than Admin user result count.");
		if(ResultCount2<ResultCount){
	    	   extentLogger.log(LogStatus.PASS, "Customer user search result count is Less than Admin user result count.");
	       }else{
	    	   extentLogger.log(LogStatus.FAIL, "Customer user search result count is not Less than Admin user result count.");
	       }
		verify.assertAll();	
		extent.endTest(extentLogger);
		
	}
	
	@Test (groups={"TC102305"}, enabled=true, priority=7)
	public void TC102305_Verify_Result_Per_Page() throws InterruptedException{
		
		logger.info("TC102305 Verify count of Results diplayed per page");
		extentLogger = extent.startTest("TC102305_Verify_Result_Per_Page");
		extentLogger.log(LogStatus.INFO, "Verify count of Results diplayed per page");
		//Login as customer
                userLogin.login(DataProviderClass.getCustomerUserDetails().getUser(), DataProviderClass.getCustomerUserDetails().getPw());
                extentLogger.log(LogStatus.INFO, "Loggedin as a customer");
                
	//Navigating to Home Page
		driver.navigate().to(configReader.getAgileCentralHome());
	//Getting the search keyword from Excel sheet.	
		SearchData saerchTerm = DataProviderClass.getSearchData(10);
		extentLogger.log(LogStatus.INFO, "Seaching the Keyword: "+saerchTerm.getKeyword());
	//Filtering the search keyword.	
		homePage.filterSearchKeyword(saerchTerm.getKeyword());
	//Getting the count of the result displayed in	result String.
		int NumberOfResultDisplayedOnPage= homePage.getCountOfResultArticleTitles();
		extentLogger.log(LogStatus.INFO, "Number of Result articles displayed on page :"+NumberOfResultDisplayedOnPage);
	//Getting the actual count of result displayed on the page.	
		int ResultCountDisplayedOnPage = homePage.getResultCountOfCurrentPage();
		extentLogger.log(LogStatus.INFO, "Number of Result count displayed on page :"+ResultCountDisplayedOnPage);
	//Comparing the result counts which displayed on Page and with count displayed in string.
		Assert.assertFalse(NumberOfResultDisplayedOnPage==0, "NumberOfResultDisplayedOnPage should not Be Zero. If it is Zero use other search Keyword.");
		Assert.assertFalse(ResultCountDisplayedOnPage==0, "ResultCountDisplayedOnPage should not Be Zero. If it is Zero use other search Keyword.");
		Assert.assertTrue(NumberOfResultDisplayedOnPage==ResultCountDisplayedOnPage, "Result Count displayed And number of result displayed on page should be equal.");
		extent.endTest(extentLogger);
		
	}

	@Test(groups = { "TC121761" }, priority = 8)
	public void TC121761_Verify_Japanese_Search() throws Exception {
		SoftAssert verify = new SoftAssert();
		logger.info("TC121761 Test verify_Japanese_Search is started.");
		extentLogger = extent.startTest("TC121761 verify_Japanese_Search");
		extentLogger.log(LogStatus.INFO, "TC121761 verify_Japanese_Search is started.");

		userLogin.login(DataProviderClass.getCustomerUserDetails().getUser(),
				DataProviderClass.getCustomerUserDetails().getPw());
		extentLogger.log(LogStatus.INFO, "Logged in as Customer");
		ArticleData articleData = DataProviderClass.getArticleData(50);

		// Navigating to Japanese language home page.
		internalUsersHomePage.accessArticleWithLocale(configReader.getValue("ac_home"),
				StringConstants.JAPANESE_LOCALE);
		SearchData searchData = DataProviderClass.getSearchData(12);
		extentLogger.log(LogStatus.INFO, "Seaching the Keyword: " + searchData.getKeyword());
		homePage.filterSearchKeyword(searchData.getKeyword());

		// Verify the search results.
		verify.assertFalse(homePage.isJapaneseNoResultFound(),
				"Atleast one japanese search result should be displayed.");
		if (homePage.isJapaneseNoResultFound()) {
			extentLogger.log(LogStatus.FAIL, "There is no search result found for japanese language.");
		} else {
			extentLogger.log(LogStatus.PASS, "Verified that Search results for japanese language is displayed");
		}
		verify.assertAll();
		extent.endTest(extentLogger);
	}
	
	
	@Test(groups={"TC113964"}, priority=9)
	public void TC113964_verify_search_Unpublished() throws Exception{
		
		SoftAssert verify = new SoftAssert(); 
		logger.info("TC113964_verify_search_Unpublished is started.");
		extentLogger = extent.startTest("TC113964_verify_search_Unpublished");
		extentLogger.log(LogStatus.INFO, "TC113964_verify_search_Unpublished is started.");
		
		//Getting the details of already added article
		ArticleData articleData = DataProviderClass.getArticleData(46);
		extentLogger.log(LogStatus.INFO, "Getting the details of: "+articleData.getTitle()+" as suite has already added and published this article.");
		//Logging in as a Doc Admin to unpublish the article.
		userLogin.login(DataProviderClass.getDocAdminUserDetails().getUser(), DataProviderClass.getDocAdminUserDetails().getPw());
        extentLogger.log(LogStatus.INFO, "Logged in as Doc Admin");
        //Accessing the article through URL Alias and unpublishing the article
        internalUsersHomePage.accessArticleWithUrlAlias(articleData.getUrlAlias());
        internalUsersHomePage.editPublishedArticle();
        contentPage.saveAndUnpublishForThisTranslation();
        extentLogger.log(LogStatus.INFO, "Accessed the article through URL Alias and unpublished the article");
        
        //Logging out and loggin in as a customer
        extentLogger.log(LogStatus.INFO, "Logging out and loggin in as a customer");
        internalUsersHomePage.logOutAndCleanCookies(userLogin);
        userLogin.login(DataProviderClass.getCustomerUserDetails().getUser(), DataProviderClass.getCustomerUserDetails().getPw());
        driver.navigate().to(configReader.getAgileCentralHome());
        //Filtering the article with its body content which is unique.
        extentLogger.log(LogStatus.INFO, "Filtering the article through its body content which is unique as: "+articleData.getBody());
		homePage.filterSearchKeyword(articleData.getBody());
		
		//Verifying whether the unpublished article is searchable by customer
		extentLogger.log(LogStatus.INFO, "Verifying whether the unpublished article is searchable by customer");
		if(homePage.isNoResultFound()){
			verify.assertTrue(homePage.isNoResultFound());
			 extentLogger.log(LogStatus.PASS, "Unpublished article is not searchable as expected.");
		}else{
			verify.assertFalse(homePage.getSearchResultArticleTitles().contains(articleData.getTitle()), "Unpublished article is searchable by customer");
			if(homePage.getSearchResultArticleTitles().contains(articleData.getTitle())){				
				extentLogger.log(LogStatus.FAIL, "Unpublished article is searchable by customer");
			}else{
				extentLogger.log(LogStatus.PASS, "Unpublished article is not searchable as expected.");
			}
			
		}
		
		verify.assertAll();
		extent.endTest(extentLogger);
		
	}

	
}
