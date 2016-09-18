package com.bizzclick.website.ui.Applications.AddNewApplication;

import com.bizzclick.website.ui.TestGroupLogin;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;


public class NavigationOnAddNewApplicationPageTest extends TestGroupLogin {

    @Test(dataProvider = "getURLsByElementsOnAddNewApplicationPage")
    public void navigateByPageElements(String element, String url){

        driver.findElement(By.xpath(APPLICATIONS_TAB_XPATH)).click();
        driver.findElement(By.xpath(ADD_APPLICATION_BUTTON)).click();
        driver.findElement(By.xpath(element)).click();

        try {
            Assert.assertEquals(driver.getCurrentUrl(), url);
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
    }
}