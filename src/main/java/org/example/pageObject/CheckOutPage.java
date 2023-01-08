package org.example.pageObject;

import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckOutPage {
    public static WebDriver driver;

    public CheckOutPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }
    //displaying title product item
    @FindBy(xpath = "//div[.='+ productName.toLowerCase().replace(\" \", \"-\") + \"']")
    private WebElement displayLandingPage;

    @FindBy(xpath = "//span[.='Your Cart']")
    private WebElement displayCheckOutPage;

    @FindBy(id = "cart_contents_container")
    private  WebElement cartContentsContainer;

    public boolean isDisplayCheckOutPage() {
        return displayCheckOutPage.isDisplayed();
    }

    public boolean isDisplayProduct(String products) {
        boolean dataReturn = false;
        String[] listOfProduct = products.split(",");
        WebElement product;
        for (String productName:
                listOfProduct) {
            product = cartContentsContainer.findElement(By.xpath("//div[text()='"+ productName +"']"));
            dataReturn = product.isDisplayed();
            if (!dataReturn){
                return false;
            }
        }
        return dataReturn;

    }


    @FindBy(xpath = "//span[@class='title']")
    private WebElement titlePage;

    @FindBy(className = "item_pricebar")
    private WebElement itemPriceBar;

    //submitInfo button
    @FindBy(xpath = "//input[@id='continue']")
    private WebElement buttonSubmitInfo;

    //finish button
    @FindBy(xpath = "//button[@id='finish']")
    private WebElement buttonFinishCheckout;

    @FindBy(className = "checkout_info")
    private WebElement checkoutInfo;

    @FindBy(xpath = "//div[contains(text(),'Item total:')]")
    private WebElement itemTotal;

    @FindBy(xpath = "//div[contains(text(),'Tax:')]")
    private WebElement itemTax;

    @FindBy(xpath = "//div[contains(text(),'Total:')]")
    private WebElement total;

    //displaying invetoryItemName
    @FindBy(css = ".inventory_item_name")
    private WebElement invetoryItemName;

    public void submitInfoBuyer() {
        buttonSubmitInfo.click();
    }

    public void finishCheckout() {
        buttonFinishCheckout.click();
    }

    public boolean isDisplayPage(String title) {
        return titlePage.getText().equals(title);
    }

    public boolean verifyProductName(String productName) {
        return invetoryItemName.getText().equals(productName);
    }


    public void removeItem(String itemName) {
        WebElement removeItem;
        String xPathRemoveItem = "//button[@id='remove-" + itemName.toLowerCase().replace(" ", "-") + "']";
        removeItem = itemPriceBar.findElement(By.xpath(xPathRemoveItem));
        removeItem.click();
    }

    public void setInformationForm(String firstname, String lastname, String postalcode) {
        WebElement fname = checkoutInfo.findElement(By.xpath("//input[@id='first-name']"));
        WebElement lname = checkoutInfo.findElement(By.xpath("//input[@id='last-name']"));
        WebElement pcode = checkoutInfo.findElement(By.xpath("//input[@id='postal-code']"));
        fname.sendKeys(firstname);
        lname.sendKeys(lastname);
        pcode.sendKeys(postalcode);
    }

    public boolean isDisplaySumPrice() {
        return itemTotal.isDisplayed() && itemTax.isDisplayed() && total.isDisplayed();
    }


}
