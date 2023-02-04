package com.qalegend.testscript;

import com.qalegend.automationcore.Base;
import com.qalegend.constants.ErrorMessages;
import com.qalegend.pages.LoginPage;
import com.qalegend.pages.ResetPage;
import com.qalegend.utilities.ExcelUtility;
import com.qalegend.utilities.RandomDataUtility;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class ResetTest extends Base {
    LoginPage login;
    ResetPage reset;
    @Test
    public void TC_005_VerifyErrorMessageOnForgetPasswordWithInvalidEmail(){
        List<ArrayList<String>> data = ExcelUtility.excelDataReader("ResetPage");
        String expValMsg= data.get(0).get(1);
        login=new LoginPage(driver);
        reset=new ResetPage(driver);
        login.clickOnForgotPassword();
        String fName = RandomDataUtility.getfName();
        reset.enterUserName(fName+"@123");
        reset.clickResetLink();
        String actValMsg=reset.resetInvalidEmail();
        Assert.assertEquals(actValMsg,expValMsg, ErrorMessages.INVALID_EMAIL_ID);
    }
}
