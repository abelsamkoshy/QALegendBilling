package com.qalegend.pages;

import com.qalegend.utilities.TestHelperUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends TestHelperUtility {
    public WebDriver driver;
    private final String _userName="//input[@id='username']";
    @FindBy(xpath = _userName) public WebElement userName;
    private final String _passwordMenu="//input[@id='password']";
    @FindBy(xpath = _passwordMenu) public WebElement passwordText;
    private final String _loginButton="//button[@class='btn btn-primary']";
    @FindBy(xpath = _loginButton) public WebElement loginButton;
    private final String _endTour="//button[@class='btn btn-default btn-sm']";
    @FindBy(xpath = _endTour) public WebElement endTour;

    private final String _validationMsg="//span[@class='help-block']//strong";
    @FindBy(xpath = _validationMsg) public WebElement validationMsg;
    private final String _rememberMeChkBox="//div[@class='checkbox']//input";
    @FindBy(xpath = _rememberMeChkBox) public WebElement rememberMeCheckBx;
    private final String _forgotPassword="//a[@class='btn btn-link']";
    @FindBy(xpath = _forgotPassword) public WebElement forgotPassword;



    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public String getLoginPageTitle() {
        String title=page.getPageTitle(driver);
        return title;
    }

    public HomePage clickOnLoginButton() {
        page.submitPage(loginButton);
        return new HomePage(driver);
    }
    public void endTour(){
        page.clickOnElement(endTour);
    }
    public void enterUserName(String userNameText){
        page.enterText(userName,userNameText);
    }
    public void enterPassword(String password){
        page.enterText(passwordText,password);
    }
    public String getValidationMsg(){
        String validationMsg1= page.getElementText(validationMsg);
        return validationMsg1;
    }
    public void clickRememberMeCheckBox(){
        page.clickOnElement(rememberMeCheckBx);
    }
    public void clickOnForgotPassword(){
        page.clickOnElement(forgotPassword);
    }
}
