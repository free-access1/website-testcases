package com.bizzclick.website.ui.ForgotPassword;

import com.bizzclick.website.ui.TestGroupWithoutDeletingData;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;
import static org.junit.Assert.assertTrue;


public class WrongEmails extends TestGroupWithoutDeletingData {

    @Test (dataProvider = "getJustIncorrectEmail")
    public void checkIncorrectEmailOnClientSide(String email) {

        sendForgotPasswordToken(driver, email);

        try {
            assertTrue(isElementPresent(driver, By.xpath(FORGOT_PASSWORD__RESET_PASSWORD_BUTTON_XPATH)));
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
    }

    @Test (dataProvider = "getJustIncorrectEmail")
    public void checkIncorrectEmailOnServerSide(String email) {

        driver.findElement(By.xpath(LOGIN_LINK_XPATH)).click();
        driver.findElement(By.xpath(FORGOT_PASSWORD_LINK_XPATH)).click();
        ((JavascriptExecutor) driver).executeScript("document.getElementById('email').removeAttribute('required'); document.getElementById('email').removeAttribute('type');");
        driver.findElement(By.id(FORGOT_PASSWORD__EMAIL_ID)).clear();
        driver.findElement(By.id(FORGOT_PASSWORD__EMAIL_ID)).sendKeys(email);
        driver.findElement(By.xpath(FORGOT_PASSWORD__RESET_PASSWORD_BUTTON_XPATH)).click();

        try {
            assertTrue(isElementPresent(driver, By.xpath(FORGOT_PASSWORD_INCORRECT_EMAIL_RED_ALERT_XPATH)));
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
    }

    @Test
    public void checkInvalidEmailOnServerSide() {

        sendForgotPasswordToken(driver, EMAIL_VALUE_CORRECT_INVALID);

        try {
            assertTrue(isElementPresent(driver, By.xpath(FORGOT_PASSWORD_INVALID_EMAIL_RED_ALERT_XPATH)));
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
    }
}
