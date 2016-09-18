package com.bizzclick.website.ui.Signup;

import com.bizzclick.website.ui.TestGroupWithDeletingData;
import org.openqa.selenium.By;
import org.testng.annotations.*;
import static org.junit.Assert.assertTrue;


public class CorrectSignupTest extends TestGroupWithDeletingData {

    @Test
    public void correctSignUp() throws Exception {

        signUpWithEmailConfirmation(driver, NAME_VALUE, COMPANY_VALUE, EMAIL_VALUE_FOR_CONFIRMATION, PASSWORD_VALUE_VALID, MAILBOX_PASSWORD_VALUE, MAILBOX_ONLY_ONE_NEW_LETTER_ABOUT_CONFIRM_EMAIL_XPATH, MAILBOX_CONFIRMATION_LINK_XPATH);

        try {
            assertTrue(isElementPresent(driver, By.xpath(EMAIL_CONFIRMATION_MESSAGE_XPATH)));
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
    }
}