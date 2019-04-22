//package com.ca.tools.docops.tests;
//
//import org.testng.annotations.BeforeClass;
//import org.testng.annotations.Test;
//import org.testng.log4testng.Logger;
//
//import com.ca.tools.docops.pageObjectRepository.CustomerHomePage;
//import com.ca.tools.docops.pageObjectRepository.GroupsPage;
//import com.ca.tools.docops.pageObjectRepository.InternalUsersHomePage;
//import com.ca.tools.docops.pageObjectRepository.MainPage;
//import com.ca.tools.docops.pageObjectRepository.UserLoginPage;
//import com.ca.tools.docops.utils.DataProviderClass;
//
//import junit.framework.Assert;
//
//public class CustomerOperations extends BaseTest {
//    private static final Logger logger = Logger.getLogger(CustomerOperations.class);
//    private MainPage mainPage;
//    private InternalUsersHomePage internalUsersHomePage;
//    private UserLoginPage userLogin;
//    private CustomerHomePage customerHomePage;
//
//    @BeforeClass
//    public void initialize() {
//        logger.info("beforeclass has been called");
//        mainPage = new MainPage(driver);
//        new GroupsPage(driver);
//        internalUsersHomePage = new InternalUsersHomePage(driver);
//        customerHomePage = new CustomerHomePage(driver);
//        userLogin = new UserLoginPage(driver);
////        mainPage.clickGroups();
////        groupsPage.addGroup(DataProviderClass.getReleaseName(), DataProviderClass.getProductName(),
////                DataProviderClass.getProductIdentifier(), DataProviderClass.getVersionIdentifier(), "EN",
////                DataProviderClass.getConfluenceSpacekey(), DataProviderClass.getBaseVersion(),
////                DataProviderClass.getAlias());
//        mainPage.clickGroups();
//        internalUsersHomePage.addUserToTheRelease(DataProviderClass.getReleaseName(),
//                DataProviderClass.getDocAdminUserDetails().getUser(), DataProviderClass.getDocAdminUserDetails().getRole());
//        internalUsersHomePage.addUserToTheRelease(DataProviderClass.getReleaseName(), DataProviderClass.getCustomerUserDetails().getUser(),
//                DataProviderClass.getCustomerUserDetails().getRole());
//        userLogin.logut();
//    }
//
//    @Test(groups = {
//            "TC86455" }, priority = 0, dataProvider = "getArticle6Data", dataProviderClass = DataProviderClass.class)
//    public void accessArticleUsingURL(String title, String hid, String alias, String weight) throws Exception {
//        logger.info("accessArticleUsingURL Test started");
//        extentLogger = extent.startTest("accessArticleUsingURL");
//        userLogin.login(DataProviderClass.getDocAdminUserDetails().getUser(), DataProviderClass.getDocAdminUserDetails().getPw());
//        internalUsersHomePage.navigateToReleaseHomepage(DataProviderClass.getReleaseName());
//        internalUsersHomePage.saveAndPublish(title, hid, alias, hid, "", "");
//        userLogin.logut();
//        userLogin.login(DataProviderClass.getCustomerUserDetails().getUser(), DataProviderClass.getCustomerUserDetails().getPw());
//        customerHomePage.navigateToArticlepage(DataProviderClass.getProductIdentifier(), DataProviderClass.getVersionIdentifier(), title);
//        Assert.assertTrue(driver.getTitle().contains(title));
//        extent.endTest(extentLogger);
//    }
//
//    @Test(groups = {
//            "TC86454" }, priority = 1, dataProvider = "getArticle6Data", dataProviderClass = DataProviderClass.class)
//    public void accessArticleUnderPublishedGroup(String title, String hid, String alias, String weight)
//            throws Exception {
//        driver.navigate().to(configReader.getDrupalBaseURL());
//        logger.info("accessArticleUnderPublishedGroup Test started");
//        extentLogger = extent.startTest("accessArticleUnderPublishedGroup");
//        customerHomePage.accessArticleUnderPublishedGroup(DataProviderClass.getProductName(), DataProviderClass.getReleaseName(),title);
//        Assert.assertTrue(driver.getTitle().contains(title));
//        userLogin.logut();
//        extent.endTest(extentLogger);
//    }
//}
