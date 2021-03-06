package com.bizzclick.website.ui.ForgotPassword;

import com.bizzclick.website.ui.TestGroupWithDeletingData;
import org.openqa.selenium.By;
import org.testng.annotations.*;
import static org.junit.Assert.assertTrue;


public class OpeningResetPasswordPage extends TestGroupWithDeletingData {

    @Override
    @BeforeTest
    @Parameters({"browser", "mailboxAccount", "mailboxPassword"})
    public void beforeTest(@Optional String browser, @Optional String mailboxAccount, @Optional String mailboxPassword) throws Exception {

        cleanAllRecordsOfEmailBeforeTest(browser, mailboxAccount, mailboxPassword);
        signUpWithEmailConfirmation(driver, NAME_VALUE, COMPANY_VALUE, mailboxAccount, PASSWORD_VALUE_VALID, mailboxPassword, MAILBOX_ONLY_ONE_NEW_LETTER_ABOUT_CONFIRM_EMAIL_XPATH, MAILBOX_CONFIRMATION_LINK_XPATH);
        sendForgotPasswordToken(driver, FORGOT_PASSWORD_EMAIL_VALUE);
        driver.quit();
        driver = setWebDriver(browser);
    }

    @Test
    public void openSetNewPasswordPageTest() throws InterruptedException {

        getLinkFromEmail(
                driver,
                FORGOT_PASSWORD_EMAIL_VALUE,
                MAILBOX_PASSWORD_VALUE,
                MAILBOX_NEW_LETTER_ABOUT_FORGOT_PASSWORD_XPATH,
                MAILBOX_FORGOT_PASSWORD_LINK_XPATH);

        try {
            assertTrue(isElementPresent(driver, By.xpath(RESET_PASSWORD__CHANGE_PASSWORD_BUTTON_XPATH)));
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
    }
}