package com.bizzclick.website.ui.SetNewPassword;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.*;
import static org.junit.Assert.assertTrue;

public class IncorrectPassword extends PasswordMismatch{

    @Override
    @Test (dataProvider = "getIncorrectPasswords")
    public void checkInputValues(String password, String confirmPassword) {

        enterInputValues(password, confirmPassword);

        try {
            assertTrue(isElementPresent(driver, By.xpath(RESET_PASSWORD__CHANGE_PASSWORD_BUTTON_XPATH)));
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
    }


    @Test (dataProvider = "getIncorrectPasswords")
    public void checkInputValuesOnServerSide(String password, String confirmPassword) {

        ((JavascriptExecutor) driver).executeScript("document.getElementById('password').removeAttribute('required'); " +
                                                    "document.getElementById('password').removeAttribute('type');" +
                                                    "document.getElementById('confirm').removeAttribute('required'); " +
                                                    "document.getElementById('confirm').removeAttribute('type');");
        enterInputValues(password, confirmPassword);

        try {
            assertTrue(isElementPresent(driver, By.xpath(RESET_PASSWORD__INCORRECT_PASSWORD_ALERT_XPATH)));
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
    }
}