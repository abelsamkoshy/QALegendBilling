package com.qalegend.testscript;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.qalegend.automationcore.Base;
import com.qalegend.constants.ErrorMessages;
import com.qalegend.listeners.TestListener;
import com.qalegend.pages.HomePage;
import com.qalegend.pages.LoginPage;
import com.qalegend.utilities.ExcelUtility;
import com.qalegend.utilities.PageUtility;
import com.qalegend.utilities.RandomDataUtility;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LoginTest extends Base {
    LoginPage login;
    HomePage home;
    ThreadLocal<ExtentTest> extentTest = TestListener.getTestInstance();
    @Test(priority = 1,description = "TC001 Verify Login Page Title",groups = {"Smoke"})
    public void TC001_verifyLoginPageTitle() throws IOException {
        //extentTest.get().assignCategory("Smoke");
        List<ArrayList<String>> data = ExcelUtility.excelDataReader("LoginPage");
        String expLoginPageTitle=data.get(0).get(1);
        login=new LoginPage(driver);
        String actLogingPageTitle=login.getLoginPageTitle();
        Assert.assertEquals(actLogingPageTitle,expLoginPageTitle, ErrorMessages.TITLE_FAILURE_MESSAGE);
        //extentTest.get().log(Status.PASS,"Expected homepage title match with actual homepage title");
    }
    @Test(priority = 1,description = "TC002_verifyValidLogin",groups = {"Sanity"})
    public void TC002_verifyValidLogin(){
        List<ArrayList<String>> data = ExcelUtility.excelDataReader("LoginPage");
        String userName=data.get(1).get(1);
        String password=data.get(2).get(1);
        String expUserName=data.get(3).get(1);
        login=new LoginPage(driver);
        login.enterUserName(userName);
        login.enterPassword(password);
        home =login.clickOnLoginButton();
        login.endTour();
        String actUserName=home.getUserName();
        Assert.assertEquals(actUserName,expUserName,ErrorMessages.INVALID_LOGIN_MESSAGE);
    }
    @Test(priority = 1,description = "TTC_003_verifyErrorMessageForInvalidLogin",groups = {"Regression"})
    public void TC_003_verifyErrorMessageForInvalidLogin(){
        List<ArrayList<String>> data = ExcelUtility.excelDataReader("LoginPage");
        String expValMsg=data.get(4).get(1);
        String fName = RandomDataUtility.getfName();
        String password = fName + "@123";
        login=new LoginPage(driver);
        login.enterUserName(fName+"@123");
        login.enterPassword(password);
        home=login.clickOnLoginButton();
        String actValMsg=login.getValidationMsg();
        Assert.assertEquals(actValMsg,expValMsg,ErrorMessages.INVALID_LOGIN_MESSAGE);
    }
    @Test(priority = 1,description = "TTC_004_VerifyUserClickRememberMeCheckbox",groups = {"Smoke"})
    public void TC_004_VerifyUserClickRememberMeCheckbox(){
        login=new LoginPage(driver);
        login.clickRememberMeCheckBox();
    }
}
