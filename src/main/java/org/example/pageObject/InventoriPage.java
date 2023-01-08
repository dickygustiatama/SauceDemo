package org.example.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.*;

public class InventoriPage {

    //shopping cart path
    @FindBy(xpath = "//div[@id='shopping_cart_container']/a[1]")
    private WebElement shoppingChartLink;

    //displaying title PRODUCT
    @FindBy(xpath = "//span[@class='title']")
    private WebElement displayLandingPage;

    //displaying title Your Cart
    @FindBy(xpath = "//span[@class='title']")
    private WebElement displayCartPage;

    @FindBy(xpath = "//span[@class='title']")
    private WebElement titlePage;

    //path field SORT
    @FindBy(xpath = "//select[@class='product_sort_container']")
    private WebElement selectContainer;

    //making ADD TO CART button
    @FindBy(css = ".shopping_cart_link")
    private WebElement buttonCart;

    //checkout button
    @FindBy(xpath = "//button[@id='checkout']")
    private WebElement buttonCheckout;


    public static WebDriver driver;

    public InventoriPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public void sortProductBy(String sortBy) {
        Select b = new Select(selectContainer);
        b.selectByVisibleText(sortBy);
    }

    public boolean isDisplayLandingPage() {
        return displayLandingPage.isDisplayed();
    }

    public boolean isDisplayCartPage() {
        return displayCartPage.getText().equals("YOUR CART");
    }

    public boolean isDisplayPage(String title) {
        return titlePage.getText().equals(title);
    }

    //making function click for SHOPPING CART
    public void shoppingCart() {
        buttonCart.click();
    }

    public void checkoutCart() {
        buttonCheckout.click();
    }


    //making function select visible text on field SORT
    public void selectProductContainer(String sortProductList) {
        Select a = new Select(selectContainer);
        a.selectByVisibleText(sortProductList);
    }

    public void addToCart(String products) throws InterruptedException {
        String[] listOfProduct = products.split(",");
        WebElement selectedProduct;
        System.out.println("check out product");
        for (String productName :
                listOfProduct) {
            String xPathSelectedProduct = "//button[@id='add-to-cart-" + productName.toLowerCase().replace(" ", "-") + "']";
            selectedProduct = selectContainer.findElement(By.xpath(xPathSelectedProduct));
            selectedProduct.click();
        }

        Thread.sleep(5000);
    }

    //making function select on field SORT
    public void filterProductBy(String filter) {
        Select b = new Select(driver.findElement(By.xpath("//select[@class='product_sort_container']")));
    }

    public void clickCart() {
        buttonCart.click();
    }

    public boolean isDisplayItem(String products) {
        String[] listOfProduct = products.split(",");
        List<String> listElementInput = new ArrayList<String>();

        List<String> listElement = new ArrayList<String>();
        this.driver = driver;
        WebElement element = driver.findElement(By.className("cart_list"));
        List<WebElement> elementList = element.findElements(By.className("cart_item"));
        elementList.forEach(e -> {
            WebElement itemLabel = e.findElement(By.className("cart_item_label"));
            WebElement itemName = itemLabel.findElement(By.className("inventory_item_name"));
            listElement.add(itemName.getText());
        });
        int index = 0 ;
        boolean res = false;
        for (String productName :
                listOfProduct) {
            res = productName.equals(listElement.get(index));
            index++;
        }
        return res;
    }
}