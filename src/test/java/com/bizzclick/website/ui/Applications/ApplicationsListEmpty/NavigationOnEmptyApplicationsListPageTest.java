package com.bizzclick.website.ui.Applications.ApplicationsListEmpty;

import com.bizzclick.website.ui.TestGroupLogin;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import static org.junit.Assert.assertEquals;


public class NavigationOnEmptyApplicationsListPageTest extends TestGroupLogin {

    @Test (dataProvider = "getURLsByApplicationsMenuItems")
    public void navigateByApplicationsMenuItems(String menuItem, String url){

        Actions action = new Actions(driver);
        action.moveToElement(driver.findElement(By.xpath(menuItem))).click().build().perform();

        try {
            assertEquals(driver.getCurrentUrl(), url);
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
    }

    @Test(dataProvider = "getURLsByElementsOnEmptyApplicationsListPage")
    public void navigateByPageElements(String element, String url){

        driver.findElement(By.xpath(APPLICATIONS_TAB_XPATH)).click();
        driver.findElement(By.xpath(element)).click();

        try {
            Assert.assertEquals(driver.getCurrentUrl(), url);
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
    }
}