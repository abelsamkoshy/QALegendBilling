package com.qalegend.pages;

import com.qalegend.utilities.TestHelperUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends TestHelperUtility {
    public WebDriver driver;
    private final String _userNameHomepage = "//a[@class='dropdown-toggle']//span";
    @FindBy(xpath = _userNameHomepage)
    public WebElement userNameHomepage;

    private final String _homeDate="//div[@class='m-8 pull-left mt-15 hidden-xs']//strong";
    @FindBy(xpath = _homeDate) public WebElement homeDate;
    private final String _signOut="//div[@class='pull-right']";
    @FindBy(xpath = _signOut) public WebElement signOut;


    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String getUserName() {
        String userNameH = page.getElementText(userNameHomepage);
        return userNameH;
    }

    public String getHomePageTitle() {
        String title = page.getPageTitle(driver);
        return title;
    }
    public void checkDate(){
        page.isDisplayed(homeDate);
    }
    public void clickUserName(){
        page.clickOnElement(userNameHomepage);
    }
    public void clickSignOut(){
        page.clickOnElement(signOut);
    }
}
