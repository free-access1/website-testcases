package com.bizzclick.website.ui;

import org.openqa.selenium.By;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import static org.junit.Assert.fail;


public class TestGroupLogin extends TestSuite{

    @BeforeTest
    @Parameters({"browser", "mailboxAccount"})
    public void beforeTest(@Optional String browser, @Optional String mailboxAccount) throws Exception {

        prepareDBforApplicationTesting(NAME_VALUE, COMPANY_VALUE, mailboxAccount);

        startTest(browser, BASE_URL);
        login(driver, mailboxAccount, PASSWORD_VALUE_VALID);
        driver.findElement(By.xpath(APPLICATIONS_TAB_XPATH)).click();
    }

    @AfterTest
    @Parameters("mailboxAccount")
    public void afterTest(@Optional String mailboxAccount) {

        driver.quit();
        clearDBafterTest(mailboxAccount);

        String verificationErrorString = verificationErrors.toString();
        if (!"".equals(verificationErrorString)) {
            fail(verificationErrorString);
        }
    }

    public void prepareDBforApplicationTesting(String publisherName, String publisherCompany, String publisherEmailbox) {
        DataBase db = new DataBase();
        db.deletePubTruncateAppAdsStatInsertPub(publisherName, publisherCompany, publisherEmailbox);
    }

    public void clearDBafterTest(String publisherMailbox) {
        DataBase db = new DataBase();
        db.deletePubTruncateAppAdsStat(publisherMailbox);
    }
}