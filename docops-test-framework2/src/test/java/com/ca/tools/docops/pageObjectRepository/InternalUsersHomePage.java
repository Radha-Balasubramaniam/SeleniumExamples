package com.ca.tools.docops.pageObjectRepository;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.ca.tools.docops.common.CommonActions;
import com.ca.tools.docops.utils.ConfigReader;
import com.ca.tools.docops.utils.StringConstants;

public class InternalUsersHomePage {
    public WebDriver driver;
    public ConfigReader configReader;

    public InternalUsersHomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        configReader = new ConfigReader();
    }
    @FindBy(xpath = "//*[text()='Add group']") public WebElement addGroup;
    String commonXpathLoator = "//a[text()='AAAAA']";
    @FindBy(id = "searchKeyword") private WebElement searchField;
    @FindBy(id = "edit-operation") private WebElement manageTranslationOperations;
    @FindBy(id = "edit-submit") private WebElement manageTranslationExecute;
    @FindBy(xpath = "//*[@class='btn btn-default btn-sm search-form-submit-btn']") private WebElement searchIcon;
    @FindBy(xpath = ".//button[contains(.,'Contents')]") private WebElement contentsLinkButton;
    @FindBy(xpath="//*[@id='page-content']/div[1]/nav/ul/li/a[contains(text(),'View')]") private WebElement viewArticle;
    @FindBy(xpath="//*[@id='page-content']/div[1]/nav/ul/li/a[contains(text(),'Translate')]") private WebElement translateArticle;
    @FindBy(xpath="//*[@id='page-content']/div[1]/nav/ul/li/a[contains(text(),'Revisions')]") private WebElement RevisionsArticle;
    @FindBy(xpath="//*[text()='Edit draft']") private WebElement editDraftArticle;
    @FindBy(linkText="New draft") private WebElement editPublishedArticle;
    @FindBy(xpath="//*[@id='page-content']/div[1]/nav/ul/li/a[contains(text(),'Delete')]") private WebElement deleteArticle;
    @FindBy(linkText="Latest version") private WebElement latestVersionTab;
    @FindBy(linkText = "Manage Translations") private WebElement manageTranslationsTab;
    @FindBy(id="edit-submit") private WebElement submit;
    @FindBy(xpath="//*[@id='page-body']//*[@id='rightacblock']//*[@id='block-headsup']") private WebElement headsUpBlock;
    @FindBy(xpath="//*[@id='page-body']//*[@id='rightacblock']//*[@id='block-fordevelopers']") private WebElement forDevelopersBlock;
    @FindBy(xpath="//*[@id='page-content']/div/article/div//a/img[@title='TitleOfVideo']") private WebElement VideoAddedtoArticle;
    @FindBy(id = "cboxClose") private WebElement closeColourBox;
    @FindBy(xpath = "//section[@id='block-views-block-feedback-block-1']//h2[text()='Feedback']/following-sibling::div//p[contains(text(),'To submit feedback')]") private WebElement Feedback;
    @FindBy(xpath = "//*[@id='block-views-block-ac-quick-links-block-1']//a[text()='Customer Login']") private WebElement CustomerLoginQuickLinks;
    @FindBy(xpath = "//*[@id='block-views-block-ac-quick-links-block-1']//a[text()='Blog']") private WebElement BlogQuickLinks;
    @FindBy(xpath = "//*[@id='block-views-block-ac-quick-links-block-1']//a[text()='Share Ideas']") private WebElement ShareIdeasQuickLinks;
    @FindBy(xpath = "//*[@id='block-views-block-ac-quick-links-block-1']//a[text()='System Status']") private WebElement SystemStatusQuickLinks;
    @FindBy(xpath = "//*[@id='block-views-block-ac-quick-links-block-1']//a[text()='Support']") private WebElement SupportQuickLinks;
    @FindBy(xpath = "//h1[@id='article-title']//span[contains(@data-quickedit-field-id,'/title/')]") private WebElement articleTitle;
    @FindBy(xpath = ".//div[@id='page-content']//a[text()='App SDK 2.1']") private WebElement AppSDKLink;
    @FindBy(xpath = "//*[@id='mi-header-nav']/li[1]/a") private WebElement UITranslationheaderProduct;
    @FindBy(xpath = "//*[@id='mi-header-nav']/li[2]/a") private WebElement UITranslationheaderSolutions;
    @FindBy(xpath = "//*[@id='mi-header-nav']/li[3]/a") private WebElement UITranslationheaderEducTran;
    @FindBy(xpath = "//*[@id='mi-header-nav']/li[4]/a") private WebElement UITranslationheaderServiceSupport;
    @FindBy(xpath = "//*[@id='mi-header-nav']/li[5]/a") private WebElement UITranslationheaderPartners;
    @FindBy(xpath = "//*[@id='mi-header-nav']/li[6]/a") private WebElement UITranslationheaderCompany;
    @FindBy(xpath = "//*[@id='block-fordevelopers']/h2") private WebElement UITranslationForDeveloper;
    @FindBy(xpath = "//*[@id='block-headsup']/h2") private WebElement UITranslationHeadsUp;
    @FindBy(xpath = "//*[@id='breadcrumb-dynamic']/li/a") private WebElement UITranslationHome;
    @FindBy(xpath = "//*[@id='toc-navigation-toggle']") private WebElement UITranslationContents;
    @FindBy(xpath = "//*[@id='languages-dropdown']") private WebElement UITranslationLanguages;
    @FindBy(xpath = "//*[@id='cacomFooter']/div/div/div/div[1]/ul/li[1]/a") private WebElement UITranslationFooterPrivacy;
    @FindBy(xpath = "//*[@id='cacomFooter']/div/div/div/div[1]/ul/li[2]/a") private WebElement UITranslationFooterLegal;
    @FindBy(xpath = "//*[@id='cacomFooter']/div/div/div/div[1]/ul/li[3]/a") private WebElement UITranslationFooterDataTransfers;
    @FindBy(xpath = "//*[@id='cacomFooter']/div/div/div/div[1]/ul/li[4]/a") private WebElement UITranslationFooterSiteMap;
    @FindBy(xpath = "//*[@id='cacomFooter']/div/div/div/div[1]/ul/li[5]/a") private WebElement UITranslationFooterImprint;
    @FindBy(xpath = "//*[@id='block-views-block-ac-quick-links-block-1']/h2") private WebElement UITranslationQuickLinks;
    @FindBy(xpath = "//*[@id='j1_1_anchor']") private WebElement UITranslationCustomerLogin;
    @FindBy(xpath = "//*[@id='j1_2_anchor']") private WebElement UITranslationBlog;
    @FindBy(xpath = "//*[@id='j1_3_anchor']") private WebElement UITranslationShareIdeas;
    @FindBy(xpath = "//*[@id='j1_4_anchor']") private WebElement UITranslationSystemStatus;
    @FindBy(xpath = "//*[@id='j1_5_anchor']") private WebElement UITranslationSupport;
    @FindBy(xpath = "//*[@id='block-agilecentralmenu']/h2") private WebElement UITranslationBrowseHelp;
    @FindBy(xpath = "//input[@id='searchKeyword']") private WebElement UITranslationSearchPlaceHolders;
    @FindBy(xpath = "//h1[@id='article-title']") private WebElement UITranslationSearchResultsString;
    @FindBy(xpath = "//*[@id='breadcrumb-dynamic']/li[2]") private WebElement UITranslationSearchResultsBreadcrumb;
    @FindBy(xpath = "//*[@id='cacomHeader']/div/div[1]/div/div[1]/a") private WebElement UITranslationFreeTrial;
    @FindBy(xpath = "//*[@id='block-views-block-feedback-block-1']/div/div/div/div/div/span/p") private WebElement UITranslationFeedbackParaText;
    @FindBy(xpath = "//input[@type='checkbox'][starts-with(@id,'edit-table-node')]") private WebElement selectFromManageTranslation;
    @FindBy(xpath = "//*[@id='page-content']/div[1]/div") public WebElement messageFromManageTranslation;
    @FindBy(xpath = "//*[@class='messages messages--error']/div") public WebElement articlealiasErrorMessage;
    
    String ImageAddedtoArticle = "//*[@id='page-content']/div/article/div//a/img[@alt='AAAAA']";
    String colourBox = "//div[@id='colorbox' and contains(@style,'display: block;')]";
    String breadCrumbsLink = "//*[@id='breadcrumb-container']/ul/li";
    String articlesParentArticleMenuLink = "//*[@id='toc_menu']//a[text()='XXXXX']/parent::li/parent::ul//preceding-sibling::a";
    String articlesGrandParentArticleMenuLink ="//*[@id='toc_menu']//a[text()='XXXXX']/parent::li/parent::ul/parent::li/parent::ul/preceding-sibling::a";
    String ToCHidden = "//div[contains(@class,'toc-collapsed')]";
    String ToCDisplayed = "//*[@id='page-content-wrapper']/div[1][contains(@class,'col-md-3')]";
    String LanguageDropDownValues = "//*[@id='languages']/li/a";
    
    
	public List<String> getAllLanguageValues(){
		UITranslationLanguages.click();
    	ArrayList<WebElement> languagesAvailable =  (ArrayList<WebElement>) driver.findElements(By.xpath(LanguageDropDownValues));
    	ArrayList<String> list = new ArrayList<>();
    	for(WebElement lang: languagesAvailable){
    		String LAN = lang.getText(); 
    		list.add(LAN);
    	}
    	return list;
    }
	
	public void switchArticleLanguage(String language) {
	UITranslationLanguages.click();
    driver.findElement(By.linkText(language)).click();
	}
    
    public void accessArticleWithUrlAlias(String articleAlias) {
        driver.navigate().to(configReader.getDrupalBaseURL() + "/"+configReader.getLocale() + articleAlias);
    }
    
    public void accessArticleWithLocale(String articleAlias,String locale) {
    	  driver.navigate().to(configReader.getDrupalBaseURL() + "/"+ locale + articleAlias);
    }
    
    public void editDraftArticle(){
        CommonActions.javaScriptClick(editDraftArticle, driver);
    }
    
    public void editPublishedArticle(){
        CommonActions.javaScriptClick(editPublishedArticle, driver);
    }
    
    public void deleteArticle(){
        CommonActions.javaScriptClick(deleteArticle, driver);
        submit.click();
    }
    
    public void goToLatestVersionTab(){
        CommonActions.javaScriptClick(latestVersionTab, driver);
    }
    
    public void goToManageTranslationsTab(){
        CommonActions.javaScriptClick(manageTranslationsTab, driver);
    }
    
    public int getBreadCrumCount(){
      return driver.findElements(By.xpath(breadCrumbsLink)).size();
    }
    
    public boolean isArticleDeletedMessageDisplayed(String article){
        String articleDeletionMessage = "//*[@role='contentinfo' and contains(.,'Agile Central Help Topic ') and contains(.,'has been deleted')]//*[text()='"
                + article + "']";
        return driver.findElements(By.xpath(articleDeletionMessage)).size() != 0;
    }
    
    public boolean isArticleCreatedMessageDisplayed(String article){
        String articleCreationMessage = "//*[@role='contentinfo' and contains(.,'Agile Central Help Topic ') and contains(.,'has been created')]//a[text()='"
                + article + "']";
        By elem = By.xpath(articleCreationMessage);
        new WebDriverWait(driver, 60).until(ExpectedConditions.presenceOfElementLocated(elem));
        return driver.findElements(By.xpath(articleCreationMessage)).size() != 0;
    }
    
    public boolean isArticleCreatedMessageDisplayedForIntegrationContentTypeArticle(String article){
        String articleCreationMessag = "//*[@role='contentinfo' and contains(.,'Agile Central Integrations') and contains(.,'has been created')]//a[text()='"
                + article + "']";
        By elem = By.xpath(articleCreationMessag);
        new WebDriverWait(driver, 60).until(ExpectedConditions.presenceOfElementLocated(elem));
        return driver.findElements(By.xpath(articleCreationMessag)).size() != 0;
    }
    
    public boolean isArticleUpdatedMessageDisplayed(String article){
        String articleUpdatedMessage = "//*[@role='contentinfo' and contains(.,'Agile Central Help Topic ') and contains(.,'has been updated')]//a[text()='"
                + article + "']";
        return driver.findElements(By.xpath(articleUpdatedMessage)).size() != 0;
    }
    
    public boolean isArticleAliasInUseErrorMessageDisplayed(){
    	return articlealiasErrorMessage.getText().contains("The alias is already in use.");
    }
    
    public boolean isArticleAliasStartswithSlashErrorMessageDisplayed() {
    	return articlealiasErrorMessage.getText().contains("The alias needs to start with a slash.");
    }
    
    public boolean isArticleLinkDisplayedInContentInfo(String link){
        String linkInArticleLocator = "//*[@id='page-content']//a[text()='"+ link + "']";
        return driver.findElements(By.xpath(linkInArticleLocator)).size() != 0;
    }
    
    
    public boolean isAccessDeniedErrorDisplayed(){
    	        String AccessDenied = "//*[@id='article-title']";
    	        return driver.findElement(By.xpath(AccessDenied)).getText().contentEquals("403 - Access Denied");
    	  }
    
    
    public void clickLinkInArticleBody(String link){
        if(isArticleLinkDisplayedInContentInfo(link))
        {
            String linkInArticleLocator = "//*[@id='page-content']//a[text()='"+ link + "']";
            driver.findElement(By.xpath(linkInArticleLocator)).click();
        }
    }
    
    public String getBreadCrumText(int level){
        return driver.findElements(By.xpath(breadCrumbsLink)).get(level).getText();
      }
    
    public void logOutAndCleanCookies(UserLoginPage userLogin) {
        userLogin.logout();
        driver.manage().deleteAllCookies();
    }
    
    public boolean headsUpFieldPresentInArticleView(){
        try{
            headsUpBlock.isDisplayed();
            return true;
        }catch(Exception e){
            return false;
        }
    }
    
    public String getHeadUpText(){
        if(headsUpFieldPresentInArticleView()){
            return driver.findElement(By.xpath("//section[@id='block-headsup']//p")).getText();
        }
        return "";
    }

    public String getTextFromForDevelopersBlock(){
        if(forDevelopersFieldPresentInArticleView()){
            return driver.findElement(By.xpath("//section[@id='block-fordevelopers']//p")).getText();
        }
        return "";
    }
    public boolean forDevelopersFieldPresentInArticleView(){
        try{
            forDevelopersBlock.isDisplayed();
            return true;
        }catch(Exception e){
            return false;
        }
    }
    public String getParentArticleMenuLinkTitle(String articlesMenuLinkTitle){
    	
		return driver.findElement(By.xpath(articlesParentArticleMenuLink.replace("XXXXX", articlesMenuLinkTitle))).getText();
	}
    public String getGrandParentArticleMenuLinkTitle(String articlesMenuLinkTitle){
    	
		return driver.findElement(By.xpath(articlesGrandParentArticleMenuLink.replace("XXXXX", articlesMenuLinkTitle))).getText();
	}
    public boolean isSearchFieldDisplayed(){
    	try{
    		searchField.isDisplayed();
    		return true;
    	}catch(Exception e){
    		return false;
    	}
    }
    public boolean isSearchIcondDisplayed(){
    	try{
    		searchIcon.isDisplayed();
    		return true;
    	}catch(Exception e){
    		return false;
    	}
    }

    public boolean isViewLinkDisplayed(){
    	try{
    		viewArticle.isDisplayed();
    		return true;
    	}catch(Exception e){
    		return false;
    	}
    }
    public boolean isEditDraftLinkDisplayed(){
    	try{
    		editDraftArticle.isDisplayed();
    		return true;
    	}catch(Exception e){
    		return false;
    	}
    }
    public boolean isNewDraftLinkDisplayed(){
    	try{
    		editPublishedArticle.isDisplayed();
    		return true;
    	}catch(Exception e){
    		return false;
    	}
    }
    public boolean isDeleteLinkDisplayed(){
    	try{
    		deleteArticle.isDisplayed();
    		return true;
    	}catch(Exception e){
    		return false;
    	}
    }
    public boolean isTranslateLinkDisplayed(){
    	try{
    		translateArticle.isDisplayed();
    		return true;
    	}catch(Exception e){
    		return false;
    	}
    }
    public boolean isRevisionsLinkDisplayed(){
    	try{
    		RevisionsArticle.isDisplayed();
    		return true;
    	}catch(Exception e){
    		return false;
    	}
    }
   
    
    public void clickOnImageOfArticle(String ImageName){
    	CommonActions.javaScriptClick(driver.findElement(By.xpath(ImageAddedtoArticle.replace("AAAAA", ImageName))), driver);
    }
    
    public void clickOnVideoOfArticle(){
    	new WebDriverWait(driver, 60).until(ExpectedConditions.elementToBeClickable(VideoAddedtoArticle));
    	CommonActions.javaScriptClick(VideoAddedtoArticle, driver);	
    }
    
    public void clickOnCloseColourBox(){
    	CommonActions.javaScriptClick(closeColourBox, driver);	
    }
    
    public boolean isColourboxDisplayed(){
        
        return driver.findElements(By.xpath(colourBox)).size()!=0;
    }
    
    public void clickOnContentsLinkButton(){
    	contentsLinkButton.click();
    	//CommonActions.javaScriptClick(contentsLinkButton, driver);	
    }
    
    public boolean isToCHidden(){
    	return driver.findElements(By.xpath(ToCHidden)).size()!=0;
    }
    public boolean isToCDisplayed(){
    	return driver.findElements(By.xpath(ToCDisplayed)).size()!=0;
    }
    public boolean isFeedbackDisplayed(){
    	try{
    		Feedback.isDisplayed();
    		return true;
    	}catch(Exception e){
    		return false;
    	}
    }
    public void clickOnCustomserLoginQuickLinks(){
    	CommonActions.javaScriptClick(CustomerLoginQuickLinks, driver);	
    }
    public void clickOnBlogQuickLinks(){
    	CommonActions.javaScriptClick(BlogQuickLinks, driver);	
    }
    public void clickOnShareIdeasQuickLinks(){
    	CommonActions.javaScriptClick(ShareIdeasQuickLinks, driver);	
    }
    public void clickOnSystemStatusQuickLinks(){
    	CommonActions.javaScriptClick(SystemStatusQuickLinks, driver);	
    }
    public void clickOnSupportQuickLinks(){
    	CommonActions.javaScriptClick(SupportQuickLinks, driver);	
    }
    public void clickOnBreadCrumLink(int level){
        driver.findElements(By.xpath(breadCrumbsLink)).get(level).click();
      }
    public String getArticleTitleFromPage(){
      return articleTitle.getText();
      }
    
    public void clickOnAppSDKLink(){
    	CommonActions.javaScriptClick(AppSDKLink, driver);	
    }

    public String getTextOfFeedbackPara(){
    	return UITranslationFeedbackParaText.getText();
    }
    public String getTextOfFreeTrial(){
    	return UITranslationFreeTrial.getText();
    }
    
    public String getTextOfSearchResultsBreadcrumb(){
    	return UITranslationSearchResultsBreadcrumb.getText();
    }
    
    public String getTextOfSearchResultString(){
    	return UITranslationSearchResultsString.getText();
    }
    
    public String getTextOfSearchPlaceHolder(){
    	return UITranslationSearchPlaceHolders.getAttribute("placeholder");
    }
    
    public String getTextOfQuickLinksField(){
    	return UITranslationQuickLinks.getText();
    }
    public String getTextOfUITranslationCustomerLogin(){
    	return UITranslationCustomerLogin.getText();
    }
    public String getTextOfUITranslationBlog(){
    	return UITranslationBlog.getText();
    }
    public String getTextOfUITranslationShareIdeas(){
    	return UITranslationShareIdeas.getText();
    }
    
    public String getTextOfUITranslationSystemStatus(){
    	return UITranslationSystemStatus.getText();
    }
    
    public String getTextOfUITranslationSupport(){
    	return UITranslationSupport.getText();
    }
    
    public String getTextOfBrowseHelpField(){
    	return UITranslationBrowseHelp.getText();
    }
    
    public String getTextOfFooterColumn1(){
    	return UITranslationFooterPrivacy.getText();
    }
    public String getTextOfFooterColumn2(){
    	return UITranslationFooterLegal.getText();
    }
    public String getTextOfFooterColumn3(){
    	return UITranslationFooterDataTransfers.getText();
    }
    public String getTextOfFooterColumn4(){
    	return UITranslationFooterSiteMap.getText();
    }
    public String getTextOfFooterColumn5(){
    	return UITranslationFooterImprint.getText();
    }
    
    public String getTextOfHeaderColumn1(){
    	return UITranslationheaderProduct.getText();
    }
    public String getTextOfHeaderColumn2(){
    	return UITranslationheaderSolutions.getText();
    }
    public String getTextOfHeaderColumn3(){
    	return UITranslationheaderEducTran.getText();
    }
    public String getTextOfHeaderColumn4(){
    	return UITranslationheaderServiceSupport.getText();
    }
    public String getTextOfHeaderColumn5(){
    	return UITranslationheaderPartners.getText();
    }
    public String getTextOfHeaderColumn6(){
    	return UITranslationheaderCompany.getText();
    }
    public String getTextOfHome(){
    	return UITranslationHome.getText();
    }
    public String getTextOfContents(){
    	return UITranslationContents.getText();
    }
    public String getTextOfForDevelopers(){
    	return UITranslationForDeveloper.getText();
    }
    public String getTextOfHeadsUp(){
    	return UITranslationHeadsUp.getText();
    }
    public String getTextOfLanguages(){
    	return UITranslationLanguages.getText();
    }
    public void selectArticleFromManageTranslation() {
    	selectFromManageTranslation.click();
    }
    public void selectManageTranslationOperation(String op) {
    	CommonActions.selectByValue(driver, manageTranslationOperations, op);
    }
    public void executeManageTranslationOperation() {
    	CommonActions.javaScriptClick(manageTranslationExecute, driver);
    }
    public String getManageTranslationOperationMessage() {
    	return messageFromManageTranslation.getText();
    }
}
