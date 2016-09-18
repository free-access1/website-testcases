package com.bizzclick.website.ui.Applications.AddNewApplication;

import com.bizzclick.website.ui.TestGroupLogin;
import org.openqa.selenium.By;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;


public class IncorrectAddingNewApplicationTestClientSide extends TestGroupLogin{

    @Test(dataProvider = "getIncorrectDataForAddingApplication")
    public void addNewApplication(String title, String packageName, String url, String category, String platform, String ageLimit, boolean paidApp, boolean virtualCurrency, String currencyName, String exchangeRate, boolean backExchange) throws InterruptedException {

        addApplication(driver, false, title, packageName, url, category, platform, ageLimit, paidApp, virtualCurrency, currencyName, exchangeRate, backExchange);

        try {
            assertTrue(isElementPresent(driver, By.xpath(BUTTON_ADD_NEW_APPLICATION_XPATH)));
        } catch (Error e) {
            verificationErrors.append(e.toString());
            String verificationErrorString = verificationErrors.toString();
            if (!"".equals(verificationErrorString)) {
                fail(verificationErrorString);
            }
        }
    }

    @Override
    @AfterTest
    @Parameters("mailboxAccount")
    public void afterTest(@Optional String mailboxAccount) {

        driver.quit();
        clearDBafterTest(mailboxAccount);
    }
}