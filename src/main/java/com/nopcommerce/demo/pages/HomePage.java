package com.nopcommerce.demo.pages;

import com.nopcommerce.demo.utilities.Utility;
import org.openqa.selenium.By;
import org.testng.Reporter;

/**
 * Created by Jay Vaghani
 */
public class HomePage extends Utility {

    By loginLink = By.linkText("Log in");
    By registerLink = By.linkText("Register");


    public void clickOnLoginLink(){
        Reporter.log("Clicking on Login Link " + loginLink.toString());
        clickOnElement(loginLink);
    }

    public void clickOnRegisterLink(){
        Reporter.log("Clicking on Register Link " + registerLink.toString());
        clickOnElement(registerLink);
    }

}
