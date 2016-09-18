package com.bizzclick.website.ui.Login;

import com.bizzclick.website.ui.TestGroupWithDeletingData;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import static org.junit.Assert.assertTrue;


public class IncorrectLoginTestServerSide extends TestGroupWithDeletingData {

    @Override
    @BeforeTest
    @Parameters({"browser", "mailboxAccount", "mailboxPassword"})
    public void beforeTest(@Optional String browser, @Optional String mailboxAccount, @Optional String mailboxPassword) throws Exception {

        cleanAllRecordsOfEmailBeforeTest(browser, mailboxAccount, mailboxPassword);
        signUpWithEmailConfirmation(driver, NAME_VALUE, COMPANY_VALUE, mailboxAccount, PASSWORD_VALUE_VALID, mailboxPassword, MAILBOX_ONLY_ONE_NEW_LETTER_ABOUT_CONFIRM_EMAIL_XPATH, MAILBOX_CONFIRMATION_LINK_XPATH);
        driver.quit();
        startTest(browser, BASE_URL);
    }

    @Test (dataProvider = "getIncorrectEmail")
    public void incorrectLoginServerSide(String email, String password) throws Exception {

        driver.findElement(By.xpath(LOGIN_LINK_XPATH)).click();
        ((JavascriptExecutor) driver).executeScript("document.getElementById('email').removeAttribute('required'); document.getElementById('email').removeAttribute('type');");
        login(driver, email, password);

        try {
            assertTrue(isElementPresent(driver, By.xpath(EMAIL_IS_NOT_VALID_ALERT_XPATH)));
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
    }

    @Test
    public void invalidEmailValue() throws Exception {

        super.login(driver, EMAIL_VALUE_CORRECT_INVALID, PASSWORD_VALUE_VALID);

        try {
            assertTrue(isElementPresent(driver, By.xpath(NO_USER_FOUND_ALERT_XPATH)));
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
    }

    @Test
    public void invalidPasswordValue() throws Exception {

        super.login(driver, EMAIL_VALUE_CORRECT_VALID, PASSWORD_VALUE_INVALID);

        try {
            assertTrue(isElementPresent(driver, By.xpath(WRONG_PASSWORD_ALERT_XPATH)));
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
    }

    @Override
    public void login(WebDriver driver, String emailValue, String passwordValue) throws Exception {

        driver.findElement(By.id(EMAIL_ID)).clear();
        driver.findElement(By.id(EMAIL_ID)).sendKeys(emailValue);
        driver.findElement(By.id(PASSWORD_ID)).clear();
        driver.findElement(By.id(PASSWORD_ID)).sendKeys(passwordValue);
        driver.findElement(By.xpath(LOGIN_BUTTON_XPATH)).click();
    }
}