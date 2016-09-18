package com.bizzclick.website.ui.Login;

import com.bizzclick.website.ui.TestGroupWithoutDeletingData;
import org.openqa.selenium.*;
import org.testng.annotations.Test;
import static org.junit.Assert.*;


public class IncorrectLoginTestClientSide extends TestGroupWithoutDeletingData{

    @Test (dataProvider = "getIncorrectEmail")
    public void incorrectEmailValue(String email, String password) throws Exception {

        login(driver, email, password);

        try {
            assertTrue(isElementPresent(driver, By.xpath(LOGIN_BUTTON_XPATH)));
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
    }
}