package com.bizzclick.website.ui;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import static org.junit.Assert.fail;


public class TestGroupWithoutDeletingData extends TestSuite {
    public StringBuffer verificationErrors = new StringBuffer();

    @BeforeTest
    @Parameters("browser")
    public void beforeTest(@Optional String browser) throws InterruptedException {

        startTest(browser, BASE_URL);
    }

    @AfterTest
    public void afterTest() throws Exception {

        driver.quit();

        String verificationErrorString = verificationErrors.toString();
        if (!"".equals(verificationErrorString)) {
            fail(verificationErrorString);
        }
    }
}