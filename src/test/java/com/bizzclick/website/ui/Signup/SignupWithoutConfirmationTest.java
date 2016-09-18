package com.bizzclick.website.ui.Signup;

import com.bizzclick.website.ui.TestGroupWithDeletingData;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import static org.junit.Assert.assertTrue;


public class SignupWithoutConfirmationTest extends TestGroupWithDeletingData{

    @Test
    public void signupWithoutConfirmation() throws Exception {

        signUp(driver, NAME_VALUE, COMPANY_VALUE, EMAIL_VALUE_WITHOUT_CONFIRMATION, PASSWORD_VALUE_VALID, PASSWORD_VALUE_VALID);

        try {
            assertTrue(isElementPresent(driver, By.xpath(CONFIRM_EMAIL_ALERT_XPATH)));
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
    }
}