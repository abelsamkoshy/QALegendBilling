package com.qalegend.pages;

import com.qalegend.utilities.TestHelperUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UserManagementPage extends TestHelperUtility {
    public WebDriver driver;

    private final String _userManagementMenu="//span[text()='User Management']";
    @FindBy(xpath = _userManagementMenu )public WebElement userManagementMenu;

    private final String _usersMenu="body > div.wrapper > aside > section > ul > li.treeview.active.active-sub > ul > li.active.active-sub > a > span";
    @FindBy(css = _usersMenu )public WebElement usersMenu;

    private final String _rolesMenu="//i[@class='fa fa-briefcase']//following-sibling::span";
    @FindBy(xpath = _rolesMenu )public WebElement rolesMenu;

    private final String _salesCommissionMenu="//i[@class='fa fa-handshake-o']//following-sibling::span";
    @FindBy(xpath = _salesCommissionMenu )private WebElement salesCommissionMenu;
    public UserManagementPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public void clickUserManagement(){
        page.clickOnElement(userManagementMenu);
    }

    public void clickUserMenu(){
        page.clickOnElement(usersMenu);
    }
}
