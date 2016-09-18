package com.bizzclick.website.ui.Signup;

import com.bizzclick.website.ui.TestGroupWithDeletingData;
import org.openqa.selenium.By;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import static org.junit.Assert.assertTrue;


public class UsingIncorrectTokenBeforeUserRemovalTest extends TestGroupWithDeletingData {

    @BeforeTest
    @Parameters({"browser", "mailboxAccount", "mailboxPassword"})
    public void beforeTest(@Optional String browser, @Optional String mailboxAccount, @Optional String mailboxPassword) throws Exception {

        cleanAllRecordsOfEmailBeforeTest(browser, mailboxAccount, mailboxPassword);
        // 1st sign up
        signUp(driver, NAME_VALUE, COMPANY_VALUE, mailboxAccount, PASSWORD_VALUE_VALID, PASSWORD_VALUE_VALID);
        driver.quit();
        deleteUserFromDBbyEmail(mailboxAccount);
        // 2nd sign up
        driver = setWebDriver(browser);
        driver.get(BASE_URL);
        signUp(driver, NAME_VALUE, COMPANY_VALUE, mailboxAccount, PASSWORD_VALUE_VALID, PASSWORD_VALUE_VALID);
        driver.quit();
        driver = setWebDriver(browser);
    }

    @Test
    public void usingIncorrectToken() throws Exception {

        getLinkFromEmail(driver, EMAIL_VALUE_WITHOUT_CONFIRMATION, MAILBOX_PASSWORD_VALUE, MAILBOX_FIRST_OF_NEW_LETTER_ABOUT_CONFIRM_EMAIL_XPATH, MAILBOX_CONFIRMATION_LINK_XPATH);

        try {
            assertTrue(isElementPresent(driver, By.xpath(INCORRECT_TOKEN_ALERT_XPATH)));
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
    }
}