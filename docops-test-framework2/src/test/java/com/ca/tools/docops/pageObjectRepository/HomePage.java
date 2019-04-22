package com.ca.tools.docops.pageObjectRepository;

import java.awt.AWTException;
import java.awt.Robot;
import java.util.ArrayList;

import org.apache.commons.lang3.StringUtils;
import org.apache.poi.hssf.record.HeaderFooterRecord;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.ca.tools.docops.common.CommonActions;
import com.ca.tools.docops.utils.ConfigReader;
import com.ca.tools.docops.utils.DataProviderClass;
import com.ca.tools.docops.utils.StringConstants;
import com.relevantcodes.extentreports.LogStatus;

	public class HomePage {
    public WebDriver driver;
    public ConfigReader configReader;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        configReader = new ConfigReader();
    }
    @FindBy(id = "edit-field-product-name-target-id") private WebElement productListDropDown;
    @FindBy(id = "edit-submit-ca-home") private WebElement productFilter;
    @FindBy(xpath = ".//input[@name='search']") public WebElement SearchTextBox;
    @FindBy(xpath = "//*[@id='search-aside']/form/div[1]/span/button") public WebElement SearchEnter;
    @FindBy(xpath = "//*[@id='page-content']/div/div/div/div[@class='view-header']") public WebElement SearchCountString;
    @FindBy(xpath = ".//a[@title='CA Agile Central Help Home']") private WebElement CALogo;
    @FindBy(xpath = "//*[@id='block-views-block-ac-product-name-block-1']/div/div/div/div/div/span/a") private WebElement ProductHeading;
    @FindBy(xpath = "//*[@id='page-content']//div[@class='view-content']/div/div//div[@class='views-field views-field-nothing']/span[@class='field-content']") public WebElement SearchResultexcerpt;
    @FindBy(xpath = ".//*[@id='breadcrumb-container']//a[text()='Home']") private WebElement HomeBreadCrumb;
 
    String EngNoSearchResultFound = "//*[@id='page-content']//div[contains(text(),'No results found')]";
    String JapaneseNoSearchResultFound = "//*[@id='page-content']//div[contains(text(),'結果が見つかりません')]"; 
    String ToolBar = "toolbar-bar";
    String FooterDiv = ".//*[@class='cacomFooter__row']/div/ul//a[contains(text(),'Privacy')]";
    String headerDiv = ".//*[@class='cacomHeader__container']/a[@title='CA Agile Central Help Home']";
    String ResultArticleTitles = "//*[@id='page-content']//a[contains(@href,'ca-agile-central')]";
    String ExpandCollapse = "//*[@id='toc_menu']/ul/li//a[text()='EEEEE']/preceding-sibling::i";
    String VerifyExpanded = "//*[@id='toc_menu']/ul/li//a[text()='EEEEE']/preceding-sibling::i/parent::li[@aria-expanded='true']";
    String VerifyCollapsed ="//*[@id='toc_menu']/ul/li//a[text()='EEEEE']/preceding-sibling::i/parent::li[@aria-expanded='false']";
    String commonXpathLoator = "//a[text()='AAAAA']";

    public void navigateToReleaseHomepageForCustomers(String release) {
        // driver.findElement(By.xpath("//*[text()='"+release+"']")).click();
        driver.navigate().to(configReader.getDrupalBaseURL() + StringConstants.CUSTOMERS_URL 
        		+ DataProviderClass.getProductIdentifier() + "/" + DataProviderClass.getVersionIdentifier() + "/en");
    }

 
    public void filterProduct(String product) {
        Select select = new Select(productListDropDown);
        select.selectByVisibleText(product);
        productFilter.click();
    }
    
    public void accessToCArticle(String ArticleMenuLink) throws InterruptedException{
    	driver.navigate().to(configReader.getAgileCentralHome());
    	WebElement articleToC = driver.findElement(By.xpath("//*[@id='toc_menu']/ul//a[text()='"+ArticleMenuLink+"']"));
    	CommonActions.waitForElementToBeClickable(driver, articleToC);
    	CommonActions.javaScriptClick(articleToC, driver);
    }
    
    public void accessArticleUnderPublishedGroup(String product, String release, String article) {
        filterProduct(product);
        driver.findElement(By.xpath(commonXpathLoator.replace("AAAAA", release))).click();
        driver.findElement(By.xpath(commonXpathLoator.replace("AAAAA", article))).click();
    }
    
    public void filterSearchKeyword(String search) throws InterruptedException{
    	SearchTextBox.clear();
    	SearchTextBox.sendKeys(search);
    	SearchEnter.click();
    	
    }
    
    public boolean isNoResultFound(){
    	
    	if((driver.findElements(By.xpath(EngNoSearchResultFound))).size()!=0){
    		return true;
    	}else{
    		return false;
    	}
    }
    
    public boolean isJapaneseNoResultFound(){
    	
    	if((driver.findElements(By.xpath(JapaneseNoSearchResultFound))).size()!=0){
    		return true;
    	}else{
    		return false;
    	}
    	
    }

    public int getTotalResultCount(){
    	int count;
    	
    	if(isNoResultFound()){
    		count=0;
    	}else{
			    CommonActions.waitForElementToBeVisible(driver, SearchCountString);
			    String s=SearchCountString.getText();
			    	
			    	String[] sp = s.split(";");
			    	String newstr= sp[1];
					String half= newstr.split("of")[1].trim();
					String fin = half.split("results")[0].trim();
					 count = Integer.parseInt(fin);
    			}
		return count;
    }
    
    public int getResultCountOfCurrentPage(){
    	int ReultPerPage;
    	if(isNoResultFound()){
    		ReultPerPage=0;
    		return ReultPerPage;
    	}else{
    		String s=SearchCountString.getText();
        	
    		String[] sp = s.split("-");
    		
    		String str2= sp[1].split("of")[0].trim();
    		
    		String str1= sp[0].split("showing")[1].trim();
    		
    		int i2= Integer.parseInt(str2);
    		
    		int i1= Integer.parseInt(str1);
    		
    		 ReultPerPage = (i2-i1)+1;
    	}
    	return ReultPerPage;
    }
    
    public int getCountOfResultArticleTitles(){
		int number;
		if(isNoResultFound()){
			number=0;
			return number;
		}else{
			CommonActions.waitForElementToBeClickable(driver, driver.findElement(By.xpath(ResultArticleTitles)));
		    number =driver.findElements(By.xpath(ResultArticleTitles)).size();
			}
		return number;
    }
    
    public ArrayList<String> getSearchResultArticleTitles(){
    	ArrayList<String> titles = new ArrayList<>();
    	
		for(int i=0; i<driver.findElements(By.xpath(ResultArticleTitles)).size();i++){
			titles.add(driver.findElements(By.xpath(ResultArticleTitles)).get(i).getText());
		}
    	return titles;
    }
    
    public void navigateToArticlepage(String product, String release, String articleAlias) {
        driver.navigate().to(configReader.getDrupalBaseURL() + "/en-us/"+ product + "/" + release + "/" + articleAlias);
    }
    
    public void clickOnCALogo(){
    	CommonActions.waitForElementToBeClickable(driver,CALogo);
    	CommonActions.javaScriptClick(CALogo, driver);
    }
    
    public void clickOnProductHeading(){
    	CommonActions.waitForElementToBeClickable(driver,ProductHeading);
    	CommonActions.javaScriptClick(ProductHeading, driver);
    }
    
    public void clickOnHomeBreadCrumb(){
    	CommonActions.waitForElementToBeClickable(driver,HomeBreadCrumb);
    	CommonActions.javaScriptClick(HomeBreadCrumb, driver);
    }
    
    public void clickOnExpandCollpase(String ArticleMenuLink){
    	
    	CommonActions.waitForElementToBeClickable(driver, driver.findElement(By.xpath(ExpandCollapse.replace("EEEEE", ArticleMenuLink))));
    	CommonActions.javaScriptClick(driver.findElement(By.xpath(ExpandCollapse.replace("EEEEE", ArticleMenuLink))), driver);
    }
    
    public boolean VerifyIfExpanded(String ArticleMenuLink){
    	
    	if(driver.findElements(By.xpath(VerifyExpanded.replace("EEEEE", ArticleMenuLink))).size()!=0){
    		return true;
    	}else {
    		return false;
    	}
    }
    
    public boolean VerifyIfCollapsed(String ArticleMenuLink){
    	
    	if(driver.findElements(By.xpath(VerifyCollapsed.replace("EEEEE", ArticleMenuLink))).size()!=0){
    		return true;
    	}else{
    		return false;
    	}
    }
    
    public boolean VerifyHeaderDisplayed(){
    	
    	if(driver.findElements(By.xpath(headerDiv)).size()!=0){
    		return true;
    	}else{
    		return false;
    	}
    }
    
    public boolean VerifyFooterDisplayed(){
    	if(driver.findElements(By.xpath(FooterDiv)).size()!=0){
    		return true;
    	}else{
    		return false;
    	}
    }
    
    public boolean VerifyToolBarDisplayed(){
    	
    	if(driver.findElements(By.id(ToolBar)).size()!=0){
    		return true;
    	}else{
    		return false;
    	}
    }
    
    public String getArticleAttribute(String menuLink, String attribute){
    
    	return	driver.findElement(By.linkText(menuLink)).getAttribute(attribute);
    }
    
    public String get1stSearchResultArticleExcerpt(){
    	
        return SearchResultexcerpt.getText();
    }
}
