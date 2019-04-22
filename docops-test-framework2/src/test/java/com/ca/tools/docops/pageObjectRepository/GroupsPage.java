package com.ca.tools.docops.pageObjectRepository;

import org.apache.poi.util.SystemOutLogger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.ca.tools.docops.utils.ConfigReader;
import com.mongodb.diagnostics.logging.Logger;

public class GroupsPage {
	public WebDriver driver;
	public ConfigReader configReader;

	public GroupsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		configReader = new ConfigReader();
	}
	@FindBy(xpath = "//*[text()='Add group']") public WebElement addGroup;
	@FindBy(linkText = "Group types") public WebElement groupTypes;
	@FindBy(linkText = "Settings") public WebElement settings;
	@FindBy(linkText = "List") public WebElement list;
	@FindBy(linkText = "Edit") public WebElement editGroup;
	@FindBy(linkText = "Delete") public WebElement deleteGroup;
	@FindBy(id = "edit-label-0-value") private WebElement titleTextbox;
	@FindBy(id = "edit-field-product-name-0-target-id") private WebElement productNameTextbox;
	@FindBy(id = "edit-field-product-key-0-value") private WebElement productIdentifierTextbox;
	@FindBy(id = "edit-field-version-key-0-value") private WebElement versionIdentifierTextbox;
	@FindBy(id = "edit-field-language-0-target-id") private WebElement languageTextbox;
	@FindBy(id = "edit-field-spacekey-0-value") private WebElement confluenceSpaceKeyTextbox;
	@FindBy(id = "edit-field-parent-release-version-key-0-value") private WebElement baseVersionTextbox;
	@FindBy(id = "edit-path-0-alias") private WebElement aliasURLTextbox;	
	@FindBy(xpath = "//label[contains(text(),'Make this release available to customers')]") private WebElement makeReleaseAvailableToCustomerChkbox;
	@FindBy(xpath = "//label[contains(text(),'Make this release available to anonymous users')]") private WebElement makeReleaseAvailableToAnonymousUserChkbox;
	@FindBy(xpath = ".//*[@id='group-standard-gt-edit-form']/details/summary") private WebElement goLiveConfiguration;
	@FindBy(linkText = "Manage fields") private WebElement manageFields;
	@FindBy(xpath = "//*[text()='Manage Articles']") private WebElement manageArticlesLink;
	@FindBy(xpath = "//*[text()='Relate Article']") private WebElement relateArticleLink;
	@FindBy(xpath = "//*[text()='Delete Article']") private WebElement deleteArticleLink;
	@FindBy(xpath = "//*[text()='Change Parent']") private WebElement changeParentLink;
	@FindBy(xpath = "//*[text()='Clone & Edit']") private WebElement cloneAndEditLink;
	@FindBy(xpath = "//*[text()='Remove from release']") private WebElement removeFromReleaseLink;
	@FindBy(xpath = "//a[text()='Members']") private WebElement members;
	@FindBy(xpath = "//*[text()='Add member']") private WebElement addMember;
	@FindBy(id = "edit-entity-id-0-target-id") private WebElement addUserName;
	@FindBy(id = "edit-group-roles-standard-gt-doc-admin") private WebElement docAdminCheckBox;
	@FindBy(id = "edit-group-roles-standard-gt-doc-author") private WebElement docAuthorCheckBox;
	@FindBy(id = "edit-group-roles-standard-gt-doc-reviewer") private WebElement docReviewerCheckbox;
	@FindBy(id = "edit-submit") private WebElement submit;
	@FindBy(id = "edit-title-0-value") private WebElement articleTitleField;
	@FindBy(id = "edit-field-hid-0-value") private WebElement hidField;
	@FindBy(id = "edit-field-video-0-upload") private WebElement addVideoField;
	@FindBy(id = "edit-field-attachment-0-upload") private WebElement addAttachmentField;
	@FindBy(id = "edit-field-article-alias-0-value") private WebElement articleAliasField;
	@FindBy(xpath = "//*[@value='Save and Create New Draft']") private WebElement saveAndCreateNewDraft;
	@FindBy(xpath = "//*[@value='Save and Request Review']") private WebElement saveAndRequestReview;
	@FindBy(xpath = "//*[@value='Save and Publish']") private WebElement saveAndPublish;
	@FindBy(xpath = "//*[@title='open Content Manager']") private WebElement openContentManager;
	@FindBy(xpath = "//*[@id='sideSecond']//a[text()='Add Article']") private WebElement addArticleLink;
	@FindBy(xpath = "//*[text()='Group node (CA Help Topic)']") private WebElement caHelpTopicLink;
	@FindBy(id = "edit-field-weight-0-value") private WebElement weightField;	
	@FindBy(xpath = ".//*[@id='edit-submit-ca-home']") private WebElement applyBtn;
	String selectProductDropDown = ".//*[@id='edit-field-product-name-target-id']";
	String strGroupNameLink = "//a[text()='AAAAA']";
	String relativePathForEditButton = "//a[text()='AAAAA']/parent::td/following-sibling::td//a[text()='Edit']";

	/**
	 * 
	 * @param releaseDocTitle
	 * @param productName
	 * @param productIdentifier
	 * @param versionIdentifier
	 * @param language
	 * @param confluenceSpaceKey
	 * @param baseVersion
	 */
	public void addGroup(String releaseDocTitle, String productName, String productIdentifier, String versionIdentifier,
			String language, String confluenceSpaceKey, String baseVersion, String aliasURL) {
		addGroup.click();
		enterReleaseDocTitle(releaseDocTitle);
		enterProductName(productName);
		enterProductIdentifier(productIdentifier);
		enterVersionIdentifier(versionIdentifier);
		//enterLanguage(language);
		enterConfluenceSpaceKey(confluenceSpaceKey);
		enterBaseVersion(baseVersion);
		submit.click();
		//        enterAliasURL(aliasURL);
		//        submit.click();
		// TODO Assertions
		// verifyGroupName();
	}

	/**
	 * 
	 * @param strReleaseDocTitle
	 */
	public void enterReleaseDocTitle(String strReleaseDocTitle) {
		if(titleTextbox.isDisplayed())
			titleTextbox.clear();
		titleTextbox.sendKeys(strReleaseDocTitle);
	}

	/**
	 * 
	 * @param strProductName
	 */
	public void enterProductName(String strProductName) {
		if(productNameTextbox.isDisplayed())
			productNameTextbox.clear();
		productNameTextbox.sendKeys(strProductName);
	}

	/**
	 * 
	 * @param strProductIdentifier
	 */
	public void enterProductIdentifier(String strProductIdentifier) {
		if(productIdentifierTextbox.isDisplayed())
			productIdentifierTextbox.clear();
		productIdentifierTextbox.sendKeys(strProductIdentifier);
	}

	/**
	 * 
	 * @param strVersionIdentifier
	 */
	public void enterVersionIdentifier(String strVersionIdentifier) {
		if(versionIdentifierTextbox.isDisplayed())
			versionIdentifierTextbox.clear();
		versionIdentifierTextbox.sendKeys(strVersionIdentifier);
	}

	/**
	 * 
	 * @param strLanguage
	 */
	public void enterLanguage(String strLanguage) {
		if(languageTextbox.isDisplayed())
			languageTextbox.clear();
		languageTextbox.sendKeys(strLanguage);
	}

	/**
	 * 
	 * @param strConfluenceSpaceKey
	 */
	public void enterConfluenceSpaceKey(String strConfluenceSpaceKey) {
		if(confluenceSpaceKeyTextbox.isDisplayed())
			confluenceSpaceKeyTextbox.clear();
		confluenceSpaceKeyTextbox.sendKeys(strConfluenceSpaceKey);
	}

	/**
	 * 
	 * @param strBaseVersion
	 */
	public void enterBaseVersion(String strBaseVersion) {
		if(baseVersionTextbox.isDisplayed())
			baseVersionTextbox.clear();
		baseVersionTextbox.sendKeys(strBaseVersion);
	}

	/**
	 * 
	 * @param strAliasURL
	 */
	public void enterAliasURL(String strAliasURL) {
		if(aliasURLTextbox.isDisplayed())
			aliasURLTextbox.clear();
		aliasURLTextbox.sendKeys(strAliasURL);
	}

	/**
	 * 
	 * @param strGroupName
	 */
	/*
	 * public void verifyGroupName(String strGroupName) { if
	 * (groupName.isDisplayed()) { groupName.click();
	 * System.out.println("CA Tools Engineering Services Pre-Release"); } else {
	 * } }
	 */

	/*
	 * public void verifyUpdatedGroupName(String strGroupName) { if
	 * (updatedGroupName.isDisplayed()) { updatedGroupName.click();
	 * System.out.println("CA Tools Engineering Services Release"); } else { } }
	 */

	/**
	 * 
	 * @param strGroupName
	 */
	public void clickGroupNameInList(String strGroupName) {
		if(isGroupNamePresent(strGroupName)){
			driver.findElement(By.xpath(relativePathForEditButton.replace("AAAAA", strGroupName))).click();
		}else{
			System.out.println(strGroupName+" is not displayed...");
		}
	}

	/**
	 * 
	 * @param strGroupName
	 * @param releaseDocTitle
	 * @param productIdentifier
	 */
	public void editGroup(String strGroupName, String newGroupName, String productIdentifier) {
		clickGroupNameInList(strGroupName);
		enterReleaseDocTitle(newGroupName);
		enterProductIdentifier(productIdentifier);
		if(submit.isDisplayed())
			submit.click();
		// TODO Assertions
		// verifyUpdatedGroupName("CA Tools Engineering Services Release");
	}

	/**
	 * 
	 * @param strGroupName
	 */
	public void deleteGroup(String strGroupName) {
		clickGroupNameInList(strGroupName);
		if(deleteGroup.isDisplayed())
			deleteGroup.click();
		if(submit.isDisplayed())
			submit.click();
	}

	/**
	 * 
	 * @param strGroupName
	 */
	public void makeReleaseAvailableToCustomers(String strGroupName) {
		clickGroupNameInList(strGroupName);
		if(goLiveConfiguration.isDisplayed())
			goLiveConfiguration.click();
		if (!makeReleaseAvailableToCustomerChkbox.isSelected()) {
			makeReleaseAvailableToCustomerChkbox.click();
		}
		if(submit.isDisplayed())
			submit.click();
	}

	/**
	 * 
	 * @param strGroupName
	 */
	public void makeReleaseAvailableToAnonymousUsers(String strGroupName) {
		clickGroupNameInList(strGroupName);
		if(goLiveConfiguration.isDisplayed())
			goLiveConfiguration.click();
		if (!makeReleaseAvailableToAnonymousUserChkbox.isSelected()) {
			makeReleaseAvailableToAnonymousUserChkbox.click();
		}
		if(submit.isDisplayed())
			submit.click();
	}



	/**
	 * 
	 * @param strProductName
	 */
	public void selectProduct(String strProductName) {
		Select selectProducts = new Select(driver.findElement(By.id("edit-field-product-name-target-id")));
		selectProducts.selectByValue(strProductName);
		// selectProducts.selectByVisibleText(strProductName);
		if(applyBtn.isDisplayed())
			applyBtn.click();
	}

	/**
	 * 
	 * @param strGroupName
	 * @return
	 */
	public boolean isGroupNamePresent(String strGroupName) {
		if(driver.findElements(By.xpath(strGroupNameLink.replace("AAAAA", strGroupName))).isEmpty()){
			return locateElementInAllPages(By.xpath("//*[text()='"+strGroupName+"']"));
		}else{
			return true;
		}
	}



	public boolean paginationExists(){
		java.util.List<WebElement> pagination =driver.findElements(By.xpath("//nav[@class='pager']//a")); 
		if(pagination .size()>0){ 
			return true;
		}
		return false;
	}

	/**
	 * 
	 * @param locator
	 * @return
	 */
	public boolean locateElementInAllPages(By locator){
		java.util.List<WebElement> paginationElement =driver.findElements(By.xpath("//nav[@class='pager']//a")); 
		if(paginationElement .size()>0){  
			for(int i = 1; i < paginationElement.size(); i++){ 
				paginationElement.get(i).click();
				try{
					driver.findElement(locator);
					return true;
				}catch(Exception e){
					System.out.println(e.getMessage());
				}
				System.out.println("Element not found");
			} 
			return false;
		} else { 
			System.out.println("pagination not exists");
			return false;
		} 

	}

}
