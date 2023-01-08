package org.example.pageObject;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    public static WebDriver driver;
    public LoginPage(WebDriver driver){
        PageFactory.initElements(driver,this);
        this.driver = driver ;
    }

    //displaying title SWAGLABS brand
    @FindBy(xpath = "//div[@class='header_label']")
    private WebElement diplayLandingPage;

    //path USER NAME field
    @FindBy(xpath = "//input[@id='user-name']")
    private WebElement userName;

    //path PASSWORD field
    @FindBy(xpath = "//input[@id='password']")
    private WebElement password;

    //path LOGIN button by xpath
    @FindBy(xpath = "//input[@id='login-button']")
    private WebElement btnLogin;

    //path LOGIN button by id
//    @FindBy(id = "login-button")
//    private WebElement btnLogin;

    //making function click for button LOGIN
    public void clickLogin(){
        btnLogin.click();
    }

    //path ERROR TEXT MESSAGE
    @FindBy(xpath = "//h3")
    private WebElement errorText;

    //making field USER NAME allow to type content automatically into an editable field
    public void setUserName(String user){
        userName.sendKeys(user);
    }

    //making field PASSWORD allow to type content automatically into an editable field
    public void setPassword(String pwd){
        password.sendKeys(pwd);
    }

    //displaying element
    public void isDisplayed(){
        userName.isDisplayed();
    }

    //get ERROR TEXT MESSAGE and display it
    public String getErrorText(){
        return errorText.getText();
    }



}