package com.bizzclick.website.ui.Signup;

import com.bizzclick.website.ui.TestGroupWithDeletingData;
import org.openqa.selenium.By;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import static org.junit.Assert.assertTrue;


public class UsingIncorrectTokenAfterUserRemovalTest extends TestGroupWithDeletingData {

    @BeforeTest
    @Parameters({"browser", "mailboxAccount", "mailboxPassword"})
    public void beforeTest(@Optional String browser, @Optional String mailboxAccount, @Optional String mailboxPassword) throws Exception {

        cleanAllRecordsOfEmailBeforeTest(browser, mailboxAccount, mailboxPassword);
        signUp(driver, NAME_VALUE, COMPANY_VALUE, mailboxAccount, PASSWORD_VALUE_VALID, PASSWORD_VALUE_VALID);
        driver.quit();
        deleteUserFromDBbyEmail(mailboxAccount);
        driver = setWebDriver(browser);
    }

    @Test
    public void usingIncorrectTokenAfterUserRemoval() throws Exception {

        getLinkFromEmail(driver, EMAIL_VALUE_WITHOUT_CONFIRMATION, MAILBOX_PASSWORD_VALUE, MAILBOX_ONLY_ONE_NEW_LETTER_ABOUT_CONFIRM_EMAIL_XPATH, MAILBOX_CONFIRMATION_LINK_XPATH);

        try {
            assertTrue(isElementPresent(driver, By.xpath(EMAIL_NOT_FOUND_ALERT_XPATH)));
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
    }
}