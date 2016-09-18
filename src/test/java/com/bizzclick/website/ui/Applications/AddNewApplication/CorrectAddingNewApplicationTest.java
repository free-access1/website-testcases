package com.bizzclick.website.ui.Applications.AddNewApplication;

import com.bizzclick.website.ui.TestGroupLogin;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import static org.junit.Assert.assertTrue;


public class CorrectAddingNewApplicationTest extends TestGroupLogin {

    @Test(dataProvider = "getCorrectDataForAddingApplication")
    public void addNewApplication(String title, String packageName, String url, String category, String platform, String ageLimit, boolean paidApp, boolean virtualCurrency, String currencyName, String exchangeRate, boolean backExchange) throws InterruptedException {

        addApplication(driver, false, title, packageName, url, category, platform, ageLimit, paidApp, virtualCurrency, currencyName, exchangeRate, backExchange);

        try {
            assertTrue(isElementPresent(driver, By.xpath(APPLICATION_CREATED_BLUE_ALERT_XPATH)));
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
    }
}