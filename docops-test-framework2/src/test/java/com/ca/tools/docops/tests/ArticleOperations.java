package com.ca.tools.docops.tests;

import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import org.testng.log4testng.Logger;
import com.ca.tools.docops.common.CommonActions;
import com.ca.tools.docops.dtos.ArticleData;
import com.ca.tools.docops.dtos.SearchData;
import com.ca.tools.docops.utils.DataProviderClass;
import com.ca.tools.docops.utils.StringConstants;
import com.relevantcodes.extentreports.LogStatus;

/**
 * Test all article fields and the CRUD opearions of article of different
 * content types
 * 
 * @author Team - Tools - Development <Team-Tools-Development@ca.com>
 *
 */

public class ArticleOperations extends BaseTest {
	private static final Logger logger = Logger.getLogger(ArticleOperations.class);

	/**
	 * TestCase : Create article in draft state
	 * 
	 * @throws Exception
	 */
	@Test(groups = { "TC92452" }, priority = 0)
	public void TC92452_createArticleAsDraft() throws Exception {
		SoftAssert verify = new SoftAssert();
		logger.info("TC92452_createArticleDraft Test started");
		extentLogger = extent.startTest("TC92452 Test Creation of article in draft state");
		extentLogger.log(LogStatus.INFO, "TC92452 Test Creation of article in draft state");
		internalUsersHomePage.logOutAndCleanCookies(userLogin);
		// login as all-authors user, create a draft of Agile central help topic
		userLogin.login(DataProviderClass.getAllAuthorUserDetails().getUser(),
				DataProviderClass.getAllAuthorUserDetails().getPw());
		extentLogger.log(LogStatus.INFO, "Logged in as All Authors user");
		ArticleData articleData = DataProviderClass.getArticleData(4);
		extentLogger.log(LogStatus.INFO, "Adding an article:" + articleData.getTitle());
		mainPage.clickContent();
		contentPage.addArticle(articleData);
		contentPage.saveArticleAsDraft();
		extentLogger.log(LogStatus.INFO, "Verifying whether the article is created as a draft");
		// Verify that the article is created as a draft
		verify.assertTrue(internalUsersHomePage.isArticleCreatedMessageDisplayed(articleData.getTitle()),
				"Article creation message should be displayed as expected.");
		if (internalUsersHomePage.isArticleCreatedMessageDisplayed(articleData.getTitle())) {
			extentLogger.log(LogStatus.PASS, "Verified that Article creation message is displayed successfuly.");
		} else {
			extentLogger.log(LogStatus.FAIL, "Verified that Article creation message is Not displayed.");
		}
		mainPage.clickContent();
		// Verify that the article's moderation state is 'Draft'
		extentLogger.log(LogStatus.INFO, "Verifying whether the article's moderation state is 'Draft'");
		verify.assertTrue(contentPage.isArticleADraft(articleData.getTitle()),
				"Article's moderation state should be 'Draft'");
		if (contentPage.isArticleADraft(articleData.getTitle())) {
			extentLogger.log(LogStatus.PASS, "Verified that Article's moderation state is 'Draft'");
		} else {
			extentLogger.log(LogStatus.FAIL, "Verified that Article's moderation is not 'Draft'");
		}

		// access the article using url alias and assert that the page title
		// contains the article title
		extentLogger.log(LogStatus.INFO,
				"Accessing the article using url alias and verifying that the page title contains the article title");
		extentLogger.log(LogStatus.INFO, "Navigating to article by url alias");
		driver.navigate().to(configReader.getDrupalBaseURL() + articleData.getUrlAlias());
		// Verify that the page title contains article title
		verify.assertTrue(driver.getTitle().contains(articleData.getTitle()),
				"page title should contain the article title");
		if (driver.getTitle().contains(articleData.getTitle())) {
			extentLogger.log(LogStatus.PASS, "Verified that page title is containing the article title");
		} else {
			extentLogger.log(LogStatus.FAIL, "Verified that page title does not contain the article title");
		}
		verify.assertAll();
		extent.endTest(extentLogger);
	}

	/**
	 * Test Case : Create article in request for review state
	 * 
	 * @throws Exception
	 */
	@Test(groups = { "TC92453" }, priority = 1)
	public void TC92453_createArticleAndRequestReview() throws Exception {
		SoftAssert verify = new SoftAssert();
		logger.info("TC92453_createArticleAndRequestReview Test started");
		extentLogger = extent.startTest("TC92453 Test Creation of article in request review state");
		extentLogger.log(LogStatus.INFO, "TC92453 Test Creation of article in request review state");

		// login as all-authors user, create a draft of Agile central help topic
		userLogin.login(DataProviderClass.getAllAuthorUserDetails().getUser(),
				DataProviderClass.getAllAuthorUserDetails().getPw());
		extentLogger.log(LogStatus.INFO, "Logged in as All Authors user");
		ArticleData articleData = DataProviderClass.getArticleData(5);
		extentLogger.log(LogStatus.INFO, "Adding an article:" + articleData.getTitle());
		mainPage.clickContent();
		contentPage.addArticle(articleData);
		contentPage.saveArticleAndRequestReview();
		extentLogger.log(LogStatus.INFO, "Verifying whether the article is created");
		// Verify that the article is created
		verify.assertTrue(internalUsersHomePage.isArticleCreatedMessageDisplayed(articleData.getTitle()),
				"Article creation message should be displayed as expected.");
		if (internalUsersHomePage.isArticleCreatedMessageDisplayed(articleData.getTitle())) {
			extentLogger.log(LogStatus.PASS, "Verified that Article creation message is displayed successfuly.");
		} else {
			extentLogger.log(LogStatus.FAIL, "Verified that Article creation message is Not displayed.");
		}

		// Verify that the article's moderation state is 'ReadyForReview'
		extentLogger.log(LogStatus.INFO, "Verifying whether the article's moderation state is 'ReadyForReview'");
		mainPage.clickContent();
		verify.assertTrue(contentPage.isArticleReadyForReview(articleData.getTitle()),
				"Article's moderation state should be 'ReadyForReview'");
		if (contentPage.isArticleReadyForReview(articleData.getTitle())) {
			extentLogger.log(LogStatus.PASS, "Verified that Article's moderation state is 'ReadyForReview'");
		} else {
			extentLogger.log(LogStatus.FAIL, "Verified that Article's moderation is not 'ReadyForReview'");
		}

		// access the article with Url alias and assert that the page title
		// contains the article title
		extentLogger.log(LogStatus.INFO,
				"Accessing the article using url alias and verifying that the page title contains the article title");
		extentLogger.log(LogStatus.INFO, "Navigating to article by url alias");
		driver.navigate().to(configReader.getDrupalURL() + articleData.getUrlAlias());
		verify.assertTrue(driver.getTitle().contains(articleData.getTitle()),
				"page title should contain the article title");
		if (driver.getTitle().contains(articleData.getTitle())) {
			extentLogger.log(LogStatus.PASS, "Verified that page title is containing the article title");
		} else {
			extentLogger.log(LogStatus.FAIL, "Verified that page title does not contain the article title");
		}
		verify.assertAll();
		extent.endTest(extentLogger);
	}

	/**
	 * Test Case : Create article and publish
	 * 
	 * @throws Exception
	 */
	@Test(groups = { "TC92454" }, priority = 2)
	public void TC92454_createArticleAndPublish() throws Exception {
		SoftAssert verify = new SoftAssert();
		logger.info("TC92454_createArticleAndPublish Test started");
		extentLogger = extent.startTest("TC92454 Test Creation of article in published state");
		extentLogger.log(LogStatus.INFO, "TC92454 Test Creation of article in published state");

		// login as doc admin user
		userLogin.login(DataProviderClass.getDocAdminUserDetails().getUser(),
				DataProviderClass.getDocAdminUserDetails().getPw());
		extentLogger.log(LogStatus.INFO, "Logged in as Doc Admin user");
		ArticleData articleData = DataProviderClass.getArticleData(6);
		extentLogger.log(LogStatus.INFO, "Adding an article:" + articleData.getTitle());
		mainPage.clickContent();
		contentPage.addArticle(articleData);
		contentPage.saveAndPublish();

		extentLogger.log(LogStatus.INFO, "Verifying whether the article is created");
		// Verify that the article is created
		verify.assertTrue(internalUsersHomePage.isArticleCreatedMessageDisplayed(articleData.getTitle()),
				"Article creation message should be displayed as expected.");
		if (internalUsersHomePage.isArticleCreatedMessageDisplayed(articleData.getTitle())) {
			extentLogger.log(LogStatus.PASS, "Verified that Article creation message is displayed successfuly.");
		} else {
			extentLogger.log(LogStatus.FAIL, "Verified that Article creation message is Not displayed.");
		}

		// Verify that the article's moderation state is 'Published'
		extentLogger.log(LogStatus.INFO, "Verifying whether the article's moderation state is 'Published'");
		mainPage.clickContent();
		verify.assertTrue(contentPage.isArticlePublished(articleData.getTitle()),
				"Article's moderation state should be 'Published'");
		if (contentPage.isArticlePublished(articleData.getTitle())) {
			extentLogger.log(LogStatus.PASS, "Verified that Article's moderation state is 'Published'");
		} else {
			extentLogger.log(LogStatus.FAIL, "Verified that Article's moderation is not 'Published'");
		}

		// access the article with Url alias and assert that the page title
		// contains the article title
		extentLogger.log(LogStatus.INFO,
				"Accessing the article using url alias and verifying that the page title contains the article title");
		extentLogger.log(LogStatus.INFO, "Navigating to article by url alias");
		driver.navigate().to(configReader.getDrupalURL() + articleData.getUrlAlias());
		verify.assertTrue(driver.getTitle().contains(articleData.getTitle()),
				"page title should contain the article title");
		if (driver.getTitle().contains(articleData.getTitle())) {
			extentLogger.log(LogStatus.PASS, "Verified that page title is containing the article title");
		} else {
			extentLogger.log(LogStatus.FAIL, "Verified that page title does not contain the article title");
		}
		verify.assertAll();
		extent.endTest(extentLogger);
	}

	/**
	 * Test Case : Delete article
	 * 
	 * @throws Exception
	 */
	@Test(groups = { "TC114788" }, priority = 3)
	public void TC114788_deleteArticle() throws Exception {
		logger.info("TC114788_deleteArticle Test started");
		extentLogger = extent.startTest("TC114788 Test article deletion");
		extentLogger.log(LogStatus.INFO, "TC114788 Test article deletion Test started.");

		// login as all-authors user, create a draft of Agile central help topic
		userLogin.login(DataProviderClass.getDocAdminUserDetails().getUser(),
				DataProviderClass.getDocAdminUserDetails().getPw());
		extentLogger.log(LogStatus.INFO, "Logged in as Doc Admin user");
		mainPage.clickContent();
		ArticleData articleData = DataProviderClass.getArticleData(6);
		extentLogger.log(LogStatus.INFO, "Filtering an article:" + articleData.getTitle() + " to Delete");
		contentPage.filterArticle(articleData.getTitle());
		if (!contentPage.isArticlePublished(articleData.getTitle())) {
			contentPage.addArticle(articleData);
			contentPage.saveAndPublish();
		}
		extentLogger.log(LogStatus.INFO, "Deleting the article");
		contentPage.deleteArticle(articleData.getTitle());
		extentLogger.log(LogStatus.INFO, "Performed the delete opearion");
		String articleDeletionMessage = "//*[@role='contentinfo' and contains(.,' Deleted 1 post.')]";
		extentLogger.log(LogStatus.INFO, "Verifying whether article is deleted.");
		if (driver.findElements(By.xpath(articleDeletionMessage)).size() != 0) {
			extentLogger.log(LogStatus.PASS, "Verified that Article is deleted successfully.");
		} else {
			extentLogger.log(LogStatus.FAIL, "Verified that Article could not be deleted.");
		}
		Assert.assertTrue(driver.findElements(By.xpath(articleDeletionMessage)).size() != 0);

		extent.endTest(extentLogger);
	}

	/**
	 * Test Case : Delete article from the article screen
	 * 
	 * @throws Exception
	 */
	@Test(groups = { "TC92468" }, priority = 4)
	public void TC92468_deleteArticleFromArticleScreen() throws Exception {
		SoftAssert verify = new SoftAssert();
		logger.info("TC92468_deleteArticleFromArticleScreen Test started");
		extentLogger = extent.startTest("TC92468 Test article deletion from article screen");
		extentLogger.log(LogStatus.INFO, "TC92468 deleteArticleFromArticleScreen Test has started");
		// Logging in as DocAdmin Role.
		userLogin.login(DataProviderClass.getDocAdminUserDetails().getUser(),
				DataProviderClass.getDocAdminUserDetails().getPw());
		extentLogger.log(LogStatus.INFO, "Logged in as Doc Admin user");
		mainPage.clickContent();
		ArticleData articleData = DataProviderClass.getArticleData(5);
		extentLogger.log(LogStatus.INFO, "Filtering an article:" + articleData.getTitle() + " to Delete");
		contentPage.filterArticle(articleData.getTitle());
		if (!contentPage.isArticleReadyForReview(articleData.getTitle())) {
			contentPage.addArticle(articleData);
			contentPage.saveAndPublish();
		}

		// access the article with Url alias and assert that the page title
		// contains the article title
		extentLogger.log(LogStatus.INFO,
				"Accessing the article using url alias and verifying that the page title contains the article title");
		extentLogger.log(LogStatus.INFO, "Navigating to article by url alias");
		driver.navigate().to(configReader.getDrupalURL() + articleData.getUrlAlias());

		verify.assertTrue(driver.getTitle().contains(articleData.getTitle()),
				"page title should contain the article title");
		if (driver.getTitle().contains(articleData.getTitle())) {
			extentLogger.log(LogStatus.PASS, "Verified that page title is containing the article title");
		} else {
			extentLogger.log(LogStatus.FAIL, "Page title does not contain the article title");
		}

		extentLogger.log(LogStatus.INFO, "Deleting the article");
		// Deleting the article and verifying whether article si deleted.
		internalUsersHomePage.deleteArticle();
		extentLogger.log(LogStatus.INFO, "Verifying whether article is deleted.");

		verify.assertTrue(internalUsersHomePage.isArticleDeletedMessageDisplayed(articleData.getTitle()),
				"Article deletion message should be displayed.");
		if (internalUsersHomePage.isArticleDeletedMessageDisplayed(articleData.getTitle())) {
			extentLogger.log(LogStatus.PASS, "Verified that Article deletion message is displayed successfully.");
		} else {
			extentLogger.log(LogStatus.FAIL, "Article deletion message is not displayed.");
		}

		verify.assertAll();
		extent.endTest(extentLogger);
	}

	/**
	 * Test Case : Add a Video to an Article and save Creates an article with an
	 * embedded video and asserts that the video is accessible to the user
	 * 
	 * @throws Exception
	 */
	@Test(groups = { "TC86949" }, priority = 5)
	public void TC86949_createArticleWithVideo() throws Exception {
		SoftAssert verify = new SoftAssert();
		logger.info("TC86949_createArticleWithVideo Test started");
		extentLogger = extent.startTest("TC86949 Test Creation of article with video");
		extentLogger.log(LogStatus.INFO, "TC86949 createArticleWithVideo Test has started");
		// login as all-authors user, create a draft of Agile central help topic
		// with video
		userLogin.login(DataProviderClass.getAllAuthorUserDetails().getUser(),
				DataProviderClass.getAllAuthorUserDetails().getPw());
		extentLogger.log(LogStatus.INFO, "Loggged in as All Author user");
		ArticleData articleData = DataProviderClass.getArticleData(7);
		extentLogger.log(LogStatus.INFO, "Adding an article:" + articleData.getTitle());
		mainPage.clickContent();
		contentPage.addArticle(articleData);
		contentPage.saveArticleAsDraft();
		// Verify that the article is created as a draft
		extentLogger.log(LogStatus.INFO, "Verifying whether the article is created as a draft");
		verify.assertTrue(internalUsersHomePage.isArticleCreatedMessageDisplayed(articleData.getTitle()),
				"Article creation message should be displayed as expected.");
		if (internalUsersHomePage.isArticleCreatedMessageDisplayed(articleData.getTitle())) {
			extentLogger.log(LogStatus.PASS, "Verified that Article creation message is displayed successfuly.");
		} else {
			extentLogger.log(LogStatus.FAIL, "Verified that Article creation message is Not displayed.");
		}
		internalUsersHomePage.logOutAndCleanCookies(userLogin);
		extentLogger.log(LogStatus.INFO, "Loggged out from All Author user");
		// login as all-authors user, create a draft of Agile central help topic
		userLogin.login(DataProviderClass.getDocAdminUserDetails().getUser(),
				DataProviderClass.getDocAdminUserDetails().getPw());
		extentLogger.log(LogStatus.INFO, "Loggged in as Doc Admin user");
		// access the article using url alias and publishing this article.
		extentLogger.log(LogStatus.INFO, "Accessing the article using url alias and publishing this article.");
		internalUsersHomePage.accessArticleWithUrlAlias(articleData.getUrlAlias());
		internalUsersHomePage.editDraftArticle();
		contentPage.saveAndPublishForThisTranslation();
		mainPage.clickContent();
		// Verifying whether article is published.

		verify.assertTrue(contentPage.isArticlePublished(articleData.getTitle()),
				"Article's moderation state should be 'Published'");
		if (contentPage.isArticlePublished(articleData.getTitle())) {
			extentLogger.log(LogStatus.PASS, "Verified that Article is 'Published' by Doc Admin.");
		} else {
			extentLogger.log(LogStatus.FAIL, "Verified that Article is not 'Published' by Doc Admin.");
		}

		/*
		 * Logout and login as customer and verify if the article is accessible
		 */
		internalUsersHomePage.logOutAndCleanCookies(userLogin);
		extentLogger.log(LogStatus.INFO, "Logged out and accessing the article as customer user");
		userLogin.login(DataProviderClass.getCustomerUserDetails().getUser(),
				DataProviderClass.getCustomerUserDetails().getPw());
		internalUsersHomePage.accessArticleWithUrlAlias(articleData.getUrlAlias());

		verify.assertTrue(driver.getTitle().contains(articleData.getTitle()),
				"page title should contain the article title");
		if (driver.getTitle().contains(articleData.getTitle())) {
			extentLogger.log(LogStatus.PASS, "Verified that article is accessed by URL alias");
		} else {
			extentLogger.log(LogStatus.FAIL, "Verified that article could not accessed by URL alias");
		}

		// Verify that the article has the attachment displayed
		extentLogger.log(LogStatus.INFO, "Verifying whether attached video is displayed on the view page of article.");

		verify.assertTrue(
				driver.findElements(By.xpath("//video/source[contains(@src, '" + articleData.getVideoPath() + "')]"))
						.size() != 0,
				"Attached video should be displayed on the view page of article.");
		if (driver.findElements(By.xpath("//video/source[contains(@src, '" + articleData.getVideoPath() + "')]"))
				.size() != 0) {
			extentLogger.log(LogStatus.PASS, "Verified that attached video is displayed on the article page.");
		} else {
			extentLogger.log(LogStatus.FAIL, "Verified that attached video is not displayed on the article page.");
		}

		verify.assertAll();
		extent.endTest(extentLogger);
	}

	/**
	 * Test Case : Test Attachment for an Article Creates an article with an
	 * image and asserts that the image is accessible to the user
	 * 
	 * @throws Exception
	 */
	@Test(groups = { "TC102061" }, enabled = true, priority = 6)
	public void TC102061_createArticleWithImage() throws Exception {
		SoftAssert verify = new SoftAssert();
		logger.info("TC102061_createArticleWithImage Test started");
		extentLogger = extent.startTest("TC102061 Test Creation of article with image");
		extentLogger.log(LogStatus.INFO, "TC86949 createArticleWithImage Test has started");
		// login as all-authors user, create a draft of Agile central help topic
		// with image
		userLogin.login(DataProviderClass.getAllAuthorUserDetails().getUser(),
				DataProviderClass.getAllAuthorUserDetails().getPw());
		extentLogger.log(LogStatus.INFO, "Loggged in as All Author user");
		ArticleData articleData = DataProviderClass.getArticleData(8);
		extentLogger.log(LogStatus.INFO, "Adding an article:" + articleData.getTitle());
		mainPage.clickContent();
		contentPage.addArticle(articleData);
		contentPage.saveArticleAsDraft();

		// Verify that the article is created as a draft
		extentLogger.log(LogStatus.INFO, "Verifying whether the article is created as a draft");
		verify.assertTrue(internalUsersHomePage.isArticleCreatedMessageDisplayed(articleData.getTitle()),
				"Article creation message should be displayed as expected.");
		if (internalUsersHomePage.isArticleCreatedMessageDisplayed(articleData.getTitle())) {
			extentLogger.log(LogStatus.PASS, "Verified that Article creation message is displayed successfuly.");
		} else {
			extentLogger.log(LogStatus.FAIL, "Verified that Article creation message is Not displayed.");
		}
		internalUsersHomePage.logOutAndCleanCookies(userLogin);
		extentLogger.log(LogStatus.INFO, "Loggged out from All Author user");
		// login as all-authors user, create a draft of Agile central help topic
		userLogin.login(DataProviderClass.getDocAdminUserDetails().getUser(),
				DataProviderClass.getDocAdminUserDetails().getPw());
		extentLogger.log(LogStatus.INFO, "Loggged in as Doc Admin user");

		// access the article using url alias and publishing this article.
		extentLogger.log(LogStatus.INFO, "Accessing the article using url alias and publishing this article.");
		internalUsersHomePage.accessArticleWithUrlAlias(articleData.getUrlAlias());
		internalUsersHomePage.editDraftArticle();
		contentPage.saveAndPublishForThisTranslation();
		mainPage.clickContent();

		// Verifying whether article is published.
		verify.assertTrue(contentPage.isArticlePublished(articleData.getTitle()),
				"Article's moderation state should be 'Published'");
		if (contentPage.isArticlePublished(articleData.getTitle())) {
			extentLogger.log(LogStatus.PASS, "Verified that Article is 'Published' by Doc Admin.");
		} else {
			extentLogger.log(LogStatus.FAIL, "Verified that Article is not 'Published' by Doc Admin.");
		}

		/*
		 * Logout and login as customer and verify if the article is accessible
		 */
		internalUsersHomePage.logOutAndCleanCookies(userLogin);
		extentLogger.log(LogStatus.INFO, "Logged out and accessing the article as customer user");
		userLogin.login(DataProviderClass.getCustomerUserDetails().getUser(),
				DataProviderClass.getCustomerUserDetails().getPw());
		internalUsersHomePage.accessArticleWithUrlAlias(articleData.getUrlAlias());
		// Verify whether page title contains the article title.
		verify.assertTrue(driver.getTitle().contains(articleData.getTitle()),
				"page title should contain the article title");
		if (driver.getTitle().contains(articleData.getTitle())) {
			extentLogger.log(LogStatus.PASS, "Verified that article is accessed by URL alias");
		} else {
			extentLogger.log(LogStatus.FAIL, "Verified that article could not accessed by URL alias");
		}

		// Verify that the article has the image attachment displayed
		extentLogger.log(LogStatus.INFO, "Verifying whether attached Image is displayed on the view page of article.");
		verify.assertTrue(driver.findElements(By.xpath("//*[@id='page-content']//img")).size() != 0,
				"Attached image should be displayed on the view page of article.");
		if (driver.findElements(By.xpath("//*[@id='page-content']//img")).size() != 0) {
			extentLogger.log(LogStatus.PASS, "Verified that attached image is displayed on the article page.");
		} else {
			extentLogger.log(LogStatus.FAIL, "Verified that attached image is not displayed on the article page.");
		}

		verify.assertAll();
		extent.endTest(extentLogger);

	}

	/**
	 * Test Case : Test Attachment for an Article Creates an article with an
	 * attachment and asserts that the attachment is accessible to the user
	 * 
	 * @throws Exception
	 */
	@Test(groups = { "TC92459" }, priority = 7)
	public void TC92459_createArticleWithAttachment() throws Exception {
		SoftAssert verify = new SoftAssert();
		logger.info("TC92459_createArticleWithAttachment Test started");
		extentLogger = extent.startTest("TC92459 Test Creation of article with attachment");
		extentLogger.log(LogStatus.INFO, "TC92459 createArticleWithAttachment Test has started");

		// login as all-authors user, create a draft of Agile central help topic
		// with video
		userLogin.login(DataProviderClass.getAllAuthorUserDetails().getUser(),
				DataProviderClass.getAllAuthorUserDetails().getPw());
		extentLogger.log(LogStatus.INFO, "Logged in as All Authors user");
		ArticleData articleData = DataProviderClass.getArticleData(9);
		extentLogger.log(LogStatus.INFO, "Adding an article:" + articleData.getTitle());
		mainPage.clickContent();
		contentPage.addArticle(articleData);
		contentPage.saveArticleAsDraft();
		// Verify that the article is created as a draft
		extentLogger.log(LogStatus.INFO, "Verifying whether the article is created as a draft");
		verify.assertTrue(internalUsersHomePage.isArticleCreatedMessageDisplayed(articleData.getTitle()),
				"Article creation message should be displayed as expected.");
		if (internalUsersHomePage.isArticleCreatedMessageDisplayed(articleData.getTitle())) {
			extentLogger.log(LogStatus.PASS, "Verified that Article creation message is displayed successfuly.");
		} else {
			extentLogger.log(LogStatus.FAIL, "Verified that Article creation message is Not displayed.");
		}

		internalUsersHomePage.logOutAndCleanCookies(userLogin);
		// login as doc admin user and publish the article
		userLogin.login(DataProviderClass.getDocAdminUserDetails().getUser(),
				DataProviderClass.getDocAdminUserDetails().getPw());
		extentLogger.log(LogStatus.INFO, "logged out from All Author and logged in as doc admin user");

		// access the article using url alias and publishing this article.
		extentLogger.log(LogStatus.INFO, "Accessing the article using url alias and publishing this article.");
		driver.navigate().to(configReader.getDrupalURL() + articleData.getUrlAlias());
		internalUsersHomePage.editDraftArticle();
		contentPage.saveAndPublishForThisTranslation();
		mainPage.clickContent();

		// Verifying whether article is published.
		verify.assertTrue(contentPage.isArticlePublished(articleData.getTitle()),
				"Article's moderation state should be 'Published'");
		if (contentPage.isArticlePublished(articleData.getTitle())) {
			extentLogger.log(LogStatus.PASS, "Verified that Article is 'Published' by Doc Admin.");
		} else {
			extentLogger.log(LogStatus.FAIL, "Verified that Article is not 'Published' by Doc Admin.");
		}

		/*
		 * Logout and login as customer and verify if the article is accessible
		 */
		internalUsersHomePage.logOutAndCleanCookies(userLogin);
		extentLogger.log(LogStatus.INFO, "Logout from doc admin and access the article as customere user");
		userLogin.login(DataProviderClass.getCustomerUserDetails().getUser(),
				DataProviderClass.getCustomerUserDetails().getPw());
		internalUsersHomePage.accessArticleWithUrlAlias(articleData.getUrlAlias());

		// Verify whether page title contains the article title.
		verify.assertTrue(driver.getTitle().contains(articleData.getTitle()),
				"page title should contain the article title");
		if (driver.getTitle().contains(articleData.getTitle())) {
			extentLogger.log(LogStatus.PASS, "Verified that article is accessed by URL alias");
		} else {
			extentLogger.log(LogStatus.FAIL, "Verified that article could not accessed by URL alias");
		}

		// Verify that the article has the attachment not displayed
		extentLogger.log(LogStatus.INFO, "Verifying whether attached Image is displayed on the view page of article.");
		verify.assertTrue(driver
				.findElements(By.xpath(
						"//*[@id='page-content']//a[contains(text(), '" + articleData.getAttachmentPath() + "')]"))
				.size() == 0, "Attachement should not be displayed on the view page of article.");
		if (driver
				.findElements(By.xpath(
						"//*[@id='page-content']//a[contains(text(), '" + articleData.getAttachmentPath() + "')]"))
				.size() == 0) {
			extentLogger.log(LogStatus.PASS,
					"Verified that attachement is not displayed on the article page successfully.");
		} else {
			extentLogger.log(LogStatus.FAIL, "Verified that attachement is displayed on the article page.");
		}

		verify.assertAll();
		extent.endTest(extentLogger);
	}

	/**
	 * Test Case : Test Moving an Published Article to Draft and verify the View
	 * 
	 * @throws Exception
	 */
	@Test(groups = { "TC101200" }, priority = 8)
	public void TC101200_movePublishedArticleToDraft() throws Exception {
		SoftAssert verify = new SoftAssert();
		logger.info("TC101200_movePublishedArticleToDraft Test started");
		extentLogger = extent.startTest("TC101200 Move Published Article To Draft and validate ");
		extentLogger.log(LogStatus.INFO, "TC101200 movePublishedArticleToDraft Test has started");
		// login as doc admin user, create an Agile central help topic and
		// publish
		userLogin.login(DataProviderClass.getDocAdminUserDetails().getUser(),
				DataProviderClass.getDocAdminUserDetails().getPw());
		extentLogger.log(LogStatus.INFO, "logged in as doc admin user");

		ArticleData articleData = DataProviderClass.getArticleData(10);
		extentLogger.log(LogStatus.INFO, "Adding an article:" + articleData.getTitle());
		mainPage.clickContent();
		contentPage.addArticle(articleData);
		contentPage.saveAndPublish();
		// Verify that the article is created
		extentLogger.log(LogStatus.INFO, "Verifying whether the article is created.");
		verify.assertTrue(internalUsersHomePage.isArticleCreatedMessageDisplayed(articleData.getTitle()),
				"Article creation message should be displayed as expected.");
		if (internalUsersHomePage.isArticleCreatedMessageDisplayed(articleData.getTitle())) {
			extentLogger.log(LogStatus.PASS, "Verified that Article creation message is displayed successfuly.");
		} else {
			extentLogger.log(LogStatus.FAIL, "Verified that Article creation message is Not displayed.");
		}

		// access the article using url alias and assert that the page title
		// contains the article title
		driver.navigate().to(configReader.getDrupalURL() + articleData.getUrlAlias());
		extentLogger.log(LogStatus.INFO, "Article is accessed through URL");
		// Edit article
		internalUsersHomePage.editPublishedArticle();

		articleData.setBody(DataProviderClass.getArticleData(9).getBody());
		contentPage.enterArticleBody(articleData);
		extentLogger.log(LogStatus.INFO, "Editing the published article and adding text to its body");
		contentPage.saveArticleAsDraftForThisTranslation();
		extentLogger.log(LogStatus.INFO,
				"Article has been revised (Added body content) by the doc admin user and saved as draft");

		String articleBodyContentLocater = "//*[@id='page-content']//p[contains(text(), '" + articleData.getBody()
				+ "')]";

		// Verify that the article view page should not have the drafted change
		// since its still unpublished
		extentLogger.log(LogStatus.INFO,
				"Verifying that the article view page should not have the drafted change since its still unpublished");
		verify.assertTrue(driver.findElements(By.xpath(articleBodyContentLocater)).size() == 0,
				"Article view page shouldn't have the drafted change since it is still unpublished.");
		if (driver.findElements(By.xpath(articleBodyContentLocater)).size() == 0) {
			extentLogger.log(LogStatus.PASS,
					"Verified that article view page does not have the drafted change since its still unpublished.");
		} else {
			extentLogger.log(LogStatus.FAIL, "Article view page has the drafted change.");
		}

		/* Verify that the last revision tab is now visible and is active */
		extentLogger.log(LogStatus.INFO, "Verify that the latest version tab is now visible and is active");
		verify.assertTrue(contentPage.isLatestRevisionTabVisible(), "latest version tab should be visible");
		if (contentPage.isLatestRevisionTabVisible()) {
			extentLogger.log(LogStatus.PASS, "Latest version tab is visible");
		} else {
			extentLogger.log(LogStatus.FAIL, "Latest version tab is not be visible");
		}

		internalUsersHomePage.goToLatestVersionTab();

		// Verify that the latest revision has the change made above
		extentLogger.log(LogStatus.INFO, "Verifying that the latest revision has the change made above");
		verify.assertTrue(driver.findElements(By.xpath(articleBodyContentLocater)).size() != 0,
				"The latest revision should have the change made above");
		if (driver.findElements(By.xpath(articleBodyContentLocater)).size() != 0) {
			extentLogger.log(LogStatus.PASS, "Verified that the latest revision has the change made above");
		} else {
			extentLogger.log(LogStatus.FAIL, "The latest revision does not have the change made above");
		}

		// Edit the article and publish the translation
		extentLogger.log(LogStatus.INFO, "Editig the article and publishing the translation");
		internalUsersHomePage.editDraftArticle();
		contentPage.saveAndPublishForThisTranslation();
		extentLogger.log(LogStatus.INFO, "Edited article and published");

		// Verify that the revised content is now available in article view
		extentLogger.log(LogStatus.INFO, "Verifying that the revised content is now available in article view");
		verify.assertTrue(driver.findElements(By.xpath(articleBodyContentLocater)).size() != 0,
				"The revised content should now be available in article view");
		if (driver.findElements(By.xpath(articleBodyContentLocater)).size() != 0) {
			extentLogger.log(LogStatus.PASS, "Verified that The revised content is now available in article view");
		} else {
			extentLogger.log(LogStatus.FAIL, "The revised content is not available in article view");
		}

		verify.assertAll();
		extent.endTest(extentLogger);
	}

	/**
	 * Test Case : Delete an Article and re-use same Article Alias Value for
	 * another Article
	 * 
	 * @throws Exception
	 */
	@Test(groups = { "TC101186" }, priority = 9)
	public void TC101186_deleteArticleAndReuseArticleAlias() throws Exception {
		SoftAssert verify = new SoftAssert();
		logger.info("TC101186_deleteArticleAndReuseArticleAlias Test started");
		extentLogger = extent
				.startTest("TC101186 Delete an Article and re-use same Article Alias Value for another Article");
		extentLogger.log(LogStatus.INFO, "TC101186 deleteArticleAndReuseArticleAlias Test has started");

		// Logging in as DocADmin User
		userLogin.login(DataProviderClass.getDocAdminUserDetails().getUser(),
				DataProviderClass.getDocAdminUserDetails().getPw());
		extentLogger.log(LogStatus.INFO, "Logged in as doc admin user");

		ArticleData articleData = DataProviderClass.getArticleData(11);
		extentLogger.log(LogStatus.INFO, "Adding an article:" + articleData.getTitle());
		mainPage.clickContent();
		contentPage.addArticle(articleData);
		contentPage.saveAndPublish();

		// Verify that the article is created
		extentLogger.log(LogStatus.INFO, "Verifying whether the article is created.");
		verify.assertTrue(internalUsersHomePage.isArticleCreatedMessageDisplayed(articleData.getTitle()),
				"Article creation message should be displayed as expected.");
		if (internalUsersHomePage.isArticleCreatedMessageDisplayed(articleData.getTitle())) {
			extentLogger.log(LogStatus.PASS, "Verified that Article creation message is displayed successfuly.");
		} else {
			extentLogger.log(LogStatus.FAIL, "Article creation message is Not displayed.");
		}

		// Delete the article
		extentLogger.log(LogStatus.INFO, "Deleting the created article");
		internalUsersHomePage.deleteArticle();
		verify.assertTrue(internalUsersHomePage.isArticleDeletedMessageDisplayed(articleData.getTitle()),
				"Article should be deleted by the doc admin user");
		if (internalUsersHomePage.isArticleDeletedMessageDisplayed(articleData.getTitle())) {
			extentLogger.log(LogStatus.PASS, "Verified that Article has been deleted by the doc admin user.");
		} else {
			extentLogger.log(LogStatus.FAIL, "Article has not been deleted by the doc admin user.");
		}
		/* Create a new article with the same article alias */
		extentLogger.log(LogStatus.INFO, "Creating a new article with the same article alias");
		mainPage.clickContent();
		contentPage.addArticle(articleData);
		contentPage.saveAndPublish();

		// Verify that the article is created with out any error
		extentLogger.log(LogStatus.INFO, "Verifying that the article is created with out any error");
		verify.assertTrue(internalUsersHomePage.isArticleCreatedMessageDisplayed(articleData.getTitle()),
				"Article creation message should be displayed while used deleted article's URL alias.");
		if (internalUsersHomePage.isArticleCreatedMessageDisplayed(articleData.getTitle())) {
			extentLogger.log(LogStatus.PASS,
					"Verified that Article creation message is displayed successfuly while used deleted article's URL alias.");
		} else {
			extentLogger.log(LogStatus.FAIL,
					"Article creation message is Not displayed while used deleted article's URL alias.");
		}

		verify.assertAll();
		extent.endTest(extentLogger);
	}

	/**
	 * Test Case : Delete an Article and re-use same Article Alias Value for
	 * another Article
	 * 
	 * @throws Exception
	 */
	@Test(groups = { "TC92483" }, priority = 10)
	public void TC92483_validateArticleCreationWithDuplicateAlias() throws Exception {
		SoftAssert verify = new SoftAssert();
		logger.info("TC92483_validateArticleCreationWithDuplicateAlias Test started");
		extentLogger = extent.startTest("TC92483 Validate Article Creation With duplicate alias");
		extentLogger.log(LogStatus.INFO, "TC92483 validateArticleCreationWithDuplicateAlias Test has started");

		// Logging in as Doc Admin
		userLogin.login(DataProviderClass.getDocAdminUserDetails().getUser(),
				DataProviderClass.getDocAdminUserDetails().getPw());
		extentLogger.log(LogStatus.INFO, "Logged in as doc admin user");

		ArticleData articleData = DataProviderClass.getArticleData(12);
		extentLogger.log(LogStatus.INFO, "Adding an article:" + articleData.getTitle());
		mainPage.clickContent();
		contentPage.addArticle(articleData);
		contentPage.saveAndPublish();

		// Verify that the article is created
		extentLogger.log(LogStatus.INFO, "Verifying whether the article is created.");
		verify.assertTrue(internalUsersHomePage.isArticleCreatedMessageDisplayed(articleData.getTitle()),
				"Article creation message should be displayed as expected.");
		if (internalUsersHomePage.isArticleCreatedMessageDisplayed(articleData.getTitle())) {
			extentLogger.log(LogStatus.PASS, "Verified that Article creation message is displayed successfuly.");
		} else {
			extentLogger.log(LogStatus.FAIL, "Verified that Article creation message is Not displayed.");
		}

		/* Create a new article with the same article alias */
		extentLogger.log(LogStatus.INFO, "Creating a new article with the same article alias.");
		mainPage.clickContent();
		contentPage.addArticle(articleData);
		contentPage.saveAndPublish();

		// Verify that the error message is displayed in the article creation
		// page
		extentLogger.log(LogStatus.INFO, "Verifying that the  error message is displayed in the article creation page");
		verify.assertTrue(internalUsersHomePage.isArticleAliasInUseErrorMessageDisplayed(),
				"Error message as 'same article alias in use' should be displayed.");
		if (internalUsersHomePage.isArticleAliasInUseErrorMessageDisplayed()) {
			extentLogger.log(LogStatus.PASS, "Verified that error message is displayed successfuly.");
		} else {
			extentLogger.log(LogStatus.FAIL, "Error message is Not displayed.");
		}

		verify.assertAll();
		extent.endTest(extentLogger);
	}

	/**
	 * Test Case : Change the parent article and validate the positioning of the
	 * child article in TOC
	 * 
	 * @throws Exception
	 */
	@Test(groups = { "TC92465", "TC92470" }, priority = 11)
	public void TC92465_TC92470_changeParentArticleTest() throws Exception {
		SoftAssert verify = new SoftAssert();
		logger.info("TC92465_TC92470_changeParentArticleTest Test started");
		extentLogger = extent.startTest("TC92465_TC92470_Validate the change of parent article");
		extentLogger.log(LogStatus.INFO, "TC92465,TC92470 changeParentArticleTest Test has started");

		userLogin.login(DataProviderClass.getDocAdminUserDetails().getUser(),
				DataProviderClass.getDocAdminUserDetails().getPw());
		extentLogger.log(LogStatus.INFO, "Logged in as doc admin user");

		// Create articles
		ArticleData parentArticle = DataProviderClass.getArticleData(13);
		ArticleData childArticle1 = DataProviderClass.getArticleData(14);
		ArticleData childArticle2 = DataProviderClass.getArticleData(15);

		for (int i = 13; i <= 15; i++) {
			ArticleData articleData = DataProviderClass.getArticleData(i);
			extentLogger.log(LogStatus.INFO, "Adding an article:" + articleData.getTitle());
			mainPage.clickContent();
			contentPage.addArticle(articleData);
			contentPage.saveAndPublish();

			// Verify that the article is created
			verify.assertTrue(internalUsersHomePage.isArticleCreatedMessageDisplayed(articleData.getTitle()),
					"Article creation message should be displayed as expected.");
			if (internalUsersHomePage.isArticleCreatedMessageDisplayed(articleData.getTitle())) {
				extentLogger.log(LogStatus.PASS, "Verified that Article creation message is displayed successfuly.");
			} else {
				extentLogger.log(LogStatus.FAIL, "Verified that Article creation message is Not displayed.");
			}
		}
		String articleHierarchyLocatorForChild = "//*[@id='toc_menu']//a[@title='" + parentArticle.getTitle()
				+ "']/following-sibling::ul/li[2]/a[text()='" + childArticle2.getTitle() + "']";
		// Verify the hierarchy of the articles
		extentLogger.log(LogStatus.INFO, "Verifying the hierarchy of the articles added.");
		verify.assertTrue(driver.findElements(By.xpath(articleHierarchyLocatorForChild)).size() != 0,
				"Added articles should be in the correct heirarchy as parent->child1->child2");
		if (driver.findElements(By.xpath(articleHierarchyLocatorForChild)).size() != 0) {
			extentLogger.log(LogStatus.PASS, "Verified that added articles are in the correct heirarchy successfuly.");
		} else {
			extentLogger.log(LogStatus.FAIL, "Added articles are not in the correct heirarchy");
		}

		extentLogger.log(LogStatus.INFO,
				"Editing the child2 article and changing its parent article as child1 article.");
		internalUsersHomePage.editPublishedArticle();
		// Alter the hierarhcy
		contentPage.selectMenuParentItem("---- " + childArticle1.getTitle());
		contentPage.saveAndPublishForThisTranslation();
		// Verify the hierarchy of the articles after the change
		articleHierarchyLocatorForChild = "//*[@id='toc_menu']//a[@title='" + parentArticle.getTitle()
				+ "']/following-sibling::ul/li/a[text()='" + childArticle1.getTitle()
				+ "']/following-sibling::ul/li/a[text()='" + childArticle2.getTitle() + "']";

		extentLogger.log(LogStatus.INFO, "Verifying the hierarchy of the article of child2 article");
		verify.assertTrue(driver.findElements(By.xpath(articleHierarchyLocatorForChild)).size() != 0,
				"Added articles should be in the correct heirarchy as parent->child1->child2");
		if (driver.findElements(By.xpath(articleHierarchyLocatorForChild)).size() != 0) {
			extentLogger.log(LogStatus.PASS, "Verified that added articles are in the correct heirarchy successfuly.");
		} else {
			extentLogger.log(LogStatus.FAIL, "Added articles are not in the correct heirarchy");
		}

		verify.assertAll();
		extent.endTest(extentLogger);
	}

	/**
	 * Test Case : Delete the parent article and validate the positioning of the
	 * child article in TOC
	 * 
	 * @throws Exception
	 */
	@Test(groups = { "TC92466" }, priority = 12)
	public void TC92466_deleteParentArticleTest() throws Exception {
		SoftAssert verify = new SoftAssert();
		logger.info("TC92466_deleteParentArticleTest Test started");
		extentLogger = extent.startTest("Validate child article hierarchy when parent article is deleted");
		extentLogger.log(LogStatus.INFO, "TC92466 deleteParentArticleTest Test has started");
		// Logging in as Doc Admin
		userLogin.login(DataProviderClass.getDocAdminUserDetails().getUser(),
				DataProviderClass.getDocAdminUserDetails().getPw());
		extentLogger.log(LogStatus.INFO, "Logged in as Doc Admin");

		// Create articles
		ArticleData parentArticle = DataProviderClass.getArticleData(16);
		ArticleData childArticle = DataProviderClass.getArticleData(17);
		for (int i = 16; i <= 17; i++) {
			ArticleData articleData = DataProviderClass.getArticleData(i);
			extentLogger.log(LogStatus.INFO, "Adding an article:" + articleData.getTitle());
			mainPage.clickContent();
			contentPage.addArticle(articleData);
			contentPage.saveAndPublish();
			// Verify that the article is created
			verify.assertTrue(internalUsersHomePage.isArticleCreatedMessageDisplayed(articleData.getTitle()),
					"Article creation message should be displayed as expected.");
			if (internalUsersHomePage.isArticleCreatedMessageDisplayed(articleData.getTitle())) {
				extentLogger.log(LogStatus.PASS, "Verified that Article creation message is displayed successfuly.");
			} else {
				extentLogger.log(LogStatus.FAIL, "Article creation message is Not displayed.");
			}
		}

		String articleHierarchyLocatorForChild = "//*[@id='toc_menu']//a[@title='" + parentArticle.getTitle()
				+ "']/following-sibling::ul/li/a[text()='" + childArticle.getTitle() + "']";
		// Verify the hierarchy of the articles
		extentLogger.log(LogStatus.INFO, "Verifying the hierarchy of the article of child article");
		verify.assertTrue(driver.findElements(By.xpath(articleHierarchyLocatorForChild)).size() != 0,
				"Added articles should be in the correct heirarchy as parent->child1->child2");
		if (driver.findElements(By.xpath(articleHierarchyLocatorForChild)).size() != 0) {
			extentLogger.log(LogStatus.PASS, "Verified that added articles are in the correct heirarchy successfuly.");
		} else {
			extentLogger.log(LogStatus.FAIL, "Added articles are not in the correct heirarchy");
		}

		// Delete the parent article
		extentLogger.log(LogStatus.INFO, "Deleting the parent article");
		mainPage.clickContent();
		contentPage.deleteArticle(parentArticle.getTitle());
		// Verify the hierarchy of the articles after the parent article is
		// deleted
		extentLogger.log(LogStatus.INFO, "Verify the hierarchy of the articles after the parent article is deleted");
		internalUsersHomePage.accessArticleWithUrlAlias((childArticle.getUrlAlias()));
		articleHierarchyLocatorForChild = ".//*[@id='toc_menu']/ul/li/a[@title='" + childArticle.getTitle() + "']";

		verify.assertTrue(driver.findElements(By.xpath(articleHierarchyLocatorForChild)).size() != 0,
				"Hierarchy of the articles after the parent article is deleted should be correct");
		if (driver.findElements(By.xpath(articleHierarchyLocatorForChild)).size() != 0) {
			extentLogger.log(LogStatus.PASS,
					"Verified that Hierarchy of the articles after the parent article deleted is correct");
		} else {
			extentLogger.log(LogStatus.FAIL,
					"Hierarchy of the articles after the parent article deleted is not correct");
		}

		// Verify that the article should have only home in the breadcrumbs
		extentLogger.log(LogStatus.INFO, "Verify that the article should have only home in the breadcrumbs");
		verify.assertTrue(internalUsersHomePage.getBreadCrumCount() == 1, "Article should have only 1 breadcrumb.");
		if (internalUsersHomePage.getBreadCrumCount() == 1) {
			extentLogger.log(LogStatus.PASS, "Verified that breadcrumbs counts is equal to 1.");
		} else {
			extentLogger.log(LogStatus.FAIL, "Breadcrumb count is more than 1 which is not expected.");
		}

		// Verify that the article should Home as the breadcrumb
		extentLogger.log(LogStatus.INFO, "Verify that the article should Home as the breadcrumb");
		verify.assertTrue(internalUsersHomePage.getBreadCrumCount() == 1,
				"Article page should have only home as the breadcrumbs");
		if (internalUsersHomePage.getBreadCrumCount() == 1) {
			extentLogger.log(LogStatus.PASS, "Verified that Article has Home in the breadcrumbs");
		} else {
			extentLogger.log(LogStatus.FAIL, "Home is not availbale in the breadcrumbs.");
		}

		verify.assertAll();
		extent.endTest(extentLogger);
	}

	/**
	 * Test Case : Delete a child article and verify that its deleted from toc
	 * 
	 * @throws Exception
	 */
	@Test(groups = { "TC92467" }, priority = 13)
	public void TC92467_deleteChildArticleTest() throws Exception {
		SoftAssert verify = new SoftAssert();
		logger.debug("TC92467_deleteChildArticleTest Test started");
		extentLogger = extent.startTest("TC92467_Validate child article deletion from TOC");
		extentLogger.log(LogStatus.INFO, "TC92467_deleteChildArticleTest Test has started");
		// Logging in as Doc Admin
		userLogin.login(DataProviderClass.getDocAdminUserDetails().getUser(),
				DataProviderClass.getDocAdminUserDetails().getPw());
		extentLogger.log(LogStatus.INFO, "Logged in as Doc Admin");
		// Create articles
		ArticleData parentArticle = DataProviderClass.getArticleData(18);
		ArticleData childArticle = DataProviderClass.getArticleData(19);
		for (int i = 18; i <= 19; i++) {
			ArticleData articleData = DataProviderClass.getArticleData(i);
			extentLogger.log(LogStatus.INFO, "Adding an article:" + articleData.getTitle());
			mainPage.clickContent();
			contentPage.addArticle(articleData);
			contentPage.saveAndPublish();
			// Verify that the article is created
			verify.assertTrue(internalUsersHomePage.isArticleCreatedMessageDisplayed(articleData.getTitle()),
					"Article creation message should be displayed as expected.");
			if (internalUsersHomePage.isArticleCreatedMessageDisplayed(articleData.getTitle())) {
				extentLogger.log(LogStatus.PASS, "Verified that Article creation message is displayed successfuly.");
			} else {
				extentLogger.log(LogStatus.FAIL, "Article creation message is Not displayed.");
			}
		}

		String articleHierarchyLocatorForChild = "//*[@id='toc_menu']//a[@title='" + parentArticle.getTitle()
				+ "']/following-sibling::ul/li/a[text()='" + childArticle.getTitle() + "']";
		// Verify the hierarchy of the articles
		extentLogger.log(LogStatus.INFO, "Verifying the hierarchy of the articles added.");
		verify.assertTrue(driver.findElements(By.xpath(articleHierarchyLocatorForChild)).size() != 0,
				"Added articles should be in the correct heirarchy as parent->child");
		if (driver.findElements(By.xpath(articleHierarchyLocatorForChild)).size() != 0) {
			extentLogger.log(LogStatus.PASS, "Verified that added articles are in the correct heirarchy successfuly.");
		} else {
			extentLogger.log(LogStatus.FAIL, "Added articles are not in the correct heirarchy");
		}

		extentLogger.log(LogStatus.INFO, "Deleting the child article");
		// Delete the child article
		mainPage.clickContent();
		contentPage.deleteArticle(childArticle.getTitle());
		// Verify the if the deleted child article is still present in TOC
		driver.navigate().to(configReader.getAgileCentralHome());

		extentLogger.log(LogStatus.INFO, "Verifying the if the deleted child article is still present in TOC");
		verify.assertTrue(driver.findElements(By.xpath(articleHierarchyLocatorForChild)).size() == 0,
				"Deleted child article should not be present in TOC");
		if (driver.findElements(By.xpath(articleHierarchyLocatorForChild)).size() == 0) {
			extentLogger.log(LogStatus.PASS, "Verified that Deleted child article is not available in TOC.");
		} else {
			extentLogger.log(LogStatus.FAIL, "Deleted child article is still available in TOC.");
		}

		verify.assertAll();
		extent.endTest(extentLogger);
	}

	/**
	 * Test Case : Upload an unsupported video and assert the error
	 * 
	 * @throws Exception
	 */
	@Test(groups = { "TC92482" }, priority = 14)
	public void TC92482_validateUnsupportedUploadsTest() throws Exception {
		SoftAssert verify = new SoftAssert();
		logger.info("TC92482_validateUnsupportedUploadsTest Test started");
		extentLogger = extent.startTest("TC92482_Validate uploading of unsupported video formats");
		extentLogger.log(LogStatus.INFO, "TC92482 validateUnsupportedUploadsTest Test has started");
		// Logging in as Doc Admin
		userLogin.login(DataProviderClass.getDocAdminUserDetails().getUser(),
				DataProviderClass.getDocAdminUserDetails().getPw());
		extentLogger.log(LogStatus.INFO, "Logged in as Doc Admin");
		// Create articles
		ArticleData articleData = DataProviderClass.getArticleData(20);
		extentLogger.log(LogStatus.INFO, "Adding an article:" + articleData.getTitle());
		mainPage.clickContent();
		contentPage.selectContentType(articleData);
		contentPage.enterArticleTitle(articleData.getTitle());
		contentPage.uploadVideo(articleData);
		// Verify that the appropriate error is thrown for the unsupported video
		// format
		extentLogger.log(LogStatus.INFO,
				"Verify that the appropriate error is thrown for the unsupported video format");
		verify.assertTrue(contentPage.isVideoUploadErrorPresent(articleData.getTitle()),
				"Appropriate error is not thrown for the unsupported video format");
		if (contentPage.isVideoUploadErrorPresent(articleData.getTitle())) {
			extentLogger.log(LogStatus.PASS,
					"Verified that Appropriate error is thrown for the unsupported video format");
		} else {
			extentLogger.log(LogStatus.FAIL, "Appropriate error is not thrown for the unsupported video format");
		}

		verify.assertAll();
		extent.endTest(extentLogger);
	}

	/**
	 * Test Case : Change the article alias, verify that the article is
	 * redirected to new alias when accessed with the old one
	 * 
	 * @throws Exception
	 */
	@Test(groups = { "TC92474" }, priority = 15)
	public void TC92474_validateAccessArticleWithOldAlias() throws Exception {
		SoftAssert verify = new SoftAssert();
		logger.info("TC92474_validateAccessArticleWithOldAlias Test started");
		extentLogger = extent.startTest("TC92474_Access an article after changing the URL Alias");
		extentLogger.log(LogStatus.INFO, "TC92474 validateAccessArticleWithOldAlias Test has started");

		// Logging in as Doc Admin
		userLogin.login(DataProviderClass.getDocAdminUserDetails().getUser(),
				DataProviderClass.getDocAdminUserDetails().getPw());
		extentLogger.log(LogStatus.INFO, "Logged in as Doc Admin");

		// Create articles
		ArticleData articleData = DataProviderClass.getArticleData(21);
		extentLogger.log(LogStatus.INFO, "Adding an article:" + articleData.getTitle());
		mainPage.clickContent();
		contentPage.addArticle(articleData);
		contentPage.saveAndPublish();
		// Verify that the article is created
		extentLogger.log(LogStatus.INFO, "Verifying whether the article is created.");
		verify.assertTrue(internalUsersHomePage.isArticleCreatedMessageDisplayed(articleData.getTitle()),
				"Article creation message should be displayed as expected.");
		if (internalUsersHomePage.isArticleCreatedMessageDisplayed(articleData.getTitle())) {
			extentLogger.log(LogStatus.PASS, "Verified that Article creation message is displayed successfuly.");
		} else {
			extentLogger.log(LogStatus.FAIL, "Verified that Article creation message is Not displayed.");
		}

		extentLogger.log(LogStatus.INFO,
				"Editing article and modifying the article alias as: " + articleData.getUrlAlias() + "-modified");
		// Edit article and modify the article alias
		internalUsersHomePage.editPublishedArticle();
		// Modify the url alias
		contentPage.configureUrlPathSettings(articleData.getUrlAlias() + "-modified");
		contentPage.saveAndReadyToPublishForThisTranslation();
		internalUsersHomePage.accessArticleWithUrlAlias(articleData.getUrlAlias());
		// Verify that the user is redirected to the new url alias
		Assert.assertTrue(driver.getTitle().contains(articleData.getTitle()));

		// Assert.assertTrue(driver.getCurrentUrl().contains(articleData.getUrlAlias()+"-modified"));

		extentLogger.log(LogStatus.INFO, "Verifying whether user is redirected to the new url alias");
		verify.assertTrue(driver.getCurrentUrl().contains(articleData.getUrlAlias() + "-modified"),
				"user is not redirected to the new url alias");
		if (driver.getCurrentUrl().contains(articleData.getUrlAlias() + "-modified")) {
			extentLogger.log(LogStatus.PASS,
					"Verified that user is redirected to the new url alias as: " + driver.getCurrentUrl());
		} else {
			extentLogger.log(LogStatus.FAIL,
					"User is not redirected to the new url alias and redirected to: " + driver.getCurrentUrl());
		}

		verify.assertAll();
		extent.endTest(extentLogger);
	}

	/**
	 * Test Case : Verify that a link to external site can be clicked from the
	 * article body
	 * 
	 * @throws Exception
	 */
	@Test(groups = { "TC92472" }, enabled = true, priority = 16)
	public void TC92472_accessExternalLinkFromTheArticle() throws Exception {
		SoftAssert verify = new SoftAssert();
		logger.info("TC92472_accessExternalLinkFromTheArticle Test started");
		extentLogger = extent.startTest("TC92472_Test accessing external Link from the article");
		extentLogger.log(LogStatus.INFO, "TC92472 accessExternalLinkFromTheArticle Test has started");

		// Logging in as Doc Admin
		userLogin.login(DataProviderClass.getDocAdminUserDetails().getUser(),
				DataProviderClass.getDocAdminUserDetails().getPw());
		extentLogger.log(LogStatus.INFO, "Logged in as Doc Admin");

		// Create articles
		ArticleData articleData = DataProviderClass.getArticleData(22);
		extentLogger.log(LogStatus.INFO, "Adding an article:" + articleData.getTitle());
		mainPage.clickContent();
		contentPage.selectContentType(articleData);
		contentPage.enterArticleTitle(articleData.getTitle());
		Thread.sleep(1000);
		contentPage.enterLinkInTheBody(articleData.getBody());
		contentPage.saveAndPublish();
		// Verify that the article is created

		extentLogger.log(LogStatus.INFO, "Verifying whether the article is created.");
		verify.assertTrue(internalUsersHomePage.isArticleCreatedMessageDisplayed(articleData.getTitle()),
				"Article creation message should be displayed as expected.");
		if (internalUsersHomePage.isArticleCreatedMessageDisplayed(articleData.getTitle())) {
			extentLogger.log(LogStatus.PASS, "Verified that Article creation message is displayed successfuly.");
		} else {
			extentLogger.log(LogStatus.FAIL, "Verified that Article creation message is Not displayed.");
		}

		// Verify that the user is able to click and get redirected on the body
		// field link
		extentLogger.log(LogStatus.INFO, "Verifying whether the link is displayed");
		verify.assertTrue(internalUsersHomePage.isArticleCreatedMessageDisplayed(articleData.getTitle()),
				"The link is not displayed");
		if (internalUsersHomePage.isArticleCreatedMessageDisplayed(articleData.getTitle())) {
			extentLogger.log(LogStatus.PASS, "Verified that the link is displayed");
		} else {
			extentLogger.log(LogStatus.FAIL, "The link is not displayed");
		}

		extentLogger.log(LogStatus.INFO, "Clicking on the link on in the article body.");
		internalUsersHomePage.clickLinkInArticleBody(articleData.getBody());

		extentLogger.log(LogStatus.INFO,
				"Verifying whether the link is accessed from the article body after clicking on the link.");
		verify.assertTrue(driver.getCurrentUrl().contains(articleData.getBody()),
				"link is not accessed from the article body");
		if (driver.getCurrentUrl().contains(articleData.getBody())) {
			extentLogger.log(LogStatus.PASS, "Verified that link is accessed from the article body");
		} else {
			extentLogger.log(LogStatus.FAIL, "The link is not accessed from the article body");
		}

		verify.assertAll();
		extent.endTest(extentLogger);
	}

	/**
	 * Test Case : Verify that a link to another article can be clicked from the
	 * article body
	 * 
	 * @throws Exception
	 */
	@Test(groups = { "TC92471" }, enabled = true, priority = 17)
	public void TC92471_accessAnotherArticleFromArticleBody() throws Exception {
		SoftAssert verify = new SoftAssert();
		logger.info("TC92471_accessAnotherArticleFromArticleBody Test started");
		extentLogger = extent.startTest("Test accessing another article Link from the article body");
		extentLogger.log(LogStatus.INFO, "TC92471 accessAnotherArticleFromArticleBody Test has started");

		// Logging in as Doc Admin
		userLogin.login(DataProviderClass.getDocAdminUserDetails().getUser(),
				DataProviderClass.getDocAdminUserDetails().getPw());
		extentLogger.log(LogStatus.INFO, "Logged in as Doc Admin");

		// Create articles
		ArticleData articleData1 = DataProviderClass.getArticleData(23);
		ArticleData articleData2 = DataProviderClass.getArticleData(24);
		mainPage.clickContent();
		contentPage.addArticle(articleData1);
		extentLogger.log(LogStatus.INFO, "Adding an article:" + articleData1.getTitle());
		contentPage.saveAndPublish();

		// Verify that the article is created
		extentLogger.log(LogStatus.INFO, "Verifying whether the article is created.");
		verify.assertTrue(internalUsersHomePage.isArticleCreatedMessageDisplayed(articleData1.getTitle()),
				"Article creation message should be displayed as expected.");
		if (internalUsersHomePage.isArticleCreatedMessageDisplayed(articleData1.getTitle())) {
			extentLogger.log(LogStatus.PASS, "Verified that Article creation message is displayed successfuly.");
		} else {
			extentLogger.log(LogStatus.FAIL, "Article creation message is Not displayed.");
		}

		mainPage.clickContent();
		extentLogger.log(LogStatus.INFO, "Adding another article:" + articleData2.getTitle());
		contentPage.selectContentType(articleData2);
		contentPage.enterArticleTitle(articleData2.getTitle());
		Thread.sleep(1000);
		String articleUrl = configReader.getDrupalBaseURL() + "/" + configReader.getLocale()
				+ articleData1.getUrlAlias();
		contentPage.enterLinkInTheBody(articleUrl);
		contentPage.saveAndPublish();

		// Verify that the article is created
		extentLogger.log(LogStatus.INFO, "Verifying whether the another article is created.");
		verify.assertTrue(internalUsersHomePage.isArticleCreatedMessageDisplayed(articleData2.getTitle()),
				"Article creation message should be displayed as expected.");
		if (internalUsersHomePage.isArticleCreatedMessageDisplayed(articleData2.getTitle())) {
			extentLogger.log(LogStatus.PASS, "Verified that Article creation message is displayed successfuly.");
		} else {
			extentLogger.log(LogStatus.FAIL, "Article creation message is Not displayed.");
		}

		// Verify that the user is able to click and get redirected on the body
		// field link
		extentLogger.log(LogStatus.INFO,
				"Verify that the user is able to click and get redirected on the body field link");

		extentLogger.log(LogStatus.INFO, "Verifying whether the link is displayed in the article body.");
		verify.assertTrue(internalUsersHomePage.isArticleLinkDisplayedInContentInfo(articleUrl),
				"The link is not displayed");
		if (internalUsersHomePage.isArticleLinkDisplayedInContentInfo(articleUrl)) {
			extentLogger.log(LogStatus.PASS, "Verified that the link is displayed");
		} else {
			extentLogger.log(LogStatus.FAIL, "The link is not displayed");
		}

		extentLogger.log(LogStatus.INFO, "Clickig on the link.");
		internalUsersHomePage.clickLinkInArticleBody(articleUrl);

		extentLogger.log(LogStatus.INFO,
				"Verifying whether the link is accessed from the article body after clicking on the link.");
		verify.assertTrue(driver.getCurrentUrl().contains(articleUrl), "link is not accessed from the article body");
		if (driver.getCurrentUrl().contains(articleUrl)) {
			extentLogger.log(LogStatus.PASS, "Verified that link is accessed from the article body");
		} else {
			extentLogger.log(LogStatus.FAIL, "The link is not accessed from the article body");
		}

		verify.assertAll();
		extent.endTest(extentLogger);
	}

	/**
	 * Test Case : verify the Headsup field and the text
	 * 
	 * @throws Exception
	 */
	@Test(groups = { "TC103561" }, priority = 18)
	public void TC103561_testHeadsUpBlock() throws Exception {
		SoftAssert verify = new SoftAssert();
		logger.info("TC103561_testHeadsUpBlock Test started");
		extentLogger = extent.startTest("TC103561 Test heads up block");
		extentLogger.log(LogStatus.INFO, "TC103561 testHeadsUpBlock Test has started");

		// login as doc admin user
		userLogin.login(DataProviderClass.getDocAdminUserDetails().getUser(),
				DataProviderClass.getDocAdminUserDetails().getPw());
		extentLogger.log(LogStatus.INFO, "Logged in as Doc Admin");

		ArticleData articleData = DataProviderClass.getArticleData(25);
		extentLogger.log(LogStatus.INFO, "Adding an article:" + articleData.getTitle());
		mainPage.clickContent();
		contentPage.addArticle(articleData);
		contentPage.saveAndPublish();
		// Verify that the article is created as a draft
		extentLogger.log(LogStatus.INFO, "Verifying whether the article is created.");
		verify.assertTrue(internalUsersHomePage.isArticleCreatedMessageDisplayed(articleData.getTitle()),
				"Article creation message should be displayed as expected.");
		if (internalUsersHomePage.isArticleCreatedMessageDisplayed(articleData.getTitle())) {
			extentLogger.log(LogStatus.PASS, "Verified that Article creation message is displayed successfuly.");
		} else {
			extentLogger.log(LogStatus.FAIL, "Article creation message is Not displayed.");
		}

		// access the article with Url alias and assert that the page title
		// contains the article title
		extentLogger.log(LogStatus.INFO, "accessing the article with Url alias");
		driver.navigate().to(configReader.getDrupalURL() + articleData.getUrlAlias());

		verify.assertTrue(driver.getTitle().contains(articleData.getTitle()),
				"Article is not accessed with URL Alias.");
		if (driver.getTitle().contains(articleData.getTitle())) {
			extentLogger.log(LogStatus.PASS, "Verified that article is accessed with URL alias.");
		} else {
			extentLogger.log(LogStatus.FAIL, "Article is not accessed with URL Alias.");
		}
		// Verifying whether the Headsup field is present.
		extentLogger.log(LogStatus.INFO, "Verifying whether the Headsup field is present.");
		verify.assertTrue(internalUsersHomePage.headsUpFieldPresentInArticleView(),
				"The Headsup field should be present in article view.");
		if (internalUsersHomePage.headsUpFieldPresentInArticleView()) {
			extentLogger.log(LogStatus.PASS, "Verified that The Headsup field is present in article view");
		} else {
			extentLogger.log(LogStatus.FAIL, "The Headsup field is not present in article view");
		}

		// Verifying whether the Headsup field is equal to what is provided.
		extentLogger.log(LogStatus.INFO, "Verifying whether the Headsup field is equal to what is provided.");
		verify.assertTrue(
				articleData.getHeadsUpFieldInCAAgileCentralHelpTopic().equals(internalUsersHomePage.getHeadUpText()),
				"The Headsup field should be equal to what is provided.");
		if (articleData.getHeadsUpFieldInCAAgileCentralHelpTopic().equals(internalUsersHomePage.getHeadUpText())) {
			extentLogger.log(LogStatus.PASS, "Verified that the Headsup field is equal to what is provided.");
		} else {
			extentLogger.log(LogStatus.FAIL, "The Headsup field is not equal to what is provided.");
		}

		verify.assertAll();
		extent.endTest(extentLogger);
	}

	/**
	 * Test Case : verify For developers field and the text
	 * 
	 * @throws Exception
	 */
	@Test(groups = { "TC103562" }, priority = 19)
	public void TC103562_testForDevelopersBlock() throws Exception {
		SoftAssert verify = new SoftAssert();
		logger.info("TC103562_testForDevelopersBlock Test started");
		extentLogger = extent.startTest("TC103562 Test For developers block");
		extentLogger.log(LogStatus.INFO, "TC103562 testForDevelopersBlock Test has started");

		// login as doc admin user
		userLogin.login(DataProviderClass.getDocAdminUserDetails().getUser(),
				DataProviderClass.getDocAdminUserDetails().getPw());
		extentLogger.log(LogStatus.INFO, "Logged in as Doc Admin");

		ArticleData articleData = DataProviderClass.getArticleData(25);
		extentLogger.log(LogStatus.INFO, "Adding an article:" + articleData.getTitle());
		mainPage.clickContent();
		contentPage.filterArticle(articleData.getTitle());

		if (!contentPage.isArticlePublished(articleData.getTitle())) {
			contentPage.addArticle(articleData);
			contentPage.saveAndPublish();
			// Verify that the article is created as a draft
			extentLogger.log(LogStatus.INFO, "Verifying whether the article is created.");
			verify.assertTrue(internalUsersHomePage.isArticleCreatedMessageDisplayed(articleData.getTitle()),
					"Article creation message should be displayed as expected.");
			if (internalUsersHomePage.isArticleCreatedMessageDisplayed(articleData.getTitle())) {
				extentLogger.log(LogStatus.PASS, "Verified that Article creation message is displayed successfuly.");
			} else {
				extentLogger.log(LogStatus.FAIL, "Article creation message is Not displayed.");
			}
		}

		// access the article with Url alias and assert that the page title
		// contains the article title
		extentLogger.log(LogStatus.INFO, "Accessing the article through URL.");
		driver.navigate().to(configReader.getDrupalURL() + articleData.getUrlAlias());

		extentLogger.log(LogStatus.INFO, "Verifying whether the article is accessible through URL");
		verify.assertTrue(driver.getTitle().contains(articleData.getTitle()),
				"Article could not be accessed through URL");
		if (driver.getTitle().contains(articleData.getTitle())) {
			extentLogger.log(LogStatus.PASS, "Verified that Article is accessible through URL");
		} else {
			extentLogger.log(LogStatus.FAIL, "Article is not accessible through URL");
		}

		// Verifying whether the ForDeveloper field is present.
		extentLogger.log(LogStatus.INFO, "Verifying whether the ForDeveloper field is present.");
		verify.assertTrue(internalUsersHomePage.forDevelopersFieldPresentInArticleView(),
				"The ForDeveloper field should be present in article view.");
		if (internalUsersHomePage.forDevelopersFieldPresentInArticleView()) {
			extentLogger.log(LogStatus.PASS, "Verified that The ForDeveloper field is present in article view");
		} else {
			extentLogger.log(LogStatus.FAIL, "The ForDeveloper field is not present in article view");
		}

		// Verifying whether the Headsup field is equal to what is provided.
		extentLogger.log(LogStatus.INFO, "Verifying whether the ForDeveloper field is equal to what is provided.");
		verify.assertTrue(
				articleData.getForDevelopersFieldInCAAgileCentralHelpTopic()
						.equals(internalUsersHomePage.getTextFromForDevelopersBlock()),
				"The ForDeveloper field should be equal to what is provided.");
		if (articleData.getForDevelopersFieldInCAAgileCentralHelpTopic()
				.equals(internalUsersHomePage.getTextFromForDevelopersBlock())) {
			extentLogger.log(LogStatus.PASS, "Verified that the ForDeveloper field is equal to what is provided.");
		} else {
			extentLogger.log(LogStatus.FAIL, "The ForDeveloper field is not equal to what is provided.");
		}

		verify.assertAll();
		extent.endTest(extentLogger);
	}

	@Test(groups = { "TC112962" }, priority = 20)
	public void TC112962_Test_Unpublish_Workflow_Of_Article() throws Exception {
		SoftAssert verify = new SoftAssert();
		logger.info("TC112962_Test_Unpublish_Workflow_Of_Article Test started");
		extentLogger = extent.startTest("TC112962 Test_Unpublish_Workflow_Of_Article");
		extentLogger.log(LogStatus.INFO, "TC112962 Test_Unpublish_Workflow_Of_Article has started");

		// login as doc admin user
		userLogin.login(DataProviderClass.getDocAdminUserDetails().getUser(),
				DataProviderClass.getDocAdminUserDetails().getPw());
		extentLogger.log(LogStatus.INFO, "Logged in as doc admin user");

		ArticleData articleData = DataProviderClass.getArticleData(45);
		extentLogger.log(LogStatus.INFO, "Adding an article:" + articleData.getTitle());
		mainPage.clickContent();
		contentPage.addArticle(articleData);
		contentPage.saveAndPublish();

		// Verify that the article's moderation state is 'Published'
		extentLogger.log(LogStatus.INFO, "Verifying whether the article's moderation state is 'Published'");
		mainPage.clickContent();
		verify.assertTrue(contentPage.isArticlePublished(articleData.getTitle()),
				"Article's moderation state should be 'Published'");
		if (contentPage.isArticlePublished(articleData.getTitle())) {
			extentLogger.log(LogStatus.PASS, "Verified that Article's moderation state is 'Published'");
		} else {
			extentLogger.log(LogStatus.FAIL, "Verified that Article's moderation is not 'Published'");
		}

		// Navigating to Published article
		internalUsersHomePage.accessArticleWithUrlAlias(articleData.getUrlAlias());
		// Editing the published article
		internalUsersHomePage.editPublishedArticle();
		contentPage.saveAndUnpublishForThisTranslation();
		// Verify that the article's moderation state is 'UnPublished'
		extentLogger.log(LogStatus.INFO, "Verifying whether the article's moderation state is 'UnPublished'");
		mainPage.clickContent();
		verify.assertTrue(contentPage.isArticleUnPublished(articleData.getTitle()),
				"Article's moderation state should be 'UnPublished'");
		if (contentPage.isArticleUnPublished(articleData.getTitle())) {
			extentLogger.log(LogStatus.PASS, "Verified that Article's moderation state is 'UnPublished'");
		} else {
			extentLogger.log(LogStatus.FAIL, "Verified that Article's moderation is not 'UnPublished'");
		}

		// logging out from Doc admin user and getting customer user control
		internalUsersHomePage.logOutAndCleanCookies(userLogin);
		userLogin.login(DataProviderClass.getCustomerUserDetails().getUser(),
				DataProviderClass.getCustomerUserDetails().getPw());
		extentLogger.log(LogStatus.INFO, "logged out from Doc admin user and logged in as customer user control.");

		// Verifying that Customer is not able to access the Unpublished
		// article.
		extentLogger.log(LogStatus.INFO, "Verifying that Customer is not able to access the Unpublished article.");
		internalUsersHomePage.accessArticleWithUrlAlias(articleData.getUrlAlias());
		verify.assertTrue(internalUsersHomePage.isAccessDeniedErrorDisplayed(),
				"Access Denied Error Page should be displayed");
		if (internalUsersHomePage.isAccessDeniedErrorDisplayed()) {
			extentLogger.log(LogStatus.PASS, "Verifed that Access Denied Error Page is displayed successfully");
		} else {
			extentLogger.log(LogStatus.FAIL, "Verifed that Access Denied Error Page could not displayed");
		}

		// Getting the rights of AllAuthor
		internalUsersHomePage.logOutAndCleanCookies(userLogin);
		userLogin.login(DataProviderClass.getDocAdminUserDetails().getUser(),
				DataProviderClass.getDocAdminUserDetails().getPw());
		extentLogger.log(LogStatus.INFO, "logged out from customer user and logged in as Doc Admin user control.");

		// Navigating to the unpublished article
		internalUsersHomePage.accessArticleWithUrlAlias(articleData.getUrlAlias());
		// Editing the Unpublished article
		internalUsersHomePage.editDraftArticle();
		contentPage.saveArticleAsDraftForThisTranslation();
		extentLogger.log(LogStatus.INFO, "Edited unpublished article and Saved as draft");
		// Verify that the article's moderation state is 'Draft'
		extentLogger.log(LogStatus.INFO, "Verifying whether the article's moderation state is 'Draft'");
		mainPage.clickContent();
		verify.assertTrue(contentPage.isArticleADraft(articleData.getTitle()),
				"Article's moderation state should be 'Draft'");
		if (contentPage.isArticleADraft(articleData.getTitle())) {
			extentLogger.log(LogStatus.PASS, "Verified that Article's moderation state is 'Draft'");
		} else {
			extentLogger.log(LogStatus.FAIL, "Verified that Article's moderation is not 'Draft'");
		}

		// Navigating to the Drafted article
		internalUsersHomePage.accessArticleWithUrlAlias(articleData.getUrlAlias());
		// Editing the Drafted article
		internalUsersHomePage.editDraftArticle();
		contentPage.saveArticleAndRequestReviewForThisTranslation();
		extentLogger.log(LogStatus.INFO, "Edited drafted article and Saved as Request review");
		// Verify that the article's moderation state is 'Request Review'
		extentLogger.log(LogStatus.INFO, "Verifying whether the article's moderation state is 'Request Review'");
		mainPage.clickContent();
		verify.assertTrue(contentPage.isArticleReadyForReview(articleData.getTitle()),
				"Article's moderation state should be 'Request Review '");
		if (contentPage.isArticleReadyForReview(articleData.getTitle())) {
			extentLogger.log(LogStatus.PASS, "Verified that Article's moderation state is 'Request Review '");
		} else {
			extentLogger.log(LogStatus.FAIL, "Verified that Article's moderation is not 'Request Review '");
		}

		// Navigating to the article view
		internalUsersHomePage.accessArticleWithUrlAlias(articleData.getUrlAlias());
		// Editing the Drafted article
		internalUsersHomePage.editDraftArticle();
		contentPage.saveAndCompleteReviewForThisTranslation();
		extentLogger.log(LogStatus.INFO, "Edited drafted article and Saved as Review Completed");
		// Verify that the article's moderation state is 'Review Completed'
		extentLogger.log(LogStatus.INFO, "Verifying whether the article's moderation state is 'Review Completed'");
		mainPage.clickContent();
		verify.assertTrue(contentPage.isArticleReviewCompleted(articleData.getTitle()),
				"Article's moderation state should be 'Review Completed'");
		if (contentPage.isArticleReviewCompleted(articleData.getTitle())) {
			extentLogger.log(LogStatus.PASS, "Verified that Article's moderation state is 'Review Completed'");
		} else {
			extentLogger.log(LogStatus.FAIL, "Verified that Article's moderation is not 'Review Completed'");
		}

		// Navigating to the article view
		internalUsersHomePage.accessArticleWithUrlAlias(articleData.getUrlAlias());
		// Editing the Drafted article
		internalUsersHomePage.editDraftArticle();
		contentPage.saveAndReadyToPublishForThisTranslation();
		extentLogger.log(LogStatus.INFO, "Edited drafted article and Saved as Ready to Publish");
		// Verify that the article's moderation state is 'Ready to Publish'
		extentLogger.log(LogStatus.INFO, "Verifying whether the article's moderation state is 'Ready to Publish'");
		mainPage.clickContent();
		verify.assertTrue(contentPage.isArticleReadyToPublish(articleData.getTitle()),
				"Article's moderation state should be 'Ready to Publish'");
		if (contentPage.isArticleReadyToPublish(articleData.getTitle())) {
			extentLogger.log(LogStatus.PASS, "Verified that Article's moderation state is 'Ready to Publish'");
		} else {
			extentLogger.log(LogStatus.FAIL, "Verified that Article's moderation is not 'Ready to Publish'");
		}

		// Navigating to the article view
		internalUsersHomePage.accessArticleWithUrlAlias(articleData.getUrlAlias());
		// Editing the Drafted article
		internalUsersHomePage.editDraftArticle();
		contentPage.saveAndPublishForThisTranslation();
		extentLogger.log(LogStatus.INFO, "Edited drafted article and Saved as Published");
		// Verify that the article's moderation state is 'Published'
		extentLogger.log(LogStatus.INFO, "Verifying whether the article's moderation state is 'Published'");
		mainPage.clickContent();
		verify.assertTrue(contentPage.isArticlePublished(articleData.getTitle()),
				"Article's moderation state should be 'Published'");
		if (contentPage.isArticlePublished(articleData.getTitle())) {
			extentLogger.log(LogStatus.PASS, "Verified that Article's moderation state is 'Published'");
		} else {
			extentLogger.log(LogStatus.FAIL, "Verified that Article's moderation is not 'Published'");
		}

		// logging out from Doc admin user and getting customer user control
		internalUsersHomePage.logOutAndCleanCookies(userLogin);
		userLogin.login(DataProviderClass.getCustomerUserDetails().getUser(),
				DataProviderClass.getCustomerUserDetails().getPw());
		extentLogger.log(LogStatus.INFO, "logged out from Doc admin user and logged in as customer user control.");

		// Verifying that Customer must be able to access the published article.
		extentLogger.log(LogStatus.INFO, "Verifying that Customer must be able to access the published article.");
		internalUsersHomePage.accessArticleWithUrlAlias(articleData.getUrlAlias());
		verify.assertTrue(driver.getTitle().contains(articleData.getTitle()),
				"Customer should be able to access the published article page.");
		if (driver.getTitle().contains(articleData.getTitle())) {
			extentLogger.log(LogStatus.PASS,
					"Verifed that Customer is accessed the published article page successfully");
		} else {
			extentLogger.log(LogStatus.FAIL, "Verifed that Customer could not accessed the published article page");
		}

		verify.assertAll();
		extent.endTest(extentLogger);

	}

	@Test(groups = { "TC115041" }, priority = 21)
	public void TC115041_Anonymous_User_Can_Access_Published_Article_Through_URL() throws Exception {
		SoftAssert verify = new SoftAssert();
		logger.info("TC115041_'Anonymous user can access published article through Url' Test started");
		extentLogger = extent.startTest("TC115041 Test_Anonymous_User_Can_Access_Published_Article_Through_URL");
		extentLogger.log(LogStatus.INFO, "TC115041 Test_Anonymous_User_Can_Access_Published_Article_Through_URL");

		// login as doc admin user
		userLogin.login(DataProviderClass.getDocAdminUserDetails().getUser(),
				DataProviderClass.getDocAdminUserDetails().getPw());
		extentLogger.log(LogStatus.INFO, "Logged in as doc admin user");

		ArticleData articleData = DataProviderClass.getArticleData(46);
		extentLogger.log(LogStatus.INFO, "Adding an article:" + articleData.getTitle());
		mainPage.clickContent();
		contentPage.addArticle(articleData);
		contentPage.saveAndPublish();

		// Verify that the article's moderation state is 'Published'
		extentLogger.log(LogStatus.INFO, "Verifying whether the article's moderation state is 'Published'");
		mainPage.clickContent();
		verify.assertTrue(contentPage.isArticlePublished(articleData.getTitle()),
				"Article's moderation state should be 'Published'");
		if (contentPage.isArticlePublished(articleData.getTitle())) {
			extentLogger.log(LogStatus.PASS, "Verified that Article's moderation state is 'Published'");
		} else {
			extentLogger.log(LogStatus.FAIL, "Verified that Article's moderation is not 'Published'");
		}

		// Logging out from Doc Admin User
		internalUsersHomePage.logOutAndCleanCookies(userLogin);
		extentLogger.log(LogStatus.INFO,
				"Logged out from Doc Admin control and accessing the published article as Anonymous user.");

		internalUsersHomePage.accessArticleWithUrlAlias(articleData.getUrlAlias());

		// Verifying that Anonymous user must be able to access the published
		// article.
		extentLogger.log(LogStatus.INFO, "Verifying that Anonymous user must be able to access the published article");
		internalUsersHomePage.accessArticleWithUrlAlias(articleData.getUrlAlias());
		verify.assertTrue(driver.getTitle().contains(articleData.getTitle()),
				"Anonymous user should be able to access the published article");
		if (driver.getTitle().contains(articleData.getTitle())) {
			extentLogger.log(LogStatus.PASS,
					"Verifed that Anonymous user has accessed the published article page successfully");
		} else {
			extentLogger.log(LogStatus.FAIL,
					"Verifed that Anonymous user could not accessed the published article page");
		}

		verify.assertAll();
		extent.endTest(extentLogger);

	}

	@Test(groups = { "TC104709", "TC105200" }, priority = 22)
	public void TC104709_Verify_Scheduled_Moderation_state_Update() throws Exception {
		SoftAssert verify = new SoftAssert();
		logger.info("TC104709_Verify_Scheduled_Moderation_state_Update Test started");
		extentLogger = extent.startTest("Verify_Scheduled_Moderation_state_Update");
		extentLogger.log(LogStatus.INFO, "TC104709_Verify_Scheduled_Moderation_state_Update");

		// login as doc admin user
		ArticleData articleData = DataProviderClass.getArticleData(49);
		extentLogger.log(LogStatus.INFO,
				articleData.getTitle() + " article is already scheduled to be Published at specific time.");
		userLogin.login(DataProviderClass.getDocAdminUserDetails().getUser(),
				DataProviderClass.getDocAdminUserDetails().getPw());
		extentLogger.log(LogStatus.INFO, "Logged in as doc admin user");

		// Accessing the scheduled article
		internalUsersHomePage.accessArticleWithUrlAlias(articleData.getUrlAlias());
		if (internalUsersHomePage.getArticleTitleFromPage().contains(articleData.getTitle())) {
			extentLogger.log(LogStatus.PASS, "Navigated to the article page " + articleData.getTitle());
		} else {
			extentLogger.log(LogStatus.FAIL, "Could not be navigated to the article " + articleData.getTitle());
		}
		Assert.assertTrue(internalUsersHomePage.getArticleTitleFromPage().contains(articleData.getTitle()),
				"should have Navigated to the article " + articleData.getTitle());

		mainPage.clickContent();
		extentLogger.log(LogStatus.INFO, "Filtering the scheduled article to verify the changed moderation state");

		// Filtering the article
		contentPage.filterArticle(articleData.getTitle());
		extentLogger.log(LogStatus.INFO, "Filtered article is: " + articleData.getTitle());

		// Getting the moderation state of the article
		String moderationState = contentPage.ModerationStateOfAnArticleFromContentsPage(articleData.getTitle());

		// verifying whether the article's moderation state got updated
		verify.assertTrue(moderationState.contains(articleData.getModerationStateToSchedule()),
				"Article's moderation state should be updated as: " + articleData.getModerationStateToSchedule());
		if (moderationState.contains(articleData.getModerationStateToSchedule())) {
			extentLogger.log(LogStatus.PASS,
					"Verifed that Article's moderation state is updated successfully and displayed as: "
							+ moderationState);
		} else {
			extentLogger.log(LogStatus.FAIL,
					"Verifed that Article's moderation state could not updated correctly and displayed as: "
							+ moderationState);
		}

		verify.assertAll();
		extent.endTest(extentLogger);
	}

	/**
	 * Test Case : verify Content Translation Workflow
	 * 
	 * @throws Exception
	 */
	@Test(groups = { "TC114706", "TC114677" }, priority = 23)
	public void TC114706_Translation_WorkFlow_Scenerio_PublishEN_UploadEN_RequestJA_DownloadJA_PublishJA()
			throws Exception {

		SoftAssert verify = new SoftAssert();
		logger.debug("testForContentTranslationWorkFlow Test started");
		extentLogger = extent.startTest(
				"TC114706 Translation WorkFlow Scenerio - PublishEN -> UploadEN and RequestJA -> DownloadJA -> PublishJA");
		logger.info(
				"TC114706 Translation WorkFlow Scenerio - PublishEN -> UploadEN and RequestJA -> DownloadJA -> PublishJA Test has started");
		// Login as Doc Admin user
		userLogin.login(DataProviderClass.getDocAdminUserDetails().getUser(),
				DataProviderClass.getDocAdminUserDetails().getPw());
		extentLogger.log(LogStatus.INFO, "Logged in as doc admin user");
		ArticleData articleData = DataProviderClass.getArticleData(50);
		extentLogger.log(LogStatus.INFO, "Adding an article:" + articleData.getTitle());
		mainPage.clickContent();
		contentPage.addArticle(articleData);
		contentPage.saveAndPublish();

		// Verify that the article is created
		extentLogger.log(LogStatus.INFO, "Verifying whether the article is created");
		verify.assertTrue(internalUsersHomePage.isArticleCreatedMessageDisplayed(articleData.getTitle()),
				"Article creation message should be displayed as expected.");
		if (internalUsersHomePage.isArticleCreatedMessageDisplayed(articleData.getTitle())) {
			extentLogger.log(LogStatus.PASS, "Verified that Article creation message is displayed successfuly.");
		} else {
			extentLogger.log(LogStatus.FAIL, "Verified that Article creation message is Not displayed.");
		}

		// navigate to Manage Translations Tab
		internalUsersHomePage.goToManageTranslationsTab();

		// Upload source for Translation
		extentLogger.log(LogStatus.INFO, "Uploading the english article for translation");
		internalUsersHomePage.selectArticleFromManageTranslation();
		internalUsersHomePage.selectManageTranslationOperation(StringConstants.UploadEnglishOperation);
		internalUsersHomePage.executeManageTranslationOperation();
		new WebDriverWait(driver, 60).until(ExpectedConditions
				.textToBePresentInElement(internalUsersHomePage.messageFromManageTranslation, "Operations completed."));
		verify.assertTrue(
				internalUsersHomePage.getManageTranslationOperationMessage().contains("Operations completed."),
				"Upload Source for Translation was not successful");
		if (internalUsersHomePage.getManageTranslationOperationMessage().contains("Operations completed.")) {
			extentLogger.log(LogStatus.PASS, "Verified that Upload Source for Translation was successful");
		} else {
			extentLogger.log(LogStatus.FAIL, "Upload Source for Translation was not successful");
		}

		// Request for Japanese translation
		extentLogger.log(LogStatus.INFO, "Requesting for Japanese translation");
		internalUsersHomePage.selectArticleFromManageTranslation();
		internalUsersHomePage.selectManageTranslationOperation(StringConstants.RequestJapaneseOperation);
		internalUsersHomePage.executeManageTranslationOperation();
		new WebDriverWait(driver, 60).until(ExpectedConditions
				.textToBePresentInElement(internalUsersHomePage.messageFromManageTranslation, "Operations completed."));
		verify.assertTrue(
				internalUsersHomePage.getManageTranslationOperationMessage().contains("Operations completed."),
				"Request for Japanese (ja) translation was not successful");
		if (internalUsersHomePage.getManageTranslationOperationMessage().contains("Operations completed.")) {
			extentLogger.log(LogStatus.PASS, "Verified that Request for Japanese (ja) translation was successful");
		} else {
			extentLogger.log(LogStatus.FAIL, "Request for Japanese (ja) translation was not successful");
		}

		// Download Japanese translation
		extentLogger.log(LogStatus.INFO, "Downloading Japanese translation");
		internalUsersHomePage.selectArticleFromManageTranslation();
		internalUsersHomePage.selectManageTranslationOperation(StringConstants.DownloadJapaneseOperation);
		internalUsersHomePage.executeManageTranslationOperation();
		new WebDriverWait(driver, 60).until(ExpectedConditions
				.textToBePresentInElement(internalUsersHomePage.messageFromManageTranslation, "Operations completed."));
		verify.assertTrue(
				internalUsersHomePage.getManageTranslationOperationMessage().contains("Operations completed."),
				"Download Japanese translation was not successful");
		if (internalUsersHomePage.getManageTranslationOperationMessage().contains("Operations completed.")) {
			extentLogger.log(LogStatus.PASS, "Verified that Download Japanese translation was successful");
		} else {
			extentLogger.log(LogStatus.FAIL, "Download Japanese translation was not successful");
		}

		// Switch to Japanese Language using Language Dropdown
		extentLogger.log(LogStatus.INFO, "Switch to Japanese Language using Language Dropdown");
		internalUsersHomePage.switchArticleLanguage(StringConstants.JAPANESE);
		verify.assertTrue(driver.getCurrentUrl().contains(StringConstants.JAPANESE_LOCALE),
				"Switching article to Japanese Language was not successful using Languagde DropDown");
		if (driver.getCurrentUrl().contains(StringConstants.JAPANESE_LOCALE)) {
			extentLogger.log(LogStatus.PASS,
					"Verified that Switching article to Japanese Language was successful using Languagde DropDown");
		} else {
			extentLogger.log(LogStatus.FAIL,
					"Switching article to Japanese Language was not successful using Languagde DropDown");
		}

		// Verifying if the content body is translated
		extentLogger.log(LogStatus.INFO, "Verifying if the content body is translated to japanese");
		verify.assertTrue(driver.findElement(By.xpath("//div[@class='content']")).getText().contains(
				StringConstants.JapaneseContentTranslationBodyText), "Content Translation was not successful");
		if (driver.findElement(By.xpath("//div[@class='content']")).getText()
				.contains(StringConstants.JapaneseContentTranslationBodyText)) {
			extentLogger.log(LogStatus.PASS, "Verified that Content Translation was successful");
		} else {
			extentLogger.log(LogStatus.FAIL, "Content Translation was not successful");
		}

		// Checking if the translated content got downloaded in the Draft State
		extentLogger.log(LogStatus.INFO, "Checking if the translated content got downloaded in the Draft State");
		mainPage.clickContent();
		CommonActions.selectByValue(driver, driver.findElement(By.id("edit-langcode")), "ja");
		verify.assertTrue(contentPage.isArticleADraft(articleData.getTitle()),
				"Japanese Translation did not download in the Draft State");
		if (contentPage.isArticleADraft(articleData.getTitle())) {
			extentLogger.log(LogStatus.PASS, "Verified that Japanese Translation got downloaded in the Draft State");
		} else {
			extentLogger.log(LogStatus.FAIL, "Japanese Translation did not download in the Draft State");
		}

		// Logout and access the translated content as a customer
		internalUsersHomePage.logOutAndCleanCookies(userLogin);
		extentLogger.log(LogStatus.INFO, "Logged out and accessing the translated japanese article as customer user");
		userLogin.login(DataProviderClass.getCustomerUserDetails().getUser(),
				DataProviderClass.getCustomerUserDetails().getPw());
		internalUsersHomePage.accessArticleWithLocale(articleData.getUrlAlias(), StringConstants.JAPANESE_LOCALE);
		verify.assertTrue(internalUsersHomePage.isAccessDeniedErrorDisplayed(), "Access Denied is displayed");
		if (internalUsersHomePage.isAccessDeniedErrorDisplayed()) {
			extentLogger.log(LogStatus.PASS,
					"Verified that Japanese Translation shows Access Denied for Customers as it is still not published");
		} else {
			extentLogger.log(LogStatus.FAIL, "Japanese Translation does not show as Access Denied for the Customers");
		}

		// Publish the Japanese Translation
		extentLogger.log(LogStatus.INFO, "Publish the Japanese Translation");
		internalUsersHomePage.logOutAndCleanCookies(userLogin);
		userLogin.login(DataProviderClass.getDocAdminUserDetails().getUser(),
				DataProviderClass.getDocAdminUserDetails().getPw());
		internalUsersHomePage.accessArticleWithLocale(articleData.getUrlAlias(), StringConstants.JAPANESE_LOCALE);
		internalUsersHomePage.editDraftArticle();
		contentPage.saveAndPublishForThisTranslation();

		// Logout and access the published translated content as a customer
		internalUsersHomePage.logOutAndCleanCookies(userLogin);
		extentLogger.log(LogStatus.INFO, "Logged out and accessing the published japanese article as customer user");
		userLogin.login(DataProviderClass.getCustomerUserDetails().getUser(),
				DataProviderClass.getCustomerUserDetails().getPw());
		internalUsersHomePage.accessArticleWithLocale(articleData.getUrlAlias(), StringConstants.JAPANESE_LOCALE);
		verify.assertTrue(driver.getTitle().contains(articleData.getTitle()),
				"Published Japanese article is not accessible by the Customer");
		if (driver.getTitle().contains(articleData.getTitle())) {
			extentLogger.log(LogStatus.PASS,
					"Verified that Published Japanese Translation is accessible by the Customer");
		} else {
			extentLogger.log(LogStatus.FAIL, "Published Japanese Translation is not accessible by the Customer");
		}

		verify.assertAll();
		extent.endTest(extentLogger);

	}

	@Test(groups = { "TC121508" }, priority = 24)
	public void TC121508_Verify_ScreenShot_Link_At_View_Page_Of_Article() throws Exception {

		SoftAssert verify = new SoftAssert();
		logger.debug("TC121508_Verify_ScreenShot_Link_At_View_Page_Of_Article Test started");
		extentLogger = extent.startTest("TC121508_Verify_ScreenShot_Link_At_View_Page_Of_Article");
		logger.info("TC121508_Verify_ScreenShot_Link_At_View_Page_Of_Article");
		// Login as Doc Admin user
		userLogin.login(DataProviderClass.getDocAdminUserDetails().getUser(),
				DataProviderClass.getDocAdminUserDetails().getPw());
		extentLogger.log(LogStatus.INFO, "Logged in as doc admin user");
		ArticleData articleData = DataProviderClass.getArticleData(52);
		extentLogger.log(LogStatus.INFO, "Adding an article:" + articleData.getTitle());
		mainPage.clickContent();
		contentPage.addIntegrationContentTypeArticle(articleData);
		contentPage.saveAndPublish();

		// verifying whether article is created
		extentLogger.log(LogStatus.INFO, "Verifying whether the article is created.");
		verify.assertTrue(internalUsersHomePage.isArticleCreatedMessageDisplayedForIntegrationContentTypeArticle(
				articleData.getTitle()), "Article creation message should be displayed as expected.");
		if (internalUsersHomePage
				.isArticleCreatedMessageDisplayedForIntegrationContentTypeArticle(articleData.getTitle())) {
			extentLogger.log(LogStatus.PASS, "Verified that Article creation message is displayed successfuly.");
		} else {
			extentLogger.log(LogStatus.FAIL, "Verified that Article creation message is Not displayed.");
		}

		// logging out from Admin role
		internalUsersHomePage.logOutAndCleanCookies(userLogin);
		extentLogger.log(LogStatus.INFO, "logged out from Admin role");

		// logging in as Customer
		userLogin.login(DataProviderClass.getCustomerUserDetails().getUser(),
				DataProviderClass.getCustomerUserDetails().getPw());
		extentLogger.log(LogStatus.INFO, "Logged in as Customer user");

		// naviagting to the added article
		internalUsersHomePage.accessArticleWithUrlAlias(articleData.getUrlAlias());
		extentLogger.log(LogStatus.INFO, "Naviagating to the added article");

		// Verify whether ScreenShot Link is Displayed as Hyperlink
		extentLogger.log(LogStatus.INFO, "Verifying whether ScreenShot Link is Displayed as Hyperlink");
		verify.assertTrue(contentPage.isScreenShotLinkClickable(), "ScreenShot link is not displayed and not enabled.");
		if (contentPage.isScreenShotLinkClickable()) {
			extentLogger.log(LogStatus.PASS, "Verified that ScreenShot link is displayed and Enabled");
		} else {
			extentLogger.log(LogStatus.FAIL, "ScreenShot link is whether not displayed or not Enabled");
		}

		verify.assertAll();
		extent.endTest(extentLogger);
	}

	@Test(groups = { "TC121507" }, priority = 25)
	public void TC121507_Verify_DataSheet_Link_At_View_Page_Of_Article() throws Exception {

		SoftAssert verify = new SoftAssert();
		logger.debug("TC121507_Verify_DataSheet_Link_At_View_Page_Of_Article Test started");
		extentLogger = extent.startTest("TC121507_Verify_DataSheet_Link_At_View_Page_Of_Article");
		logger.info("TC121507_Verify_DataSheet_Link_At_View_Page_Of_Article");
		// Login as Doc Admin user
		userLogin.login(DataProviderClass.getDocAdminUserDetails().getUser(),
				DataProviderClass.getDocAdminUserDetails().getPw());
		extentLogger.log(LogStatus.INFO, "Logged in as doc admin user");
		ArticleData articleData = DataProviderClass.getArticleData(53);
		extentLogger.log(LogStatus.INFO, "Adding an article:" + articleData.getTitle());
		mainPage.clickContent();
		contentPage.addIntegrationContentTypeArticle(articleData);
		contentPage.saveAndPublish();

		// verifying whether article is created

		extentLogger.log(LogStatus.INFO, "Verifying whether the article is created.");
		verify.assertTrue(internalUsersHomePage.isArticleCreatedMessageDisplayedForIntegrationContentTypeArticle(
				articleData.getTitle()), "Article creation message should be displayed as expected.");
		if (internalUsersHomePage
				.isArticleCreatedMessageDisplayedForIntegrationContentTypeArticle(articleData.getTitle())) {
			extentLogger.log(LogStatus.PASS, "Verified that Article creation message is displayed successfuly.");
		} else {
			extentLogger.log(LogStatus.FAIL, "Verified that Article creation message is Not displayed.");
		}

		// logging out from Admin role
		internalUsersHomePage.logOutAndCleanCookies(userLogin);
		extentLogger.log(LogStatus.INFO, "logged out from Admin role");

		// logging in as Customer
		userLogin.login(DataProviderClass.getCustomerUserDetails().getUser(),
				DataProviderClass.getCustomerUserDetails().getPw());
		extentLogger.log(LogStatus.INFO, "Logged in as Customer user");

		// naviagting to the added article
		internalUsersHomePage.accessArticleWithUrlAlias(articleData.getUrlAlias());
		extentLogger.log(LogStatus.INFO, "Naviagating to the added article");

		// Verify whether ScreenShot Link is Displayed as Hyperlink
		extentLogger.log(LogStatus.INFO, "Verifying whether DataSheet Link is Displayed as Hyperlink");
		verify.assertTrue(contentPage.isDataSheetLinkClickable(), "DataSheet link is not displayed and not enabled.");
		if (contentPage.isDataSheetLinkClickable()) {
			extentLogger.log(LogStatus.PASS, "Verified that DataSheet link is displayed and Enabled");
		} else {
			extentLogger.log(LogStatus.FAIL, "DataSheet link is whether not displayed or not Enabled");
		}

		verify.assertAll();
		extent.endTest(extentLogger);
	}

	/**
	 * Test Case : Verify whether URL Alias Field is Auto-created when provided
	 * blank while creation and verify URL Alias Value - When User creates an
	 * Article with same Title
	 * 
	 * @throws Exception
	 */
	@Test(groups = { "TC112019", "TC113539" }, priority = 26)
	public void TC112019_Verify_whether_URLAlias_is_autocreated_when_provided_blank_while_creation() throws Exception {

		SoftAssert verify = new SoftAssert();
		logger.debug("TC112019_Verify_whether_URLAlias_is_autocreated_when_provided_blank_while_creation Test started");
		extentLogger = extent.startTest(
				"TC112019_Verify_whether_URLAlias_is_autocreated_when_provided_blank_while_creation Test started");
		logger.info("TC112019_Verify_whether_URLAlias_is_autocreated_when_provided_blank_while_creation Test started");

		// Login as Doc Admin user
		userLogin.login(DataProviderClass.getDocAdminUserDetails().getUser(),
				DataProviderClass.getDocAdminUserDetails().getPw());
		extentLogger.log(LogStatus.INFO, "Logged in as doc admin user");
		ArticleData articleData = DataProviderClass.getArticleData(54);
		extentLogger.log(LogStatus.INFO, "Adding an article:" + articleData.getTitle());
		mainPage.clickContent();
		contentPage.addArticle(articleData);
		contentPage.saveAndPublish();

		// Verify that the article is created
		extentLogger.log(LogStatus.INFO, "Verifying whether the article is created");
		verify.assertTrue(internalUsersHomePage.isArticleCreatedMessageDisplayed(articleData.getTitle()),
				"Article creation message should be displayed as expected.");
		if (internalUsersHomePage.isArticleCreatedMessageDisplayed(articleData.getTitle())) {
			extentLogger.log(LogStatus.PASS, "Verified that Article creation message is displayed successfuly.");
		} else {
			extentLogger.log(LogStatus.FAIL, "Verified that Article creation message is Not displayed.");
		}

		// Verify that the article alias is been automatically created and gets
		// the title value
		extentLogger.log(LogStatus.INFO, "Verifying that the article alias is been automatically created");
		verify.assertTrue(
				driver.getCurrentUrl()
						.equals(configReader.getDrupalAgileCentralURL() + "/" + articleData.getTitle().toLowerCase()),
				"article alias is not been created with the article title value");
		if (driver.getCurrentUrl()
				.equals(configReader.getDrupalAgileCentralURL() + "/" + articleData.getTitle().toLowerCase())) {
			extentLogger.log(LogStatus.PASS,
					"Verified that the article alias is been automatically created and got the article title value");
		} else {
			extentLogger.log(LogStatus.FAIL, "article alias is not been created with the article title value");
		}

		extentLogger.log(LogStatus.INFO, "Adding an article with same title:" + articleData.getTitle());
		mainPage.clickContent();
		contentPage.addArticle(articleData);
		contentPage.saveAndPublish();

		// Verify that one more article is created with the same title
		extentLogger.log(LogStatus.INFO, "Verifying whether one more article is created with the already used title");
		verify.assertTrue(internalUsersHomePage.isArticleCreatedMessageDisplayed(articleData.getTitle()),
				"Article creation with already used title is failed");
		if (internalUsersHomePage.isArticleCreatedMessageDisplayed(articleData.getTitle())) {
			extentLogger.log(LogStatus.PASS, "Verified that one more article is created with the already used title");
		} else {
			extentLogger.log(LogStatus.FAIL, "Article creation with already used title is failed");
		}
		// Verify that the article alias is been automatically created and gets
		// the title value appended by -0
		extentLogger.log(LogStatus.INFO,
				"Verifying that the article alias is been automatically created by appending -0");
		verify.assertTrue(
				driver.getCurrentUrl().equals(
						configReader.getDrupalAgileCentralURL() + "/" + articleData.getTitle().toLowerCase() + "-0"),
				"article alias is not been created with the article title value");
		if (driver.getCurrentUrl()
				.equals(configReader.getDrupalAgileCentralURL() + "/" + articleData.getTitle().toLowerCase() + "-0")) {
			extentLogger.log(LogStatus.PASS,
					"Verified that the article alias is been automatically created and got the article title value appended by a -0");
		} else {
			extentLogger.log(LogStatus.FAIL,
					"article alias is not been created with the article title value appended by a -0");
		}

		verify.assertAll();
		extent.endTest(extentLogger);

	}

	/**
	 * Test Case : Verify whether URLAlias gets the same value as given in its
	 * creation
	 * 
	 * @throws Exception
	 */
	@Test(groups = { "TC112025" }, priority = 27)
	public void TC112025_Verify_whether_URLAlias_gets_the_same_value_as_given_in_its_creation() throws Exception {

		SoftAssert verify = new SoftAssert();
		logger.debug(
				"TC112025_Verify_whether_URLAlias_field_is_populated_with_same_value_as_given_in_its_creation Test started");
		extentLogger = extent.startTest(
				"TC112019_Verify_whether_URLAlias_gets_the_same_value_as_given_in_its_creation Test started");
		logger.info("TC112025_Verify_whether_URLAlias_gets_the_same_value_as_given_in_its_creation Test started");

		// Login as Doc Admin user
		userLogin.login(DataProviderClass.getDocAdminUserDetails().getUser(),
				DataProviderClass.getDocAdminUserDetails().getPw());
		extentLogger.log(LogStatus.INFO, "Logged in as doc admin user");
		ArticleData articleData = DataProviderClass.getArticleData(55);
		extentLogger.log(LogStatus.INFO, "Adding an article:" + articleData.getTitle());
		mainPage.clickContent();
		contentPage.addArticle(articleData);
		contentPage.saveAndPublish();

		// Verify that the article is created
		extentLogger.log(LogStatus.INFO, "Verifying whether the article is created");
		verify.assertTrue(internalUsersHomePage.isArticleCreatedMessageDisplayed(articleData.getTitle()),
				"Article creation message should be displayed as expected.");
		if (internalUsersHomePage.isArticleCreatedMessageDisplayed(articleData.getTitle())) {
			extentLogger.log(LogStatus.PASS, "Verified that Article creation message is displayed successfuly.");
		} else {
			extentLogger.log(LogStatus.FAIL, "Verified that Article creation message is Not displayed.");
		}

		// Verify that the article alias is been automatically created and gets
		// the title value
		extentLogger.log(LogStatus.INFO,
				"Verifying that the article alias provided on add article form is picked correctly");
		verify.assertTrue(driver.getCurrentUrl().contains(articleData.getUrlAlias()),
				"article alias provided on add article form is not picked correctly");
		if (driver.getCurrentUrl().contains(articleData.getUrlAlias())) {
			extentLogger.log(LogStatus.PASS,
					"Verified that the article alias provided on add article form is picked correctly");
		} else {
			extentLogger.log(LogStatus.FAIL, "article alias provided on add article form is not picked correctly");
		}

		verify.assertAll();
		extent.endTest(extentLogger);
	}

	/**
	 * Test Case : Verify providing slash in url alias field will autocreate the
	 * alias value
	 * 
	 * @throws Exception
	 */
	@Test(groups = { "TC112024" }, priority = 28)
	public void TC112024_Verify_providing_slash_in_url_alias_field_will_autocreate_the_alias_value() throws Exception {

		SoftAssert verify = new SoftAssert();
		logger.debug("TC112024_Verify_providing_slash_in_url_alias_field_will_autocreate_the_alias_value Test started");
		extentLogger = extent.startTest(
				"TC112024_Verify_providing_slash_in_url_alias_field_will_autocreate_the_alias_value Test started");
		logger.info("TC112024_Verify_providing_slash_in_url_alias_field_will_autocreate_the_alias_value Test started");

		// Login as Doc Admin user
		userLogin.login(DataProviderClass.getDocAdminUserDetails().getUser(),
				DataProviderClass.getDocAdminUserDetails().getPw());
		extentLogger.log(LogStatus.INFO, "Logged in as doc admin user");
		ArticleData articleData = DataProviderClass.getArticleData(56);
		extentLogger.log(LogStatus.INFO, "Adding an article:" + articleData.getTitle());
		mainPage.clickContent();
		contentPage.addArticle(articleData);
		contentPage.saveAndPublish();

		// Verify that the article is created
		extentLogger.log(LogStatus.INFO, "Verifying whether the article is created");
		verify.assertTrue(internalUsersHomePage.isArticleCreatedMessageDisplayed(articleData.getTitle()),
				"Article creation message should be displayed as expected.");
		if (internalUsersHomePage.isArticleCreatedMessageDisplayed(articleData.getTitle())) {
			extentLogger.log(LogStatus.PASS, "Verified that Article creation message is displayed successfuly.");
		} else {
			extentLogger.log(LogStatus.FAIL, "Verified that Article creation message is Not displayed.");
		}

		// Verify that the article alias is been automatically created and gets
		// the title value
		extentLogger.log(LogStatus.INFO, "Verifying that the article alias is been automatically created");
		verify.assertTrue(
				driver.getCurrentUrl()
						.equals(configReader.getDrupalAgileCentralURL() + "/" + articleData.getTitle().toLowerCase()),
				"article alias is not been created with the article title value");
		if (driver.getCurrentUrl()
				.equals(configReader.getDrupalAgileCentralURL() + "/" + articleData.getTitle().toLowerCase())) {
			extentLogger.log(LogStatus.PASS,
					"Verified that the article alias is been automatically created and got the article title value");
		} else {
			extentLogger.log(LogStatus.FAIL, "article alias is not been created with the article title value");
		}
		verify.assertAll();
		extent.endTest(extentLogger);
	}

	/**
	 * Test Case : Verify providing agilecentral baseurl as url alias field
	 * value
	 * 
	 * @throws Exception
	 */
	@Test(groups = { "TC122015" }, priority = 29)
	public void TC122015_Verify_providing_agilecentral_baseurl_as_url_alias_field_value() throws Exception {

		SoftAssert verify = new SoftAssert();
		logger.debug("TC122015_Verify_providing_agilecentral_baseurl_as_url_alias_field_value Test started");
		extentLogger = extent
				.startTest("TC122015_Verify_providing_agilecentral_baseurl_as_url_alias_field_value Test started");
		logger.info("TC122015_Verify_providing_agilecentral_baseurl_as_url_alias_field_value Test started");

		// Login as Doc Admin user
		userLogin.login(DataProviderClass.getDocAdminUserDetails().getUser(),
				DataProviderClass.getDocAdminUserDetails().getPw());
		extentLogger.log(LogStatus.INFO, "Logged in as doc admin user");
		ArticleData articleData = DataProviderClass.getArticleData(57);
		extentLogger.log(LogStatus.INFO, "Adding an article:" + articleData.getTitle());
		mainPage.clickContent();
		contentPage.addArticle(articleData);
		contentPage.saveAndPublish();

		// Verify that the article is created
		extentLogger.log(LogStatus.INFO, "Verifying whether the article is created");
		verify.assertTrue(internalUsersHomePage.isArticleCreatedMessageDisplayed(articleData.getTitle()),
				"Article creation message should be displayed as expected.");
		if (internalUsersHomePage.isArticleCreatedMessageDisplayed(articleData.getTitle())) {
			extentLogger.log(LogStatus.PASS, "Verified that Article creation message is displayed successfuly.");
		} else {
			extentLogger.log(LogStatus.FAIL, "Verified that Article creation message is Not displayed.");
		}

		// Verify that the article alias is been automatically created and gets
		// the title value
		extentLogger.log(LogStatus.INFO,
				"Verifying that the article alias is been automatically created by appending article title to the agile central base url");
		verify.assertTrue(
				driver.getCurrentUrl()
						.equals(configReader.getDrupalAgileCentralURL() + "/" + articleData.getTitle().toLowerCase()),
				"article alias is not been updated by apppending article title to the agil central base url");
		if (driver.getCurrentUrl()
				.equals(configReader.getDrupalAgileCentralURL() + "/" + articleData.getTitle().toLowerCase())) {
			extentLogger.log(LogStatus.PASS,
					"Verified that the article alias is been automatically created by appending article title to the agile central base url");
		} else {
			extentLogger.log(LogStatus.FAIL,
					"article alias is not been updated by apppending article title to the agil central base url");
		}
		verify.assertAll();
		extent.endTest(extentLogger);
	}

	/**
	 * Test Case : Verify urlalias field when providing existing alias value
	 * 
	 * @throws Exception
	 */
	@Test(groups = { "TC122031" }, priority = 30)
	public void TC122031_Verify_url_alias_field_when_providing_existing_alias_value() throws Exception {

		SoftAssert verify = new SoftAssert();
		logger.debug("TC122031_Verify_url_alias_field_when_providing_existing_alias_value Test started");
		extentLogger = extent
				.startTest("TC122031_Verify_url_alias_field_when_providing_existing_alias_value Test started");
		logger.info("TC122031_Verify_url_alias_field_when_providing_existing_alias_value Test started");

		// Login as Doc Admin user
		userLogin.login(DataProviderClass.getDocAdminUserDetails().getUser(),
				DataProviderClass.getDocAdminUserDetails().getPw());
		extentLogger.log(LogStatus.INFO, "Logged in as doc admin user");
		ArticleData articleData = DataProviderClass.getArticleData(58);
		extentLogger.log(LogStatus.INFO, "Adding an article:" + articleData.getTitle());
		mainPage.clickContent();
		contentPage.addArticle(articleData);
		contentPage.saveAndPublish();
		extentLogger.log(LogStatus.INFO,
				"Verifying that the article alias already in use error message is getting displayed or not");
		verify.assertTrue(internalUsersHomePage.isArticleAliasInUseErrorMessageDisplayed(),
				"article alias in use error message is not displayed");
		if (internalUsersHomePage.isArticleAliasInUseErrorMessageDisplayed()) {
			extentLogger.log(LogStatus.PASS,
					"Verified that article alias already in use error message is displayed successfully");
		} else {
			extentLogger.log(LogStatus.FAIL, "article alias already in use error message is not displayed");
		}
		verify.assertAll();
		extent.endTest(extentLogger);
	}

	/**
	 * Test Case : Verify url alias field value without providing baseurl and
	 * validate Error Message when User provides URL alias without "/"
	 * 
	 * @throws Exception
	 */
	@Test(groups = { "TC122033", "TC114624" }, priority = 31)
	public void TC122033_Verify_url_alias_field_value_without_providing_baseurl() throws Exception {

		SoftAssert verify = new SoftAssert();
		logger.debug("TC122033_Verify_url_alias_field_value_without_providing_baseurl Test started");
		extentLogger = extent.startTest("TC122033_Verify_url_alias_field_value_without_providing_baseurl Test started");
		logger.info("TC122033_Verify_url_alias_field_value_without_providing_baseurl Test started");

		// Login as Doc Admin user
		userLogin.login(DataProviderClass.getDocAdminUserDetails().getUser(),
				DataProviderClass.getDocAdminUserDetails().getPw());
		extentLogger.log(LogStatus.INFO, "Logged in as doc admin user");
		ArticleData articleData1 = DataProviderClass.getArticleData(59);
		extentLogger.log(LogStatus.INFO, "Adding an article:" + articleData1.getTitle());
		mainPage.clickContent();
		contentPage.addArticle(articleData1);
		contentPage.saveAndPublish();

		extentLogger.log(LogStatus.INFO,
				"Verifying that the article alias needs to start with a slash error message is getting displayed or not");
		verify.assertTrue(internalUsersHomePage.isArticleAliasStartswithSlashErrorMessageDisplayed(),
				"article alias alias needs to start with a slash error message is not displayed");
		if (internalUsersHomePage.isArticleAliasStartswithSlashErrorMessageDisplayed()) {
			extentLogger.log(LogStatus.PASS,
					"Verified that article alias needs to start with a slash error message is displayed successfully");
		} else {
			extentLogger.log(LogStatus.FAIL,
					"article alias needs to start with a slash error message is not displayed");
		}

		contentPage.cancelArticleToSave();

		ArticleData articleData2 = DataProviderClass.getArticleData(60);
		extentLogger.log(LogStatus.INFO, "Adding an article:" + articleData2.getTitle());
		mainPage.clickContent();
		contentPage.addArticle(articleData2);
		contentPage.saveAndPublish();

		// Verify that the article is created
		extentLogger.log(LogStatus.INFO, "Verifying whether the article is created");
		verify.assertTrue(internalUsersHomePage.isArticleCreatedMessageDisplayed(articleData2.getTitle()),
				"Article creation message should be displayed as expected.");
		if (internalUsersHomePage.isArticleCreatedMessageDisplayed(articleData2.getTitle())) {
			extentLogger.log(LogStatus.PASS, "Verified that Article creation message is displayed successfuly.");
		} else {
			extentLogger.log(LogStatus.FAIL, "Verified that Article creation message is Not displayed.");
		}

		// Verify that the article alias is been automatically created by
		// appending base url to the alias provided
		extentLogger.log(LogStatus.INFO,
				"Verifying that the article alias is been automatically created by appending base url to the alias provided");
		verify.assertTrue(
				driver.getCurrentUrl().equals(configReader.getDrupalAgileCentralURL() + articleData2.getUrlAlias()),
				"article alias is not been updated by apppending base url to the alias provided");
		if (driver.getCurrentUrl().equals(configReader.getDrupalAgileCentralURL() + articleData2.getUrlAlias())) {
			extentLogger.log(LogStatus.PASS,
					"Verified that the article alias is been automatically created by appending base url to the alias provided");
		} else {
			extentLogger.log(LogStatus.FAIL,
					"article alias is not been updated by appending base url to the alias provided");
		}
		verify.assertAll();
		extent.endTest(extentLogger);

	}

	/**
	 * Test Case : Verify url alias field value with providing spaces
	 * 
	 * @throws Exception
	 */
	@Test(groups = "TC121475", priority = 32)
	public void TC121475_Verify_url_alias_field_value_with_providing_spaces() throws Exception {

		SoftAssert verify = new SoftAssert();
		logger.debug("TC121475_Verify_url_alias_field_value_with_providing_spaces Test started");
		extentLogger = extent.startTest("TC121475_Verify_url_alias_field_value_with_providing_spaces Test started");
		logger.info("TC121475_Verify_url_alias_field_value_with_providing_spaces Test started");

		// Login as Doc Admin user
		userLogin.login(DataProviderClass.getDocAdminUserDetails().getUser(),
				DataProviderClass.getDocAdminUserDetails().getPw());
		extentLogger.log(LogStatus.INFO, "Logged in as doc admin user");
		ArticleData articleData = DataProviderClass.getArticleData(61);
		extentLogger.log(LogStatus.INFO, "Adding an article:" + articleData.getTitle());
		mainPage.clickContent();
		contentPage.addArticle(articleData);
		contentPage.saveAndPublish();

		// Verify that the article is created
		extentLogger.log(LogStatus.INFO, "Verifying whether the article is created");
		verify.assertTrue(internalUsersHomePage.isArticleCreatedMessageDisplayed(articleData.getTitle()),
				"Article creation message should be displayed as expected.");
		if (internalUsersHomePage.isArticleCreatedMessageDisplayed(articleData.getTitle())) {
			extentLogger.log(LogStatus.PASS, "Verified that Article creation message is displayed successfuly.");
		} else {
			extentLogger.log(LogStatus.FAIL, "Verified that Article creation message is Not displayed.");
		}

		// Verify that the article alias is been automatically created by
		// appending base url to the alias provided in the edit article form
		extentLogger.log(LogStatus.INFO,
				"Verifying that the article alias is been automatically created by appending base url to the alias provided in the edit article form");
		internalUsersHomePage.editPublishedArticle();
		verify.assertTrue(contentPage.getUrlAliasValue().equals(configReader.getBaseUrl() + articleData.getUrlAlias()),
				"article alias is not been updated by appending base url to the alias provided in the edit article form");
		if (contentPage.getUrlAliasValue().equals(configReader.getBaseUrl() + articleData.getUrlAlias())) {
			extentLogger.log(LogStatus.PASS,
					"Verified that the article alias is been automatically created by appending base url to the alias provided in the edit article form");
		} else {
			extentLogger.log(LogStatus.FAIL,
					"article alias is not been updated by appending base url to the alias provided in the edit article form");
		}

		contentPage.cancelArticleToSave();

		// Verify that the article alias has been updated in the url and the
		// article is accessible
		extentLogger.log(LogStatus.INFO,
				"Verifying that the article alias has been updated in the url and the article is accessible");
		internalUsersHomePage.accessArticleWithLocale(configReader.getBaseUrl() + articleData.getUrlAlias(),
				StringConstants.ENGLISH_LOCALE);
		verify.assertTrue(driver.getTitle().contains(articleData.getTitle()),
				"article alias is not been updated in the url and the article is not accessible");
		if (driver.getTitle().contains(articleData.getTitle())) {
			extentLogger.log(LogStatus.PASS,
					"Verified that the article alias is been updated in the url and the article is accessible");
		} else {
			extentLogger.log(LogStatus.FAIL,
					"article alias is not been updated in the url and the article is not accessible");
		}

		verify.assertAll();
		extent.endTest(extentLogger);
	}

	/**
	 * Test Case : Verify url alias field value with providing spaces in title
	 * 
	 * @throws Exception
	 */
	@Test(groups = "TC122068", priority = 33)
	public void TC122068_Verify_url_alias_field_value_with_providing_spaces_in_title() throws Exception {

		SoftAssert verify = new SoftAssert();
		logger.debug("TC121475_Verify_url_alias_field_value_with_providing_spaces_in_title Test started");
		extentLogger = extent
				.startTest("TC121475_Verify_url_alias_field_value_with_providing_spaces_in_title Test started");
		logger.info("TC121475_Verify_url_alias_field_value_with_providing_spaces_in_title Test started");

		// Login as Doc Admin user
		userLogin.login(DataProviderClass.getDocAdminUserDetails().getUser(),
				DataProviderClass.getDocAdminUserDetails().getPw());
		extentLogger.log(LogStatus.INFO, "Logged in as doc admin user");
		ArticleData articleData = DataProviderClass.getArticleData(62);
		extentLogger.log(LogStatus.INFO, "Adding an article:" + articleData.getTitle());
		mainPage.clickContent();
		contentPage.addArticle(articleData);
		contentPage.saveAndPublish();

		// Verify that the article is created
		extentLogger.log(LogStatus.INFO, "Verifying whether the article is created");
		verify.assertTrue(internalUsersHomePage.isArticleCreatedMessageDisplayed(articleData.getTitle()),
				"Article creation message should be displayed as expected.");
		if (internalUsersHomePage.isArticleCreatedMessageDisplayed(articleData.getTitle())) {
			extentLogger.log(LogStatus.PASS, "Verified that Article creation message is displayed successfuly.");
		} else {
			extentLogger.log(LogStatus.FAIL, "Verified that Article creation message is Not displayed.");
		}

		// Verify that the article alias is been automatically created and gets
		// the title value by replacing the white spaces with -
		extentLogger.log(LogStatus.INFO,
				"Verifying that the article alias is been automatically created by replacing the white spaces with -");
		verify.assertTrue(
				driver.getCurrentUrl()
						.equals(configReader.getDrupalAgileCentralURL() + "/"
								+ (articleData.getTitle().toLowerCase()).replaceAll("\\s", "-")),
				"article alias is not been created with the article title value replacing white spaces with -");
		if (driver.getCurrentUrl().equals(configReader.getDrupalAgileCentralURL() + "/"
				+ articleData.getTitle().toLowerCase().replaceAll("\\s", "-"))) {
			extentLogger.log(LogStatus.PASS,
					"Verified that the article alias is been automatically created and got the article title value by replacing white spaces with -");
		} else {
			extentLogger.log(LogStatus.FAIL,
					"article alias is not been created with the article title value replacing white spaces with -");
		}

		verify.assertAll();
		extent.endTest(extentLogger);
	}

	/**
	 * Test Case : Verify excluding an article from internet search engines
	 * using MetaTags
	 * 
	 * @throws Exception
	 */
	@Test(groups = "TC116091", priority = 34)
	public void TC116091_Verify_excluding_an_article_from_internet_search_engines_using_MetaTags() throws Exception {

		SoftAssert verify = new SoftAssert();
		logger.debug("TC116091_Verify_excluding_an_article_from_internet_search_engines_using_MetaTags Test started");
		extentLogger = extent.startTest(
				"TC116091_Verify_excluding_an_article_from_internet_search_engines_using_MetaTags Test started");
		logger.info("TC116091_Verify_excluding_an_article_from_internet_search_engines_using_MetaTags Test started");

		// Login as Doc Admin user
		userLogin.login(DataProviderClass.getDocAdminUserDetails().getUser(),
				DataProviderClass.getDocAdminUserDetails().getPw());
		extentLogger.log(LogStatus.INFO, "Logged in as doc admin user");
		ArticleData articleData = DataProviderClass.getArticleData(63);
		extentLogger.log(LogStatus.INFO, "Adding an article:" + articleData.getTitle());
		mainPage.clickContent();
		contentPage.addArticle(articleData);
		contentPage.saveAndPublish();

		// Verifying if the meta tag for no index is not added to the article
		// when meta tags option for it is disabled
		extentLogger.log(LogStatus.INFO,
				"Verifying if the meta tag for no index is not added to the article when meta tags option for it is not disabled");
		verify.assertFalse(driver.getPageSource().contains(StringConstants.NoIndexMetaTag),
				"The Meta Tag " + StringConstants.NoIndexMetaTag
						+ " is getting added to the article though meta tags option for it is disabled ");
		if (driver.getPageSource().contains(StringConstants.NoIndexMetaTag)) {
			extentLogger.log(LogStatus.FAIL, "The Meta Tag " + StringConstants.NoIndexMetaTag
					+ " is getting added to the article though meta tags option for it is disabled ");
		} else {
			extentLogger.log(LogStatus.PASS, "Verified that the Meta Tag" + StringConstants.NoIndexMetaTag
					+ " is not added to the article when meta tags option for it is not disabled");
		}

		// Enable the Meta Tags option to prevent the search engines from
		// indexing an article
		extentLogger.log(LogStatus.INFO,
				"Enable the Meta Tags option to prevent the search engines from indexing an article");
		internalUsersHomePage.editPublishedArticle();
		contentPage.preventSearchEngineFromIndexingArticle();
		contentPage.saveAndPublishForThisTranslation();

		// Verifying if the meta tag for no index is added to the article when
		// meta tags option for it is enabled
		verify.assertTrue(driver.getPageSource().contains(StringConstants.NoIndexMetaTag),
				"The Meta Tag" + StringConstants.NoIndexMetaTag + " is not found");
		if (driver.getPageSource().contains(StringConstants.NoIndexMetaTag)) {
			extentLogger.log(LogStatus.PASS, "Verified that Meta Tag " + StringConstants.NoIndexMetaTag
					+ " is added to the article when meta tags option for it is enabled");
		} else {
			extentLogger.log(LogStatus.FAIL, "The Meta Tag" + StringConstants.NoIndexMetaTag
					+ " is not added to the article though meta tags option for it is enabled");
		}

		verify.assertAll();
		extent.endTest(extentLogger);

	}

	@Test(groups = { "TC93441" }, priority = 35)
	public void TC93441_Verify_Bulk_Moderation_Updates_of_Articles() throws Exception {

		SoftAssert verify = new SoftAssert();
		logger.info("TC93441_Verify_Bulk_Moderation_Updates_of_Articles Test started");
		extentLogger = extent.startTest("TC93441_Verify_Bulk_Moderation_Updates_of_Articles Test started");
		extentLogger.log(LogStatus.INFO, "TC93441_Verify_Bulk_Moderation_Updates_of_Articles");

		// Login as Doc Admin user
		userLogin.login(DataProviderClass.getDocAdminUserDetails().getUser(),
				DataProviderClass.getDocAdminUserDetails().getPw());
		extentLogger.log(LogStatus.INFO, "Logged in as doc admin user");

		mainPage.clickContent();

		// Filtering the article which automation suite already have created.
		contentPage.filterArticle(StringConstants.ARTICLE_PREFIX);
		ArrayList<WebElement> filteredArticles = (ArrayList<WebElement>) driver
				.findElements(By.xpath(contentPage.filteredArticleTitles));
		// selecting articles to perform bulk update
		contentPage.selectArticleToPerformAction(StringConstants.ARTICLE_PREFIX);
		// Setting bulk update action as 'Publish'
		contentPage.setAction(StringConstants.SET_CONTENT_AS_PUBLISHED);
		contentPage.clickOnApplyToSelectedItems();

		// Verifying whether the bulk update message is displayed.
		extentLogger.log(LogStatus.INFO, "Verifying whether the bulk update message is displayed");
		verify.assertTrue(contentPage.isBulkUpdateMessageMessageDisplayed(filteredArticles.size(),
				StringConstants.SET_CONTENT_AS_PUBLISHED), "Bulk Update message is Not displayed");
		if (contentPage.isBulkUpdateMessageMessageDisplayed(filteredArticles.size(),
				StringConstants.SET_CONTENT_AS_PUBLISHED)) {
			extentLogger.log(LogStatus.PASS, "Bulk Update message is displayed successfully.");
		} else {
			extentLogger.log(LogStatus.FAIL, "Bulk Update message is not displayed successfully.");
		}

		extentLogger.log(LogStatus.INFO,
				"Verifying whether each and every article got updated with the bulk update states.");
		// Verifying whether each and every article got updated with the bulk
		// update states.
		ArrayList<String> states = contentPage
				.getModerationStateOfAllArticlesFromContentsPage(StringConstants.ARTICLE_PREFIX);
		verify.assertFalse(
				states.contains("Draft") || states.contains("Ready to Publish") || states.contains("Request Review")
						|| states.contains("Review Completed") || states.contains("UnPublished"),
				"One or more article's moderation state could not be updated as Published.");
		if (states.contains("Draft") || states.contains("Ready to Publish") || states.contains("Request Review")
				|| states.contains("Review Completed") || states.contains("UnPublished")) {
			extentLogger.log(LogStatus.FAIL,
					"One or more article's moderation state could not be updated as Published.");
		} else {
			extentLogger.log(LogStatus.PASS, "Every article's moderation state is updated as Published.");
		}

		verify.assertAll();
		extent.endTest(extentLogger);
	}

	@Test(groups = { "TC127023" }, priority = 36)
	public void TC127023_Verify_Cache_Control_Headers_Of_Home_Page_For_English_Anonymous_User() throws IOException {

		SoftAssert verify = new SoftAssert();
		logger.info("TC127023_Verify_Cache_Control_Headers_Of_Home_Page_For_English_And_Anonymous_User Test started");
		extentLogger = extent.startTest("TC127023_Verify_Cache_Control_Headers_Of_Home_Page_For_English_And_Anonymous_User Test started");
		extentLogger.log(LogStatus.INFO, "TC127023_Verify_Cache_Control_Headers_Of_Home_Page_For_English_And_Anonymous_User");

		driver.navigate().to(configReader.getAgileCentralHome());
		URL url = null;
		String HeaderFieldValue = null;
		// Verifying cache control header at the Home page for English Language
		try {

			url = new URL(configReader.getAgileCentralHome());
			URLConnection conn = url.openConnection();
			HeaderFieldValue = conn.getHeaderField(StringConstants.HEADER_FIELD);

			verify.assertTrue(HeaderFieldValue.contains("public"),
					"Cache Control Header of the Home page for Annonymous users in English language does not contain 'public' keyword.");
			if (HeaderFieldValue.contains("public")) {
				extentLogger.log(LogStatus.PASS,
						"Verified that Cache Control Header of the Home page for Annonymous users in English language contains 'public' keyword and displayed as: "
								+ HeaderFieldValue);
			} else {
				extentLogger.log(LogStatus.FAIL,
						"Cache Control Header of the Home page for Annonymous users in English language does not contain 'public' keyword and displayed as: "
								+ HeaderFieldValue);
			}

		} catch (IOException e) {
			extentLogger.log(LogStatus.ERROR, "Exception at Home Page for Annonymous users in english language: " + e);
			logger.error("Exception at Home Page for Annonymous users in english language: ", e);
		}
		
		verify.assertAll();
		extent.endTest(extentLogger);

	}

	@Test(groups = { "TC127044" }, priority = 37)
	public void TC127044_Verify_Cache_Control_Headers_Of_Home_Page_For_Japanese_Anonymous_User(){
		
		SoftAssert verify = new SoftAssert();
		logger.info("TC127044_Verify_Cache_Control_Headers_Of_Home_Page_For_Japanese_Anonymous_User Test started");
		extentLogger = extent.startTest("TC127044_Verify_Cache_Control_Headers_Of_Home_Page_For_Japanese_Anonymous_User Test started");
		extentLogger.log(LogStatus.INFO, "TC127044_Verify_Cache_Control_Headers_Of_Home_Page_For_Japanese_Anonymous_User");

		driver.navigate().to(configReader.getAgileCentralHome());
		URL url = null;
		String HeaderFieldValue = null;
		
		try {

			url = new URL(configReader.getDrupalBaseURL() + "/" + StringConstants.JAPANESE_LOCALE
					+ configReader.getValue("ac_home"));

			URLConnection conn = url.openConnection();
			HeaderFieldValue = conn.getHeaderField(StringConstants.HEADER_FIELD);
			verify.assertTrue(HeaderFieldValue.contains("public"),
					"Cache Control Header of the Home page for Annonymous users in Japanese language does not contain 'public' keyword.");
			if (HeaderFieldValue.contains("public")) {
				extentLogger.log(LogStatus.PASS,
						"Verified that Cache Control Header of the Home page for Annonymous users in Japanese contains 'public' keyword and displayed as: "
								+ HeaderFieldValue);
			} else {
				extentLogger.log(LogStatus.FAIL,
						"Cache Control Header of the Home page for Annonymous users in Japanese does not contain 'public' keyword and displayed as: "
								+ HeaderFieldValue);
			}

		} catch (IOException e) {
			extentLogger.log(LogStatus.ERROR, "Exception at Home Page for Annonymous users in japanese language: " + e);
			logger.error("Exception at Home Page for Annonymous users in japanese language: ", e);
		}
		
		verify.assertAll();
		extent.endTest(extentLogger);
		
	}
	
	@Test(groups = { "TC127045"}, priority = 38)
	public void TC127045_Verify_Cache_Control_Headers_Of_SearchResult_Page_For_Japanese_Anonymous_User(){
		
		SoftAssert verify = new SoftAssert();
		logger.info("TC127045_Verify_Cache_Control_Headers_Of_SearchResult_Page_For_Japanese_Anonymous_User Test started");
		extentLogger = extent.startTest("TC127045_Verify_Cache_Control_Headers_Of_SearchResult_Page_For_Japanese_Anonymous_User Test started");
		extentLogger.log(LogStatus.INFO, "TC127045_Verify_Cache_Control_Headers_Of_SearchResult_Page_For_Japanese_Anonymous_User");
		
		driver.navigate().to(configReader.getAgileCentralHome());
		URL url = null;
		String HeaderFieldValue = null;
		SearchData searchData = DataProviderClass.getSearchData(11);
		extentLogger.log(LogStatus.INFO, "Seaching the Keyword: " + searchData.getKeyword());

		try {
			driver.navigate().to(configReader.getAgileCentralHome());
			homePage.filterSearchKeyword(searchData.getKeyword());
			String SearchURL = driver.getCurrentUrl();

			url = new URL(SearchURL);
			URLConnection conn = url.openConnection();
			HeaderFieldValue = conn.getHeaderField(StringConstants.HEADER_FIELD);

			verify.assertTrue(HeaderFieldValue.contains("public"),
					"Cache Control Header at the search result page for Annonymous users for english does not contain 'public' keyword.");
			if (HeaderFieldValue.contains("public")) {
				extentLogger.log(LogStatus.PASS,
						"Verified that Cache Control Header at the search result page for Annonymous users for english contains 'public' keyword and displayed as: "
								+ HeaderFieldValue);
			} else {
				extentLogger.log(LogStatus.FAIL,
						"Cache Control Header at the search result page for Annonymous users for english does not contain 'public' keyword and displayed as: "
								+ HeaderFieldValue);
			}

		} catch (IOException | InterruptedException e) {
			extentLogger.log(LogStatus.ERROR,
					"Exception at search page for Annonymous users for english language: " + e);
			logger.error("Exception at search page for Annonymous users for english language: ", e);
		}
		
		verify.assertAll();
		extent.endTest(extentLogger);
	}
	
	@Test(groups = { "TC127277" }, priority = 39)
	public void TC127277_Verify_Cache_Control_Headers_Of_SearchResult_Page_For_Japanese_LoggedIn_User(){
		
		SoftAssert verify = new SoftAssert();
		logger.info("TC127277_Verify_Cache_Control_Headers_Of_SearchResult_Page_For_Japanese_LoggedIn_User");
		extentLogger = extent.startTest("TC127277_Verify_Cache_Control_Headers_Of_SearchResult_Page_For_Japanese_LoggedIn_User Test started");
		extentLogger.log(LogStatus.INFO, "TC127277_Verify_Cache_Control_Headers_Of_SearchResult_Page_For_Japanese_LoggedIn_User");

		driver.navigate().to(configReader.getAgileCentralHome());
	
		extentLogger.log(LogStatus.INFO, "Verifying cache header for LoggedIn users");
		String Chacheheader = GetHeaderForLoggedInUser.getCacheControlHeaderForLoggedInUsers(configReader.getDrupalLoginURL(), configReader.getAgileCentralHome());
		
		//verifying whether the Cache control header is contains 'no-cache'
		verify.assertTrue(Chacheheader.contains("no-cache"),
				"Cache Control Header at home page for LoggedIn users for english does not contain 'no-cache' keyword.");
		if (Chacheheader.contains("no-cache")) {
			extentLogger.log(LogStatus.PASS,
					"Verified that Cache Control Header at home page for LoggedIn users for english contains 'no-cache' keyword and displayed as: "
							+ Chacheheader);
		} else {
			extentLogger.log(LogStatus.FAIL,
					"Cache Control Header at home page for LoggedIn users for english does not contain 'no-cache' keyword and displayed as: "
							+ Chacheheader);
		}

		verify.assertAll();
		extent.endTest(extentLogger);

	}
}
