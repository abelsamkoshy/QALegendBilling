package com.qalegend.testscript;

import com.qalegend.automationcore.Base;
import com.qalegend.constants.ErrorMessages;
import com.qalegend.pages.HomePage;
import com.qalegend.pages.LoginPage;
import com.qalegend.pages.UserManagementPage;
import com.qalegend.pages.UserPage;
import com.qalegend.utilities.ExcelUtility;
import com.qalegend.utilities.WaitUtility;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class UserManagementTest extends Base {
    UserManagementPage userManagement;
    UserPage user;
    LoginPage login;
    HomePage home;
    WaitUtility wait;
    @Test(priority = 1,description = "TC_009_verifyUsermangementSubTabs",groups = {"Regression"})
    public void TC_009_verifyUsermangementSubTabs() throws InterruptedException {
        List<ArrayList<String>> data = ExcelUtility.excelDataReader("LoginPage");
        String userName=data.get(1).get(1);
        String password=data.get(2).get(1);
        String expUserName=data.get(3).get(1);
        login=new LoginPage(driver);
        login.enterUserName(userName);
        login.enterPassword(password);
        home =login.clickOnLoginButton();
        login.endTour();
        userManagement=new UserManagementPage(driver);
        userManagement.clickUserManagement();
        userManagement.clickUserMenu();
        Thread.sleep(5000);
        List<ArrayList<String>> data1 = ExcelUtility.excelDataReader("UserPage");
        user=new UserPage(driver);
        String expUserPageTitle=data1.get(0).get(1);
        String actUserPageTitle=user.getUserPageTitle();
        Assert.assertEquals(actUserPageTitle,expUserPageTitle, ErrorMessages.TITLE_FAILURE_MESSAGE);
    }
    @Test(priority = 1,description = "TC_010_verifyUsersPageTitle",groups = {"Sanity"})
    public void TC_010_verifyUsersPageTitle() throws InterruptedException {
        List<ArrayList<String>> data = ExcelUtility.excelDataReader("LoginPage");
        String userName=data.get(1).get(1);
        String password=data.get(2).get(1);
        String expUserName=data.get(3).get(1);
        login=new LoginPage(driver);
        login.enterUserName(userName);
        login.enterPassword(password);
        home =login.clickOnLoginButton();
        login.endTour();
        userManagement=new UserManagementPage(driver);
        userManagement.clickUserManagement();
        userManagement.clickUserMenu();
        Thread.sleep(5000);
        List<ArrayList<String>> data1 = ExcelUtility.excelDataReader("UserPage");
        user=new UserPage(driver);
        String expUserPageTitle=data1.get(0).get(1);
        String actUserPageTitle=user.getUserPageTitle();
        Assert.assertEquals(actUserPageTitle,expUserPageTitle, ErrorMessages.TITLE_FAILURE_MESSAGE);
    }
}
