package com.bizzclick.website.ui.SetNewPassword;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import static org.junit.Assert.assertTrue;


public class CorrectPasswords extends PasswordMismatch {


    @Override
    @Test(dataProvider = "getCorrectPasswords")
    public void checkInputValues(String password, String confirmPassword) {

        enterInputValues(password, confirmPassword);

        try {
            assertTrue(isElementPresent(driver, By.xpath(RESET_PASSWORD__PASSWORD_CHANGED_GREEN_ALERT_XPATH)));
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
    }
}
