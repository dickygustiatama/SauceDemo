package step_definitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.example.pageObject.CheckOutPage;
import org.example.pageObject.InventoriPage;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

public class PurchaseSteps {

    private WebDriver webDriver;

    public PurchaseSteps() {
        super();
        this.webDriver = Hooks.webDriver;

    }

//    @And("user pick item Sauce Labs Backpack")
//    public void clickItemBasket1() throws InterruptedException {
//        InventoriPage inventoriPage = new InventoriPage(webDriver);
//        Thread.sleep(1000);
//        inventoriPage.clickBasket1();
//        Thread.sleep(1000);
//    }

    @When("user already on landing page")
    public void isDisplayLandingPage() throws InterruptedException {
        InventoriPage inventoriPage = new InventoriPage(webDriver);
        String a = "(Name Z to A)";
        inventoriPage.selectProductContainer(a);
        Thread.sleep(1000);
    }

    @When("user select \"(.*)\" to FILTER PRODUCT item, product will be sorted by selected input")
    public void filterProduct(String filter) throws InterruptedException {
        InventoriPage inventoriPage = new InventoriPage(webDriver);
        Thread.sleep(1000);
        inventoriPage.sortProductBy(filter);
        Thread.sleep(1000);
    }

    @Then("User already on landing page")
    public void verifyLandingPage(){
        InventoriPage inventoryPage = new InventoriPage(webDriver);
        Assert.assertTrue(inventoryPage.isDisplayLandingPage());
    }
    @And("User already on checkout page")
    public void verifyCheckOutPage(){
        CheckOutPage checkOutPage = new CheckOutPage(webDriver);
        Assert.assertTrue(checkOutPage.isDisplayCheckOutPage());
    }

    @And("User verify that \"(.*)\" as products in a list")
    public void verifyListOfProduct(String products) {
        CheckOutPage checkOutPage = new CheckOutPage(webDriver);
        Assert.assertTrue(checkOutPage.isDisplayProduct(products));
    }



//    @And("user checkout \"(.*)\" as products to cart")
//    public void addProductToCart(String products) throws InterruptedException {
//        InventoriPage inventoryPage = new InventoriPage(webDriver);
//        inventoryPage.addToCart(products);
//        inventoryPage.clickCart();
//        Thread.sleep(1000);
//    }

    @And("user pick item \"(.*)\"")
    public void addToCart(String product) throws InterruptedException {
        InventoriPage inventoriPage = new InventoriPage(webDriver);
        Thread.sleep(1000);
        inventoriPage.addToCart(product);
        inventoriPage.clickCart();
        Thread.sleep(1000);
    }

    @When("user has picked the products item, click Shopping Cart")
    public void shoppingCart() throws InterruptedException {
        InventoriPage inventoriPage = new InventoriPage(webDriver);
        Thread.sleep(1000);
        inventoriPage.shoppingCart();
        Thread.sleep(1000);
    }

    @Then("verify picked item \"(.*)\"")
    public boolean isDisplayItem (String products) throws InterruptedException {
        InventoriPage inventoriPage = new InventoriPage(webDriver);
        Thread.sleep(1000);
        Assert.assertTrue(inventoriPage.isDisplayItem(products));
        Thread.sleep(1000);
        return true;
    }


    @Then("user will be redirected to CART page titled YOUR CART")
    public void isDisplayCartPage() throws InterruptedException {
        InventoriPage inventoriPage = new InventoriPage(webDriver);
        Assert.assertTrue(inventoriPage.isDisplayCartPage());
    }

    @Then("user will be redirected to page titled \"(.*)\"")
    public void redirectPage(String title) throws InterruptedException {
        InventoriPage inventoriPage = new InventoriPage(webDriver);
        Assert.assertTrue(inventoriPage.isDisplayPage(title));
    }

    @When("user click remove item \"(.*)\"")
    public void removingAnItem(String itemName) throws InterruptedException {
        CheckOutPage checkOutPage = new CheckOutPage(webDriver);
        checkOutPage.removeItem(itemName);
        Thread.sleep(1000);
    }

    @When("user click Checkout Button")
    public void checkoutCart() throws InterruptedException {
        InventoriPage inventoriPage = new InventoriPage(webDriver);
        inventoriPage.checkoutCart();
        Thread.sleep(1000);
    }

    @When("user click Continue Button")
    public void submitInfoBuyer() throws InterruptedException {
        CheckOutPage checkOutPage = new CheckOutPage(webDriver);
        checkOutPage.submitInfoBuyer();
        Thread.sleep(1000);
    }

    @When("user click Finish Button")
    public void FinishCheckout() throws InterruptedException {
        CheckOutPage checkOutPage = new CheckOutPage(webDriver);
        checkOutPage.finishCheckout();
        Thread.sleep(1000);
    }

    @When("user need to input Information First Name/Last Name/Postal Code :\"(.*)\"/\"(.*)\"/\"(.*)\"")
    public void informationForm(String firstname, String lastname, String postalcode) throws InterruptedException {
        CheckOutPage checkOutPage = new CheckOutPage(webDriver);
        checkOutPage.setInformationForm(firstname, lastname, postalcode);
        Thread.sleep(1000);
    }

    @Then("verify component summary cost")
    public void isDisplaySummaryCost() throws InterruptedException {
        CheckOutPage checkOutPage = new CheckOutPage(webDriver);
        Assert.assertTrue(checkOutPage.isDisplaySumPrice());
    }

    @Then("verify product Name \"(.*)\"")
    public void verifyProductName(String productName) throws InterruptedException {
        CheckOutPage checkOutPage = new CheckOutPage(webDriver);
        Assert.assertTrue(checkOutPage.verifyProductName(productName));
    }
}