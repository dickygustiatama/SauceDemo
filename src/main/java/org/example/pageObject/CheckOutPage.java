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
    //displaying title PRODUCT
//    @FindBy(xpath = "//div[@class='cart_desc_label']")
//    private WebElement displayLandingPage;

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


}
