package com.qalegend.pages;

import com.qalegend.utilities.TestHelperUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ResetPage extends TestHelperUtility {
    public WebDriver driver;
    private final String _userName="//input[@class='form-control']";
    @FindBy(xpath = _userName) public WebElement userName;
    private final String _resetLink="//button[@class='btn btn-primary']";
    @FindBy(xpath = _resetLink) public WebElement resetLink;
    private final String _resetInvalidEmail="//span[@class='help-block']//strong";
    @FindBy(xpath =_resetInvalidEmail) public WebElement resetInvalidEmail;


    public ResetPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public void enterUserName(String userNameText){
        page.enterText(userName,userNameText);
    }
    public void clickResetLink(){
        page.clickOnElement(resetLink);
    }
    public String resetInvalidEmail(){
        String actValidationmsg=page.getElementText(resetInvalidEmail);
        return actValidationmsg;
    }
}
