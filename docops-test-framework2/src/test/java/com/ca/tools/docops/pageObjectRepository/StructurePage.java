package com.ca.tools.docops.pageObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ca.tools.docops.common.CommonActions;
import com.ca.tools.docops.common.DocOpsCommonMethods;
import com.sun.jna.platform.win32.WinNT.WELL_KNOWN_SID_TYPE;

public class StructurePage {
    private WebDriver driver;
    private DocOpsCommonMethods docOpsCommonMethods;

    public StructurePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        docOpsCommonMethods = new DocOpsCommonMethods(driver);
    }
    @FindBy(xpath = "//*[text()='Block layout']") private WebElement blockLayout;
    @FindBy(xpath = "//*[text()='Comment types']") private WebElement commentTypes;
    @FindBy(xpath = "//*[text()='Contact forms']") private WebElement contactForms;
    @FindBy(xpath = "//*[text()='Content types']") private WebElement contentTypes;
    @FindBy(xpath = "//*[text()='Context']") private WebElement context;
    @FindBy(xpath = "//*[text()='Display modes']") private WebElement displayModes;
    @FindBy(xpath = "//*[text()='Media bundles']") private WebElement mediaBundles;
    @FindBy(xpath = "//*[text()='Menus']") private WebElement menus;
    @FindBy(xpath = "//*[text()='Migrations']") private WebElement migrations;
    @FindBy(xpath = "//*[text()='Table of contents types']") private WebElement tableOfContentTypes;
    @FindBy(xpath = "//*[text()='Taxonomy']") private WebElement taxonomy;
    @FindBy(xpath = "//*[text()='Views']") private WebElement views;
    @FindBy(xpath = "//*[text()='Custom tokens']") private WebElement customTokens;
    @FindBy(xpath = "//*[@href='/admin/structure/taxonomy/manage/product_name/overview']") private WebElement listProductNames;
    @FindBy(xpath = "//*[text()='Add term']") private WebElement addProduct;
    @FindBy(id = "edit-name-0-value") private WebElement productNameTextbox;
    @FindBy(id = "edit-submit") private WebElement saveButton;
    @FindBy(id = "edit-delete") private WebElement deleteButton;
    String relativePathForEditButton = "//a[text()='AAAAA']/parent::td/following-sibling::td//a[text()='Edit']";
    String relativePathForDeleteButton = "//a[text()='AAAAA']/parent::td/following-sibling::td//a[text()='Delete']";
    String ListAdditionActionsButton = "//a[text()='AAAAA']/parent::td/following-sibling::td//button";

    public void clickBlockLayout() {
        blockLayout.click();
    }

    public void clickCommentTypes() {
        commentTypes.click();
    }

    public void clickContactForms() {
        contactForms.click();
    }

    public void clickContentTypes() {
        contentTypes.click();
    }

    public void clickContext() {
        context.click();
    }

    public void clickDisplayModes() {
        displayModes.click();
    }

    public void clickMediaBundles() {
        mediaBundles.click();
    }

    public void clickMenus() {
        menus.click();
    }

    public void clickMigrations() {
        migrations.click();
    }

    public void clickTableOfContentTypes() {
        tableOfContentTypes.click();
    }

    public void clickTaxonomy() {
        // CommonActions.javaScriptClick(taxonomy, driver);
        taxonomy.click();
    }

    public void clickViews() {
        views.click();
    }

    public void clickCustomTokens() {
        customTokens.click();
    }

    public void clickListProductNames() {
        clickTaxonomy();
        listProductNames.click();
    }

    public void clickAddProduct() {
        addProduct.click();
    }

    public void enterProductName(String productName) {
        productNameTextbox.clear();
        productNameTextbox.sendKeys(productName);
    }

    public void createProduct(String productName) {
        clickListProductNames();
        clickAddProduct();
        enterProductName(productName);
        saveButton.click();
    }

    public boolean isProductListed(String productName) {
        if (driver.findElements(By.xpath("//a[text()='" + productName + "']")).isEmpty()) {
            return false;
        } else {
            return true;
        }
    }

    public void locateAndEditProduct(String oldName, String newName) {
        By locator = By.xpath("//*[text()='" + oldName + "']");
        clickListProductNames();
        if (driver.findElements(locator).isEmpty()) {
            if(docOpsCommonMethods.locateElementInAllPages(locator)){
                editProduct(oldName, newName);
            }
        }
    }

    private void editProduct(String oldName, String newName) {
        driver.findElement(By.xpath(relativePathForEditButton.replace("AAAAA", oldName))).click();
        enterProductName(newName);
        saveButton.click();
    }

    public void deleteProduct(String prod) {
        clickListProductNames();
        if (!driver.findElements(By.xpath("//*[text()='" + prod + "']")).isEmpty()) {
            driver.findElement(By.xpath(ListAdditionActionsButton.replace("AAAAA", prod))).click();
            driver.findElement(By.xpath(relativePathForDeleteButton.replace("AAAAA", prod))).click();
            saveButton.click();
        }
    }
}