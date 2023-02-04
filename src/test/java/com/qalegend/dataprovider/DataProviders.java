package com.qalegend.dataprovider;


import com.qalegend.utilities.ExcelUtility;
import org.testng.annotations.DataProvider;

public class DataProviders {
    ExcelUtility excel=new ExcelUtility();
    @DataProvider(name = "InvalidUserCredentials")
    public Object[][] invalidUserCredentialsToLogin(){
        Object[][] data=excel.dataProviderRead("LoginPageDataProvider");
        return data;
    }
}
