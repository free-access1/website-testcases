package com.bizzclick.website.ui.Login;

import com.bizzclick.website.ui.TestGroupWithDeletingData;
import org.openqa.selenium.*;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import static org.junit.Assert.*;


public class CorrectLoginTest extends TestGroupWithDeletingData {

    @Override
    @BeforeTest
    @Parameters({"browser", "mailboxAccount", "mailboxPassword"})
    public void beforeTest(@Optional String browser, @Optional String mailboxAccount, @Optional String mailboxPassword) throws Exception {

        cleanAllRecordsOfEmailBeforeTest(browser, mailboxAccount, mailboxPassword);
        signUpWithEmailConfirmation(driver, NAME_VALUE, COMPANY_VALUE, mailboxAccount, PASSWORD_VALUE_VALID, mailboxPassword, MAILBOX_ONLY_ONE_NEW_LETTER_ABOUT_CONFIRM_EMAIL_XPATH, MAILBOX_CONFIRMATION_LINK_XPATH);
        driver.quit();
        startTest(browser, BASE_URL);
    }

    @Test
    public void correctLogin() throws Exception {

        login(driver, EMAIL_VALUE_CORRECT_VALID, PASSWORD_VALUE_VALID);

        try {
            assertTrue(isElementPresent(driver, By.xpath(USER_MENU_XPATH)));
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
    }
}