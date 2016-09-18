package com.bizzclick.website.ui.SetNewPassword;

import com.bizzclick.website.ui.TestGroupWithDeletingData;
import org.openqa.selenium.By;
import org.testng.annotations.*;
import java.util.concurrent.TimeUnit;
import static org.junit.Assert.assertTrue;


public class PasswordMismatch extends TestGroupWithDeletingData {

    @Override
    @BeforeTest
    @Parameters({"browser", "mailboxAccount", "mailboxPassword"})
    public void beforeTest(@Optional String browser, @Optional String mailboxAccount, @Optional String mailboxPassword) throws Exception {

        cleanAllRecordsOfEmailBeforeTest(browser, mailboxAccount, mailboxPassword);
        signUpWithEmailConfirmation(driver, NAME_VALUE, COMPANY_VALUE, mailboxAccount, PASSWORD_VALUE_VALID, mailboxPassword, MAILBOX_ONLY_ONE_NEW_LETTER_ABOUT_CONFIRM_EMAIL_XPATH, MAILBOX_CONFIRMATION_LINK_XPATH);
        sendForgotPasswordToken(driver, mailboxAccount);
        driver.quit();
        driver = setWebDriver(browser);
        getLinkFromEmail(driver, mailboxAccount, mailboxPassword, MAILBOX_NEW_LETTER_ABOUT_FORGOT_PASSWORD_XPATH, MAILBOX_FORGOT_PASSWORD_LINK_XPATH);
    }

    @Test (dataProvider = "getDifferentPasswords")
    public void checkInputValues(String password, String confirmPassword) {

        enterInputValues(password, confirmPassword);

        try {
            assertTrue(isElementPresent(driver, By.xpath(RESET_PASSWORD__PASSWORD_MISMATCH_ALERT_XPATH)));
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
    }

    public void enterInputValues(String password, String confirmPassword) {

        driver.findElement(By.id(RESET_PASSWORD__PASSWORD_ID)).clear();
        driver.findElement(By.id(RESET_PASSWORD__PASSWORD_ID)).sendKeys(password);
        driver.findElement(By.id(RESET_PASSWORD__CONFIRM_PASSWORD_ID)).clear();
        driver.findElement(By.id(RESET_PASSWORD__CONFIRM_PASSWORD_ID)).sendKeys(confirmPassword);
        driver.findElement(By.xpath(RESET_PASSWORD__CHANGE_PASSWORD_BUTTON_XPATH)).click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
}