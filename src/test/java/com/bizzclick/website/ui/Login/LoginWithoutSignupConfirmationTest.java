package com.bizzclick.website.ui.Login;

import com.bizzclick.website.ui.TestGroupWithDeletingData;
import org.openqa.selenium.By;
import org.testng.annotations.*;
import static org.junit.Assert.assertTrue;


public class LoginWithoutSignupConfirmationTest extends TestGroupWithDeletingData {

    @Override
    @BeforeTest
    @Parameters({"browser", "mailboxAccount", "mailboxPassword"})
    public void beforeTest(@Optional String browser, @Optional String mailboxAccount, @Optional String mailboxPassword) throws Exception {

        cleanAllRecordsOfEmailBeforeTest(browser, mailboxAccount, mailboxPassword);
        signUp(driver, NAME_VALUE, COMPANY_VALUE, mailboxAccount, PASSWORD_VALUE_VALID, PASSWORD_VALUE_VALID);
    }

    @Test
    public void loginWithoutSignUpConfirmation() throws Exception {

        login(driver, EMAIL_VALUE_WITHOUT_CONFIRMATION, PASSWORD_VALUE_VALID);

        try {
            assertTrue(isElementPresent(driver, By.xpath(ACTIVATE_ACCOUNT_ALERT_XPATH)));
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
    }
}