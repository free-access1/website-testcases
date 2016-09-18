package com.bizzclick.website.ui.Applications.ApplicationsListFilled;

import com.bizzclick.website.ui.DataBase;
import com.bizzclick.website.ui.TestGroupLogin;
import org.openqa.selenium.By;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


public class NavigationOnFilledApplicationListPageTest extends TestGroupLogin{

    @Override
    @BeforeTest
    @Parameters({"browser", "mailboxAccount"})
    public void beforeTest(@Optional String browser, @Optional String mailboxAccount) throws Exception {

        deletePubTruncateAppAdsStatInsertPubApp(
                NAME_VALUE, COMPANY_VALUE, mailboxAccount,
                APPLICATION_TITLE_VALUE, PACKAGE_NAME_CORRECT_VALUE, "", "IAB1-1 Books & Literature", PLATFORM_ANDROID_VALUE, AGE_LIMIT_0_VALUE, "false", CURRENCY_NAME_CORRECT_VALUE, EXCHANGE_RATE_CORRECT_VALUE1, "false", "ZoomBaBee2", "initial");

        startTest(browser, BASE_URL);
        login(driver, mailboxAccount, PASSWORD_VALUE_VALID);
        driver.findElement(By.xpath(APPLICATIONS_TAB_XPATH)).click();
    }

    @Test//(dataProvider = "getURLsByElementsOnFilledApplicationListPage")
    public void navigateOnFilledApplicationListPage() {

    }

    public void deletePubTruncateAppAdsStatInsertPubApp(
            String publisherName, String publisherCompany, String publisherMailbox,
            String appTitle, String packageName, String storeUrl, String category, String platform, String ageLimit, String paidApplication, String currencyName, String exchangeRate, String realCurrency, String appKey, String status)
    {
        DataBase db = new DataBase();
        db.deletePubTruncateAppAdsStatInsertPubApp(
                publisherName, publisherCompany, publisherMailbox,
                appTitle, packageName, storeUrl, category, platform, ageLimit, paidApplication, currencyName, exchangeRate, realCurrency, appKey, status);
    }
}
