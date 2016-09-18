package com.bizzclick.website.ui.Header;

import com.bizzclick.website.ui.TestGroupWithoutDeletingData;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import static org.junit.Assert.assertEquals;


public class NonLoggedHeaderNavigationTest extends TestGroupWithoutDeletingData {

    @Test (dataProvider = "nonLoggedHeaderItems")
    public void navigateTo(String clickTarget, String destinationUrl) throws Exception {

        driver.findElement(By.xpath(clickTarget)).click();

        try {
            assertEquals(destinationUrl, driver.getCurrentUrl());
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
    }
}