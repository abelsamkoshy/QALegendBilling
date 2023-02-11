package com.qalegend.testscript;

import com.qalegend.automationcore.Base;
import com.qalegend.constants.ErrorMessages;
import com.qalegend.pages.HomePage;
import com.qalegend.pages.LoginPage;
import com.qalegend.utilities.ExcelUtility;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class HomeTest extends Base {
    HomePage home;
    LoginPage login;

    @Test(priority = 1,description = "TC001_verify Home page title",groups = {"Smoke"})
    public void TC006_verifyHomePageTitle() throws IOException {
        //extentTest.get().assignCategory("Smoke");
        List<ArrayList<String>> data = ExcelUtility.excelDataReader("LoginPage");
        String userName=data.get(1).get(1);
        String password=data.get(2).get(1);
        String expUserName=data.get(3).get(1);
        login=new LoginPage(driver);
        login.enterUserName(userName);
        login.enterPassword(password);
        home =login.clickOnLoginButton();
        login.endTour();
        List<ArrayList<String>> data1 = ExcelUtility.excelDataReader("HomePage");
        String expHomePageTitle = data1.get(0).get(1);
        home = new HomePage(driver);
        String actHomePageTitle = home.getHomePageTitle();
        Assert.assertEquals(actHomePageTitle, expHomePageTitle, ErrorMessages.TITLE_FAILURE_MESSAGE);
        //extentTest.get().log(Status.PASS,"Expected homepage title match with actual homepage title");
    }
    @Test(priority = 1,description = "TC_007_verifyDateDisplayed",groups = {"Regression"})
    public void TC_007_verifyDateDisplayed(){
        List<ArrayList<String>> data = ExcelUtility.excelDataReader("LoginPage");
        String userName=data.get(1).get(1);
        String password=data.get(2).get(1);
        String expUserName=data.get(3).get(1);
        login=new LoginPage(driver);
        login.enterUserName(userName);
        login.enterPassword(password);
        home =login.clickOnLoginButton();
        login.endTour();
        home.checkDate();
    }
    @Test(priority = 1,description = "TC_008_verifyclickingOnsignOutToLoginPage",groups = {"Sanity"})
    public void TC_008_verifyclickingOnsignOutToLoginPage(){
        List<ArrayList<String>> data = ExcelUtility.excelDataReader("LoginPage");
        String userName=data.get(1).get(1);
        String password=data.get(2).get(1);
        String expUserName=data.get(3).get(1);
        login=new LoginPage(driver);
        login.enterUserName(userName);
        login.enterPassword(password);
        home =login.clickOnLoginButton();
        login.endTour();
        home.clickUserName();
        home.clickSignOut();
        List<ArrayList<String>> data1 = ExcelUtility.excelDataReader("LoginPage");
        String expLoginPageTitle=data1.get(0).get(1);
        login=new LoginPage(driver);
        String actLogingPageTitle=login.getLoginPageTitle();
        Assert.assertEquals(actLogingPageTitle,expLoginPageTitle, ErrorMessages.TITLE_FAILURE_MESSAGE);
    }
}
