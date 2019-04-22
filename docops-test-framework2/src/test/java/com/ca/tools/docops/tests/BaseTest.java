package com.ca.tools.docops.tests;

import java.io.File;
import java.io.IOException;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.UnknownHostException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.ca.tools.docops.common.DocOpsCommonMethods;
import com.ca.tools.docops.dtos.ArticleData;
import com.ca.tools.docops.pageObjectRepository.ConfigPage;
import com.ca.tools.docops.pageObjectRepository.ContentPage;
import com.ca.tools.docops.pageObjectRepository.ExtendPage;
import com.ca.tools.docops.pageObjectRepository.HomePage;
import com.ca.tools.docops.pageObjectRepository.InternalUsersHomePage;
import com.ca.tools.docops.pageObjectRepository.MainPage;
import com.ca.tools.docops.pageObjectRepository.PeoplePage;
import com.ca.tools.docops.pageObjectRepository.StructurePage;
import com.ca.tools.docops.pageObjectRepository.UserLoginPage;
import com.ca.tools.docops.utils.AutomationLogger;
import com.ca.tools.docops.utils.ConfigReader;
import com.ca.tools.docops.utils.DataProviderClass;
import com.ca.tools.docops.utils.InputData;
import com.ca.tools.docops.utils.StringConstants;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class BaseTest {
	private static final Logger logger = Logger.getLogger(BaseTest.class);
	public static WebDriver driver;
	protected ConfigReader configReader;
	protected InputData inputData;
	ExtentTest extentLogger;
	protected DocOpsCommonMethods dcm;
	protected ExtentReports extent;
	protected PeoplePage peoplePage;
	protected UserLoginPage userLogin;
	protected MainPage mainPage;
	protected StructurePage structurePage;
	protected ContentPage contentPage;
	protected InternalUsersHomePage internalUsersHomePage;
	protected ConfigPage configPage;
	protected HomePage homePage;
	ExtendPage extendPage;
	public static int failcount = 0;
	static String DriverPaths = null;
	public static List<String> failureName = new ArrayList<String>();
	public static String environmentName = null;
	private static String separator = System.getProperty("file.separator");
	{
		AutomationLogger.configure();
		configReader = new ConfigReader();
		inputData = new InputData();
	}

	@Parameters({ "browser", "environment", "driverPath", "SuiteName" })
	@BeforeSuite
	public void load(@Optional("chrome") String browser, @Optional("!local") String environment,
			@Optional("drivers/chromedriver.exe") String driverPath, String SuiteName) throws Exception {
		logger.info("Before Suite has been called");
		if ("local".equals(environment)) {
			System.setProperty("webdriver.chrome.driver", driverPath);
			System.setProperty("org.uncommons.reportng.escape-output", "false");
			ChromeOptions chromeOptions = new ChromeOptions();
			chromeOptions.addArguments("--start-maximized");
			chromeOptions.addArguments("--disable-web-security");
			chromeOptions.addArguments("--no-proxy-server");
			Map<String, Object> prefs = new HashMap<String, Object>();
			prefs.put("credentials_enable_service", false);
			prefs.put("profile.password_manager_enabled", false);
			chromeOptions.setExperimentalOption("prefs", prefs);
			driver = new ChromeDriver(chromeOptions);
		} else {
			driver = new RemoteWebDriver(new URL(configReader.getGridUrl()),
					getBrowserCapabilities(browser, SuiteName));
			driver.manage().window().maximize();
		}
		DriverPaths = driverPath;
		driver.manage().timeouts().pageLoadTimeout(80, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.navigate().to(configReader.getAgileCentralHome());
		environmentName = driver.getCurrentUrl().split(".com")[0].replace("https://", "").replace(".ca", "")
				.substring(0, 1).toUpperCase()
				+ driver.getCurrentUrl().split(".com")[0].replace("https://", "").replace(".ca", "").substring(1);
	}

	public static String getDriverPath() {
		return DriverPaths;
	}

	public static String getEnvName() {
		return environmentName;
	}

	protected static DesiredCapabilities getBrowserCapabilities(String browserType, String SuiteName) {
		switch (browserType) {
		case "firefox":
			logger.info("Opening firefox driver");
			return DesiredCapabilities.firefox();
		case "chrome":
			logger.info("Opening chrome driver");
			System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
			DesiredCapabilities chromeCaps = DesiredCapabilities.chrome();
			return chromeCaps;
		case "IE":
			logger.info("Opening IE driver");
			return DesiredCapabilities.internetExplorer();
		default:
			logger.info("browser : " + browserType + " is invalid, Launching Firefox as browser of choice..");
			return DesiredCapabilities.chrome();
		}
	}

	public static String getScreenShot(WebDriver driver, String screenshotName) throws Exception {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		String finalDestination = "target" + separator + "surefire-reports" + separator + "screenshots" + separator
				+ screenshotName + ".png";
		FileUtils.copyFile(source, new File(finalDestination));
		return finalDestination.toString();
	}

	@AfterMethod
	public void getResult(ITestResult result) throws Exception {
		logger.debug("After method has been called");
		if (result.getStatus() == ITestResult.FAILURE) {
			extentLogger.log(LogStatus.FAIL,
					"Test Case " + result.getName() + " failed due to the error " + result.getThrowable().getMessage());
			// To add it in the extent report
			failcount = failcount + 1;
			failureName.add(result.getName());
			extentLogger.log(LogStatus.FAIL, extentLogger
					.addScreenCapture(System.getProperty("user.dir") + "/" + getScreenShot(driver, result.getName())));
		} else if (result.getStatus() == ITestResult.SKIP) {
			extentLogger.log(LogStatus.SKIP, "Test Case " + result.getName() + " has been skipped");
		} else {
			extentLogger.log(LogStatus.PASS, "Test case " + result.getName() + " has passed");
		}
		// Delete browser cookies
		userLogin.logout();
		driver.manage().deleteAllCookies();
		extent.endTest(extentLogger);
	}

	@Parameters({ "SuiteName" })
	@BeforeClass
	public void initialize(String SuiteName) {
		logger.info("beforeclass has been called");
		mainPage = new MainPage(driver);
		peoplePage = new PeoplePage(driver);
		dcm = new DocOpsCommonMethods(driver);
		userLogin = new UserLoginPage(driver);
		internalUsersHomePage = new InternalUsersHomePage(driver);
		contentPage = new ContentPage(driver);
		configPage = new ConfigPage(driver);
		homePage = new HomePage(driver);
		extendPage = new ExtendPage(driver);
		String seperator = System.getProperty("file.separator");
		extent = new ExtentReports(
				"target" + seperator + "surefire-reports" + seperator + "DocOps2.0-" + SuiteName + "-report.html",
				false);
	}

	public void cleanup() {
		userLogin.logout();
		userLogin.login(configReader.getDocOpsUserName(StringConstants.USER_NAME),
				configReader.getDocOpsPassword(StringConstants.PASSWORD));
		mainPage.clickContent();
		contentPage.deleteArticle(StringConstants.ARTICLE_PREFIX);

	}

	@AfterSuite(alwaysRun = true)
	public void clean() throws InterruptedException {
		logger.debug("after suite has been called");

		try {
			cleanup();
		} catch (Exception e) {
			logger.error("cleanup failed due to the error", e);
		} finally {
			driver.close();
			driver.quit();
		}
	}

	@SuppressWarnings("unused")
	private void copyReport() throws IOException {
		String separator = System.getProperty("file.separator");
		String reportPath = "target" + separator + "surefire-reports";
		String destFolder = configReader.getValue(StringConstants.AUTOMATION_LOGS_FOLDER) + separator
				+ "AutomationReports" + separator + new SimpleDateFormat("yyyy-MM-dd-hh-mm-ss").format(new Date());
		File destDir = new File(destFolder);
		FileUtils.copyDirectory(new File(reportPath), destDir);

	}

	@AfterClass(alwaysRun = true)
	public void tear() {
		extent.endTest(extentLogger);
		extent.flush();
		extent.close();
	}

	public static String countFailures() {

		if (failcount != 0) {
			return failcount + " Failed";
		} else {
			return "All Passed";
		}
	}

	public static List<String> printFailuresName() {
		return failureName;
	}
}
