package com.bizzclick.website.ui.Login;

import com.bizzclick.website.ui.TestGroupWithoutDeletingData;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import static org.junit.Assert.assertEquals;


public class LoginNavigationTest extends TestGroupWithoutDeletingData {

    @Test (dataProvider = "navigationToLoginPageItems")
    public void navigateTo(String clickTarget, String destinationUrl) throws Exception {

        driver.findElement(By.xpath(LOGIN_LINK_XPATH)).click();
        driver.findElement(By.xpath(clickTarget)).click();

        try {
            assertEquals(destinationUrl, driver.getCurrentUrl());
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
    }
}