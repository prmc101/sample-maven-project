package com.nopcommerce.demo.testsuite;

import com.nopcommerce.demo.excelutility.ExcelUtility;
import com.nopcommerce.demo.pages.HomePage;
import com.nopcommerce.demo.pages.LoginPage;
import com.nopcommerce.demo.testbase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * Created by Jay Vaghani
 */
public class LoginTestWithExcelData extends BaseTest {

    public static final String FILE_PATH = System.getProperty("user.dir") + "/src/test/java/resources/testdata/ExcelData.xlsx";

    HomePage homePage = new HomePage();
    LoginPage loginPage = new LoginPage();

    @BeforeClass
    public void setExcel(){
        //Tell the code about the location of Excel file
        try {
            ExcelUtility.setExcelFile(FILE_PATH, "LoginTests");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @DataProvider(name = "dataFromExcel")
    public Object[][] getData(){
        return ExcelUtility.getTestData("Invalid_Login");
    }

    @Test(dataProvider = "dataFromExcel")
    public void verifyErrorMessageWithInvalidCredentials(String username, String password) {
        homePage.clickOnLoginLink();
        loginPage.loginToApplication(username, password);
        String expectedErrorMessage = "Login was unsuccessful. Please correct the errors and try again.\n"
                + "No customer account found";
        Assert.assertEquals(loginPage.getErrorMessage(), expectedErrorMessage, "Error message not displayed");
    }

}
