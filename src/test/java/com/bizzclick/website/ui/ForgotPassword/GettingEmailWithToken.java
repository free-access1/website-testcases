package com.bizzclick.website.ui.ForgotPassword;

import com.bizzclick.website.ui.TestGroupWithDeletingData;
import org.openqa.selenium.By;
import org.testng.annotations.*;
import static org.junit.Assert.assertTrue;


public class GettingEmailWithToken extends TestGroupWithDeletingData {

    @Override
    @BeforeTest
    @Parameters({"browser", "mailboxAccount", "mailboxPassword"})
    public void beforeTest(@Optional String browser, @Optional String mailboxAccount, @Optional String mailboxPassword) throws Exception {

        cleanAllRecordsOfEmailBeforeTest(browser, mailboxAccount, mailboxPassword);
        signUpWithEmailConfirmation(driver, NAME_VALUE, COMPANY_VALUE, mailboxAccount, PASSWORD_VALUE_VALID, mailboxPassword, MAILBOX_ONLY_ONE_NEW_LETTER_ABOUT_CONFIRM_EMAIL_XPATH, MAILBOX_CONFIRMATION_LINK_XPATH);
    }

    @Test
    public void sendEmailWithTokenCorrectly() throws Exception {

        sendForgotPasswordToken(driver, FORGOT_PASSWORD_EMAIL_VALUE);

        try {
            assertTrue(isElementPresent(driver, By.xpath(FORGOT_PASSWORD__TOKEN_SENT__BLUE_ALERT_XPATH)));
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
    }
}