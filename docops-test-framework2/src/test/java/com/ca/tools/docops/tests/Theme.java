package com.ca.tools.docops.tests;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import com.ca.tools.docops.dtos.ArticleData;
import com.ca.tools.docops.dtos.SearchData;
import com.ca.tools.docops.utils.DataProviderClass;
import com.ca.tools.docops.utils.StringConstants;
import com.relevantcodes.extentreports.LogStatus;

public class Theme extends BaseTest {

	public static final Logger logger = Logger.getLogger(Theme.class);

	@Test(groups = { "TC93921" }, enabled = true, priority = 1)
	public void TC93921_Verify_Redirection_When_Clicked_On_CA_Logo() throws Exception {

		SoftAssert verify = new SoftAssert();

		logger.info("Test Redirection when Clicked on CA Logo");
		extentLogger = extent.startTest("TC93921_Verify_Redirection_When_Clicked_On_CA_Logo");
		extentLogger.log(LogStatus.INFO, "TC93921 Verify Redirection When Clicked On CA Logo");
		extentLogger.log(LogStatus.INFO, "Logged Out and Navigating to Home page of Agile Central doc site.");
		// Login as customer
		userLogin.login(DataProviderClass.getCustomerUserDetails().getUser(),
				DataProviderClass.getCustomerUserDetails().getPw());
		extentLogger.log(LogStatus.INFO, "Loggedin as a customer");

		// Getting the data from Excel to access an article.
		ArticleData articleData = DataProviderClass.getArticleData(30);
		extentLogger.log(LogStatus.INFO, "Accessing an article through direct URL Alias :" + articleData.getTitle());
		internalUsersHomePage.accessArticleWithUrlAlias(articleData.getUrlAlias());
		extentLogger.log(LogStatus.INFO, "Clicking on CA Logo");

		// Clicking on CA Logo.
		homePage.clickOnCALogo();

		String CurrentURLOfThePage = driver.getCurrentUrl();
		extentLogger.log(LogStatus.INFO, "Redirected URL of the page is: " + CurrentURLOfThePage);
		extentLogger.log(LogStatus.INFO, "Actual Home page is: " + configReader.getAgileCentralHome());
		// Verifying URL Redirection
		extentLogger.log(LogStatus.INFO, "Verifying the Redirection through current URL of the page.");
		verify.assertEquals(CurrentURLOfThePage.equalsIgnoreCase(configReader.getAgileCentralHome()), true,
				"Redirected page should be Home page of Agile Central");

		if (CurrentURLOfThePage.equalsIgnoreCase(configReader.getAgileCentralHome())) {
			extentLogger.log(LogStatus.PASS,
					"Verified that redirected page is Home page of Agile Central when clicked on CA Logo.");
		} else {
			extentLogger.log(LogStatus.FAIL,
					"Redirected page is not the Home page of Agile Central when clicked on CA Logo.");
		}

		verify.assertAll();
		extent.endTest(extentLogger);

	}

	@Test(groups = { "TC93923" }, enabled = true, priority = 2)
	public void TC93923_Verify_Redirection_When_Clicked_On_Product_Name() throws Exception {

		SoftAssert verify = new SoftAssert();

		logger.info("Test Redirection when Clicked on CA Agile Central");
		extentLogger = extent.startTest("TC93923_Verify_Redirection_When_Clicked_On_CA_Agile_Central");
		extentLogger.log(LogStatus.INFO, "TC93923 Verify Redirection When Clicked On CA Agile Central");
		extentLogger.log(LogStatus.INFO,
				"Logged Out from Admin view and Navigating to Home page of Agile Central doc site.");

		// Login as customer
		userLogin.login(DataProviderClass.getCustomerUserDetails().getUser(),
				DataProviderClass.getCustomerUserDetails().getPw());
		extentLogger.log(LogStatus.INFO, "Loggedin as a customer");
		// Getting the data from Excel to access an article.
		ArticleData articleData = DataProviderClass.getArticleData(30);
		extentLogger.log(LogStatus.INFO, "Accessing an article through direct URL Alias :" + articleData.getTitle());
		internalUsersHomePage.accessArticleWithUrlAlias(articleData.getUrlAlias());
		// Clicking on Product Name (CA Agile Central)
		extentLogger.log(LogStatus.INFO, "Clicking on CA Agil Central");
		homePage.clickOnProductHeading();

		String CurrentURLOfThePage = driver.getCurrentUrl();
		// Verifying URL Redirection
		extentLogger.log(LogStatus.INFO, "Verifying the Redirection through current URL of the page.");
		verify.assertEquals(CurrentURLOfThePage.equalsIgnoreCase(configReader.getAgileCentralHome()), true,
				"Redirected page should be Home page of Agile Central");
		if (CurrentURLOfThePage.equalsIgnoreCase(configReader.getAgileCentralHome())) {
			extentLogger.log(LogStatus.PASS,
					"Verified that redirected page is Home page of Agile Central when clicked on Product name.");
		} else {
			extentLogger.log(LogStatus.FAIL,
					"Redirected page is not the Home page of Agile Central when clicked on Product name.");
		}

		verify.assertAll();
		extent.endTest(extentLogger);
	}

	@Test(groups = { "TC93924" }, enabled = true, priority = 3)
	public void TC93924_Verify_Redirection_When_Clicked_On_Home_Link() throws Exception {

		SoftAssert verify = new SoftAssert();

		logger.info("Test Redirection When Clicked On Home Link");
		extentLogger = extent.startTest("TC93924_Verify_Redirection_When_Clicked_On_Home_Link");
		extentLogger.log(LogStatus.INFO, "TC93924 Verify Redirection When Clicked On Home Link");
		extentLogger.log(LogStatus.INFO,
				"Logged Out from Admin view and Navigating to Home page of Agile Central doc site.");

		// Login as customer
		userLogin.login(DataProviderClass.getCustomerUserDetails().getUser(),
				DataProviderClass.getCustomerUserDetails().getPw());
		extentLogger.log(LogStatus.INFO, "Loggedin as a customer");
		// Getting the data from Excel to access an article.
		ArticleData articleData = DataProviderClass.getArticleData(30);
		extentLogger.log(LogStatus.INFO, "Accessing an article through direct URL Alias :" + articleData.getTitle());
		internalUsersHomePage.accessArticleWithUrlAlias(articleData.getUrlAlias());
		// Clicking on Product Name (CA Agile Central)
		extentLogger.log(LogStatus.INFO, "Clicking on Home Link in BreadCrumbs");
		homePage.clickOnHomeBreadCrumb();

		String CurrentURLOfThePage = driver.getCurrentUrl();
		// Verifying URL Redirection
		extentLogger.log(LogStatus.INFO, "Verifying the Redirection through current URL of the page.");
		verify.assertEquals(CurrentURLOfThePage.equalsIgnoreCase(configReader.getAgileCentralHome()), true,
				"Redirected page should be Home page of Agile Central");
		if (CurrentURLOfThePage.equalsIgnoreCase(configReader.getAgileCentralHome())) {
			extentLogger.log(LogStatus.PASS,
					"Verified that redirected page is Home page of Agile Central when clicked on Home Link");
		} else {
			extentLogger.log(LogStatus.FAIL,
					"Redirected page is not the Home page of Agile Central when clicked on Home Link.");
		}

		verify.assertAll();
		extent.endTest(extentLogger);

	}

	@Test(groups = { "TC101416" }, enabled = true, priority = 4)
	public void TC101416_Verify_Expand_And_Collapse_Links_in_ToC() throws Exception {

		SoftAssert verify = new SoftAssert();
		logger.info("Verify ToC can Be Expand and Collapse");
		extentLogger = extent.startTest("TC101416_Verify_ToC_Can_be_Expand_And_Collapse");
		extentLogger.log(LogStatus.INFO, "Verify ToC can Be Expand and Collapse");
		// Login as Doc Admin user to add an Article
		userLogin.login(DataProviderClass.getDocAdminUserDetails().getUser(),
				DataProviderClass.getDocAdminUserDetails().getPw());
		extentLogger.log(LogStatus.INFO, "Loggedin as a Doc Admin user");
		// Getting the data from Excel to Add an article.
		ArticleData articleParent = DataProviderClass.getArticleData(31);
		extentLogger.log(LogStatus.INFO, "Adding a parent Article as: " + articleParent.getTitle());
		mainPage.clickContent();
		contentPage.addArticle(articleParent);
		contentPage.saveAndPublish();

		// Getting the data from Excel to Add a child article to above added
		// article.
		ArticleData articleChild = DataProviderClass.getArticleData(32);
		extentLogger.log(LogStatus.INFO, "Adding a child Article as: " + articleChild.getTitle());
		mainPage.clickContent();
		contentPage.addArticle(articleChild);
		contentPage.saveAndPublish();

		// Logging Out from DocAdmin Control
		internalUsersHomePage.logOutAndCleanCookies(userLogin);
		extentLogger.log(LogStatus.INFO, "Logged Out from DocAdmin controls and Logging in as customer");

		// Login as customer
		userLogin.login(DataProviderClass.getCustomerUserDetails().getUser(),
				DataProviderClass.getCustomerUserDetails().getPw());

		extentLogger.log(LogStatus.INFO,
				"In ToC Clicking on Expand link of added parent Aricle: " + articleParent.getMenuLinkTitle());
		// Clicking on Expand Icon
		driver.navigate().to(configReader.getAgileCentralHome());
		homePage.clickOnExpandCollpase(articleParent.getMenuLinkTitle());
		extentLogger.log(LogStatus.INFO, "Verifying after cliking the expand icon whether it gets Expand or collapsed");
		// Verifying whether icon got clicked
		verify.assertEquals(homePage.VerifyIfExpanded(articleParent.getMenuLinkTitle()), true);

		if (homePage.VerifyIfExpanded(articleParent.getMenuLinkTitle())) {
			extentLogger.log(LogStatus.PASS, "Verified that ToC is Expanded.");
		} else {
			extentLogger.log(LogStatus.FAIL, "Verified that ToC is NOT Expanded.");
		}

		if (homePage.VerifyIfCollapsed(articleParent.getMenuLinkTitle())) {
			extentLogger.log(LogStatus.FAIL, "Verified that ToC is Collapsed.");
		} else {
			extentLogger.log(LogStatus.PASS, "Verified that ToC is NOT Collapsed");
		}

		// Again Clicking on Expand Icon
		extentLogger.log(LogStatus.INFO,
				"In ToC Again Clicking on Expand link of particular Aricle: " + articleParent.getMenuLinkTitle());
		homePage.clickOnExpandCollpase(articleParent.getMenuLinkTitle());

		// Verifying whether Expand icon got clicked.
		verify.assertEquals(homePage.VerifyIfCollapsed(articleParent.getMenuLinkTitle()), true);

		if (homePage.VerifyIfExpanded(articleParent.getMenuLinkTitle())) {
			extentLogger.log(LogStatus.FAIL, "Verified that ToC is Expanded.");
		} else {
			extentLogger.log(LogStatus.PASS, "Verified that ToC is NOT Expanded.");
		}

		if (homePage.VerifyIfCollapsed(articleParent.getMenuLinkTitle())) {
			extentLogger.log(LogStatus.PASS, "Verified that ToC is Collapsed.");
		} else {
			extentLogger.log(LogStatus.FAIL, "Verified that ToC is NOT Collapsed");
		}

		verify.assertAll();
		extent.endTest(extentLogger);
	}

	@Test(groups = { "TC101485" }, enabled = true, priority = 5)
	public void TC101485_Verify_Header_And_Footer_Is_Displayed() {

		SoftAssert verify = new SoftAssert();

		logger.info("Verify Header and Footer is Displayed");
		extentLogger = extent.startTest("TC101485_Verify_Header_And_Footer_Is_Displayed");
		extentLogger.log(LogStatus.INFO, "Verify Header and Footer is Displayed");

		// Login as internal user
		userLogin.login(DataProviderClass.getDocAdminUserDetails().getUser(),
				DataProviderClass.getDocAdminUserDetails().getPw());
		extentLogger.log(LogStatus.INFO, "Loggedin as a Doc Admin user");
		// Navigating to Home Page.
		driver.navigate().to(configReader.getAgileCentralHome());
		extentLogger.log(LogStatus.INFO, "Navigated to Home Page.");
		extentLogger.log(LogStatus.INFO, "Verifying whether Header is Displayed");

		// Verifying whether Header is Displayed
		verify.assertTrue(homePage.VerifyHeaderDisplayed(), "Header should be displayed at the page.");
		if (homePage.VerifyHeaderDisplayed()) {
			extentLogger.log(LogStatus.PASS, "Verified that Header is Displayed");
		} else {
			extentLogger.log(LogStatus.FAIL, "Header is not Displayed");
		}

		extentLogger.log(LogStatus.INFO, "Verifying whether Footer is Displayed");
		// Verifying whether Footer is Displayed
		verify.assertTrue(homePage.VerifyFooterDisplayed(), "Footer should be displayed at the page.");
		if (homePage.VerifyFooterDisplayed()) {
			extentLogger.log(LogStatus.PASS, "Verified that Footer is Displayed");
		} else {
			extentLogger.log(LogStatus.FAIL, "Footer is not Displayed");
		}

		internalUsersHomePage.logOutAndCleanCookies(userLogin);
		// Login as customer
		userLogin.login(DataProviderClass.getCustomerUserDetails().getUser(),
				DataProviderClass.getCustomerUserDetails().getPw());
		extentLogger.log(LogStatus.INFO,
				"Logging out from Admin control and Verifying display of Header and Footer in Customer view.");
		extentLogger.log(LogStatus.INFO, "Verifying whether Header is Displayed");

		// Verifying whether Header is Displayed
		driver.navigate().to(configReader.getAgileCentralHome());
		verify.assertTrue(homePage.VerifyHeaderDisplayed(), "Header should be displayed at the page.");
		if (homePage.VerifyHeaderDisplayed()) {
			extentLogger.log(LogStatus.PASS, "Verified that Header is Displayed in customer view");
		} else {
			extentLogger.log(LogStatus.FAIL, "Header is not Displayed in customer view");
		}

		extentLogger.log(LogStatus.INFO, "Verifying whether Footer is Displayed");
		// Verifying whether Footer is Displayed
		verify.assertTrue(homePage.VerifyFooterDisplayed(), "Footer should be displayed at the page.");
		if (homePage.VerifyFooterDisplayed()) {
			extentLogger.log(LogStatus.PASS, "Verified that Footer is Displayed in customer view");
		} else {
			extentLogger.log(LogStatus.FAIL, "Footer is not Displayed in customer view");
		}

		verify.assertAll();
		extent.endTest(extentLogger);
	}

	@Test(groups = { "TC101486" }, enabled = true, priority = 6)
	public void TC101486_Verify_Tool_Bar_Is_Displayed_For_LoggedIn_Users() {

		SoftAssert verify = new SoftAssert();

		logger.info("Verify Tool bar is Displayed for LoggedIn users");
		extentLogger = extent.startTest("TC101486_Verify_Tool_Bar_Is_Displayed_For_LoggedIn_Users");
		extentLogger.log(LogStatus.INFO, "Verify Tool bar is Displayed for LoggedIn users");

		// Logging in As DocAdmin
		userLogin.login(DataProviderClass.getDocAdminUserDetails().getUser(),
				DataProviderClass.getDocAdminUserDetails().getPw());
		extentLogger.log(LogStatus.INFO, "Logged in as Doc Admin");

		// Navigating to Home Page.
		driver.navigate().to(configReader.getAgileCentralHome());
		extentLogger.log(LogStatus.INFO, "Navigated to Home Page.");

		// Verifying whether Tool bar is Displayed for Admin control
		extentLogger.log(LogStatus.INFO, "Verifying whether Tool bar is Displayed for Admin user");

		verify.assertTrue(homePage.VerifyToolBarDisplayed(), "Toolbar should be displayed for Admin user");
		if (homePage.VerifyToolBarDisplayed()) {
			extentLogger.log(LogStatus.PASS, "Toolbar is displayed successfully for Admin user");
		} else {
			extentLogger.log(LogStatus.FAIL, "Toolbar is Not displayed for Admin user");
		}

		verify.assertAll();
		extent.endTest(extentLogger);

	}

	@Test(groups = { "TC101487" }, enabled = true, priority = 7)
	public void TC101487_Verify_Tool_Bar_Is_Displayed_For_Customer_Users() {

		SoftAssert verify = new SoftAssert();

		logger.info("Verify Tool bar is Displayed for customer users");
		extentLogger = extent.startTest("TC101487_Verify_Tool_Bar_Is_Displayed_For_customer_Users");
		extentLogger.log(LogStatus.INFO, "Verify Tool bar is Displayed for customer users");

		// Logging in As customer
		userLogin.login(DataProviderClass.getCustomerUserDetails().getUser(),
				DataProviderClass.getCustomerUserDetails().getPw());
		extentLogger.log(LogStatus.INFO, "Logged in as Customer");

		// Navigating to Home Page.
		driver.navigate().to(configReader.getAgileCentralHome());
		extentLogger.log(LogStatus.INFO, "Navigated to Home Page.");

		// Verifying whether Tool bar is Displayed for customer Users.
		driver.navigate().to(configReader.getAgileCentralHome());
		extentLogger.log(LogStatus.INFO, "Verifying whether Toolbar is Displayed for Customer users.");

		verify.assertFalse(homePage.VerifyToolBarDisplayed(), "Toolbar should not be displayed for customer user.");
		if (homePage.VerifyToolBarDisplayed()) {
			extentLogger.log(LogStatus.FAIL, "Toolbar is displayed for customer user successfully.");
		} else {
			extentLogger.log(LogStatus.PASS, "Toolbar is Not displayed for customer user.");
		}

		verify.assertAll();
		extent.endTest(extentLogger);

	}

	@Test(groups = { "TC102623" }, enabled = true, priority = 8)
	public void TC102623_Verify_Whether_Selected_Article_Is_Highlighted_In_ToC() throws Exception {

		logger.info("Verify Whether Selected Article is Highlighted in ToC");
		extentLogger = extent.startTest("TC102623_Verify_Whether_Selected_Article_Is_Highlighted_In_ToC");
		extentLogger.log(LogStatus.INFO, "Verify Whether Selected Article is Highlighted in ToC");

		// Adding an Article
		userLogin.login(DataProviderClass.getDocAdminUserDetails().getUser(),
				DataProviderClass.getDocAdminUserDetails().getPw());
		extentLogger.log(LogStatus.INFO, "Logged in as Doc Admin");
		driver.navigate().to(configReader.getAgileCentralHome());

		ArticleData article = DataProviderClass.getArticleData(33);
		extentLogger.log(LogStatus.INFO, "Adding an article:" + article.getTitle());
		mainPage.clickContent();
		contentPage.addArticle(article);
		contentPage.saveAndPublish();
		internalUsersHomePage.logOutAndCleanCookies(userLogin);

		// Logging in As customer
		userLogin.login(DataProviderClass.getCustomerUserDetails().getUser(),
				DataProviderClass.getCustomerUserDetails().getPw());
		extentLogger.log(LogStatus.INFO, "Loggedout from Doc Admin controls and Loggedin as a customer");
		// Accessing an article which we have added.
		extentLogger.log(LogStatus.INFO, "Accessing an article which user has added.");
		driver.navigate().to(configReader.getAgileCentralHome());
		homePage.accessToCArticle(article.getMenuLinkTitle());
		// Retrieving the class attribute of the accessed article.
		extentLogger.log(LogStatus.INFO, "Retrieving the class attribute of the accessed article.");
		String ClassAttribute = homePage.getArticleAttribute(article.getMenuLinkTitle(), "class");
		extentLogger.log(LogStatus.INFO, "Accessed articles class attribute is: " + ClassAttribute);
		// Verifying whether the accessed article menu title is Highlighted.
		extentLogger.log(LogStatus.INFO, "Verifying whether the accessed article menu title is Highlighted.");
		if (ClassAttribute.contains("is-active")) {
			extentLogger.log(LogStatus.PASS, "Verified that Article's menu link is highlighted while accessing it.");
		} else {
			extentLogger.log(LogStatus.FAIL, "Article's menu link is not highlighted while accessing it.");
		}
		Assert.assertTrue(ClassAttribute.contains("is-active"), "Article should be highlighted while accessing.");

		extent.endTest(extentLogger);
	}

	@Test(groups = { "TC108020" }, enabled = true, priority = 9)
	public void TC108020_ToC_Breadcrumbs_Hierarchy() throws Exception {

		SoftAssert verify = new SoftAssert();

		logger.info("Test Verify BreadCrumb links heirarchy is started.");
		extentLogger = extent.startTest("TC108020_Verify_BreadCrumbs_heirarchy_links");
		extentLogger.log(LogStatus.INFO, "TC108020 Verify BreadCrumbs links heirarchy is started.");

		// Login as DocAdmin
		userLogin.login(DataProviderClass.getDocAdminUserDetails().getUser(),
				DataProviderClass.getDocAdminUserDetails().getPw());
		extentLogger.log(LogStatus.INFO, "Logged in as DocAdmin");
		// Create articles
		ArticleData grandParentArticle = DataProviderClass.getArticleData(34);
		ArticleData parentArticle = DataProviderClass.getArticleData(35);
		ArticleData childArticle = DataProviderClass.getArticleData(36);

		for (int i = 34; i <= 36; i++) {
			ArticleData articleData = DataProviderClass.getArticleData(i);
			mainPage.clickContent();
			contentPage.addArticle(articleData);
			contentPage.saveAndPublish();
			// Verify that the article is created
			verify.assertTrue(internalUsersHomePage.isArticleCreatedMessageDisplayed(articleData.getTitle()));
			extentLogger.log(LogStatus.INFO, "The article is created and published: " + articleData.getTitle());
		}

		// Getting the article's Parent from ToC.
		String ParentOfChild = internalUsersHomePage.getParentArticleMenuLinkTitle(childArticle.getMenuLinkTitle());
		String GrandParentOfChild = internalUsersHomePage
				.getGrandParentArticleMenuLinkTitle(childArticle.getMenuLinkTitle());

		// Verify that the article should have 3 links in the bread crumbs
		// including Home, Grand parent and parent when accessed the child
		// article
		extentLogger.log(LogStatus.INFO,
				"Verify that the article should have 3 links in the bread crumbs including Home, Grand parent and parent when accessed the child article");
		verify.assertTrue(internalUsersHomePage.getBreadCrumCount() == 3, "Breadcrumb count should be 3");
		if (internalUsersHomePage.getBreadCrumCount() == 3) {
			extentLogger.log(LogStatus.PASS, "Verified that breadcrumb links count is displayed as: "
					+ internalUsersHomePage.getBreadCrumCount());
		} else {
			extentLogger.log(LogStatus.FAIL, "Breadcrumb count is not equal to 3");
		}

		// Verify the first breadcrumb item is Home
		verify.assertTrue("Home".equals(internalUsersHomePage.getBreadCrumText(0)),
				"First Breadcrumb Link should be Home");
		if ("Home".equals(internalUsersHomePage.getBreadCrumText(0))) {
			extentLogger.log(LogStatus.PASS, "Verified that First Breadcrumb Link is Home and displayed as: "
					+ internalUsersHomePage.getBreadCrumText(0));
		} else {
			extentLogger.log(LogStatus.FAIL,
					"First Breadcrumb Link is not 'Home' and it is: " + internalUsersHomePage.getBreadCrumText(0));
		}

		// Verify the Second breadcrumb item should be Grand Prent item of child
		verify.assertTrue(GrandParentOfChild.equals(internalUsersHomePage.getBreadCrumText(1)),
				"Second Breadcrumb Link should be :" + GrandParentOfChild);
		if (GrandParentOfChild.equals(internalUsersHomePage.getBreadCrumText(1))) {
			extentLogger.log(LogStatus.PASS, "Second Breadcrumb Link is grand Parent item and displayed as: "
					+ internalUsersHomePage.getBreadCrumText(1));
		} else {
			extentLogger.log(LogStatus.FAIL, "Second Breadcrumb Link is not grand Parent item and displayed as: "
					+ internalUsersHomePage.getBreadCrumText(1));
		}

		// Verify the Third breadcrumb item should be Parent item
		verify.assertTrue(ParentOfChild.equals(internalUsersHomePage.getBreadCrumText(2)),
				"Third Breadcrumb Link should be :" + ParentOfChild);
		if (ParentOfChild.equals(internalUsersHomePage.getBreadCrumText(2))) {
			extentLogger.log(LogStatus.PASS, "Third Breadcrumb Link is Parent item and displayed as:"
					+ internalUsersHomePage.getBreadCrumText(2));
		} else {
			extentLogger.log(LogStatus.FAIL, "Third Breadcrumb Link is not Parent item and displayed as:"
					+ internalUsersHomePage.getBreadCrumText(2));
		}

		verify.assertAll();
		extent.endTest(extentLogger);

	}

	@Test(groups = { "TC107564" }, enabled = true, priority = 10)
	public void TC107564_Search_box_should_Display() throws Exception {

		SoftAssert verify = new SoftAssert();

		logger.info("Test Verify_Display_Of_Search_Box is started.");
		extentLogger = extent.startTest("TC107564_Verify_Display_Of_Search_Box");
		extentLogger.log(LogStatus.INFO, "TC107564 Verify_Display_Of_Search_Box.");

		// Login as Doc Admins
		userLogin.login(DataProviderClass.getDocAdminUserDetails().getUser(),
				DataProviderClass.getDocAdminUserDetails().getPw());
		extentLogger.log(LogStatus.INFO, "Logged in as DocAdmin");
		driver.navigate().to(configReader.getAgileCentralHome());
		extentLogger.log(LogStatus.INFO,
				"Verifying whether Search text box and Icon is displayed on Home page for Doc Admins");

		// Verify whether Search TextBox is displayed on the home page for Doc
		// Admins..
		verify.assertTrue(internalUsersHomePage.isSearchFieldDisplayed(),
				"Search TextBox should display on Home page for Doc Admins.");
		if (internalUsersHomePage.isSearchFieldDisplayed()) {
			extentLogger.log(LogStatus.INFO, "Search TextBox field is displayed successfuly for Doc Admins.");
		} else {
			extentLogger.log(LogStatus.FAIL, "Search TextBox field is Not displayed for Doc Admins.");
		}

		// Verify whether Search Icon is displayed on the home page for Doc
		// Admins..
		verify.assertTrue(internalUsersHomePage.isSearchIcondDisplayed(),
				"Search Icon should display on Home page for Doc Admins.");
		if (internalUsersHomePage.isSearchIcondDisplayed()) {
			extentLogger.log(LogStatus.INFO, "Search Icon field is displayed successfuly for Doc Admins.");
		} else {
			extentLogger.log(LogStatus.FAIL, "Search Icon field is Not displayed for Doc Admins.");
		}
		internalUsersHomePage.logOutAndCleanCookies(userLogin);
		// Login as customer
		userLogin.login(DataProviderClass.getCustomerUserDetails().getUser(),
				DataProviderClass.getCustomerUserDetails().getPw());
		extentLogger.log(LogStatus.INFO, "Loggedout from DocAdmin and Logged in as Customer");
		extentLogger.log(LogStatus.INFO,
				"Verifying whether Search text box nad Icon is displayed on Home page for Customers");
		driver.navigate().to(configReader.getAgileCentralHome());

		// Verify whether Search TextBox is displayed on the home page for
		// customers.
		verify.assertTrue(internalUsersHomePage.isSearchFieldDisplayed(),
				"Search TextBox should display on Home page for customers.");
		if (internalUsersHomePage.isSearchFieldDisplayed()) {
			extentLogger.log(LogStatus.INFO, "Search TextBox field is displayed successfuly for customers.");
		} else {
			extentLogger.log(LogStatus.FAIL, "Search TextBox field is Not displayed for customers.");
		}

		// Verify whether Search Icon is displayed on the home page for
		// customers.
		verify.assertTrue(internalUsersHomePage.isSearchIcondDisplayed(),
				"Search Icon should display on Home page for customers.");
		if (internalUsersHomePage.isSearchIcondDisplayed()) {
			extentLogger.log(LogStatus.INFO, "Search Icon field is displayed successfuly for customers.");
		} else {
			extentLogger.log(LogStatus.FAIL, "Search Icon field is Not displayed for customers.");
		}

		verify.assertAll();
		extent.endTest(extentLogger);
	}

	@Test(groups = { "TC108018" }, enabled = true, priority = 11)
	public void TC108018_Diaplay_Of_Edit_Buttons() throws Exception {

		SoftAssert verify = new SoftAssert();

		logger.info("TC108018_Test Verify Diaplay_Of_Edit_Button is started.");
		extentLogger = extent.startTest("TC108018 Diaplay_Of_Edit_Button");
		extentLogger.log(LogStatus.INFO, "TC108018 Diaplay_Of_Edit_Button is started.");
		// Login as DocAdmin
		userLogin.login(DataProviderClass.getDocAdminUserDetails().getUser(),
				DataProviderClass.getDocAdminUserDetails().getPw());
		extentLogger.log(LogStatus.INFO, "Logged In as DocAdmin");
		// Create articles
		extentLogger.log(LogStatus.INFO, "Creating an article");
		ArticleData articleData = DataProviderClass.getArticleData(37);
		driver.navigate().to(configReader.getAgileCentralHome());
		mainPage.clickContent();
		contentPage.addArticle(articleData);
		contentPage.saveArticleAsDraft();
		// Verify that the article is created
		verify.assertTrue(internalUsersHomePage.isArticleCreatedMessageDisplayed(articleData.getTitle()),
				"Article creation message should be displayed as expected.");
		if (internalUsersHomePage.isArticleCreatedMessageDisplayed(articleData.getTitle())) {
			extentLogger.log(LogStatus.PASS, "Verified that Article creation message is displayed successfuly.");
		} else {
			extentLogger.log(LogStatus.FAIL, "Verified that Article creation message is Not displayed.");
		}

		extentLogger.log(LogStatus.INFO, "Verifying Edit buttons are displayed on the article page");

		// Verify View Link is displayed on the page
		verify.assertTrue(internalUsersHomePage.isViewLinkDisplayed(),
				"View Link Button should displayed on the Article view page");
		if (internalUsersHomePage.isViewLinkDisplayed()) {
			extentLogger.log(LogStatus.PASS, "View Link Button is displayed successfuly.");
		} else {
			extentLogger.log(LogStatus.FAIL, "View Link Button is Not displayed.");
		}

		// Verify Edit Draft Link is displayed on the page
		verify.assertTrue(internalUsersHomePage.isEditDraftLinkDisplayed(),
				"Edit Draft Link Button should displayed on the Article view page");
		if (internalUsersHomePage.isEditDraftLinkDisplayed()) {
			extentLogger.log(LogStatus.PASS, "Edit Draft Link Button is displayed successfuly.");
		} else {
			extentLogger.log(LogStatus.FAIL, "Edit Draft Link Button is Not displayed.");
		}

		// Verify Delete Link is displayed on the page
		verify.assertTrue(internalUsersHomePage.isDeleteLinkDisplayed(),
				"Delete Link Button should displayed on the Article view page");
		if (internalUsersHomePage.isDeleteLinkDisplayed()) {
			extentLogger.log(LogStatus.PASS, "Delete Link Button is displayed successfuly.");
		} else {
			extentLogger.log(LogStatus.FAIL, "Delete Link Button is Not displayed.");
		}

		// Verify Translate Link is displayed on the page
		verify.assertTrue(internalUsersHomePage.isTranslateLinkDisplayed(),
				"Translate Link Button should displayed on the Article view page");
		if (internalUsersHomePage.isTranslateLinkDisplayed()) {
			extentLogger.log(LogStatus.PASS, "Translate Link Button is displayed successfuly.");
		} else {
			extentLogger.log(LogStatus.FAIL, "Translate Link Button is Not displayed.");
		}

		extentLogger.log(LogStatus.INFO, "Publishing the above created article");
		// Publishing the Article
		internalUsersHomePage.editDraftArticle();
		contentPage.saveAndPublishForThisTranslation();
		extentLogger.log(LogStatus.INFO, "Verifying whether the article is updated");
		verify.assertTrue(internalUsersHomePage.isArticleUpdatedMessageDisplayed(articleData.getTitle()),
				"Article updation message should be displayed as expected.");
		if (internalUsersHomePage.isArticleUpdatedMessageDisplayed(articleData.getTitle())) {
			extentLogger.log(LogStatus.PASS, "Verified that Article updation message has displayed as expected.");
		} else {
			extentLogger.log(LogStatus.FAIL, "Article updation message could not be displayed as expected.");
		}

		extentLogger.log(LogStatus.INFO, "Verifying Edit buttons are displayed on the Published article page");

		// Verify New Draft Link is displayed on the page
		verify.assertTrue(internalUsersHomePage.isNewDraftLinkDisplayed(),
				"New Draft Link Button should displayed on the Article view page");
		if (internalUsersHomePage.isTranslateLinkDisplayed()) {
			extentLogger.log(LogStatus.PASS, "New Draft Link Button is displayed successfuly.");
		} else {
			extentLogger.log(LogStatus.FAIL, "New Draft Link Button is Not displayed.");
		}

		// Verify Revisions Link is displayed on the page
		verify.assertTrue(internalUsersHomePage.isRevisionsLinkDisplayed(),
				"Revisions Link Button should displayed on the Article view page");
		if (internalUsersHomePage.isTranslateLinkDisplayed()) {
			extentLogger.log(LogStatus.PASS, "Revisions Link Button is displayed successfuly.");
		} else {
			extentLogger.log(LogStatus.FAIL, "Revisions Link Button is Not displayed.");
		}

		verify.assertAll();
		extent.endTest(extentLogger);

	}

	@Test(groups = { "TC108017" }, enabled = true, priority = 12)
	public void TC108017_Images_and_videos_should_open_in_Colorbox() throws Exception {

		SoftAssert verify = new SoftAssert();

		logger.info("Test Verify Images_and_videos_should_open_in_Colorbox is started.");
		extentLogger = extent.startTest("TC108017_Images_and_videos_should_open_in_Colorbox");
		extentLogger.log(LogStatus.INFO, "TC108017 Images_and_videos_should_open_in_Colorbox is started.");

		// Login as DocAdmin
		extentLogger.log(LogStatus.INFO, "Logging in as DocAdmin");
		userLogin.login(DataProviderClass.getDocAdminUserDetails().getUser(),
				DataProviderClass.getDocAdminUserDetails().getPw());

		// Create articles
		extentLogger.log(LogStatus.INFO, "Creating an article with Image and Video");
		ArticleData articleData = DataProviderClass.getArticleData(38);
		extentLogger.log(LogStatus.INFO, "Adding an article:" + articleData.getTitle());
		driver.navigate().to(configReader.getAgileCentralHome());
		mainPage.clickContent();
		contentPage.addArticle(articleData);
		contentPage.saveArticleAsDraft();

		// Verify that the article is created
		extentLogger.log(LogStatus.INFO, "Verifying whether article is created.");
		verify.assertTrue(internalUsersHomePage.isArticleCreatedMessageDisplayed(articleData.getTitle()),
				"Article creation message should be displayed as expected.");
		if (internalUsersHomePage.isArticleCreatedMessageDisplayed(articleData.getTitle())) {
			extentLogger.log(LogStatus.PASS, "Verified that Article creation message is displayed successfuly.");
		} else {
			extentLogger.log(LogStatus.FAIL, "Verified that Article creation message is Not displayed.");
		}

		// Clicking On Image
		extentLogger.log(LogStatus.INFO, "Clicking On Image");
		internalUsersHomePage.clickOnImageOfArticle(articleData.getImagePath());

		// Verifying whether colour Box has opened Or not
		verify.assertTrue(internalUsersHomePage.isColourboxDisplayed(), "Colour Box should open to show the image.");
		if (internalUsersHomePage.isColourboxDisplayed()) {
			extentLogger.log(LogStatus.PASS, "Colour Box is displayed successfully when clicked on Image");
		} else {
			extentLogger.log(LogStatus.FAIL, "Colour Box could not Displayed when clicked on Image ");
		}

		// Closing the ColourBox.
		internalUsersHomePage.clickOnCloseColourBox();
		extentLogger.log(LogStatus.INFO, "Colour Box has closed.");
		// Clicking On Video
		extentLogger.log(LogStatus.INFO, "Clicking On video");
		internalUsersHomePage.clickOnVideoOfArticle();

		// Verifying whether colour Box has opened Or not
		verify.assertTrue(internalUsersHomePage.isColourboxDisplayed(), "Colour Box should open to show the video.");
		if (internalUsersHomePage.isColourboxDisplayed()) {
			extentLogger.log(LogStatus.PASS, "Colour Box is displayed successfully when clicked on video");
		} else {
			extentLogger.log(LogStatus.FAIL, "Colour Box could not Displayed when clicked on video ");
		}

		// Closing the ColourBox
		internalUsersHomePage.clickOnCloseColourBox();
		extentLogger.log(LogStatus.INFO, "Colour Box has closed.");

		verify.assertAll();
		extent.endTest(extentLogger);

	}

	@Test(groups = { "TC101184" }, enabled = true, priority = 13)
	public void TC101184_Verify_ToC_Should_Be_Hidden_When_Clicked_On_contents_Link_Button() {

		SoftAssert verify = new SoftAssert();

		logger.info("Test TC101184_Verify_ToC_Can_Be_Hidden_When_Clicked_On_contents_Link_Button is started.");
		extentLogger = extent.startTest("TC101184_Verify_ToC_Can_Be_Hidden_When_Clicked_On_contents_Link_Button");
		extentLogger.log(LogStatus.INFO, "TC101184 Verify_ToC_Can_Be_Hidden_When_Clicked_On_contents_Link_Button.");

		// Login as customer
		userLogin.login(DataProviderClass.getCustomerUserDetails().getUser(),
				DataProviderClass.getCustomerUserDetails().getPw());
		extentLogger.log(LogStatus.INFO, "Logged in as a customer");
		driver.navigate().to(configReader.getAgileCentralHome());

		// Cliking on Contetns button
		extentLogger.log(LogStatus.INFO, "Cliking on Contents button");
		internalUsersHomePage.clickOnContentsLinkButton();

		// Verify whether ToC become hidden
		extentLogger.log(LogStatus.INFO, "Veifying whether ToC is hidden after clicking on Contents button");

		verify.assertTrue(internalUsersHomePage.isToCHidden(),
				"ToC should be hidden when clicked on contents link button");
		if (internalUsersHomePage.isToCHidden()) {
			extentLogger.log(LogStatus.PASS, "ToC is hidden successfuly.");
		} else {
			extentLogger.log(LogStatus.FAIL, "ToC is Not hidden.");
		}

		// Again Cliking on Contents button
		extentLogger.log(LogStatus.INFO, "Again cliking on Contetns button");
		internalUsersHomePage.clickOnContentsLinkButton();

		// Verify whether ToC is displayed
		extentLogger.log(LogStatus.INFO, "Veifying whether ToC is displayed after again clicking on Contents button");
		verify.assertTrue(internalUsersHomePage.isToCDisplayed(),
				"ToC should be displayed when again clicked on contents link button");
		if (internalUsersHomePage.isToCDisplayed()) {
			extentLogger.log(LogStatus.PASS, "ToC is displayed successfuly.");
		} else {
			extentLogger.log(LogStatus.FAIL, "ToC could Not be displayed.");
		}

		verify.assertAll();
		extent.endTest(extentLogger);

	}

	@Test(groups = { "TC108019" }, enabled = true, priority = 14)
	public void TC108019_Verify_Feedback_Displayed_On_Home_And_Article_Page() throws Exception {

		SoftAssert verify = new SoftAssert();

		logger.info("Test TC108019_Verify_Feedback_should_Available_On_Home_And_Article_Page is started.");
		extentLogger = extent.startTest("TC108019_Verify_Feedback_should_Available_On_Home_And_Article_Page");
		extentLogger.log(LogStatus.INFO, "TC108019 Verify_Feedback_should_Available_On_Home_And_Article_Page.");

		// Login as DocAdmin
		extentLogger.log(LogStatus.INFO, "Logging in as DocAdmin");
		userLogin.login(DataProviderClass.getDocAdminUserDetails().getUser(),
				DataProviderClass.getDocAdminUserDetails().getPw());
		driver.navigate().to(configReader.getAgileCentralHome());

		// Verify whether Feedback display on Home Page.
		extentLogger.log(LogStatus.INFO, "Verify whether Feedback display on Home Page.");
		verify.assertTrue(internalUsersHomePage.isFeedbackDisplayed(), "Feedback should be displayed on home page.");
		if (internalUsersHomePage.isFeedbackDisplayed()) {
			extentLogger.log(LogStatus.PASS, "Verified that Feedback displayed successfuly on home page.");
		} else {
			extentLogger.log(LogStatus.FAIL, "Verified that Feedback could not be displayed on home page.");
		}

		// Create articles
		extentLogger.log(LogStatus.INFO, "Creating an article");
		ArticleData articleData = DataProviderClass.getArticleData(39);
		extentLogger.log(LogStatus.INFO, "Adding an article:" + articleData.getTitle());
		mainPage.clickContent();
		contentPage.addArticle(articleData);
		contentPage.saveArticleAsDraft();

		// Verify that the article is created
		verify.assertTrue(internalUsersHomePage.isArticleCreatedMessageDisplayed(articleData.getTitle()),
				"Article creation message should be displayed as expected.");
		if (internalUsersHomePage.isArticleCreatedMessageDisplayed(articleData.getTitle())) {
			extentLogger.log(LogStatus.PASS, "Verified that Article creation message is displayed successfuly.");
		} else {
			extentLogger.log(LogStatus.FAIL, "Verified that Article creation message is Not displayed.");
		}

		// Verify whether Feedback display on Article page.
		extentLogger.log(LogStatus.INFO, "Verify whether Feedback display on Article Page.");
		verify.assertTrue(internalUsersHomePage.isFeedbackDisplayed(), "Feedback should be displayed on Article page.");
		if (internalUsersHomePage.isFeedbackDisplayed()) {
			extentLogger.log(LogStatus.PASS, "Verified that Feedback displayed successfuly on Article page.");
		} else {
			extentLogger.log(LogStatus.FAIL, "Verified that Feedback could Not be displayed on Article Page.");
		}

		verify.assertAll();
		extent.endTest(extentLogger);
	}

	@Test(groups = { "TC101393" }, enabled = true, priority = 15)
	public void TC101393_Verify_Quick_Links_Redirections() throws InterruptedException {

		SoftAssert verify = new SoftAssert();

		logger.info("Test Verify_Quick_Links_Redirections is started.");
		extentLogger = extent.startTest("TC101393_Verify_Quick_Links_Redirections");
		extentLogger.log(LogStatus.INFO, "TC101393 Verify_Quick_Links_Redirections.");

		// Login as customer
		extentLogger.log(LogStatus.INFO, "Logging in as DocAdmin");
		userLogin.login(DataProviderClass.getCustomerUserDetails().getUser(),
				DataProviderClass.getCustomerUserDetails().getPw());
		driver.navigate().to(configReader.getAgileCentralHome());

		// Click on various Quick Links
		ArrayList<String> Handles = null;

		for (int i = 1; i < 6; i++) {

			switch (i) {
			case 1:
				internalUsersHomePage.clickOnCustomserLoginQuickLinks();
				break;
			case 2:
				internalUsersHomePage.clickOnBlogQuickLinks();
				break;
			case 3:
				internalUsersHomePage.clickOnShareIdeasQuickLinks();
				break;
			case 4:
				internalUsersHomePage.clickOnSystemStatusQuickLinks();
				break;
			case 5:
				internalUsersHomePage.clickOnSupportQuickLinks();
				break;
			default:
				break;
			}

			Handles = new ArrayList<String>(driver.getWindowHandles());
			driver.switchTo().window(Handles.get(1));
			String Linki = driver.getTitle();
			driver.close();
			driver.switchTo().window(Handles.get(0));
			Handles.clear();

			// Verifying after clicking opened page is correct or Not.

			switch (i) {
			case 1:
				extentLogger.log(LogStatus.INFO, "Verifying redirection of customer Login Link of Quick Links section");
				verify.assertTrue(Linki.equals(StringConstants.QuickLinksCustomerLoginPageTitle),
						"After clicking on Customer Login Link opened new page title should be same as the Customer Login page Title");
				if (Linki.equals(StringConstants.QuickLinksCustomerLoginPageTitle)) {
					extentLogger.log(LogStatus.PASS,
							"Verified that after clicking on Customer Login Link opened page's title is: " + Linki
									+ " and Expected Page's Title: " + StringConstants.QuickLinksCustomerLoginPageTitle
									+ " are same.");
				} else {
					extentLogger.log(LogStatus.FAIL,
							"Verified that after clicking on Customer Login Link opened page's title is: " + Linki
									+ " and Expected Page's Title: " + StringConstants.QuickLinksCustomerLoginPageTitle
									+ " are NOT same.");
				}
				break;

			case 2:
				extentLogger.log(LogStatus.INFO, "Verifying the Blog Link available in Quick Links");
				verify.assertTrue(Linki.equals(StringConstants.QuickLinksBlogPageTitle),
						"After clicking on Blog Link opened new page title should be same as the Blog page Title");
				if (Linki.equals(StringConstants.QuickLinksBlogPageTitle)) {
					extentLogger.log(LogStatus.PASS,
							"Verified that after clicking on Blog Link opened page's title is: " + Linki
									+ " and Expected Page's Title: " + StringConstants.QuickLinksBlogPageTitle
									+ " are same.");
				} else {
					extentLogger.log(LogStatus.FAIL,
							"Verified that after clicking on Blog Link opened page's title is: " + Linki
									+ " and Expected Page's Title: " + StringConstants.QuickLinksBlogPageTitle
									+ " are NOT same.");
				}
				break;

			case 3:
				extentLogger.log(LogStatus.INFO, "Verifying the Share Ideas Link available in Quick Links");
				verify.assertTrue(Linki.equals(StringConstants.QuickLinksShareIdeasPageTitle),
						"After clicking on Share Ideas Link opened new page title should be same as the Share Ideas page Title");
				if (Linki.equals(StringConstants.QuickLinksShareIdeasPageTitle)) {
					extentLogger.log(LogStatus.PASS,
							"Verified that after clicking on Share Ideas opened page's title is: " + Linki
									+ " and Expected Page's Title: " + StringConstants.QuickLinksShareIdeasPageTitle
									+ " are same.");
				} else {
					extentLogger.log(LogStatus.FAIL,
							"Verified that after clicking on Share Ideas opened page's title is: " + Linki
									+ " and Expected Page's Title: " + StringConstants.QuickLinksShareIdeasPageTitle
									+ " are NOT same.");
				}
				break;

			case 4:
				extentLogger.log(LogStatus.INFO, "Verifying the System Status Link available in Quick Links");
				verify.assertTrue(Linki.equals(StringConstants.QuickLinksSystemStatusPageTitle),
						"After clicking on System Status Link opened new page title should be same as the Share Ideas page Title");
				if (Linki.equals(StringConstants.QuickLinksSystemStatusPageTitle)) {
					extentLogger.log(LogStatus.PASS,
							"Verified that after clicking on System Status opened page's title is: " + Linki
									+ " and Expected Page's Title: " + StringConstants.QuickLinksSystemStatusPageTitle
									+ " are same.");
				} else {
					extentLogger.log(LogStatus.FAIL,
							"Verified that after clicking on System Status opened page's title is: " + Linki
									+ " and Expected Page's Title: " + StringConstants.QuickLinksSystemStatusPageTitle
									+ " are NOT same.");
				}
				break;

			case 5:
				extentLogger.log(LogStatus.INFO, "Verifying the Support Link available in Quick Links");
				verify.assertTrue(Linki.equals(StringConstants.QuickLinksSupportPageTitle),
						"After clicking on Support Link opened new page title should be same as the Support page Title");
				if (Linki.equals(StringConstants.QuickLinksSupportPageTitle)) {
					extentLogger.log(LogStatus.PASS,
							"Verified that after clicking on Support opened page's title is: " + Linki
									+ " and Expected Page's Title: " + StringConstants.QuickLinksSupportPageTitle
									+ " are same.");
				} else {
					extentLogger.log(LogStatus.FAIL,
							"Verified that after Clicking on Support opened page's title is: " + Linki
									+ " and Expected Page's Title: " + StringConstants.QuickLinksSupportPageTitle
									+ " are NOT same.");
				}
				break;
			}

			verify.assertAll();
		}
		extent.endTest(extentLogger);
	}

	@Test(groups = { "TC108376" }, enabled = true, priority = 16)
	public void TC108376_Verify_Glossary_Page_Is_Available() {

		SoftAssert verify = new SoftAssert();

		logger.info("Test TC108376_Verify_Glossary_Page_Is_Available is started.");
		extentLogger = extent.startTest("TC108376_Verify_Glossary_Page_Is_Available");
		extentLogger.log(LogStatus.INFO, "TC108376 Verify Glossary Page Is Available");

		// Login as customer
		userLogin.login(DataProviderClass.getCustomerUserDetails().getUser(),
				DataProviderClass.getCustomerUserDetails().getPw());
		extentLogger.log(LogStatus.INFO, "Logged in as a Customer");

		// Navigating to Glossary page
		driver.navigate().to(configReader.getDrupalAgileCentralURL() + "/" + StringConstants.GLOSSARY);
		extentLogger.log(LogStatus.INFO, "Navigated to Glossary Page");
		verify.assertTrue(driver.getTitle().contains(StringConstants.GLOSSARY), "Glossary page should be displayed.");
		if (driver.getTitle().contains(StringConstants.GLOSSARY)) {
			extentLogger.log(LogStatus.PASS,
					"Glossary page is displayed. Navigated page Title is :" + driver.getTitle());
		} else {
			extentLogger.log(LogStatus.FAIL,
					"Glossary page is Not displayed. Navigated page Title is :" + driver.getTitle());
		}

		verify.assertAll();
		extent.endTest(extentLogger);
	}

	@Test(groups = { "TC108370" }, enabled = true, priority = 17)
	public void TC108370_Verify_ToC_Breadcrumbs_Links() throws Exception {

		SoftAssert verify = new SoftAssert();

		logger.info("Test Verify ToC Breadcrumbs Links is started.");
		extentLogger = extent.startTest("TC108370_Verify_ToC_Breadcrumbs_Links");
		extentLogger.log(LogStatus.INFO, "TC108370 Verify ToC Breadcrumbs Links is started.");

		// Login as DocAdmin
		extentLogger.log(LogStatus.INFO, "Loging in as DocAdmin");
		userLogin.login(DataProviderClass.getDocAdminUserDetails().getUser(),
				DataProviderClass.getDocAdminUserDetails().getPw());

		// Create articles
		ArticleData grandParentArticle = DataProviderClass.getArticleData(40);
		ArticleData parentArticle = DataProviderClass.getArticleData(41);
		ArticleData childArticle = DataProviderClass.getArticleData(42);

		for (int i = 40; i <= 42; i++) {
			ArticleData articleData = DataProviderClass.getArticleData(i);
			mainPage.clickContent();
			contentPage.addArticle(articleData);
			contentPage.saveAndPublish();
			// Verify that the article is created
			Assert.assertTrue(internalUsersHomePage.isArticleCreatedMessageDisplayed(articleData.getTitle()));
			extentLogger.log(LogStatus.INFO, "The article is created and published: " + articleData.getTitle());
		}

		// Verify the first breadcrumb item is Home
		verify.assertTrue("Home".equals(internalUsersHomePage.getBreadCrumText(0)),
				"First Breadcrumb Link should be Home");
		if ("Home".equals(internalUsersHomePage.getBreadCrumText(0))) {
			extentLogger.log(LogStatus.PASS, "Verified that First Breadcrumb Link is Home and displayed as: "
					+ internalUsersHomePage.getBreadCrumText(0));
		} else {
			extentLogger.log(LogStatus.FAIL,
					"First Breadcrumb Link is not 'Home' and it is: " + internalUsersHomePage.getBreadCrumText(0));
		}

		// Verify the Second breadcrumb item should be TestArticleorAutomation40
		// menu link
		verify.assertTrue(grandParentArticle.getMenuLinkTitle().equals(internalUsersHomePage.getBreadCrumText(1)),
				"Second Breadcrumb Link should be :" + grandParentArticle.getMenuLinkTitle());
		if (grandParentArticle.getMenuLinkTitle().equals(internalUsersHomePage.getBreadCrumText(1))) {
			extentLogger.log(LogStatus.PASS, "Second Breadcrumb Link is grand Parent item and displayed as: "
					+ internalUsersHomePage.getBreadCrumText(1));
		} else {
			extentLogger.log(LogStatus.FAIL, "Second Breadcrumb Link is not grand Parent item and displayed as: "
					+ internalUsersHomePage.getBreadCrumText(1));
		}

		// Verify the Third breadcrumb item should be TestArticleorAutomation41
		// menu link
		verify.assertTrue(parentArticle.getMenuLinkTitle().equals(internalUsersHomePage.getBreadCrumText(2)),
				"Third Breadcrumb Link should be :" + parentArticle.getMenuLinkTitle());
		if (parentArticle.getMenuLinkTitle().equals(internalUsersHomePage.getBreadCrumText(2))) {
			extentLogger.log(LogStatus.PASS, "Third Breadcrumb Link is Parent item and displayed as:"
					+ internalUsersHomePage.getBreadCrumText(2));
		} else {
			extentLogger.log(LogStatus.FAIL, "Third Breadcrumb Link is not Parent item and displayed as:"
					+ internalUsersHomePage.getBreadCrumText(2));
		}

		// Clicking on 3rd Breadcrumb Link verifying its Article Title
		internalUsersHomePage.clickOnBreadCrumLink(2);
		extentLogger.log(LogStatus.INFO, "Clicked on 3rd breadcrumb link");

		extentLogger.log(LogStatus.INFO,
				"Verifying that the article page displayed should be :" + parentArticle.getTitle());
		verify.assertTrue(internalUsersHomePage.getArticleTitleFromPage().equals(parentArticle.getTitle()),
				"BreadCrumb's 3rd links article title should be :" + parentArticle.getTitle());
		if (internalUsersHomePage.getArticleTitleFromPage().equals(parentArticle.getTitle())) {
			extentLogger.log(LogStatus.PASS,
					"Verified that newly opened Article title is :" + internalUsersHomePage.getArticleTitleFromPage());
		} else {
			extentLogger.log(LogStatus.FAIL, "Verified that newly opened Article title is Not :"
					+ internalUsersHomePage.getArticleTitleFromPage());
		}

		// Clicking on 2nd Breadcrumb Link verifying its Article Title
		internalUsersHomePage.clickOnBreadCrumLink(1);
		extentLogger.log(LogStatus.INFO, "Clicked on 2nd breadcrumb link");

		extentLogger.log(LogStatus.INFO,
				"Verifying that the article page displayed should be :" + grandParentArticle.getTitle());
		verify.assertTrue(internalUsersHomePage.getArticleTitleFromPage().equals(grandParentArticle.getTitle()),
				"BreadCrumb's 2nd links article title should be :" + grandParentArticle.getTitle());
		if (internalUsersHomePage.getArticleTitleFromPage().equals(grandParentArticle.getTitle())) {
			extentLogger.log(LogStatus.PASS,
					"Verified that newly opened Article title is :" + internalUsersHomePage.getArticleTitleFromPage());
		} else {
			extentLogger.log(LogStatus.FAIL, "Verified that newly opened Article title is Not :"
					+ internalUsersHomePage.getArticleTitleFromPage());
		}

		verify.assertAll();
		extent.endTest(extentLogger);
	}

	@Test(groups = { "TC102176" }, enabled = true, priority = 18)
	public void TC102176_Verify_API_Docs_Page_Is_Available() {

		SoftAssert verify = new SoftAssert();

		logger.info("Test Verify_API_Docs_Page_Is_Available is started.");
		extentLogger = extent.startTest("TC102176_Verify_API_Docs_Page_Is_Available");
		extentLogger.log(LogStatus.INFO, "TC102176_Verify_API_Docs_Page_Is_Available is started.");

		// Login as customer
		userLogin.login(DataProviderClass.getCustomerUserDetails().getUser(),
				DataProviderClass.getCustomerUserDetails().getPw());
		extentLogger.log(LogStatus.INFO, "Logged in as Customer");

		ArticleData articleData = DataProviderClass.getArticleData(43);

		// Navigating to For-Developers Page
		driver.navigate().to(configReader.getDrupalBaseURL() + articleData.getUrlAlias());
		extentLogger.log(LogStatus.INFO, "Navigated to For-Developers Page");
		new WebDriverWait(driver, 60).until(ExpectedConditions.titleContains(StringConstants.FOR_DEVELOPERS));

		// Clicking on AppSDK2.1 Link
		internalUsersHomePage.clickOnAppSDKLink();
		extentLogger.log(LogStatus.INFO, "Clicked on AppSDK2.1 Link");

		// Verifying that the navigated page should be :Agile Central App SDK
		// 2.1 Docs
		extentLogger.log(LogStatus.INFO, "Verifying that the navigated page should be :" + StringConstants.APP_SDK_2_1);
		verify.assertTrue(driver.getTitle().equals(StringConstants.APP_SDK_2_1),
				"It should navigate to page :" + StringConstants.APP_SDK_2_1);
		if (driver.getTitle().equals(StringConstants.APP_SDK_2_1)) {
			extentLogger.log(LogStatus.PASS,
					"Verified that App SDK 2.1 page is available. Navigated page Title is :" + driver.getTitle());
		} else {
			extentLogger.log(LogStatus.FAIL,
					"Verified that App SDK 2.1 page is Not available. Navigated page Title is :" + driver.getTitle());
		}

		verify.assertAll();
		extent.endTest(extentLogger);
	}

	@Test(groups = { "TC108063" }, enabled = true, priority = 19)
	public void TC108063_Verify_Google_Analytics() {

		SoftAssert verify = new SoftAssert();

		logger.info("Test TC108063_Verify_Google_Analytics is started.");
		extentLogger = extent.startTest("TC108063_Verify_Google_Analytics");
		extentLogger.log(LogStatus.INFO, "TC108063_Verify_Google_Analytics is started.");

		// Login as customer
		userLogin.login(DataProviderClass.getCustomerUserDetails().getUser(),
				DataProviderClass.getCustomerUserDetails().getPw());
		extentLogger.log(LogStatus.INFO, "Logged in as Customer");

		driver.navigate().to(configReader.getAgileCentralHome());
		extentLogger.log(LogStatus.INFO, "Navigated to Home Page");

		String HomePageSource = driver.getPageSource();
		if (driver.getCurrentUrl().contains(StringConstants.DEV_ENV)) {

			// Verifying whether Home Page Source contains Google Analytics Tag
			// for customers
			extentLogger.log(LogStatus.PASS, "Verifying whether Home Page Source contains Google Analytics Tag");
			verify.assertTrue(HomePageSource.contains(StringConstants.GOOGLE_ANALYTICS_ID_DEV),
					"Google Analytics Tag should be available for home page");
			if (HomePageSource.contains(StringConstants.GOOGLE_ANALYTICS_ID_DEV)) {
				extentLogger.log(LogStatus.PASS, "Verified that Google Analytics Tag is available for home page");
			} else {
				extentLogger.log(LogStatus.FAIL, "Google Analytics Tag "+StringConstants.GOOGLE_ANALYTICS_ID_DEV+" is Not available for home page");
			}
		} else if (driver.getCurrentUrl().contains(StringConstants.Stage_ENV)) {

			// Verifying whether Home Page Source contains Google Analytics Tag
			// for customers
			extentLogger.log(LogStatus.PASS, "Verifying whether Home Page Source contains Google Analytics Tag");
			verify.assertTrue(HomePageSource.contains(StringConstants.GOOGLE_ANALYTICS_ID_STAGE),
					"Google Analytics Tag should be available for home page");
			if (HomePageSource.contains(StringConstants.GOOGLE_ANALYTICS_ID_STAGE)) {
				extentLogger.log(LogStatus.PASS, "Verified that Google Analytics Tag is available for home page");
			} else {
				extentLogger.log(LogStatus.FAIL, "Google Analytics Tag "+StringConstants.GOOGLE_ANALYTICS_ID_STAGE+" is Not available for home page");
			}

		}
		internalUsersHomePage.logOutAndCleanCookies(userLogin);
		// Login as DocAdmn
		extentLogger.log(LogStatus.INFO, "Logged out from Customer and logging in as DocAdmn");
		userLogin.login(DataProviderClass.getDocAdminUserDetails().getUser(),
				DataProviderClass.getDocAdminUserDetails().getPw());

		// Adding an Article and publishing it.
		extentLogger.log(LogStatus.INFO, "Creating an article");
		ArticleData articleData = DataProviderClass.getArticleData(44);
		extentLogger.log(LogStatus.INFO, "Adding a parent Article as: " + articleData.getTitle());
		mainPage.clickContent();
		try {
			contentPage.addArticle(articleData);
			contentPage.saveAndPublish();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			extentLogger.log(LogStatus.ERROR, "Exception while adding the article: " + e);
		}

		// Verify that the article is created
		verify.assertTrue(internalUsersHomePage.isArticleCreatedMessageDisplayed(articleData.getTitle()),
				"Article creation message should be displayed as expected.");
		if (internalUsersHomePage.isArticleCreatedMessageDisplayed(articleData.getTitle())) {
			extentLogger.log(LogStatus.PASS, "Verified that Article creation message is displayed successfuly.");
		} else {
			extentLogger.log(LogStatus.FAIL, "Article creation message is Not displayed.");
		}

		String ArticlePageSource = driver.getPageSource();
		if (driver.getCurrentUrl().contains(StringConstants.DEV_ENV)) {

			// Verifying whether Home Page Source contains Google Analytics Tag
			extentLogger.log(LogStatus.PASS, "Verifying whether Home Page source contains Google Analytics Tag");
			verify.assertTrue(ArticlePageSource.contains(StringConstants.GOOGLE_ANALYTICS_ID_DEV),
					"Google Analytics Tag should be available for article page");
			if (ArticlePageSource.contains(StringConstants.GOOGLE_ANALYTICS_ID_DEV)) {
				extentLogger.log(LogStatus.PASS, "Verified that Google Analytics Tag is available for article page");
			} else {
				extentLogger.log(LogStatus.FAIL, "Google Analytics Tag " + StringConstants.GOOGLE_ANALYTICS_ID_DEV
						+ " is Not available for article page");
			}

		} else if (driver.getCurrentUrl().contains(StringConstants.Stage_ENV)) {

			// Verifying whether Home Page Source contains Google Analytics Tag
			extentLogger.log(LogStatus.PASS, "Verifying whether Home Page source contains Google Analytics Tag");
			verify.assertTrue(ArticlePageSource.contains(StringConstants.GOOGLE_ANALYTICS_ID_STAGE),
					"Google Analytics Tag should be available for article page");
			if (ArticlePageSource.contains(StringConstants.GOOGLE_ANALYTICS_ID_STAGE)) {
				extentLogger.log(LogStatus.PASS, "Verified that Google Analytics Tag is available for article page");
			} else {
				extentLogger.log(LogStatus.FAIL, "Google Analytics Tag " + StringConstants.GOOGLE_ANALYTICS_ID_STAGE
						+ " is Not available for article page");
			}

		}

		// Navigating to Admin Page
		driver.navigate().to(configReader.getAdminURL());
		extentLogger.log(LogStatus.INFO, "Navigated to Admin Page");

		String AdminPageSource = driver.getPageSource();
		// Verifying whether Home Page Source contains Google Analytics Tag
		extentLogger.log(LogStatus.INFO, "Verifying whether Admin page source contains Google Analytics Tag");

		if (driver.getCurrentUrl().contains(StringConstants.DEV_ENV)) {

			// Verifying whether Admin Page Source contains Google Analytics Tag
			verify.assertFalse(AdminPageSource.contains(StringConstants.GOOGLE_ANALYTICS_ID_DEV),
					"Google Analytics Tag should not be available for Admin page");
			if (AdminPageSource.contains(StringConstants.GOOGLE_ANALYTICS_ID_DEV)) {
				extentLogger.log(LogStatus.FAIL,
						"Google Analytics Tag is available for Admin page which is not expected.");
			} else {
				extentLogger.log(LogStatus.PASS,
						"Verified that Google Analytics Tag is Not available for Admin page as expected.");
			}
		} else if (driver.getCurrentUrl().contains(StringConstants.Stage_ENV)) {

			verify.assertFalse(AdminPageSource.contains(StringConstants.GOOGLE_ANALYTICS_ID_STAGE),
					"Google Analytics Tag should not be available for Admin page");
			if (AdminPageSource.contains(StringConstants.GOOGLE_ANALYTICS_ID_STAGE)) {
				extentLogger.log(LogStatus.FAIL,
						"Google Analytics Tag is available for Admin page which is not expected.");
			} else {
				extentLogger.log(LogStatus.PASS,
						"Verified that Google Analytics Tag is Not available for Admin page as expected.");
			}
		}

		verify.assertAll();
		extent.endTest(extentLogger);
	}

	@Test(groups = { "TC114806", "TC114814" }, priority = 20)
	public void TC114814_Verify_UI_Translations() throws Exception {

		SoftAssert verify = new SoftAssert();
		logger.info("TC114814_Test Verify_UI_Translations is started.");
		extentLogger = extent.startTest("TC114814_Verify_UI_Translations");
		logger.info("TC114814_Verify_UI_Translations has started.");

		// Login as DocAdmin
		userLogin.login(DataProviderClass.getDocAdminUserDetails().getUser(),
				DataProviderClass.getDocAdminUserDetails().getPw());
		extentLogger.log(LogStatus.INFO, "Logged in as DocAdmin");

		// Create articles
		ArticleData articleData = DataProviderClass.getArticleData(47);
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

		// verify UI Translations when switched to German language
		extentLogger.log(LogStatus.INFO, "Navigating to german translations of the article page");
		internalUsersHomePage.accessArticleWithLocale(articleData.getUrlAlias(), StringConstants.GERMAN_LOCALE);
		new WebDriverWait(driver, 60).until(ExpectedConditions.urlContains(StringConstants.GERMAN_LOCALE));

		// verify Header
		extentLogger.log(LogStatus.INFO, "Verifying Header links are translated in German.");

		verify.assertTrue(
				internalUsersHomePage.getTextOfHeaderColumn1().equals(StringConstants.UITranslationHeaderProduct),
				"1st column of the header should be properly translated in German");
		if (internalUsersHomePage.getTextOfHeaderColumn1().equals(StringConstants.UITranslationHeaderProduct)) {
			extentLogger.log(LogStatus.PASS,
					"Verified that 1st column of the header is properly translated in German as :"
							+ internalUsersHomePage.getTextOfHeaderColumn1());
		} else {
			extentLogger.log(LogStatus.FAIL, "Verified that 1st column of the header could not translated in German");
		}

		verify.assertTrue(
				internalUsersHomePage.getTextOfHeaderColumn2().equals(StringConstants.UITranslationHeaderSolutions),
				"2nd column of the header should be properly translated in German");
		if (internalUsersHomePage.getTextOfHeaderColumn2().equals(StringConstants.UITranslationHeaderSolutions)) {
			extentLogger.log(LogStatus.PASS,
					"Verified that 2nd column of the header is properly translated in German as :"
							+ internalUsersHomePage.getTextOfHeaderColumn2());
		} else {
			extentLogger.log(LogStatus.FAIL, "Verified that 2nd column of the header could not translated in German");
		}

		verify.assertTrue(
				internalUsersHomePage.getTextOfHeaderColumn3().equals(StringConstants.UITranslationHeaderEducTran),
				"3rd column of the header should be properly translated in German");
		if (internalUsersHomePage.getTextOfHeaderColumn3().equals(StringConstants.UITranslationHeaderEducTran)) {
			extentLogger.log(LogStatus.PASS,
					"Verified that 3rd column of the header is properly translated in German as :"
							+ internalUsersHomePage.getTextOfHeaderColumn3());
		} else {
			extentLogger.log(LogStatus.FAIL, "Verified that 3rd column of the header could not translated in German");
		}

		verify.assertTrue(
				internalUsersHomePage.getTextOfHeaderColumn4()
						.equals(StringConstants.UITranslationHeaderServiceSupport),
				"4th column of the header should be properly translated in German");
		if (internalUsersHomePage.getTextOfHeaderColumn4().equals(StringConstants.UITranslationHeaderServiceSupport)) {
			extentLogger.log(LogStatus.PASS,
					"Verified that 4th column of the header is properly translated in German as :"
							+ internalUsersHomePage.getTextOfHeaderColumn4());
		} else {
			extentLogger.log(LogStatus.FAIL, "Verified that 4th column of the header could not translated in German");
		}

		verify.assertTrue(
				internalUsersHomePage.getTextOfHeaderColumn5().equals(StringConstants.UITranslationHeaderPartner),
				"5th column of the header should be properly translated in German");
		if (internalUsersHomePage.getTextOfHeaderColumn5().equals(StringConstants.UITranslationHeaderPartner)) {
			extentLogger.log(LogStatus.PASS,
					"Verified that 5th column of the header is properly translated in German as :"
							+ internalUsersHomePage.getTextOfHeaderColumn5());
		} else {
			extentLogger.log(LogStatus.FAIL, "Verified that 5th column of the header could not translated in German");
		}

		verify.assertTrue(
				internalUsersHomePage.getTextOfHeaderColumn6().equals(StringConstants.UITranslationHeaderCompany),
				"6th column of the header should be properly translated in German");
		if (internalUsersHomePage.getTextOfHeaderColumn6().equals(StringConstants.UITranslationHeaderCompany)) {
			extentLogger.log(LogStatus.PASS,
					"Verified that 6th column of the header is properly translated in German as :"
							+ internalUsersHomePage.getTextOfHeaderColumn6());
		} else {
			extentLogger.log(LogStatus.FAIL, "Verified that 6th column of the header could not translated in German");
		}

		// verify HeadsUp, For Developers, Contents and Home link and Language
		// on the article page
		extentLogger.log(LogStatus.INFO,
				"Verifying HeadsUp, ForDevelopers, Contents link, Home link and Language dropdown link are translated in German.");

		verify.assertTrue(internalUsersHomePage.getTextOfHeadsUp().equals(StringConstants.UITranslationHeadsUp),
				"Heads Up Block should be properly translated in German");
		if (internalUsersHomePage.getTextOfHeadsUp().equals(StringConstants.UITranslationHeadsUp)) {
			extentLogger.log(LogStatus.PASS, "Verified that Heads Up Block is properly translated in German as :"
					+ internalUsersHomePage.getTextOfHeadsUp());
		} else {
			extentLogger.log(LogStatus.FAIL, "Verified that HeadsUp Block could not be properly translated in German");
		}

		verify.assertTrue(
				internalUsersHomePage.getTextOfForDevelopers().equals(StringConstants.UITranslationForDeveloper),
				"For Developers Block should be properly translated in German");
		if (internalUsersHomePage.getTextOfForDevelopers().equals(StringConstants.UITranslationForDeveloper)) {
			extentLogger.log(LogStatus.PASS, "For Developers Block is properly translated in German as :"
					+ internalUsersHomePage.getTextOfForDevelopers());
		} else {
			extentLogger.log(LogStatus.FAIL, "For Developers Block could not properly translated in German");
		}

		verify.assertTrue(internalUsersHomePage.getTextOfHome().equals(StringConstants.UITranslationHome),
				"Home Link should be properly translated in German");
		if (internalUsersHomePage.getTextOfHome().equals(StringConstants.UITranslationHome)) {
			extentLogger.log(LogStatus.PASS, "Verified that Home link is properly translated in German as :"
					+ internalUsersHomePage.getTextOfHome());
		} else {
			extentLogger.log(LogStatus.FAIL, "Verified that Home link could not properly translated in German");
		}

		verify.assertTrue(internalUsersHomePage.getTextOfContents().equals(StringConstants.UITranslationContents),
				"Contents link should be properly translated in German");
		if (internalUsersHomePage.getTextOfContents().equals(StringConstants.UITranslationContents)) {
			extentLogger.log(LogStatus.PASS, "Verified that Contents link is properly translated in German as :"
					+ internalUsersHomePage.getTextOfContents());
		} else {
			extentLogger.log(LogStatus.FAIL, "Verified that Contents link could not properly translated in German");
		}

		verify.assertTrue(internalUsersHomePage.getTextOfLanguages().equals(StringConstants.UITranslationLanguage),
				"Language dropdown link should be properly translated in German");
		if (internalUsersHomePage.getTextOfLanguages().equals(StringConstants.UITranslationLanguage)) {
			extentLogger.log(LogStatus.PASS,
					"Verified that Language dropdown link is properly translated in German as :"
							+ internalUsersHomePage.getTextOfLanguages());
		} else {
			extentLogger.log(LogStatus.FAIL,
					"Verified that Language dropdown link could not properly translated in German");
		}

		// Verify Footer Links
		extentLogger.log(LogStatus.INFO, "Verifying Footer links are translated in German.");

		verify.assertTrue(
				internalUsersHomePage.getTextOfFooterColumn1().equals(StringConstants.UITranslationFooterPrivacy),
				"1st column of the Footer should be properly translated in German");
		if (internalUsersHomePage.getTextOfFooterColumn1().equals(StringConstants.UITranslationFooterPrivacy)) {
			extentLogger.log(LogStatus.PASS,
					"Verified that 1st column of the Footer is properly translated in German as :"
							+ internalUsersHomePage.getTextOfFooterColumn1());
		} else {
			extentLogger.log(LogStatus.FAIL, "Verified that 1st column of the Footer could not translated in German");
		}

		verify.assertTrue(
				internalUsersHomePage.getTextOfFooterColumn2().equals(StringConstants.UITranslationFooterLegal),
				"2nd column of the Footer should be properly translated in German");
		if (internalUsersHomePage.getTextOfFooterColumn2().equals(StringConstants.UITranslationFooterLegal)) {
			extentLogger.log(LogStatus.PASS,
					"Verified that 2nd column of the Footer is properly translated in German as :"
							+ internalUsersHomePage.getTextOfFooterColumn2());
		} else {
			extentLogger.log(LogStatus.FAIL, "Verified that 2nd column of the Footer could not translated in German");
		}

		verify.assertTrue(
				internalUsersHomePage.getTextOfFooterColumn3().equals(StringConstants.UITranslationFooterDataTransfers),
				"3rd column of the Footer should be properly translated in German");
		if (internalUsersHomePage.getTextOfFooterColumn3().equals(StringConstants.UITranslationFooterDataTransfers)) {
			extentLogger.log(LogStatus.PASS,
					"Verified that 3rd column of the Footer is properly translated in German as :"
							+ internalUsersHomePage.getTextOfFooterColumn3());
		} else {
			extentLogger.log(LogStatus.FAIL, "Verified that 3rd column of the Footer could not translated in German");
		}

		verify.assertTrue(
				internalUsersHomePage.getTextOfFooterColumn4().equals(StringConstants.UITranslationFooterSiteMap),
				"4th column of the Footer should be properly translated in German");
		if (internalUsersHomePage.getTextOfFooterColumn4().equals(StringConstants.UITranslationFooterSiteMap)) {
			extentLogger.log(LogStatus.PASS,
					"Verified that 4th column of the Footer is properly translated in German as :"
							+ internalUsersHomePage.getTextOfFooterColumn4());
		} else {
			extentLogger.log(LogStatus.FAIL, "Verified that 4th column of the Footer could not translated in German");
		}

		verify.assertTrue(
				internalUsersHomePage.getTextOfFooterColumn5().equals(StringConstants.UITranslationFooterImprint),
				"5th column of the Footer should be properly translated in German");
		if (internalUsersHomePage.getTextOfFooterColumn5().equals(StringConstants.UITranslationFooterImprint)) {
			extentLogger.log(LogStatus.PASS,
					"Verified that 5th column of the Footer is properly translated in German as :"
							+ internalUsersHomePage.getTextOfFooterColumn5());
		} else {
			extentLogger.log(LogStatus.FAIL, "Verified that 5th column of the Footer could not translated in German");
		}

		// Verify QuickLInks and Browse help
		extentLogger.log(LogStatus.INFO, "Verifying Quick links ans Browse Help are translated in German.");

		verify.assertTrue(
				internalUsersHomePage.getTextOfQuickLinksField().equals(StringConstants.UITranslationQuickLinks),
				"Quick Links field should be properly translated in German");
		if (internalUsersHomePage.getTextOfQuickLinksField().equals(StringConstants.UITranslationQuickLinks)) {
			extentLogger.log(LogStatus.PASS, "Verified that Quick Links field is properly translated in German as :"
					+ internalUsersHomePage.getTextOfQuickLinksField());
		} else {
			extentLogger.log(LogStatus.FAIL, "Verified that Quick Links field could not translated in German");
		}

		verify.assertTrue(
				internalUsersHomePage.getTextOfUITranslationCustomerLogin()
						.equals(StringConstants.UITranslationCustomerLogin),
				"CustomerLogin field should be properly translated in German");
		if (internalUsersHomePage.getTextOfUITranslationCustomerLogin()
				.equals(StringConstants.UITranslationCustomerLogin)) {
			extentLogger.log(LogStatus.PASS, "Verified that CustomerLogin field is properly translated in German as :"
					+ internalUsersHomePage.getTextOfUITranslationCustomerLogin());
		} else {
			extentLogger.log(LogStatus.FAIL, "Verified that CustomerLogin field could not translated in German");
		}

		verify.assertTrue(internalUsersHomePage.getTextOfUITranslationBlog().equals(StringConstants.UITranslationBlog),
				"Blog field should be properly translated in German");
		if (internalUsersHomePage.getTextOfUITranslationBlog().equals(StringConstants.UITranslationBlog)) {
			extentLogger.log(LogStatus.PASS, "Verified that Blog field is properly translated in German as :"
					+ internalUsersHomePage.getTextOfUITranslationBlog());
		} else {
			extentLogger.log(LogStatus.FAIL, "Verified that Blog field could not translated in German");
		}

		verify.assertTrue(
				internalUsersHomePage.getTextOfUITranslationShareIdeas()
						.equals(StringConstants.UITranslationShareIdeas),
				"Share Ideas Field should be properly translated in German");
		if (internalUsersHomePage.getTextOfUITranslationShareIdeas().equals(StringConstants.UITranslationShareIdeas)) {
			extentLogger.log(LogStatus.PASS, "Verified that Share Ideas Field is properly translated in German as :"
					+ internalUsersHomePage.getTextOfUITranslationShareIdeas());
		} else {
			extentLogger.log(LogStatus.FAIL, "Verified that Share Ideas Field could not translated in German");
		}

		verify.assertTrue(
				internalUsersHomePage.getTextOfUITranslationSystemStatus()
						.equals(StringConstants.UITranslationSystemStatus),
				"System status field should be properly translated in German");
		if (internalUsersHomePage.getTextOfUITranslationSystemStatus()
				.equals(StringConstants.UITranslationSystemStatus)) {
			extentLogger.log(LogStatus.PASS, "Verified that System status field is properly translated in German as :"
					+ internalUsersHomePage.getTextOfUITranslationSystemStatus());
		} else {
			extentLogger.log(LogStatus.FAIL, "Verified that System status field could not translated in German");
		}

		verify.assertTrue(
				internalUsersHomePage.getTextOfUITranslationSupport().equals(StringConstants.UITranslationSupport),
				"Support field should be properly translated in German");
		if (internalUsersHomePage.getTextOfUITranslationSupport().equals(StringConstants.UITranslationSupport)) {
			extentLogger.log(LogStatus.PASS, "Verified that Support field is properly translated in German as :"
					+ internalUsersHomePage.getTextOfUITranslationSupport());
		} else {
			extentLogger.log(LogStatus.FAIL, "Verified that Support field could not translated in German");
		}

		verify.assertTrue(
				internalUsersHomePage.getTextOfBrowseHelpField().equals(StringConstants.UITranslationBrowseHelp),
				"Browse Help field should be properly translated in German");
		if (internalUsersHomePage.getTextOfBrowseHelpField().equals(StringConstants.UITranslationBrowseHelp)) {
			extentLogger.log(LogStatus.PASS, "Verified that Browse Help field is properly translated in German as :"
					+ internalUsersHomePage.getTextOfBrowseHelpField());
		} else {
			extentLogger.log(LogStatus.FAIL,
					"Verified that Browse Help field could not translated in German and displayed as: "
							+ internalUsersHomePage.getTextOfBrowseHelpField());
		}

		// verify Search place holder text
		extentLogger.log(LogStatus.INFO, "Verifying Search plcehoders text is  translated in German.");

		verify.assertTrue(
				internalUsersHomePage.getTextOfSearchPlaceHolder()
						.equals(StringConstants.UITranslationSearchPlaceholder),
				"Search place holder text should be properly translated in German");
		if (internalUsersHomePage.getTextOfSearchPlaceHolder().equals(StringConstants.UITranslationSearchPlaceholder)) {
			extentLogger.log(LogStatus.PASS,
					"Verified that Search place holder text is properly translated in German as :"
							+ internalUsersHomePage.getTextOfSearchPlaceHolder());
		} else {
			extentLogger.log(LogStatus.FAIL,
					"Verified that Search place holder text could not translated in German and displayed as: "
							+ internalUsersHomePage.getTextOfSearchPlaceHolder());
		}

		extentLogger.log(LogStatus.INFO, "Clicking on search enter button and verifying the place holder error text");
		homePage.SearchEnter.click();

		verify.assertTrue(
				internalUsersHomePage.getTextOfSearchPlaceHolder()
						.equals(StringConstants.UITranslationSearchErrorPlaceholder),
				"Search error place holder text should be properly translated in German");
		if (internalUsersHomePage.getTextOfSearchPlaceHolder()
				.equals(StringConstants.UITranslationSearchErrorPlaceholder)) {
			extentLogger.log(LogStatus.PASS,
					"Verified that Search error place holder text is properly translated in German as :"
							+ internalUsersHomePage.getTextOfSearchPlaceHolder());
		} else {
			extentLogger.log(LogStatus.FAIL,
					"Verified that Search error place holder text could not translated in German");
		}

		// verify Feedback Paragraph Text is translated in german
		extentLogger.log(LogStatus.INFO, "Verifying that Feedback Paragraph Text is translated in German");

		verify.assertTrue(
				internalUsersHomePage.getTextOfFeedbackPara().contains(StringConstants.UITranslationFeedbackParaText),
				"Feedback para text should be properly translated in German on search results page");
		if (internalUsersHomePage.getTextOfFeedbackPara().contains(StringConstants.UITranslationFeedbackParaText)) {
			extentLogger.log(LogStatus.PASS,
					"Verified that Feedback Paragraph Text is properly translated in German as :"
							+ StringConstants.UITranslationFeedbackParaText);
		} else {
			extentLogger.log(LogStatus.FAIL,
					"Verified that Feedback Paragraph Text could not translated in German and displayed as: "
							+ internalUsersHomePage.getTextOfFeedbackPara());
		}

		internalUsersHomePage.logOutAndCleanCookies(userLogin);

		userLogin.login(DataProviderClass.getCustomerUserDetails().getUser(),
				DataProviderClass.getCustomerUserDetails().getPw());
		extentLogger.log(LogStatus.INFO, "Loggedout from Admin controls and Loggedin as a customer");
		internalUsersHomePage.accessArticleWithLocale(articleData.getUrlAlias(), StringConstants.GERMAN_LOCALE);
		extentLogger.log(LogStatus.INFO, "Navigated to Agile Central Drupal site.");

		SearchData searchData = DataProviderClass.getSearchData(11);
		extentLogger.log(LogStatus.INFO, "Seaching the Keyword: " + searchData.getKeyword());
		homePage.filterSearchKeyword(searchData.getKeyword());

		// verify Search result heading text on search page and in breadcrumbs
		extentLogger.log(LogStatus.INFO,
				"Verifying that search results heading text on search page and in breadcrumbs");

		verify.assertTrue(
				internalUsersHomePage.getTextOfSearchResultString()
						.equals(StringConstants.UITranslationSearchResultTextOnSearchPage),
				"Search Results header text should be translated in German as: "
						+ StringConstants.UITranslationSearchResultTextOnSearchPage);
		if (internalUsersHomePage.getTextOfSearchResultString()
				.equals(StringConstants.UITranslationSearchResultTextOnSearchPage)) {
			extentLogger.log(LogStatus.PASS,
					"Verified that Search Results header text is properly translated in German as :"
							+ internalUsersHomePage.getTextOfSearchResultString());
		} else {
			extentLogger.log(LogStatus.FAIL,
					"Verified that Search Results header text could not translated in German and displayed as: "
							+ internalUsersHomePage.getTextOfSearchResultString());
		}

		verify.assertTrue(
				internalUsersHomePage.getTextOfSearchResultsBreadcrumb()
						.equals(StringConstants.UITranslationSearchResultTextOnSearchPage),
				"Search Results breadcrumb text should be properly translated in German on search results page as: "
						+ StringConstants.UITranslationSearchResultTextOnSearchPage);
		if (internalUsersHomePage.getTextOfSearchResultsBreadcrumb()
				.equals(StringConstants.UITranslationSearchResultTextOnSearchPage)) {
			extentLogger.log(LogStatus.PASS,
					"Verified that Search Results breadcrumb text is properly translated in German as :"
							+ internalUsersHomePage.getTextOfSearchResultsBreadcrumb());
		} else {
			extentLogger.log(LogStatus.FAIL,
					"Verified that Search Results breadcrumb text could not translated in German and displayed as: "
							+ internalUsersHomePage.getTextOfSearchResultsBreadcrumb());
		}

		// verify Free Trial Field is translated in german
		extentLogger.log(LogStatus.INFO, "Verifying that Free Trial Field is translated in German");

		verify.assertTrue(internalUsersHomePage.getTextOfFreeTrial().equals(StringConstants.UITranslationFreeTrial),
				"Free trial text should be properly translated in German");
		if (internalUsersHomePage.getTextOfFreeTrial().equals(StringConstants.UITranslationFreeTrial)) {
			extentLogger.log(LogStatus.PASS, "Verified that Free trial text is properly translated in German as :"
					+ internalUsersHomePage.getTextOfFreeTrial());
		} else {
			extentLogger.log(LogStatus.FAIL,
					"Verified that Free trial text could not translated in German and displayed as: "
							+ internalUsersHomePage.getTextOfFreeTrial());
		}

		verify.assertAll();
		extent.endTest(extentLogger);
	}

	@Test(groups = { "TC115804" }, priority = 21)
	public void Verify_legal_Notice_Page_Is_Available() throws InterruptedException {

		SoftAssert verify = new SoftAssert();

		logger.info("TC115804_Verify_legal_Notice_Page_Is_Available is started.");
		extentLogger = extent.startTest("TC115804_Verify_legal_Notice_Page_Is_Available");
		logger.info("TC115804_Verify_legal_Notice_Page_Is_Available");

		// Login as customer
		userLogin.login(DataProviderClass.getCustomerUserDetails().getUser(),
				DataProviderClass.getCustomerUserDetails().getPw());
		extentLogger.log(LogStatus.INFO, "Logged in as Customer");

		ArticleData articleData = DataProviderClass.getArticleData(48);

		// Navigating to Documentation legal Notice Page through ToC
		extentLogger.log(LogStatus.INFO,
				"Verifying whether the Documentation legal notice page is accessible through ToC");
		homePage.accessToCArticle(articleData.getMenuLinkTitle());
		extentLogger.log(LogStatus.INFO,
				"Verifying that the navigated page should be: " + StringConstants.LEGAl_NOTICE);
		verify.assertTrue(driver.getTitle().contains(StringConstants.LEGAl_NOTICE),
				"It should be navigated to page :" + StringConstants.LEGAl_NOTICE + " page when accessed by ToC");
		if (driver.getTitle().contains(StringConstants.LEGAl_NOTICE)) {
			extentLogger.log(LogStatus.PASS,
					"Verified that Documentation legal Notice Page is accessible through ToC. Navigated page Title is :"
							+ driver.getTitle());
		} else {
			extentLogger.log(LogStatus.FAIL,
					"Verified that Documentation legal Notice Page is Not accessible through ToC. Navigated page Title is :"
							+ driver.getTitle());
		}

		// Navigating to Documentation legal Notice Page through URL
		driver.navigate().to(configReader.getDrupalBaseURL() + articleData.getUrlAlias());
		extentLogger.log(LogStatus.INFO, "Navigated to Documentation legal Notice Page through URL");
		new WebDriverWait(driver, 60).until(ExpectedConditions.titleContains(StringConstants.LEGAl_NOTICE));

		// Verifying that the navigated page should be : Documentation legal
		// Notice Page
		extentLogger.log(LogStatus.INFO,
				"Verifying that the navigated page should be: " + StringConstants.LEGAl_NOTICE);
		verify.assertTrue(driver.getTitle().contains(StringConstants.LEGAl_NOTICE),
				"It should be navigated to page :" + StringConstants.LEGAl_NOTICE);
		if (driver.getTitle().contains(StringConstants.LEGAl_NOTICE)) {
			extentLogger.log(LogStatus.PASS,
					"Verified that Documentation legal Notice Page is available and accessible through URL. Navigated page Title is :"
							+ driver.getTitle());
		} else {
			extentLogger.log(LogStatus.FAIL,
					"Verified that Documentation legal Notice Page is Not available and accessible through URL. Navigated page Title is :"
							+ driver.getTitle());
		}

		// Getting the values of language drop down list.
		List<String> langs = internalUsersHomePage.getAllLanguageValues();
		extentLogger.log(LogStatus.INFO,
				"Verifying whether the language drop down contains all the 4 languages required which are English, German, French and Japanese.");

		verify.assertTrue(
				langs.contains("English") && langs.contains("German") && langs.contains("French")
						&& langs.contains("Japanese"),
				"Language dropdown must contains the 4 languages which are English, German, French and Japanese.");
		if (langs.contains("English") && langs.contains("German") && langs.contains("French")
				&& langs.contains("Japanese")) {
			extentLogger.log(LogStatus.PASS, "Verified that Language dropdown contains the 4 languages specified");
		} else {
			extentLogger.log(LogStatus.FAIL,
					"Verified that Language dropdown does not contains the 4 languages specified and contains only: "
							+ langs.toString());
		}

		verify.assertAll();
		extent.endTest(extentLogger);
	}

}
