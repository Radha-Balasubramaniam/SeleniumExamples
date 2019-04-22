package com.ca.tools.docops.pageObjectRepository;

import java.awt.AWTException;
import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.ca.tools.docops.common.CommonActions;
import com.ca.tools.docops.dtos.ArticleData;
import com.ca.tools.docops.tests.BaseTest;
import com.ca.tools.docops.utils.ConfigReader;
import com.ca.tools.docops.utils.StringConstants;

public class ContentPage {
    private WebDriver driver;
    private InternalUsersHomePage internalUsersHomePage;
    private ConfigReader configReader;

    public ContentPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        internalUsersHomePage = new InternalUsersHomePage(driver);
        configReader = new ConfigReader();
    }
    @FindBy(linkText = "Add content") private WebElement addContent;
    @FindBy(xpath = "//*[text()='Agile Central Integrations']") private WebElement agileCentralIntegrationsLink;
    @FindBy(xpath = "//*[text()='Agile Central Help Topic']") private WebElement agileCentralHelpTopicLink;
    @FindBy(xpath = "//*[text()='CA Help Topic']") private WebElement helpTopicLink;
    @FindBy(id = "edit-title-0-value") private WebElement articleTitleField;
    @FindBy(id = "edit-langcode-0-value") private WebElement languageFieldElement;
    @FindBy(id = "edit-field-title2-0-value") private WebElement title2;
    @FindBy(id = "edit-field-logo-entity-browser-entity-browser-open-modal") private WebElement selectLogoImageButton;
    @FindBy(id = "edit-field-image-entity-browser-entity-browser-open-modal") private WebElement selectImageButton;
    @FindBy(xpath = "//*[text()='Menu settings']") private WebElement menuSettings;
    @FindBy(id = "edit-menu-enabled") private WebElement menuLinkCheckboxElement;
    @FindBy(id = "edit-menu-title") private WebElement menuLinkTitleElement;
    @FindBy(id = "edit-menu-description") private WebElement menuLinkDescriptionElement;
    @FindBy(id = "edit-menu-menu-parent") private WebElement menuLinkParentItem;
    @FindBy(id = "edit-menu-weight") private WebElement menuLinkWeight;
    @FindBy(xpath = "//*[text()='URL path settings']") private WebElement urlPathSettings;
    @FindBy(id = "edit-path-0-alias") private WebElement urlAliasTestbox;
    @FindBy(xpath = "//*[@value='Save and Create Draft']") private WebElement saveAndCreateNewDraft;
    @FindBy(xpath = "//*[@value='Save and Create Draft (this translation)']") private WebElement saveAndCreateNewDraftThisTranslation;
    @FindBy(xpath = "//*[@value='Save and Request Review']") private WebElement saveAndRequestReview;
    @FindBy(xpath = "//*[@value='Save and Request Review (this translation)']") private WebElement saveAndRequestReviewThisTranslation;
    @FindBy(xpath = "//*[@value='Save and Publish']") private WebElement saveAndPublish;
    @FindBy(xpath = "//*[@value='Save and UnPublish (this translation)']") private WebElement saveAndUnPublishThisTranslation;
    @FindBy(xpath = "//*[@value='Save and Publish (this translation)']") private WebElement saveAndPublishThisTranslation;
    @FindBy(xpath = "//*[@value='Save and Complete Review']") private WebElement saveAndCompleteReview;
    @FindBy(xpath = "//*[@value='Save and Complete Review (this translation)']") private WebElement saveAndCompleteReviewThisTranslation;
    @FindBy(xpath = "//*[@value='Save and Ready to Publish']") private WebElement saveAndReadyToPublish;
    @FindBy(xpath = "//*[@value='Save and Ready to Publish (this translation)']") private WebElement saveAndReadyToPublishThisTranslation;
    @FindBy(id = "edit-cancel") private WebElement CancelArticleToSave;
    @FindBy(id = "edit-title") private WebElement titleFilterElement;
    @FindBy(id = "edit-type") private WebElement contentTypeFitlerElement;
    @FindBy(id = "edit-langcode") private WebElement languageFitlerElement;
    @FindBy(id = "edit-moderation-state") private WebElement statusFitlerElement;
    @FindBy(id = "edit-submit-content") private WebElement filterButton;
    @FindBy(id = "edit-submit") private WebElement submitButton;
    @FindBy(id = "edit-action") private WebElement actionDropDown;
    @FindBy(id = "edit-submit--2") private WebElement applyToSelectedItems;
    @FindBy(id = "edit-path-0-alias") private WebElement urlAliasValue;
    @FindBy(xpath = "//iframe[@title='Rich Text Editor, Body field']") private WebElement bodyIframe;
    @FindBy(xpath = "//iframe[@title='Rich Text Editor, Heads Up field']") private WebElement headsUpIframe;
    @FindBy(xpath = "//iframe[@title='Rich Text Editor, For Developers field']") private WebElement forDevelopersFrame;
    @FindBy(xpath = "//*[@type='submit']/parent::li/following-sibling::li//*[text()='List additional actions']") protected WebElement listAdditionalActions;
    @FindBy(xpath = "//*[@id='edit-field-agilecentral-video-0-upload' and @name='files[field_agilecentral_video_0][]']") private WebElement browseAgileCentralVideoButton;
    @FindBy(xpath = "//*[@id='cke_edit-body-0-value']//*[text()='Source']") private WebElement sourceButtonInBodyField;
    @FindBy(xpath = "//*[@id='cke_edit-body-0-value']//*[text()='Image']") private WebElement imageButtonInBodyField;
    @FindBy(xpath = "//*[@id='cke_edit-body-0-value']//*[contains(@class,'cke_button__link_icon')]") private WebElement LinkIconInBodyField;
    @FindBy(className = "cke_dialog_body") private WebElement linkDialog;
    @FindBy(name = "field_agilecentral_video_0_remove_button") private WebElement removeVideoButton;
    @FindBy(xpath = "//*[contains(@id,'edit-fid-upload') and @type='file']") private WebElement browseImageButton;
    @FindBy(xpath = "//*[contains(@id,'edit-attributes-alt')]") private WebElement imageAlternativeTextField;
    @FindBy(xpath= "//button/span[text()='Save']") private WebElement saveImageButton;
    @FindBy(xpath = "html//img") private WebElement imageInBodyLocator;
    @FindBy(xpath = "//input[@id='edit-field-attachment-0-upload']") private WebElement browseAttachmentButton;
    @FindBy(name = "field_attachment_0_remove_button") private WebElement removeAttachmentButton;
    @FindBy(xpath = "//input[starts-with(@id,'edit-field-datasheet-0-remove-button')]") private WebElement RemoveDatasheetIntegrations;
    @FindBy(xpath = ".//input[starts-with(@id,'edit-field-image-current') and contains(@id,'remove-button')]") private WebElement RemoveScreenShotIntegrations;
    @FindBy(xpath = "//*[text()='Display Text']/following-sibling::div//input[@class='cke_dialog_ui_input_text']") private WebElement linkDisplayTextField;
    @FindBy(xpath = "//*[text()='URL']/following-sibling::div//input[@class='cke_dialog_ui_input_text']") private WebElement linkURLField;
    @FindBy(xpath = "//*[@class='cke_dialog_body']//*[text()='OK']") private WebElement OKButton;
    @FindBy(xpath = "//*[@id='node-story-form']//div[@id='edit-title-wrapper']//following-sibling::details/summary[text()='Blocks']") private WebElement BlockPanel;
    @FindBy(xpath = "//*[@id='node-story-form']//div[@id='edit-title-wrapper']//following-sibling::details/summary[text()='Multimedia']") private WebElement MultimediaPanel;
    @FindBy(xpath = "//*[@id='node-story-form']//div[@id='edit-title-wrapper']//following-sibling::details/summary[text()='Attachments']") private WebElement AttachmentsPanel;
    @FindBy(xpath = "//*[starts-with(@id,'node-story')]//div[@id='edit-title-wrapper']//following-sibling::details/summary[text()='Schedule Content']") public WebElement ScheduleContentPanel;
    @FindBy(xpath = "//*[@id='node-integrations-form']//div[@id='edit-title-wrapper']//following-sibling::details/summary[text()='Others']") public WebElement OthersIntegrationPanel;
    @FindBy(xpath = "//*[@id='node-integrations-form']//div[@id='edit-title-wrapper']//following-sibling::details//summary[text()='Screenshots']") public WebElement ScreenShotIntegrationPanel;
    @FindBy(xpath = "//*[@id='edit-field-meta-tags-0']/summary[text()='Meta tags']") private WebElement MetaTagsPanel;
    @FindBy(xpath = "//*[@id='edit-field-meta-tags-0-advanced']/summary[text()='Advanced']") private WebElement MetaTagsAdvancedPanel;
    @FindBy(xpath = "//*[@id='edit-field-meta-tags-0-advanced-robots']/div[3]/label[text()='Prevents search engines from indexing this page.']") private WebElement MetaTagsPreventSearchEngineIndexLabel;
    @FindBy(id = "edit-moderation-state-update-actions-ief-add") private WebElement AddModerationStateButton;
    @FindBy(xpath = "//*[contains(@id,'edit-moderation-state-update-form-inline-entity-form-update-timestamp-0-value-date--')]") private WebElement InsertDateSchedule;
    @FindBy(xpath = "//input[contains(@id,'edit-moderation-state-update-form-inline-entity-form-update-timestamp-0-value-time')]") private WebElement InsertTimeSchedule;
    @FindBy(xpath = "//select[contains(@id,'edit-moderation-state-update-form-inline-entity-form-field-moderation-state')]") private WebElement SelectModerationState;
    @FindBy(xpath = "//input[contains(@id,'edit-moderation-state-update-form-inline-entity-form-actions-ief-add-save')]") private WebElement CreateModerationStateUpdate;
    @FindBy(xpath = "//table[starts-with(@id,'ief-entity-table-edit-moderation-state-update-entities')]/tbody/tr/td[2]/div")private WebElement UpdatedModerationStateFromTable;
    @FindBy(xpath = ".//input[starts-with(@id,'edit-moderation-state-update-entities-0-actions-ief-entity-edit')]")private WebElement ScheduledModerationStateEditButtoninTable;
    @FindBy(xpath = "//*[@id='views-form-content-page-1']/table/tbody/tr[1]//td[contains(@class,'views-field views-field-moderation-state')]")private WebElement ModerationStateOfAnArticleFromContentsPage;
    @FindBy(xpath = "/html/body/div[5]/div[1]/button/span[1]") private WebElement ImageUploadPopUpCloseButton;
    @FindBy(xpath = "//*[starts-with(@id,'edit-field-datasheet-0-upload') and @type='file']") private WebElement UploadDatasheet;
    @FindBy(xpath = ".//section[@id='block-image']//a[text()='Screenshots']") private WebElement ScreenShotLink;
    @FindBy(xpath = ".//section[@id='block-datasheet']//a[text()='Datasheet']") private WebElement DataSheetLink;
    @FindBy(xpath = ".//*[@id='entity-browser-image-browser-form']/nav//li/a[text()='Upload']") private WebElement UploadLinkInSelectImagePopup;
    @FindBy(xpath = "//*[@id='edit-input-file']") private WebElement ChooseFileLinkInUploadLink;
    @FindBy(xpath = "//input[contains(@id,'edit-entity-name')]") private WebElement MediaNameTextBoxinUploadLink;
    @FindBy(xpath = "//input[contains(@id,'-meta-alt-')]") private WebElement AltTextTextboxInSelectImage;
  
    String ModerationStateOfAllArticleFromContentsPage = "//*[@id='views-form-content-page-1']/table/tbody/tr//td[contains(@class,'views-field views-field-moderation-state')]";
    String ImageUploadPopUpRemoveButton = ".//input[@name='fid_remove_button']";
    String latestRevisionTab="//a[text()='Latest version']";
    String listAdditionalActionsInManageArticles = "//a[text()='AAAAA']/parent::td/following-sibling::td//*[text()='List additional actions']";
    String selectAll = "//*[@title='Select all rows in this table']";
    public String filteredArticleTitles = "//*[@id='views-form-content-page-1']//table/tbody/tr/td[@headers='view-title-table-column']/a";
	String CheckBox = "//*[@id='views-form-content-page-1']//table/tbody/tr/td/div/input";
	String BulkUpdateMessage = ".//div[@class='messages messages--status' and contains(.,'was applied to AAAAAAAAA item')]//em[text()='KKKKKKKKK']";

	public boolean isScreenShotLinkClickable(){
		
		if(ScreenShotLink.isDisplayed() && ScreenShotLink.isEnabled()){
			return true;
		}else {
			return false;
		}
	}
	
	public boolean isDataSheetLinkClickable(){
		
		if(DataSheetLink.isDisplayed() && DataSheetLink.isEnabled()){
			return true;
		}else {
			return false;
		}
	}
	
    public By getLocatorForArticleState(String article, String moderationState) {
        return By.xpath("//*[text()='" + article + "']/parent::td/following-sibling::td[starts-with(.,'"
                + moderationState + "')]");
    }

    public String getUpdatedModerationStateFromTable(){
    	
    	return UpdatedModerationStateFromTable.getText();
    }
    
    public String ModerationStateOfAnArticleFromContentsPage(String articleTitle){
    	
    	filterArticle(articleTitle);
        List<WebElement> filteredArticles = driver.findElements(By.xpath(filteredArticleTitles));
		
		if(filteredArticles.size()!=0){
				return	ModerationStateOfAnArticleFromContentsPage.getText();
		}else{
				return "Article not found on contents page.";
			}
	}
    
	public ArrayList<String> getModerationStateOfAllArticlesFromContentsPage(String articleTitle){
	    	
    	filterArticle(articleTitle);
        List<WebElement> filteredArticles = driver.findElements(By.xpath(filteredArticleTitles));
        List<WebElement> States = driver.findElements(By.xpath(ModerationStateOfAllArticleFromContentsPage));
        ArrayList<String> ModerationStates = new ArrayList<String>();
		if(filteredArticles.size()!=0){
			for(int i=0; i<filteredArticles.size(); i++){
	        		ModerationStates.add(States.get(i).getText());
	        	}
        	}
        return ModerationStates;
	}
    
    public void saveArticleAsDraft() throws Exception {
        saveAndCreateNewDraft.click();
    }

    public void saveArticleAndRequestReview() throws Exception {
        CommonActions.javaScriptClick(listAdditionalActions, driver);
        CommonActions.javaScriptClick(saveAndRequestReview, driver);
    }

    public void saveAndPublish() throws Exception {
        CommonActions.javaScriptClick(listAdditionalActions, driver);
        CommonActions.javaScriptClick(saveAndPublish, driver);
    }

    public void saveAndUnpublishForThisTranslation() throws Exception {
        CommonActions.javaScriptClick(listAdditionalActions, driver);
        CommonActions.javaScriptClick(saveAndUnPublishThisTranslation, driver);
    }
    
    public void saveAndReadyToPublish() throws Exception {
        CommonActions.javaScriptClick(listAdditionalActions, driver);
        CommonActions.javaScriptClick(saveAndReadyToPublish, driver);
    }

    public void saveArticleAsDraftForThisTranslation() throws Exception {
        CommonActions.javaScriptClick(saveAndCreateNewDraftThisTranslation, driver);
    }

    public void saveArticleAndRequestReviewForThisTranslation() throws Exception {
        CommonActions.javaScriptClick(listAdditionalActions, driver);
        CommonActions.javaScriptClick(saveAndRequestReviewThisTranslation, driver);
    }

    public void saveAndPublishForThisTranslation() throws Exception {
        CommonActions.javaScriptClick(listAdditionalActions, driver);
        CommonActions.javaScriptClick(saveAndPublishThisTranslation, driver);
    }

    public void saveAndReadyToPublishForThisTranslation() throws Exception {
        CommonActions.javaScriptClick(listAdditionalActions, driver);
        CommonActions.javaScriptClick(saveAndReadyToPublishThisTranslation, driver);
    }

    public void saveAndCompleteReviewForThisTranslation() throws Exception {
        CommonActions.javaScriptClick(saveAndCompleteReviewThisTranslation, driver);
    }
    
    public void cancelArticleToSave() throws Exception {
        CommonActions.javaScriptClick(CancelArticleToSave, driver);
    }
    
    public void addArticle(ArticleData articleData) throws Exception {
        selectContentType(articleData);
        enterArticleTitle(articleData.getTitle());

        if(StringUtils.isNotEmpty(articleData.getBody())){
            enterArticleBody(articleData);
        }
        if(StringUtils.isNotEmpty(articleData.getHeadsUpFieldInCAAgileCentralHelpTopic())){
        	enterArticleHeadsup(articleData);
        }
        if(StringUtils.isNotEmpty(articleData.getForDevelopersFieldInCAAgileCentralHelpTopic())){
        	enterForDevelopersContent(articleData);
        }
        if(StringUtils.isNotEmpty(articleData.getImagePath())){
        	uploadImage(articleData);
        }
        if(StringUtils.isNotEmpty(articleData.getVideoPath())){
        	uploadAndAttachVideo(articleData);
         }
        if(StringUtils.isNotEmpty(articleData.getAttachmentPath())){
        	uploadAttachmentAndWait(articleData);   	
        }
        if(StringUtils.isNotEmpty(articleData.getModerationStateToSchedule())){
        	scheduleModerationStateUpdateAfter5mins(articleData);	 	
        }
        configureMenuSettings(articleData);
        configureUrlPathSettings(articleData.getUrlAlias());
    }

    

    public void addIntegrationContentTypeArticle(ArticleData articleData) throws Exception {
       
       	selectContentType(articleData);
           enterArticleTitle(articleData.getTitle());
          
           if(StringUtils.isNotEmpty(articleData.getDataSheetPath())){
           
        	   uploadDatasheet(articleData);
           }
           if(StringUtils.isNotEmpty(articleData.getScreenshotPath())){
           
        	   uploadScreenShotAsAttachment(articleData);
           }
           
           configureMenuSettings(articleData);
           configureUrlPathSettings(articleData.getUrlAlias());
     }
    
    public void uploadDatasheet(ArticleData articleData) throws Exception {
    	String ariaExpand =OthersIntegrationPanel.getAttribute("aria-expanded");
	    	if(ariaExpand.equals("false")){
    			OthersIntegrationPanel.click();
    		}
	    	((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", UploadDatasheet);		
    		UploadDatasheet.sendKeys(configReader.getUploadFilesPath()+articleData.getDataSheetPath());
    		new WebDriverWait(driver, 60).until(ExpectedConditions.elementToBeClickable(RemoveDatasheetIntegrations));
    }
    
    
    public void scheduleModerationStateUpdateAfter5mins(ArticleData articleData) throws ParseException{
    	
    	String ariaExpand = ScheduleContentPanel.getAttribute("aria-expanded");
    	if(ariaExpand.equals("false")){
    		ScheduleContentPanel.click();
    	}
    	
    	AddModerationStateButton.click();
    	LocalDate date = LocalDate.now();
    	if(BaseTest.getDriverPath().contains("exe")){
    		InsertDateSchedule.sendKeys(date.format(DateTimeFormatter.ofPattern("MMddyyyy")));
    	}else{
    		InsertDateSchedule.sendKeys(date.format(DateTimeFormatter.ofPattern("ddMMyyyy")));
    			}
		
		LocalTime time = LocalTime.now().plusMinutes(5);
		String goodtime = time.toString().replace(".", "_").split("_")[0];
		DateFormat Iti = new SimpleDateFormat("HH:mm:ss");
		DateFormat Oti = new SimpleDateFormat("KK:mm:ss a");
		InsertTimeSchedule.sendKeys(Oti.format(Iti.parse(goodtime)).replaceAll(":", "").replace(" ", ""));
		
		CommonActions.selectByVisibleText(driver, SelectModerationState, articleData.getModerationStateToSchedule());
		CreateModerationStateUpdate.click();
    }
    
    public void uploadAttachmentAndWait(ArticleData articleData) throws Exception {
    	String ariaExpand =AttachmentsPanel.getAttribute("aria-expanded");
    	if(ariaExpand.equals("false")){
    		AttachmentsPanel.click();
    	}
    	
    	uploadAttachment(articleData);
        CommonActions.waitForElementToBeClickable(driver, removeAttachmentButton);
     }

    public void selectContentType(ArticleData articleData) {
        addContent.click();
        if (StringConstants.AGIlE_CENTRAL_HELP_TOPIC.equals(articleData.getArticleType())) {
            CommonActions.javaScriptClick(agileCentralHelpTopicLink, driver);
        }else if (StringConstants.AGIlE_CENTRAL_INTEGRATIONS.equals(articleData.getArticleType())) {
        	CommonActions.javaScriptClick(agileCentralIntegrationsLink, driver);
        }
    }

    public void uploadImage(ArticleData articleData) throws Exception {
       
    	String ariaExpand =MultimediaPanel.getAttribute("aria-expanded");
    	if(ariaExpand.equals("false")){
    		MultimediaPanel.click();
    	}
    	
    	CommonActions.javaScriptClick(imageButtonInBodyField, driver);
        driver.switchTo().activeElement();
       if(driver.findElements(By.xpath(ImageUploadPopUpRemoveButton)).size()==0){
    	     browseImageButton.sendKeys(configReader.getUploadFilesPath()+articleData.getImagePath());
	        imageAlternativeTextField.sendKeys(articleData.getImagePath());
	        CommonActions.javaScriptClick(saveImageButton, driver);
	        driver.switchTo().frame(bodyIframe);
	        CommonActions.waitForElementToBeVisible(driver, imageInBodyLocator);
	        driver.switchTo().defaultContent();
	        
       }else{
    	   ImageUploadPopUpCloseButton.click();
    	   driver.switchTo().frame(bodyIframe);
	        CommonActions.waitForElementToBeVisible(driver, imageInBodyLocator);
	        driver.switchTo().defaultContent();
       }
    }

    public void uploadScreenShotAsAttachment(ArticleData articleData) throws Exception{
    	String ariaExpand =ScreenShotIntegrationPanel.getAttribute("aria-expanded");
    	if(ariaExpand.equals("false")){
    		ScreenShotIntegrationPanel.click();
    	}
    	
    	((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", selectImageButton);
    	CommonActions.javaScriptClick(selectImageButton, driver);
        driver.switchTo().frame("entity_browser_iframe_image_browser");
        CommonActions.javaScriptClick(UploadLinkInSelectImagePopup, driver);
        ChooseFileLinkInUploadLink.sendKeys(configReader.getUploadFilesPath()+articleData.getScreenshotPath());
        MediaNameTextBoxinUploadLink.sendKeys(articleData.getScreenshotPath());
        CommonActions.javaScriptClick(submitButton, driver);
        driver.switchTo().defaultContent();
        new WebDriverWait(driver, 60).until(ExpectedConditions.elementToBeClickable(RemoveScreenShotIntegrations));
       AltTextTextboxInSelectImage.sendKeys(articleData.getScreenshotPath());
    }
    
   
    
    public void uploadAndAttachVideo(ArticleData articleData) throws Exception {
    	String ariaExpand =MultimediaPanel.getAttribute("aria-expanded");
    	if(ariaExpand.equals("false")){
    		MultimediaPanel.click();
    	}
    	uploadVideo(articleData);
        CommonActions.waitForElementToBeClickable(driver, removeVideoButton);
        uploadImage(articleData);
        CommonActions.javaScriptClick(sourceButtonInBodyField, driver);
        String videoUrl= StringConstants.VIDEO_UPLOAD_LINK_URL.replace("AAAAA", configReader.getDrupalBaseURL()+StringConstants.MULTIMEDIA_LOCATION+articleData.getVideoPath()).replace("BBBBB", configReader.getDrupalBaseURL()+StringConstants.MULTIMEDIA_LOCATION+articleData.getImagePath());
        driver.findElement(By.xpath("//*[@title='Rich Text Editor, Body field']")).sendKeys(videoUrl);
    }

    public void uploadVideo(ArticleData articleData) throws Exception {
        browseAgileCentralVideoButton.sendKeys(configReader.getUploadFilesPath()+articleData.getVideoPath());
        
    }
    

    private void uploadAttachment(ArticleData articleData) throws Exception {
        browseAttachmentButton.sendKeys(configReader.getUploadFilesPath()+articleData.getAttachmentPath());
    }

    public void enterArticleHeadsup(ArticleData articleData) {
    	String ariaExpand =BlockPanel.getAttribute("aria-expanded");
    	
    	if(ariaExpand.equals("false")){
    		BlockPanel.click();
    	}
    	driver.switchTo().frame(headsUpIframe);
    	driver.switchTo().activeElement().sendKeys(articleData.getHeadsUpFieldInCAAgileCentralHelpTopic());
        driver.switchTo().defaultContent();
    }
    
    public void enterForDevelopersContent(ArticleData articleData) {
    	String ariaExpand =BlockPanel.getAttribute("aria-expanded");
    	if(ariaExpand.equals("false")){
    		BlockPanel.click();
    	}
    	driver.switchTo().frame(forDevelopersFrame);
        driver.switchTo().activeElement().sendKeys(articleData.getForDevelopersFieldInCAAgileCentralHelpTopic());
        driver.switchTo().defaultContent();
    }
    
    public void enterArticleBody(ArticleData articleData) {
    	driver.switchTo().frame(bodyIframe);  
        driver.findElement(By.xpath("html/body")).sendKeys(articleData.getBody());
        driver.switchTo().defaultContent();
    }

    public void selectArticleLanguage(String language) {
        Select select = new Select(languageFieldElement);
        select.selectByVisibleText(language);        
    }

    public void configureMenuSettings(ArticleData articleData) {
        
    	if(!menuLinkCheckboxElement.isDisplayed()){
            CommonActions.javaScriptClick(menuSettings, driver);
            CommonActions.waitForElementToBeVisible(driver, menuLinkCheckboxElement);
        }
    	
        toggleMenuLinkCheckbox(true);
        CommonActions.waitForElementToBeVisible(driver, menuLinkTitleElement);
        menuLinkTitleElement.clear();
        menuLinkTitleElement.sendKeys(articleData.getMenuLinkTitle());
        menuLinkDescriptionElement.clear();
        menuLinkDescriptionElement.sendKeys(articleData.getMenuLinkDescription());
        selectMenuParentItem(articleData.getMenuLinkParentItem());
        menuLinkWeight.clear();
        menuLinkWeight.sendKeys(articleData.getMenuLinkWeight());
    }

    public void selectMenuParentItem(String parent) {
        Select select = new Select(menuLinkParentItem);
        if (StringUtils.isEmpty(parent)) {
            select.selectByVisibleText(StringConstants.MENU_PARENTITEM_DEFAULT_VALUE);
        } else {
            select.selectByVisibleText(parent);
        }
    }

    public void toggleMenuLinkCheckbox(Boolean menuLinkCheckbox) {
        if (menuLinkCheckbox) {
            if (!menuLinkCheckboxElement.isSelected()) {
                CommonActions.javaScriptClick(menuLinkCheckboxElement, driver);
            }
        } else {
            if (menuLinkCheckboxElement.isSelected()) {
                CommonActions.javaScriptClick(menuLinkCheckboxElement, driver);
            }
        }
    }

    public void configureUrlPathSettings(String articleAlias) {
        urlPathSettings.click();
        CommonActions.waitForElementToBeVisible(driver, urlAliasTestbox);
        urlAliasTestbox.clear();
        urlAliasTestbox.sendKeys(articleAlias);
    }

    public void enterArticleTitle(String title) {
        articleTitleField.clear();
        articleTitleField.sendKeys(title);
    }

    public void filterArticle(String article) {
        titleFilterElement.clear();
        titleFilterElement.sendKeys(article);
        filterButton.click();
    }

 /*   public void deleteArticle(String article) {
        filterArticle(article);
        if(driver.findElements(By.xpath(selectAll)).size()!=0) {
            setAction(StringConstants.DELETE_CONTENT);
            driver.findElement(By.xpath(selectAll)).click();
            applyToSelectedItems.click();
            submitButton.click();
        }
    }*/

    public void deleteArticle(String article) {
        filterArticle(article);
        
        List<WebElement> filteredArticles = driver.findElements(By.xpath(filteredArticleTitles));
		if(filteredArticles.size()!=0){
		   selectArticleToPerformAction(article);
		   setAction(StringConstants.DELETE_CONTENT);
		   CommonActions.javaScriptClick(applyToSelectedItems, driver);
		   CommonActions.javaScriptClick(submitButton, driver);
			   }
    }
    
	public void selectArticleToPerformAction(String articlePrefix){
	    	
	    	List<WebElement> filteredArticles = driver.findElements(By.xpath(filteredArticleTitles));
			List<WebElement> CheckBoxes =  driver.findElements(By.xpath(CheckBox));
			if(filteredArticles.size()!=0){
				for (int i=0; i<filteredArticles.size(); i++) {
					String articleText = filteredArticles.get(i).getText();
					if(articleText.contains(articlePrefix)){
						 CommonActions.javaScriptClick(CheckBoxes.get(i), driver);		
					}
				}
			}
	}
    
	public boolean isBulkUpdateMessageMessageDisplayed(int NumberOfArticle, String UpdatedModerationState){
	    
    	String message = BulkUpdateMessage.replace("AAAAAAAAA", String.valueOf(NumberOfArticle)).replace("KKKKKKKKK", UpdatedModerationState);
    	
    	return driver.findElements(By.xpath(message)).size()!=0;
    }
    
    public void clickOnApplyToSelectedItems(){
    	CommonActions.javaScriptClick(applyToSelectedItems, driver);
    	
    }
    
    public void clickOnSubmitButtonToConfirmAction(){
    CommonActions.javaScriptClick(submitButton, driver);
    }
    
    public void setAction(String action) {
        Select select = new Select(actionDropDown);
        switch (action) {
        case StringConstants.DELETE_CONTENT:
            select.selectByVisibleText(StringConstants.DELETE_CONTENT);
            break;
        case StringConstants.SET_CONTENT_AS_PUBLISHED: 
        	select.selectByVisibleText(StringConstants.SET_CONTENT_AS_PUBLISHED);
        	break;
        default:
            break;
        }
    }

    public boolean isArticleADraft(String article) {
        filterArticle(article);
        if (driver.findElements(getLocatorForArticleState(article, StringConstants.DRAFT_MODERATION_STATE))
                .size() != 0) {
            return true;
        }
      return false;
    }

    public boolean isArticleReadyForReview(String article) {
        filterArticle(article);
        if (driver.findElements(getLocatorForArticleState(article, StringConstants.REQUEST_REVIEW_MODERATION_STATE))
                .size() != 0) {
            return true;
        }
      return false;
    }

    public boolean isArticleReviewCompleted(String article) {
        filterArticle(article);
        return driver.findElements(getLocatorForArticleState(article, StringConstants.REVIEW_COMPLETED_MODERATION_STATE))
                .size() != 0;
    }

    public boolean isArticleReadyToPublish(String article) {
        filterArticle(article);
        return driver.findElements(getLocatorForArticleState(article, StringConstants.READY_TO_PUBLISH_MODERATION_STATE))
                .size() != 0;
    }

    public boolean isArticlePublished(String article) {
        filterArticle(article);
       return driver.findElements(getLocatorForArticleState(article, StringConstants.PUBLISHED_MODERATION_STATE)).size() != 0;
    }
    
    public boolean isArticleUnPublished(String article) {
        filterArticle(article);
       return driver.findElements(getLocatorForArticleState(article, StringConstants.UNPUBLISHED_MODERATION_STATE)).size() != 0;
    }
   
    public boolean isLatestRevisionTabVisible(){
        return driver.findElements(By.xpath(latestRevisionTab)).size() !=0;        
    }
    
    public boolean isVideoUploadErrorPresent(String video){
        //String errorLocator = "//*[starts-with(@id, 'edit-field-agilecentral-video') and contains(.,'The specified file') and contains(.,'could not be uploaded')]//*[text()='TestVideo.webm']/following-sibling::div//*[contains(text(),'Only files with the following extensions are allowed:')]/em[text()='mp4 ogv flv swf']";
    	String errorLocator ="//details[starts-with(@id, 'edit-field-agilecentral-video') and contains(.,'The specified file') and contains(.,'could not be uploaded')]";
    	CommonActions.waitUntil(driver, By.xpath(errorLocator), 120);
       // return driver.findElements(By.xpath(errorLocator)).size() == 1;
        return driver.findElements(By.xpath(errorLocator)).size() != 0;
    } 
    
    public boolean isAttachmentUploadErrorPresent(String video){
        String errorLocator = "//*[starts-with(@id, 'edit-field-agilecentral-video') and contains(.,'The specified file') and contains(.,'could not be uploaded')]//*[text()='TestVideo.webm']/following-sibling::div//*[contains(text(),'Only files with the following extensions are allowed:')]/em[text()='mp4 ogv flv swf']";
        return driver.findElements(By.xpath(errorLocator)).size() == 1;
    }

    public void enterLinkInTheBody(String body) throws InterruptedException {
        LinkIconInBodyField.click();
        Thread.sleep(1000);
        CommonActions.waitForElementToBeVisible(driver, linkDialog);
        driver.switchTo().activeElement();
        linkDisplayTextField.clear();
        linkDisplayTextField.sendKeys(body);
        linkURLField.clear();
        linkURLField.sendKeys(body);
        CommonActions.javaScriptClick(OKButton, driver);
    }

    public String getUrlAliasValue() {
     return	urlAliasValue.getAttribute("value");
    }
    
    public void preventSearchEngineFromIndexingArticle() {
    	
    	// Expanding the Meta Tags panel only if its not already expanded
    	String ariaExpand =MetaTagsPanel.getAttribute("aria-expanded");
    	if(ariaExpand.equals("false")){
    		MetaTagsPanel.click();
    	}
    	
    	// Expanding the Meta Tags Advanced panel only if its not already expanded
    	ariaExpand = MetaTagsAdvancedPanel.getAttribute("aria-expanded");
    	if(ariaExpand.equals("false")){
    		MetaTagsAdvancedPanel.click();
    	}
    	
    	// Select the prevent search engines from indexing a page option if its not already selected
    	if(!MetaTagsPreventSearchEngineIndexLabel.isSelected()) {
    		MetaTagsPreventSearchEngineIndexLabel.click();
    	}
    	
    	
    }
}