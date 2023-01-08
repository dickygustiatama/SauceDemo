package org.example.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.*;
import java.util.concurrent.atomic.AtomicBoolean;

public class InventoriPage {

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


    public boolean verifyProductName(String productName) {
        return invetoryItemName.getText().equals(productName);
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

    public void submitInfoBuyer() {
        buttonSubmitInfo.click();
    }
    public void finishCheckout() {
        buttonFinishCheckout.click();
    }

    public void setInformationForm(String firstname, String lastname, String postalcode){
        WebElement fname = checkoutInfo.findElement(By.xpath("//input[@id='first-name']"));
        WebElement lname = checkoutInfo.findElement(By.xpath("//input[@id='last-name']"));
        WebElement pcode = checkoutInfo.findElement(By.xpath("//input[@id='postal-code']"));
        fname.sendKeys(firstname);
        lname.sendKeys(lastname);
        pcode.sendKeys(postalcode);
    }
    public void removeItem(String itemName){
        WebElement removeItem;
        String xPathRemoveItem = "//button[@id='remove-"+itemName.toLowerCase().replace(" ","-") +"']";
        removeItem = itemPriceBar.findElement(By.xpath(xPathRemoveItem));
        removeItem.click();
    }

    //making function select visible text on field SORT
    public void selectProductContainer(String sortProductList){
        Select a = new Select (selectContainer);
        a.selectByVisibleText(sortProductList);
    }
    public void addToCart(String products) throws InterruptedException {
        String[] listOfProduct = products.split(",");
        WebElement selectedProduct;
        System.out.println("check out product");
        for (String productName:
                listOfProduct) {
            String xPathSelectedProduct = "//button[@id='add-to-cart-"+productName.toLowerCase().replace(" ","-") +"']";
            selectedProduct = selectContainer.findElement(By.xpath(xPathSelectedProduct));
            selectedProduct.click();
        }

        Thread.sleep(5000);
    }


//    public boolean isDisplayItem(String products) throws InterruptedException {
//        String[] listOfProduct = products.split(",");
//        WebElement selectedProduct;
//        System.out.println("check out product");
//        for (String productName :
//                listOfProduct) {
//            String xPathSelectedProduct = "//div[.='" + productName.toLowerCase().replace(" ", "-") + "']";
//            selectedProduct = selectContainer.findElement(By.xpath(xPathSelectedProduct));
//            selectedProduct.click();
//        }
//        Thread.sleep(5000);
//        return true;
//    }

    //making function select on field SORT
    public void filterProductBy(String filter){
        Select b = new Select (driver.findElement(By.xpath("//select[@class='product_sort_container']")));
    }

    public void clickCart(){
        buttonCart.click();
    }

    //shopping cart path
    @FindBy(xpath = "//div[@id='shopping_cart_container']/a[1]")
    private WebElement shoppingChartLink;

    //displaying title PRODUCT
    @FindBy(xpath = "//span[@class='title']")
    private WebElement displayLandingPage;

    //displaying title Your Cart
    @FindBy(xpath = "//span[@class='title']")
    private WebElement displayCartPage;

    //displaying invetoryItemName
    @FindBy(css = ".inventory_item_name")
    private WebElement invetoryItemName;

    @FindBy(xpath = "//span[@class='title']")
    private WebElement titlePage;

    //path field SORT
    @FindBy(xpath = "//select[@class='product_sort_container']")
    private WebElement selectContainer;

    @FindBy(className = "item_pricebar")
    private WebElement itemPriceBar;

    @FindBy(className = "checkout_info")
    private WebElement checkoutInfo;

    //making ADD TO CART button
    @FindBy(css=".shopping_cart_link")
    private WebElement buttonCart;

    //checkout button
    @FindBy(xpath="//button[@id='checkout']")
    private WebElement buttonCheckout;

    //submitInfo button
    @FindBy(xpath="//input[@id='continue']")
    private WebElement buttonSubmitInfo;

    //finish button
    @FindBy(xpath="//button[@id='finish']")
    private WebElement buttonFinishCheckout;

    public boolean isDisplayItem(String products) {
        String[] listOfProduct = products.split(",");
        List<String> listElement =  new ArrayList<String>();
        this.driver = driver;
        WebElement element = driver.findElement(By.className("cart_list"));
        List<WebElement> elementList = element.findElements(By.className("cart_item"));
        elementList.forEach( e -> {
           WebElement itemLabel = e.findElement(By.className("cart_item_label"));
           WebElement itemName = itemLabel.findElement(By.className("inventory_item_name"));
            listElement.add(itemName.getText());
        });
        return listOfProduct.equals(listElement);
    }

    public boolean overviewSummaryInfo(String paymentLabel, String paymentVal, String shippingLabel,String shippingVal) {
        this.driver = driver;

//        Map<String, String> mapInput = new HashMap<String, String>();
//        mapInput.put(paymentLabel, paymentVal);
//        mapInput.put(shippingLabel, shippingVal);

        String plabelActual = "#";
        WebElement element = driver.findElement(By.id("checkout_summary_container"));
        List<WebElement> elementList = element.findElements(By.xpath("//div[@class='summary_info']"));
//        List<String> listLabel =  new ArrayList<String>();
//        List<String> listValue =  new ArrayList<String>();
//        AtomicBoolean result = new AtomicBoolean(true);
        elementList.forEach( e -> {
            WebElement pLabel = e.findElement(By.xpath("//div[.='#:']".replace("#",paymentLabel)));
            plabelActual.replace("#", pLabel.getText());
        });
        return plabelActual.equals(paymentLabel);

//        Map<String, String> mapActual = new HashMap<String, String>();

//        mapActual.put(listLabel.get(0), listValue.get(0));
//        mapActual.put(listLabel.get(1), listValue.get(1));

//        return mapInput.equals(mapActual);
    }
}

//    //path item SAUCE LABS BACKPACK
//    @FindBy(xpath = "//button[@id='add-to-cart-sauce-labs-backpack']")
//    private WebElement basketItem1;
//
//    //making function click
//    public void clickBasket1(){
//        basketItem1.click();
//    }


//}


//package org.example.pageObject;
//
//        import org.openqa.selenium.By;
//        import org.openqa.selenium.WebDriver;
//        import org.openqa.selenium.WebElement;
//        import org.openqa.selenium.support.FindBy;
//        import org.openqa.selenium.support.PageFactory;
//        import org.openqa.selenium.support.ui.Select;
//
//        import static jdk.nashorn.internal.runtime.regexp.joni.Config.log;
//
//public class InventoriPage {
//    public static WebDriver driver;
//
//    public InventoriPage(WebDriver driver){
//        PageFactory.initElements(driver, this);
//        this.driver = driver;
//    }
//
//    @FindBy(xpath = "//button[@id='add-to-cart-sauce-labs-backpack']")
//    private WebElement basketItem1;
//
//    @FindBy(xpath = "//select[@class='product_sort_container']")
//    private WebElement selectContainer;
//
//    @FindBy(className = "shopping_cart_link")
//    private WebElement buttonCart;
//
//    @FindBy(xpath = "//span[.='Products']")
//    private WebElement displayLandingPage;
//
//    @FindBy(className = "inventory_list")
//    private WebElement productContainer;
//
//    public void clickBasket1(){
//        basketItem1.click();
//    }
//    public void sortProductBy(String sortBy){
//        Select b = new Select (selectContainer);
//        b.selectByVisibleText(sortBy);
//    }
//
//    public boolean isDisplayLandingPage(){
//        return displayLandingPage.isDisplayed();
//    }
//
//    public void clickCart(){
//        buttonCart.click();
//    }
//
//    public void addToCart(String products) throws InterruptedException {
//        String[] listOfProduct = products.split(",");
//        WebElement selectedProduct;
//        System.out.println("check out product");
//        for (String productName:
//                listOfProduct) {
//            String xPathSelectedProduct =  "//button[@id='add-to-cart-"+ productName.toLowerCase().replace(" ","-") +"']";
//            selectedProduct = productContainer.findElement(By.xpath(xPathSelectedProduct));
//            selectedProduct.click();
//        }
//        Thread.sleep(5000);
//    }
//}