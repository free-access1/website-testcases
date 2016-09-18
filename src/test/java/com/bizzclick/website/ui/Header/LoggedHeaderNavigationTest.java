package com.bizzclick.website.ui.Header;

import com.bizzclick.website.ui.TestGroupWithDeletingData;
import org.openqa.selenium.By;
import org.testng.annotations.*;
import static org.junit.Assert.assertEquals;


public class LoggedHeaderNavigationTest extends TestGroupWithDeletingData {

    @Override
    @BeforeTest
    @Parameters({"browser", "mailboxAccount", "mailboxPassword"})
    public void beforeTest(@Optional String browser, @Optional String mailboxAccount, @Optional String mailboxPassword) throws Exception {

        cleanAllRecordsOfEmailBeforeTest(browser, mailboxAccount, mailboxPassword);
        signUpWithEmailConfirmation(driver, NAME_VALUE, COMPANY_VALUE, mailboxAccount, PASSWORD_VALUE_VALID, mailboxPassword, MAILBOX_ONLY_ONE_NEW_LETTER_ABOUT_CONFIRM_EMAIL_XPATH, MAILBOX_CONFIRMATION_LINK_XPATH);
        driver.quit();
    }

    @BeforeMethod
    @Parameters("browser")
    public void beforeMethod(@Optional String browser) {

        startTest(browser, BASE_URL);
    }

    @AfterMethod
    public void afterMethod() throws Exception {

        driver.quit();
    }

    @Test (dataProvider = "navigationToHeaderTabsData")
    public void navigationToHeaderTabs(String user, String password, String tab, String url) throws Exception {

        login(driver, user, password);
        driver.findElement(By.xpath(tab)).click();

        try {
            assertEquals(url, driver.getCurrentUrl());
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
    }

    @Test (dataProvider = "navigationToUserMenuItemsData")
    public void navigationToUserMenuItems(String user, String password, String menuItem, String url) throws Exception {

        login(driver, user, password);
        driver.findElement(By.xpath(USER_MENU_XPATH)).click();
        driver.findElement(By.xpath(menuItem)).click();

        try {
            assertEquals(url, driver.getCurrentUrl());
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
    }
}