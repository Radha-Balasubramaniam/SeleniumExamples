package com.ca.tools.docops.pageObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.ca.tools.docops.common.CommonActions;
import com.ca.tools.docops.utils.StringConstants;
import com.relevantcodes.extentreports.LogStatus;

public class ExtendPage {
    private WebDriver driver;

    public ExtendPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    
    @FindBy(xpath = "//*[@id='edit-modules-search--2']//tr//td//span[text()='Provides a generic framework for modules offering search capabilities.']") private WebElement SearchAPILink;
    @FindBy(linkText = "Install new module") private WebElement installNewModule;        
    @FindBy(xpath = "//*[@id='edit-modules-search--2']//tr//a[text()='Configure ']") private WebElement ConfigureSearchAPI;
    @FindBy(xpath = "//*[@id='search-api-entity-list']/tbody/tr[@title='ID: acquia_search_index']//a[text()='Edit']") private WebElement AcquiaSearchSolrIndexEditButton;
    @FindBy(xpath = "//*[@id='block-seven-primary-local-tasks']//a[text()='View']") private WebElement ViewTabOnAcquiaSearchSolrIndex;        
    @FindBy(id = "edit-clear") private WebElement clearAllIndexedData;   
    @FindBy(id="edit-submit") private WebElement confirmClearIndexedData;
    @FindBy(id = "edit-reindex") private WebElement QueueAllItemsForIndexing;
    @FindBy(id="edit-submit") private WebElement confirmQueueIndexedData;
    @FindBy(id = "edit-index-now") private WebElement IndexNowButton;
    By SuccessIndexingMsg = By.xpath("/html/body/div[2]/main/div[@class='region region-highlighted']/div[@class='messages messages--status' and contains(.,'Successfully indexed ')]");
    
  //  @FindBy(xpath = "/html/body/div[2]/main/div[2]/div[contains(.,'Successfully indexed ')]") private WebElement SuccessIndexingMsg; 
    
    public boolean isSuccessIndexingMsgDisplayed(){
    	
    	CommonActions.waitUntil(driver, SuccessIndexingMsg, 300);
    	if(driver.findElements(SuccessIndexingMsg).size()!=0){
    		
    		return true;
    	}else{
    		return false;
    	}
    }
    
    public void clickSearchAPI() {
    	JavascriptExecutor je = (JavascriptExecutor) driver;
    	je.executeScript("arguments[0].scrollIntoView(true);",SearchAPILink);
        CommonActions.javaScriptClick(SearchAPILink, driver);
    }

    public void clickConfigureSearchAPI() {
    	
        CommonActions.javaScriptClick(ConfigureSearchAPI, driver);
    }
   
    public void clickAcquiaSearchSolrIndexEditButton() {
    	
        CommonActions.javaScriptClick(AcquiaSearchSolrIndexEditButton, driver);
    }

    public void clickViewTabOnAcquiaSearchSolrIndex() {
    	
        CommonActions.javaScriptClick(ViewTabOnAcquiaSearchSolrIndex, driver);
    }
 
    public void clickOnclearAllIndexedData() {
 	
     CommonActions.javaScriptClick(clearAllIndexedData, driver);
 }
    public void clickOnQueueAllItemsForIndexing() {
 	
     CommonActions.javaScriptClick(QueueAllItemsForIndexing, driver);
 }
    public void clickOnIndexNowButton() {
 	
     CommonActions.javaScriptClick(IndexNowButton, driver);
 }
 
    public void clickOnconfirmClearIndexedData() {
	 	
     CommonActions.javaScriptClick(confirmClearIndexedData, driver);
 }
 
    public void clickOnConfirmQueueIndexing() {
	 	
     CommonActions.javaScriptClick(confirmQueueIndexedData, driver);
 }
    
    public void runIndexingJob() {
                clickSearchAPI();
                clickConfigureSearchAPI();
                clickAcquiaSearchSolrIndexEditButton();
                clickViewTabOnAcquiaSearchSolrIndex();
                clickOnclearAllIndexedData();
                clickOnconfirmClearIndexedData();
                clickOnQueueAllItemsForIndexing();
                clickOnConfirmQueueIndexing();
                clickOnIndexNowButton();
                Assert.assertTrue(isSuccessIndexingMsgDisplayed(), "Indexing should have run successfully.");
    }
 
}
