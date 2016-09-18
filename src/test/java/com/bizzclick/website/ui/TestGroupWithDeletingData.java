package com.bizzclick.website.ui;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import static org.junit.Assert.fail;


public class TestGroupWithDeletingData extends TestSuite {

    @BeforeTest
    @Parameters({"browser", "mailboxAccount", "mailboxPassword"})
    public void beforeTest(@Optional String browser, @Optional String mailboxAccount, @Optional String mailboxPassword) throws Exception {

        cleanAllRecordsOfEmailBeforeTest(browser, mailboxAccount, mailboxPassword);
    }

    @AfterTest
    @Parameters({"browser", "mailboxAccount", "mailboxPassword"})
    public void afterTest(@Optional String browser, @Optional String mailboxAccount, @Optional String mailboxPassword) {

        cleanAllRecordsOfEmailAfterTest(browser, mailboxAccount, mailboxPassword);
    }

    public void cleanAllRecordsOfEmailBeforeTest(String browser, String mailboxAccount, String mailboxPassword) throws InterruptedException {

        cleanRecordsOfEmail(browser, mailboxAccount, mailboxPassword);
        startTest(browser, BASE_URL);
    }

    public void cleanAllRecordsOfEmailAfterTest(String browser, String mailboxAccount, String mailboxPassword) {

        driver.quit();
        cleanRecordsOfEmail(browser, mailboxAccount, mailboxPassword);

        String verificationErrorString = verificationErrors.toString();
        if (!"".equals(verificationErrorString)) {
            fail(verificationErrorString);
        }
    }

    public void cleanRecordsOfEmail(String browser, String mailboxAccount, String mailboxPassword) {

        deleteUserFromDBbyEmail(mailboxAccount);

        WebDriver driver = setWebDriver(browser);
        deleteAllEmailsFromMailbox(driver, mailboxAccount, mailboxPassword);
        driver.quit();
    }

    public void deleteUserFromDBbyEmail(String email) {

        DataBase db = new DataBase();
        db.deletePublisherByEmail(email);
    }

    public void deleteAllEmailsFromMailbox(WebDriver driver, String mailboxLogin, String mailboxPassword) {

        MailBox mailBox = new MailBox();
        mailBox.login(driver, mailboxLogin, mailboxPassword);
        mailBox.deleteAllEmails(driver);
        mailBox.logout(driver);
    }

    public void signUpWithEmailConfirmation (WebDriver driver, String name, String company, String mailboxAccount, String sitePassword, String mailboxPassword, String letter, String link) throws InterruptedException {

        signUp(driver, name, company, mailboxAccount, sitePassword, sitePassword);
        getLinkFromEmail(driver, mailboxAccount, mailboxPassword, letter, link);
    }

    public void truncateTable (String tableName) {
        DataBase db = new DataBase();
        db.truncateTable(tableName);
    }
}